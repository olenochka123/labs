package ua.lviv.iot.spring.first.rest.controllers;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ua.lviv.iot.spring.first.rest.models.Accessory;

@RequestMapping("/products")
@RestController
public class ProductManager {
	public Map<Integer, Accessory> accessories = new HashMap<>();
	private AtomicInteger idCounter = new AtomicInteger();
	
	@GetMapping
	public List<Accessory> getAccessories() {
		
		return new LinkedList<Accessory>(accessories.values());
	}
	
	@GetMapping(path = "/{id}")
	public Accessory getAccessoryById(final @PathVariable("id") Integer id) {
		if(accessories.containsKey(id))	{
			return accessories.get(id);
		}
		else {
			return null;
		}
	}

	@PostMapping
	public Accessory addProductToList(final @RequestBody Accessory accessory) {
		accessory.setId(idCounter.incrementAndGet());
		accessories.put(accessory.getId(), accessory);
		return accessory;
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Accessory> removeProductFromList(@PathVariable("id") Integer id) {
		HttpStatus status = accessories.remove(id) == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
		return ResponseEntity.status(status).build();
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Accessory> modifyElement(final @PathVariable("id") Integer id, @RequestBody Accessory accessory) {
		
		HttpStatus status;
		Accessory oldOne = new Accessory();
		
		if(accessories.containsKey(id)) {
			oldOne = accessories.get(id);
			accessory.setId(id);
			accessories.replace(id, accessory);
			status = HttpStatus.OK;
		}
		else
		{
			status = HttpStatus.NOT_FOUND;
		}
		
		return status == HttpStatus.OK ? (new ResponseEntity<Accessory>(oldOne, status)) : ResponseEntity.status(status).build();
	}
}
