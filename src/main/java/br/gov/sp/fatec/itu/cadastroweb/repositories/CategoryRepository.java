package br.gov.sp.fatec.itu.cadastroweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.gov.sp.fatec.itu.cadastroweb.models.Category;


public interface CategoryRepository extends JpaRepository <Category,Integer>{
    
}
