/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author sidney.andrde@gmail.com
 */
 
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
import dao.ConnectionFactory;
import model.Contato;
 
public class ContatoDAO {
 
    public void save(Contato contato){
 
    String sql = "INSERT INTO contatos(nome,idade,dataCadastro)" +
    " VALUES(?,?,?)";
    Connection conn = null;
    PreparedStatement pstm = null;

    try {
       //Cria uma conexão com o banco
       conn = ConnectionFactory.createConnectionToMySQL();

       //Cria um PreparedStatment, classe usada para executar a query
       pstm = conn.prepareStatement(sql);

       //Adiciona o valor do primeiro parâmetro da sql
       pstm.setString(1, contato.getNome());
       //Adicionar o valor do segundo parâmetro da sql
       pstm.setInt(2, contato.getIdade());
       //Adiciona o valor do terceiro parâmetro da sql
       pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));

       //Executa a sql para inserção dos dados
       pstm.execute();

    } catch (Exception e) {
        e.printStackTrace();
    } finally {

        try {
            if(pstm != null){
                pstm.close();
            }
            if(conn != null){
                conn.close();
            }

            } catch(Exception e) {
                 e.printStackTrace();
            }
        }
    }
}
