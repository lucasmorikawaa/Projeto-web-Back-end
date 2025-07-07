package br.gov.sp.fatec.itu.cadastroweb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.fatec.itu.cadastroweb.models.Category;
import br.gov.sp.fatec.itu.cadastroweb.models.Pessoa;
import br.gov.sp.fatec.itu.cadastroweb.repositories.PessoaRepository;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

     @Autowired
    private CategoryService categoryService;
    
    public Pessoa getById(int id){

        Pessoa pessoa = pessoaRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa not found"));

            return pessoa;
    }

    public List <Pessoa> getAll(){
        return pessoaRepository.findAll();
    }

    public Pessoa save(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }


    public void deleteById(int id){
        Pessoa pessoa = getById(id);
        pessoaRepository.delete(pessoa);
    }

    public void update(int id, Pessoa pessoaUpdate){
        Pessoa pessoa = getById(id);

        if(pessoaUpdate.getEstado() == null){
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria can not be empity");
        }

        Category category = categoryService.getById(pessoaUpdate.getEstado().getId());

        pessoa.setName(pessoaUpdate.getName());
        pessoa.setEmail(pessoaUpdate.getEmail());
        pessoa.setTelefone(pessoaUpdate.getTelefone());
        pessoa.setDatanascimento(pessoaUpdate.getDatanascimento());
        pessoa.setCpf(pessoaUpdate.getCpf());
        pessoa.setEndereco(pessoaUpdate.getEndereco());
        pessoa.setCidade(pessoaUpdate.getCidade());
        pessoa.setEstado(category);
        pessoa.setCep(pessoaUpdate.getCep());
        pessoa.setFavorito(pessoaUpdate.isFavorito());

        pessoaRepository.save(pessoa);
    }


}
