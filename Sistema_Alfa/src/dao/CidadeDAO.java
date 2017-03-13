/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.Cidade;

/**
 *
 * @author sidney.andrde@gmail.com
 */
public class CidadeDAO {
    
    public void load(int id)throws Exception {
        String sql = "select * from endereco where idendereco = " + id;
        Cidade cidade = new Cidade();
        ResultSet rs = executaQuery(sql);
        try {
            while (rs.next()) {
                cidade.setIdCidade(rs.getInt("idcliente"));
                cidade.setNome(rs.getString("nome"));
                cidade.setEstado(rs.getString("rua"));

            }
            rs.close();
            rs = null;
        }catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Não foi possível acessar a base de dados!");
        }
    }
    
}
