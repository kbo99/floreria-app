/**
 * 
 */
package com.floreria.app.service.imagen;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.floreria.app.dao.imagen.IImagenDAO;
import com.floreria.app.dao.imagen.IProdImgDAO;
import com.floreria.app.model.imagen.Imagen;
import com.floreria.app.model.imagen.ProdImg;
import com.floreria.app.model.producto.Producto;

/**
 * @author macpro
 *
 */
@Service
public class ImagenService implements IIMagen {
	
	Logger log = LoggerFactory.getLogger(ImagenService.class);
	
	@Autowired
	IImagenDAO imagenDAO;
	
	@Autowired
	IProdImgDAO proImgDAO;

	@Override
	public Imagen save(Imagen img) throws Exception {
		try {
			img = imagenDAO.save(img);
		} catch (Exception e) {
			log.error("Error al guardar imagen", e);
			throw new Exception();
		}
		return img;
	}

	@Override
	public List<Imagen> getLstImagByProd(Integer prodId) throws Exception {
		List<Imagen>  lstImg = new ArrayList<Imagen>();
		try {
			lstImg = proImgDAO.getLstImagenByProdId(prodId);
		} catch (Exception e) {
			log.error("Error al consultar imagen produxto", e);
			throw new Exception();
		}
		return lstImg;
	}

	@Override
	public ProdImg save(ProdImg save) throws Exception {
		try {
			save = proImgDAO.save(save);
		} catch (Exception e) {
			log.error("Error al guardar producto -> imagen", e);
			throw new Exception();
		}
		return save;
	}

	@Override
	public List<Imagen> saveImgByProdId(List<Imagen> lstImg, Integer proId) throws Exception {
		try {
			for(Imagen img : lstImg) {
				if(img.getImgId() == null || img.getImgId() <= 0) {
					img = save(img);
				}
				ProdImg pdi = new ProdImg();
				pdi.setImagen(img);
				pdi.setProducto(new Producto(proId));
				proImgDAO.save(pdi);
			}
		} catch (Exception e) {
			log.error("Error al guardar imagen produxto", e);
			throw new Exception();
		}
		return lstImg;
	}

}
