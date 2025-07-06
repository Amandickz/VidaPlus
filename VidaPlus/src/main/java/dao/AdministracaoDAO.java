/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import classes.Administracao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Amanda
 */
public class AdministracaoDAO {
    
    public void testeConnection(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select * from administracao");
            
            while(rs.next()){
                int id = rs.getInt("id");
                String cnpj = rs.getString("cnpj");
                String razaoSocial = rs.getString("razaoSocial");
                String email = rs.getString("email");
                String telefone = rs.getString("telefone");
                
                Administracao adm = new Administracao(id, cnpj, razaoSocial, email, telefone);
                System.out.println(adm);
            }
            
        } catch (SQLException e){
            System.err.println("********Erro ao Recuperar dados!");
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(stmt);
            DB.closeConnection();
        }
        
    }
    
}
