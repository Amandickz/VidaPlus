/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import classes.Administracao;
import classes.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Amanda
 */
public class AdministracaoDAO {
    
    public boolean cadastraAdministracao(Administracao adm){
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            pstmt = conn.prepareStatement("INSERT INTO administracao" +
                    "(cnpj, razaoSocial, email, telefone)" +
                    " VALUES(?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            
            pstmt.setString(1, adm.getCnpj());
            pstmt.setString(2, adm.getRazaoSocial());
            pstmt.setString(3, adm.getEmail());
            pstmt.setString(4, adm.getTelefone());
            
            int rollsAffected = pstmt.executeUpdate();

            if(rollsAffected > 0){
                return true;
            }
            
        } catch (SQLException e){
            System.out.println("!!!!!Erro ao CADASTRAR o Administrador!!!!!");
        } finally {
            DB.closeStatement(pstmt);
            DB.closeConnection();
        }
        
        return false;
    }
    
    public ArrayList<Administracao> recuperaAdministracao(){
        ArrayList<Administracao> administradores = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select * from administracao");
            
            System.out.println("\n----->Administradores Recuperados:");
            
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
            
            System.out.println("\n");
            return administradores;
            
        } catch (SQLException e){
            System.out.println("!!!!!Erro ao RECUPERAR dados dos Administradores!!!!!");
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(stmt);
            DB.closeConnection();
        }
        
        return null;
        
    }
    
    public Administracao buscaAdmPorCNPJ(String cnpj){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select * from administracao where cnpj = '" + cnpj + "'");
            
            System.out.println("\n----->Administrador Recuperado:");
            
            while(rs.next()){
                int id = rs.getInt("id");
                String razaoSocial = rs.getString("razaoSocial");
                String email = rs.getString("email");
                String telefone = rs.getString("telefone");
                
                Administracao adm = new Administracao(id, cnpj, razaoSocial, email, telefone);
                System.out.println(adm);
                System.out.println("\n");
                return adm;
            }
            
        } catch (SQLException e){
            System.out.println("!!!!!Erro ao BUSCAR dados dos Administradores!!!!!");
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(stmt);
            DB.closeConnection();
        }
        
        return null;
    }
    
}
