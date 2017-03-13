/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
/**
 *
 * @author sidney.andrde@gmail.com
 */
import java.util.Date;

public class Cliente {
    private int numinscricao;
    private String nome;
    private String cpf;
    private String endereco;
    private Date datacadastro;
    private String telefone;

    public Cliente() {
    }

    public  Cliente(int numinscricao, String nome, String cpf, String endereco, Date datacadastro, String telefone) {
        this.numinscricao = numinscricao;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.datacadastro = datacadastro;
        this.telefone = telefone;
    }

    public int getNuminscricao() {
        return numinscricao;
    }

    public  void setNuminscricao(int numinscricao) {
        this.numinscricao = numinscricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(Date datacadastro) {
        this.datacadastro = datacadastro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
