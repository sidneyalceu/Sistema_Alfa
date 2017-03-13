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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cidade;
import model.Endereco;

public class EnderecoDAO {

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

    public EnderecoDAO(){

    }
    
    public void alter(Endereco endereco)throws Exception {
        String sql = "UPDATE endereco SET nome=?, rua=?, numero=?, bairro=?, " +
                "idcidade=?, telefone=?, celular=?, email=?, cep=?, rg=?, cpf=?, idusuario=? " +
                " where idcliente = " + endereco.getIdClientes();
        PreparedStatement pst = prepara(sql);
        try {
            pst.setString(1, endereco.getNome());
            pst.setString(2, endereco.getRua());
            pst.setString(3, endereco.getNumero());
            pst.setString(4, endereco.getBairro());
            pst.setInt(5, endereco.getIdCidade());
            pst.setString(6, endereco.getTelefone());
            pst.setString(7, endereco.getCelular());
            pst.setString(8, endereco.getEmail());
            pst.setString(9, endereco.getCep());
            pst.setString(10, endereco.getRg());
            pst.setString(11, endereco.getCpf());
            pst.setInt(12, endereco.getIdUsuario());
              if (pst.executeUpdate() == 0) {
                throw new Exception("O Registro não pode ser alterado!");
            }
            pst.close();
            pst = null;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Não foi possível acessar a base de dados!");
        }
    }
    
    public void load(int id)throws Exception {
        String sql = "select * from endereco where idendereco = " + id;
        Endereco endereco = new Endereco();
        ResultSet rs = executaQuery(sql);
        try {
            while (rs.next()) {
                endereco.setIdClientes(rs.getInt("idcliente"));
                endereco.setNome(rs.getString("nome"));
                endereco.setRua(rs.getString("rua"));
                endereco.setNumero(rs.getString("numero"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setIdCidade(rs.getInt("idcidade"));
                endereco.setTelefone(rs.getString("telefone"));
                endereco.setCelular(rs.getString("celular"));
                endereco.setEmail(rs.getString("email"));
                endereco.setCep(rs.getString("cep"));
                endereco.setRg(rs.getString("rg"));
                endereco.setCpf(rs.getString("cpf"));
                endereco.setIdUsuario(rs.getInt("idusuario"));
            }
            rs.close();
            rs = null;
        }catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Não foi possível acessar a base de dados!");
        }
    }
    
    public void delete(Endereco endereco)throws Exception {
        String sql = "delete from endereco where idendereco ='" + endereco.getIdClientes() + "'";
        try {
            executa(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Não foi possível excluir o registro da base de dados!");
        }
    }
    
    public static List<Endereco> list(String where, String orderBy)throws Exception {
        String sql = "select * from endereco";

        if (where != null) {
            sql += " where " + where;
        }
        if (orderBy != null) {
            sql += " order by " + orderBy;
        }
        List<Endereco> resultado = new ArrayList<Endereco>();
        try {
            ResultSet rs = executaQuery(sql);
            while (rs.next()) {
                Endereco endereco = new Endereco();
                endereco.setIdClientes(rs.getInt("idcliente"));
                endereco.setNome(rs.getString("nome"));
                endereco.setRua(rs.getString("rua"));
                endereco.setNumero(rs.getString("numero"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setIdCidade(rs.getInt("idcidade"));
                endereco.setTelefone(rs.getString("telefone"));
                endereco.setCelular(rs.getString("celular"));
                endereco.setEmail(rs.getString("email"));
                endereco.setCep(rs.getString("cep"));
                endereco.setRg(rs.getString("rg"));
                endereco.setCpf(rs.getString("cpf"));
                endereco.setIdUsuario(rs.getInt("idusuario"));
                resultado.add(endereco);
            }
            rs.close();
            rs = null;
            return resultado;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Não foi possível consultar a base de dados!");
        }
    }
    
    public void save(Endereco endereco)throws Exception {
        String sql = "INSERT INTO cliente(idcliente, nome, rua, numero, bairro, idcidade, " +
                "telefone, celular, email, cep, rg, cpf, idusuario) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        ResultSet rs = DAO.executaQuery("SELECT nextval('cliente_idcliente_seq');");
        if (rs.next()) {
            endereco.setIdClientes(rs.getInt(1));
        }

        PreparedStatement pst = prepara(sql);
        try {
            pst.setInt(1, endereco.getIdClientes());
            pst.setString(2, endereco.getNome());
            pst.setString(3, endereco.getRua());
            pst.setString(4, endereco.getNumero());
            pst.setString(5, endereco.getBairro());
            pst.setInt(6, endereco.getIdCidade());
            pst.setString(7, endereco.getTelefone());
            pst.setString(8, endereco.getCelular());
            pst.setString(9, endereco.getEmail());
            pst.setString(10, endereco.getCep());
            pst.setString(11, endereco.getRg());
            pst.setString(12, endereco.getCpf());
            pst.setInt(13, endereco.getIdUsuario());
            pst.executeUpdate();
            pst.close();
            pst = null;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Não foi possível incluir o registro na base de dados!");
        }
    }
}
