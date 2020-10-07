/**
 * 
 */
package com.floreria.app.service.producto;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.floreria.app.dao.imagen.IProdImgDAO;
import com.floreria.app.dao.producto.IHProductoDAO;
import com.floreria.app.dao.producto.IProdHijoDAO;
import com.floreria.app.dao.producto.IProductoDao;
import com.floreria.app.dao.producto.ITipoProductoDAO;
import com.floreria.app.dao.producto.ITpoMovProductoDAO;
import com.floreria.app.model.imagen.Imagen;
import com.floreria.app.model.producto.Hproducto;
import com.floreria.app.model.producto.ProdHijo;
import com.floreria.app.model.producto.Producto;
import com.floreria.app.model.producto.TipoProducto;
import com.floreria.app.model.producto.TpoMovimientoProducto;
import com.floreria.app.service.imagen.IIMagen;
import com.floreria.app.util.Const;
import com.floreria.app.util.RequestPerson;


/**
 * @author rgarciaq
 *
 */
@Service
public class ProductoService implements IProductoService { 
	
	Logger logger = LoggerFactory.getLogger(ProductoService.class);

	/**
	 * Intsancia dao de producto
	 */
	@Autowired
	IProductoDao productoDao;
	
	@Autowired
	IProdImgDAO prodImgDAO;
	
	
	@Autowired
	IIMagen imagenService;
	
	@Autowired
	IProdHijoDAO prodHijoDAO;
	
	@Autowired
	ITipoProductoDAO tipoProductoDAO;
	
	@Autowired
	IHProductoDAO hproductoDAO;
	
	@Autowired
	ITpoMovProductoDAO tpoMovDAO;
	
	
	@Override
	public Producto findProductoById(Integer id) {
		
		return productoDao.findByProdId(id);
		
		
	}

	@Override
	public Producto save(Producto producto, String username) {
		
		try {
			
			boolean isNew = producto.getProdId() == 0;
			producto.setProdFechaRegistro(new Date());
			
			
			producto.setTipoProducto(
					producto.getTipoProducto() != null && producto.getTipoProducto().getTpoprodId() > 0
							? producto.getTipoProducto()
							: null);
			
			 productoDao.save(producto);
			
			if(isNew) {
				producto.setProdExistenciaMin(generaMov(producto, Const.TPO_MOV_NUEVO_INGRESO_INSU, 0, 
						producto.getProdExistenciaMin()).getHpsCantidadExi());
				 productoDao.save(producto);
			}
			
			if(producto.getCantidadMov() != null && producto.getCantidadMov() > 0 
					&& producto.getTpoMov() != null && producto.getTpoMov() > 0) {
				generaMov(producto);
			}
			
			if(producto.getLstProdHijo() != null && producto.getLstProdHijo().size() > 0) {
				producto.getLstProdHijo().forEach(item -> {
					ProdHijo chamacoAdd = prodHijoDAO.findByProdIdPadreAndProductoProdId(producto.getProdId(), item.getProdId());
					if(chamacoAdd == null) {
						 chamacoAdd = new ProdHijo();
						 chamacoAdd.setProducto(item);
							chamacoAdd.setProdIdPadre(producto.getProdId());
							chamacoAdd.setPrhEstatus("AC");
					}
					chamacoAdd.setPrhCantidad(item.getCantidadMov().doubleValue());
					prodHijoDAO.save(chamacoAdd);
					
				});
			}
			
			imagenService.saveImgByProdId(producto.getLstImg(), producto.getProdId());
		} catch (Exception e) {
			logger.error("Error al guardar el producto con nombre :" + producto.getProdNombre() + "razon \n" + e.getMessage() + e.getCause());
		}
		return producto;
	}

	@Override
	public Producto update(Producto prod, String username) {
		try {
			
			productoDao.save(prod);
			
		} catch (Exception e) {
			logger.error("Error al actualizar el producto con nombre :" + prod.getProdNombre() + "razon \n" + e.getMessage() + e.getCause());
		}
	
		return prod;
	}

	
	@Override
	public Producto getProductDetail(Integer proId) {
		Producto prodTemp = new Producto();
		
		try {
			prodTemp = productoDao.findByProdId(proId);
			prodTemp.setLstImg(imagenService.getLstImagByProd(proId));
			
		} catch (Exception e) {
			logger.error("Error al buscar el producto con id :" + proId+ "razon \n" + e.getMessage() + e.getCause());
		}
		return prodTemp;
	}

	
	@Override
	public boolean delete(Producto prod) {
		try {
			prod.setProdEstatus("SU");
			productoDao.save(prod);
		} catch (Exception e) {
			logger.error("Error al borrar el producto con id :" + prod.getProdId() + "razon \n" + e.getMessage() + e.getCause());
		}
		return false;
	}

	
	@Override
	public List<Producto> getLstProductAc(String status) throws Exception {
		List<Producto>  lstProducto = new ArrayList<>();
		try {
			lstProducto = productoDao.findByProdEstatus(status);
			lstProducto.forEach(item -> {
				try {
					item.setLstImg(imagenService.getLstImagByProd(item.getProdId()));
					if(item.getLstImg() != null && item.getLstImg().size() > 0) {
						item.setImgDefault(((Imagen)item.getLstImg().get(0)).getImgUrl());
					}
					
					
					item.setLstProdHijo(prodHijoDAO.getChamacosActivosProd(item.getProdId(), status));
					
				
				} catch (Exception e) {
					logger.error("Error al buscor imagen del producto razon \n" + e.getMessage() + e.getCause(), e);
					e.printStackTrace();
				}
			});
			
		} catch (Exception e) {
			logger.error("Error al buscor el producto razon \n" + e.getMessage() + e.getCause());
			throw new Exception(e);
		}
		return lstProducto;
	}

	
	@Override
	public List<Producto> getLstProductAcNotInProdId(List<Integer> lstProdId) throws Exception {
		List<Producto>  lstProducto = new ArrayList<>();
		try {
			lstProducto = productoDao.getProductos(lstProdId);
		} catch (Exception e) {
			logger.error("Error al buscor el producto razon \n" + e.getMessage() + e.getCause());
			throw new Exception(e);
		}
		return lstProducto;

	}

	@Override
	public List<TipoProducto> findTpoByEstatus(String status) throws Exception {
		List<TipoProducto> lstProd = new ArrayList<TipoProducto>();
		try {
			lstProd = tipoProductoDAO.findByTpoprodEstatus(status);
		} catch (Exception e) {
			logger.error("Error al buscor tipo producto razon \n" + e.getMessage() + e.getCause(),e);
			throw new Exception(e);
		}
		return lstProd;
	}

	@Override
	public TipoProducto save(TipoProducto tipoProd) throws Exception {
		try {
			tipoProd = tipoProductoDAO.save(tipoProd);
		} catch (Exception e) {
			logger.error("Error al guardar tipo producto razon \n" + e.getMessage() + e.getCause(),e);
			throw new Exception(e);
		}
		return tipoProd;
	}

	@Override
	public Hproducto generaMov(Producto prod, Integer tpoMov, 
			Integer cantAnterior, Integer cantidadMov) throws Exception {
		Hproducto hprod = new Hproducto();
		try {
			hprod.setHpsFecha(new Date());
			hprod.setUsuario(prod.getUsuario());
			TpoMovimientoProducto tpo = tpoMovDAO.findByTmpId(tpoMov);
			hprod.setTmpId(tpo);
			hprod.setHpsCantAnterior(cantAnterior);
			hprod.setHpsCantidadMovimiento(cantidadMov);
			hprod.setProducto(prod);
			
			hprod.setHpsCantidadExi(tpo.getTmpSuma().equals(Const.STRING_V) ? hprod.getHpsCantAnterior() + hprod.getHpsCantidadMovimiento() : 
				hprod.getHpsCantAnterior() - hprod.getHpsCantidadMovimiento());
			
			hprod = hproductoDAO.save(hprod);
			
			
		} catch (Exception e) {
			logger.error("Error al guardar historico producto razon \n" + e.getMessage() + e.getCause(),e);
			throw new Exception(e);
		}
		
		return hprod;
	}

	@Override
	public List<TpoMovimientoProducto> findAll() throws Exception {
		return tpoMovDAO.findAll();
	}

	@Override
	public Hproducto generaMov(Producto prod) throws Exception {
		Hproducto hpro = new Hproducto();
		try {
			hpro = generaMov(prod, prod.getTpoMov(), prod.getProdExistenciaMin(), prod.getCantidadMov());
			prod.setProdExistenciaMin(hpro.getHpsCantidadExi());
			productoDao.save(prod);
		} catch (Exception e) {
			logger.error("Error al guardar historico producto razon \n" + e.getMessage() + e.getCause(),e);
			throw new Exception(e);
		}
		return hpro;
	}

	
	@Override
	public List<Hproducto> findMovmientoByParam(RequestPerson reque) throws Exception {
		List<Hproducto> lstTmp = new ArrayList<Hproducto>();
		try {
			Calendar now = Calendar.getInstance();
			now.setTime(reque.getFechaIni());
	        now.set(Calendar.HOUR, 0);
	        now.set(Calendar.MINUTE, 0);
	        now.set(Calendar.SECOND, 0);
			if(reque.getExtraParamMap() != null && reque.getExtraParamMap().size() > 0) {
				if(reque.getExtraParamMap().get("nombre") != null && 
						((String)reque.getExtraParamMap().get("nombre")).length() > 0 &&
						reque.getExtraParamMap().get("tpomov") != null && 
						((Integer)reque.getExtraParamMap().get("tpomov")) > 0) {
					lstTmp = hproductoDAO.findByHpsFechaBetweenAndProductoProdNombreLikeAndTmpIdTmpIdOrderByHpsFechaDesc(
							now.getTime(), reque.getFechaFin(),
									(String) reque.getExtraParamMap().get("nombre"), 
									(Integer)reque.getExtraParamMap().get("tpomov"));
				}else if(reque.getExtraParamMap().get("tpomov") != null &&
						reque.getExtraParamMap().get("tpomov") != null && 
						((Integer)reque.getExtraParamMap().get("tpomov")) > 0) {
					lstTmp = hproductoDAO.findByHpsFechaBetweenAndTmpIdTmpIdOrderByHpsFechaDesc(
							now.getTime(), reque.getFechaFin(),(Integer)reque.getExtraParamMap().get("tpomov"));
				}else if(reque.getExtraParamMap().get("nombre") != null && 
						((String)reque.getExtraParamMap().get("nombre")).length() > 0){
					lstTmp = hproductoDAO.findByHpsFechaBetweenAndProductoProdNombreLikeOrderByHpsFechaDesc(
							now.getTime(), reque.getFechaFin(),(String) reque.getExtraParamMap().get("nombre"));
				}else {
					lstTmp = hproductoDAO.findByHpsFechaBetweenOrderByHpsFechaDesc(now.getTime(),
							reque.getFechaFin());
					
				}
			}else {
				lstTmp = hproductoDAO.findByHpsFechaBetweenOrderByHpsFechaDesc(reque.getFechaIni(),
						reque.getFechaFin());
				
			}
			
			for(Hproducto hprod : lstTmp) {
				hprod.setProdExistenciaActual(hprod.getProducto().getProdExistenciaMin()+"");
				hprod.setProdNombre(hprod.getProducto().getProdNombre());
				hprod.setTpoMovimiento(hprod.getTmpId().getTmpDesc());
			}
		} catch (Exception e) {
			logger.error("Error al consultar historico producto razon \n" + e.getMessage() + e.getCause(),e);
			throw new Exception(e);
		}
		return lstTmp;
	}

	

}
