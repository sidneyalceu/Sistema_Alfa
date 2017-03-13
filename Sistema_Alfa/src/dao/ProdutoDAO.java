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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;
import model.Produto;


public class ProdutoDAO{

private Connection con;//objeto connection que será usado nos métodos abaixo

/*
* Construtor que recebe como parametro uma conexao com o banco de dado. 
*/
public ProdutoDAO(Connection con){
   this.con = con;
}

public void cadastrar(Produto produto) throws Exception {
   PreparedStatement p = con.prepareStatement("insert into produto (nome, descricao) values (?,?)");
   p.setString(1, produto.getNome());
   p.setString(2, produto.getDescricao());
   p.executeUpdate();
   p.close();
}

public void deletar(Produto produto) throws Exception {
   PreparedStatement p = con.prepareStatement("delete from produto where id = ?");
   p.setInt(1, produto.getId());
   p.executeUpdate();
   p.close();
}

public void update(Produto produto) throws Exception {
   PreparedStatement p = 
   con.prepareStatement("update produto set nome = ?, descricao = ? where id = ?");
   p.setString(1, produto.getNome());
   p.setString(2, produto.getDescricao());
   p.setInt(3, produto.getId());
   p.executeUpdate();
   p.close();
}

public List<Produto> listarTodos() throws Exception{
   List<Produto> produtos = new ArrayList<Produto>();
   PreparedStatement p = con.prepareStatement("select * from produto");
   ResultSet rs = p.executeQuery();
   while(rs.next()){
      Produto produto = new Produto();
      produto.setId(rs.getInt("id"));
      produto.setNome(rs.getString("nome"));
      produto.setDescricao(rs.getString("descricao"));
      produtos.add(produto);
   }
   rs.close();
   p.close();
   return produtos;
}

}//fim da classe ProdutoDAO
