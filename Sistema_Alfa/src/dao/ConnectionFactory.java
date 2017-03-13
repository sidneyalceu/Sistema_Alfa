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
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class ConnectionFactory {
 
   //Nome do usuário do mysql
   private static final String USERNAME = "root";
 
   //Senha do mysql
   private static final String PASSWORD = "root";
 
   //Dados de caminho, porta e nome da base de dados que irá ser feita a conexão
   private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agenda";

   public static Connection createConnectionToMySQL() {
       try {
           Class.forName("com.mysql.jdbc.Driver"); //Faz com que a classe seja carregada pela JVM
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
       }
 
      //Cria a conexão com o banco de dados
       Connection connection = null;      
       try {

           connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
       } catch (SQLException ex) {
           Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
       } 
       
       return connection;
       
   }
   
   public Connection testeConnection() {
 
      //Recupera uma conexão com o banco de dados
      Connection con = createConnectionToMySQL();
 
      //Testa se a conexão é nula
      if(con != null){
         System.out.println("Conexão obtida com sucesso!" + con);
          try {
              con.close();
          } catch (SQLException ex) {
              Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
       return null;
 
    }
}
