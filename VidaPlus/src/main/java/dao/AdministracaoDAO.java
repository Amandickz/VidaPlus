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
import java.util.ArrayList;

/**
 *
 * @author Amanda
 */
public class AdministracaoDAO {
    
    public void recuperaAdministracao(){
        ArrayList<Administracao> administradores = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select * from administracao");
            
            System.out.println("\n\n----->Administradores Recuperados:");
            
            while(rs.next()){
                int id = rs.getInt("id");
                String cnpj = rs.getString("cnpj");
                String razaoSocial = rs.getString("razaoSocial");
                String email = rs.getString("email");
                String telefone = rs.getString("telefone");
                
                Administracao adm = new Administracao(id, cnpj, razaoSocial, email, telefone);
                administradores.add(adm);
                System.out.println(adm);
            }
            
            System.out.println("\n\n");
            
        } catch (SQLException e){
            System.err.println("!!!!!Erro ao Recuperar dados dos Administradores!!!!!");
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(stmt);
            DB.closeConnection();
        }
        
    }
    
    public Administracao buscaAdmPorCNPJ(String cnpj){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select * from administracao where cnpj = '" + cnpj + "'");
            
            System.out.println("\n\n----->Administrador Recuperado:");
            
            while(rs.next()){
                int id = rs.getInt("id");
                String razaoSocial = rs.getString("razaoSocial");
                String email = rs.getString("email");
                String telefone = rs.getString("telefone");
                
                Administracao adm = new Administracao(id, cnpj, razaoSocial, email, telefone);
                System.out.println(adm);
                System.out.println("\n\n");
                return adm;
            }
            
        } catch (SQLException e){
            System.err.println("!!!!!Erro ao Recuperar dados dos Administradores!!!!!");
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(stmt);
            DB.closeConnection();
        }
        
        return null;
    }
    
}
