/**
 * 
 */
package com.floreria.app.dao.producto;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.floreria.app.model.producto.Producto;

/**
 * @author gdejesus
 *
 */
@Repository
public interface IProductoDao extends PagingAndSortingRepository<Producto, Long> {

	Producto findByProdId(Integer proId);
	
	Producto save(Producto producto); 
	
	List<Producto> findByProdEstatus(String prodEstatus);
	
	@Query("Select prod FROM Producto prod where prod.prodId NOT IN (?1) AND prod.prodEstatus = 'AC'")
	List<Producto> getProductos(List<Integer> prodId);
	
}
