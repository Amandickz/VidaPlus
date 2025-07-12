/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Amanda
 */
public class DB {
    
    public static Connection conn = null;
    
    public static Connection getConeConnection(){
        if(conn == null){
            try{
                
                String user = "root";
                String password = "root";
                String url = "jdbc:mysql://localhost:3306/vidaplus";
                conn = DriverManager.getConnection(url, user, password);
                
                //System.out.println("********Conexão realizada!");
                
            } catch (SQLException e){
                System.out.println("!!!!!!!!/n"
                        + "Erro na conexão!/n"
                        + "(!!!!!!!!");
            }
        }
        return conn;
    }
    
    public static void closeConnection(){
        if(conn != null){
            try{
                
                conn.close();
                conn = null;
                
                //System.out.println("********Conexão fechada!");
                
            } catch (SQLException e){
                System.out.println("!!!!!!!!/n"
                        + "Erro ao fechar o bancon/"
                        + "!!!!!!!!");
            }
        }
    }
    
    public static void closeStatement(Statement stmt){
        if(stmt != null){
            try{
                stmt.close();
                
                //System.out.println("********Statement fechada!");
            } catch (SQLException e){
                System.out.println("********Erro ao fechar o Statement!");
            }
        }
    }
    
    public static void closeResultSet(ResultSet rs){
        if(rs != null){
            try{
                rs.close();
                
                //System.out.println("********ResultSet fechada!");
            } catch (SQLException e){
                System.out.println("********Erro ao fechar o ResultSet!");
            }
        }
    }
    
}