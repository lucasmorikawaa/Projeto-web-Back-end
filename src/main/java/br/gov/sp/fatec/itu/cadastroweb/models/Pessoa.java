package br.gov.sp.fatec.itu.cadastroweb.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "TBL_PESSOA")
public class Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String telefone;
    private String datanascimento;
    private String cpf;
    private String endereco;
    private String cidade;
    private String cep;
    private boolean favorito = false;
   

    @ManyToOne
    private Category estado;

    

    public Pessoa(int id, String name, String email, String telefone, String datanascimento,String cpf, String endereco, String cidade, Category estado, String cep,
    boolean favorito){
        this.id = id;
        this.name = name;
        this.email = email;
        this.telefone = telefone;
        this.datanascimento = datanascimento;
        this.cpf = cpf;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.favorito = favorito;
    }

    

    public Pessoa(){

    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getDatanascimento() {
        return datanascimento;
    }
    public void setDatanascimento(String datanascimento) {
        this.datanascimento = datanascimento;
    }
    
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public Category getEstado() {
        return estado;
    }
    public void setEstado(Category estado) {
        this.estado = estado;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean isFavorito() {
        return favorito;
    }


    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }
    

    

}
