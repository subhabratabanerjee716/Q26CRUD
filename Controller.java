package Q26.iNeuron.CRUD.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Q26.iNeuron.CRUD.Entity.Products;
import Q26.iNeuron.CRUD.dao.Dao;

@RestController
public class Controller {
	
	@Autowired
	Dao dao;
	
	@GetMapping("/GetProduct/{id}")
	public ResponseEntity<Optional<Products>> getProduct(@RequestParam(name = "id") int id){
		
		Optional<Products> p=dao.getById(id);
		
		if(p==null) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
		}
		
		return ResponseEntity.of(Optional.of(p));
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Products>>getAllProducts(){
		
	List<Products>	list=dao.GetAll();
		
	if(list==null) {
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
	}
	
	return ResponseEntity.of(Optional.of(list));
	
	}
	
	@PostMapping("/postOne")
	public ResponseEntity<Products> postOne(@RequestBody Products products){
		
		Products p=dao.saveOne(products);
		
		if(p==null) {
			
			ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
		}
		
		return ResponseEntity.of(Optional.of(p));
	}
	
	@PostMapping("/postAll")
	public ResponseEntity<List<Products>> postAll(@RequestBody List<Products> products){
		
		List<Products> p=dao.saveAll(products);
		
		if(p==null) {
			
			ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
		}
		
		return ResponseEntity.of(Optional.of(p));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@RequestParam Integer id){
		
		String s=dao.delete(id);
		
		if(s==null) {
			
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
			
		}
		
		return ResponseEntity.of(Optional.of(s));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Products> update(@RequestBody Products products,@RequestParam Integer id){
		
		Products p=dao.Update(products, id);
		
		if(p==null) {
			
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();	
		}
		
		return ResponseEntity.of(Optional.of(p));
		
		
	}
	
	
	
	
	
}
