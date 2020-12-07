package com.example.projeto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.projeto.model.Cidade;
import com.example.projeto.repository.CidadeRepository;
import com.example.projeto.repository.EstadoRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class CidadeController {

	@Autowired
	CidadeRepository cidadeRepository;
	
	@Autowired
	EstadoRepository estadoRepository;
	
	@GetMapping("/cidades")
	public ResponseEntity<List<Cidade>> getAllCidades(@RequestParam(required = false) String nome){
		try {
			List<Cidade> cidades = new ArrayList<Cidade>();
			
			if(nome == null) {
				cidadeRepository.findAll().forEach(cidades::add);
			}
			
			if (cidades.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(null, HttpStatus.OK);

				
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	@GetMapping("/cidades/{id}")
	public ResponseEntity<Cidade> getCidadeById(@PathVariable("id") long id){
		Optional <Cidade> cidade = cidadeRepository.findById(id);
		if(cidade.isPresent()) {
			return new ResponseEntity<>(cidade.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/cidades")
	public ResponseEntity<Cidade> createCidade(@RequestBody Cidade cidade){
		try {
			Cidade cidadeSave = cidadeRepository.save(new Cidade(cidade.getId(),cidade.getNome(), cidade.getidCidadeEstado()));
			return new ResponseEntity<>(cidadeSave, HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/cidade/{id}")
	public ResponseEntity<Cidade> UpdateCidade(@PathVariable("id") long id, @RequestBody Cidade cidade) {
		Optional<Cidade> cidadeAtualiza = cidadeRepository.findById(id);
		
		if(cidadeAtualiza.isPresent()) {
			Cidade cidadeSave = cidadeAtualiza.get();
			cidadeSave.setNome(cidade.getNome());
			cidadeSave.setidCidadeEstadoo(cidade.getidCidadeEstado());
			return new ResponseEntity<>(cidadeRepository.save(cidadeSave), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("cidade/{id}")
	public ResponseEntity<HttpStatus> DeleteCidade(@PathVariable("id") long id){

		try {
			cidadeRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
