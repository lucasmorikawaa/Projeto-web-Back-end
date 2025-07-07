package br.gov.sp.fatec.itu.cadastroweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.gov.sp.fatec.itu.cadastroweb.models.Pessoa;


public interface PessoaRepository extends JpaRepository <Pessoa,Integer>{
    
}
