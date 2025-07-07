package br.gov.sp.fatec.itu.cadastroweb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.fatec.itu.cadastroweb.models.Category;
import br.gov.sp.fatec.itu.cadastroweb.repositories.CategoryRepository;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;

    public Category getById(int id){

        Category category = categoryRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa not found"));

            return category;
    }

    public List <Category> getAll(){
        return categoryRepository.findAll();
    }

}
