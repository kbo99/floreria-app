/**
 * 
 */
package com.floreria.app.controller.producto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.floreria.app.model.producto.Hproducto;
import com.floreria.app.model.producto.Producto;
import com.floreria.app.model.producto.TipoProducto;
import com.floreria.app.model.producto.TpoMovimientoProducto;
import com.floreria.app.service.producto.IProductoService;

/**
 * @author macpro
 *
 */
@RestController
@RequestMapping("/prod")
public class ProductoController {

	@Autowired
	IProductoService productoService;
	
	@PostMapping("/save")
	public Producto save(@RequestBody Producto producto) {
		try {
			 productoService.save(producto, producto.getUsuario());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return producto;
	}
	
	@PostMapping("/insumos")
	List<Producto> findAllProd(@RequestBody String estatus){
		List<Producto>  lstPrdo = new ArrayList<Producto>();
		try {
			lstPrdo = productoService.getLstProductAc(estatus);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lstPrdo;
		
	}
	
	@PostMapping("/prod")
	public Producto getProd(@RequestBody Integer producto) {
		Producto prod = new Producto();
		try {
			prod = productoService.getProductDetail(producto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prod;
	}
	
	@PostMapping("/savetpo")
	public TipoProducto save(@RequestBody TipoProducto producto) {
		try {
			 productoService.save(producto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return producto;
	}
	
	@PostMapping("/tpoprod")
	List<TipoProducto> findAllTpoProd(@RequestBody String estatus){
		List<TipoProducto>  lstPrdo = new ArrayList<TipoProducto>();
		try {
			lstPrdo = productoService.findTpoByEstatus(estatus);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lstPrdo;
		
	}
	
	@PostMapping("/tpomov")
	List<TpoMovimientoProducto> findAllTpoMProd(){
		List<TpoMovimientoProducto>  lstPrdo = new ArrayList<TpoMovimientoProducto>();
		try {
			lstPrdo = productoService.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lstPrdo;
		
	}
	
	
	@PostMapping("/saveHtpo")
	public Hproducto saveHistorico(@RequestBody Producto producto) {
		Hproducto hprod = new Hproducto();
		try {
			hprod = productoService.generaMov(producto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hprod;
	}
}
