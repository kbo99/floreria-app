/**
 * 
 */
package com.floreria.app.service.producto;

import java.util.List;

import com.floreria.app.model.producto.Hproducto;
import com.floreria.app.model.producto.Producto;
import com.floreria.app.model.producto.TipoProducto;
import com.floreria.app.model.producto.TpoMovimientoProducto;
import com.floreria.app.util.RequestPerson;

/**
 * @author gdejesus
 *
 */
public interface IProductoService {

	Producto findProductoById(Integer id)throws Exception;
	
	Producto save(Producto productoVO,String username)throws Exception;
	
	Producto update (Producto prod, String username)throws Exception;
	
	Producto getProductDetail(Integer proId)throws Exception;
	
	boolean delete(Producto prod)throws Exception;
	
	List<Producto> getLstProductAc(String status, boolean esInsumo) throws Exception;
	
	List<Producto> getLstProductAcNotInProdId(List<Integer> lstProdId) throws Exception;
	
	List<TipoProducto> findTpoByEstatus(String status) throws Exception;
	
	TipoProducto save(TipoProducto tipoProd) throws Exception;
	
	Hproducto generaMov(Producto prod, Integer tpoMov,Integer cantAnterior, Integer cantidadMov) throws Exception;
	
	List<TpoMovimientoProducto> findAll() throws Exception;
	
	Hproducto generaMov(Producto prod) throws Exception;
	
	List<Hproducto> findMovmientoByParam(RequestPerson reque) throws Exception;
	
	
}
