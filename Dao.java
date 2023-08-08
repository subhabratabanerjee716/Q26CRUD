package Q26.iNeuron.CRUD.dao;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import Q26.iNeuron.CRUD.Entity.Products;
import Q26.iNeuron.CRUD.Repository.ProductsRepository;

@Component
public class Dao {
	
	@Autowired
	ProductsRepository productRepo;
	
	public List<Products> GetAll(){
		
		List<Products> products=null;
		
		products=productRepo.findAll();
		
		return products;
		
	}
	
	public Optional<Products> getById(int id) {
		
		
		Optional<Products> p2=productRepo.findById(id);
		
		return p2;
	}

	public List<Products> save(List<Products> products){
		
		List<Products> p=(List<Products>) productRepo.saveAll(products);
		
		return p;
	}
	
	public Products saveOne(Products p) {
		
		return productRepo.save(p);
			
	}
	
	public String delete(Integer id) {
		
		
		productRepo.deleteById(id);
		
		return "deleted";
		
	}
	
	public Products Update(Products p , int bookId) {
		
		
				Products p1= new Products();
				
				p1.setId(bookId);
				p1.setName(p.getName());
				p1.setCost(p.getCost());
				p1.setDescription(p.getDescription());
				
				productRepo.deleteById(bookId);
				productRepo.save(p1);
				
				return p1;
				
				
		
	}

	public List<Products> saveAll(List<Products> products) {
		
		return (List<Products>) productRepo.saveAll(products);
		
	}
}
