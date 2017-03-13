/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author sidney
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Endereco {

    private int idClientes;
    private String nome;
    private String rua;
    private String numero;
    private String bairro;
    private int idCidade;
    private String telefone;
    private String celular;
    private String email;
    private int idUsuario;
    private String cep;
    private String rg;
    private String cpf;

    private Cidade objetoCidade;

    public Endereco(){

    }
        
    public String toString(){
        return this.getNome();
    }


    public int getIdClientes() {
        return idClientes;
    }


    public void setIdClientes(int idClientes) {
        this.idClientes = idClientes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }


    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Cidade getObjetoCidade() throws Exception {
         if(this.objetoCidade == null){
            this.objetoCidade = new Cidade();
    //        objetoCidade.load(getIdCidade());
        }
        return objetoCidade;
    }

    public void setObjetoCidade(Cidade objetoCidade) {
        this.objetoCidade = objetoCidade;
    }

}
