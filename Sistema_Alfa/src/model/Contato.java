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
 
public class Contato {
 
private int id;
 private String nome;
 private int idade;
 private Date dataCadastro;
 
 public int getId() {
 return id;
 }
 
 public void setId(int id) {
 this.id = id;
 }
 
 public String getNome() {
 return nome;
 }
 
 public void setNome(String nome) {
 this.nome = nome;
 }
 
 public int getIdade() {
 return idade;
 }
 
 public void setIdade(int idade) {
 this.idade = idade;
 }
 
 public Date getDataCadastro() {
 return dataCadastro;
 }
 
 public void setDataCadastro(Date dataCadastro) {
 this.dataCadastro = dataCadastro;
 }
}
