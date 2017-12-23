package com.asd.controller;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.asd.model.Active;
import com.asd.repository.ActiveRepository;


import java.util.List;


@RestController
@RequestMapping("/actives")
public class ActiveController {

	@Autowired
	private ActiveRepository activeRepo;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Active>> getActives() {
		return new ResponseEntity<>(activeRepo.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Active> getActive(@PathVariable long id) {
		Active active = activeRepo.findOne(id);

		if (active != null) {
			return new ResponseEntity<>(activeRepo.findOne(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addActive(@RequestBody Active active) {
		return new ResponseEntity<>(activeRepo.save(active), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteActiven(@PathVariable(value = "id") long id) {
		activeRepo.delete(id);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

		@RequestMapping(value= "/tipo/{tipo}", method = RequestMethod.GET)
	public List<Active> getActiveByType(@PathVariable(value = "tipo") String tipo) {
		return activeRepo.findAllByTypeIgnoreCase(tipo);
	}
			
	@RequestMapping(value = "/serial/{serial}", method = RequestMethod.GET)
	public List<Active> getActiveBySerial(@PathVariable(value = "serial") Long serial) {
		return activeRepo.findAllBySerialIgnoreCase(serial);
	}
	

}
