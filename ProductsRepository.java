package Q26.iNeuron.CRUD.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import Q26.iNeuron.CRUD.Entity.Products;

@Component
public interface ProductsRepository extends CrudRepository<Products,Integer> {

	public List<Products> findAll();
	
	public Optional<Products> findById(Integer id);
	
	
	
}
