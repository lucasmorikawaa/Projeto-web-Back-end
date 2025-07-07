package br.gov.sp.fatec.itu.cadastroweb.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.gov.sp.fatec.itu.cadastroweb.models.Category;
import br.gov.sp.fatec.itu.cadastroweb.models.Pessoa;

import br.gov.sp.fatec.itu.cadastroweb.services.CategoryService;
import br.gov.sp.fatec.itu.cadastroweb.services.PessoaService;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@CrossOrigin(origins = "*")
@RestController
public class PessoaController {


    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PessoaService pessoaService;

    @PostConstruct
    public void init(){


    }

    @GetMapping("cadastrados/{id}")
    public ResponseEntity<Pessoa> getPessoa(@PathVariable int id){

        Pessoa pessoa = pessoaService.getById(id);
        return ResponseEntity.ok(pessoa);
        
    }

    @PostMapping("cadastrados")
    public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa){

        pessoa = pessoaService.save(pessoa);

        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(pessoa.getId())
            .toUri();

        return ResponseEntity.created(location).body(pessoa);


    }
    

    @GetMapping("cadastrados")
    public List<Pessoa> getPessoas(){

        return pessoaService.getAll();

    }

    @DeleteMapping("cadastrados/{id}")
    public ResponseEntity<Void> removePessoa(@PathVariable int id) {
    pessoaService.deleteById(id);
    return ResponseEntity.noContent().build();
}

    @PutMapping("cadastrados/{id}")
    public ResponseEntity<Void> updatePessoa(@PathVariable int id, @RequestBody Pessoa pessoaUpdate){

        pessoaService.update(id, pessoaUpdate);

        return ResponseEntity.ok().build();
        
    }


   
}
