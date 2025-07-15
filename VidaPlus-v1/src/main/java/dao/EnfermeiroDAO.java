/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import classes.Enfermeiro;
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
public class EnfermeiroDAO {
    
    public boolean cadastrarEnfermeiro(Enfermeiro enfermeiro){
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            pstmt = conn.prepareStatement("INSERT INTO enfermeiro" +
                    "(idProfissionalSaude, coren, uf, dataEmissao, tipo)" +
                    " VALUES(?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            
            pstmt.setInt(1, enfermeiro.getId());
            pstmt.setString(2, enfermeiro.getCoren());
            pstmt.setString(3, enfermeiro.getUf());
            pstmt.setString(4, enfermeiro.getDataEmissao());
            pstmt.setInt(5, enfermeiro.getTipo());
            
            int rollsAffected = pstmt.executeUpdate();

            if(rollsAffected > 0){
                System.out.println("----->Enfermeiro Cadastrado:");
                System.out.println(enfermeiro);
                return true;
            }
            
        } catch (SQLException e){
            System.out.println("!!!!!Erro ao SALVAR o Enfermeiro!!!!!");
        } finally {
            DB.closeStatement(pstmt);
            DB.closeConnection();
        }
        
        return false;
    }
    
    public Enfermeiro buscaEnfermeiroPorCOREN(String coren){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select * from enfermeiro where coren = '" + coren + "'");
            
            while(rs.next()){
                int id = rs.getInt("idProfissionalSaude");
                String uf = rs.getString("uf");
                String dataEmissao = rs.getString("dataEmissao");
                int tipo = rs.getInt("tipo");
                
                Enfermeiro enfermeiro = new Enfermeiro(coren, uf, dataEmissao, tipo, id, "", "", "", "", "", "");
                System.out.println("----->Enfermeiro Localizado pelo COREN:");
                System.out.println(enfermeiro);
                return enfermeiro;
            }
            
        } catch (SQLException e){
            System.out.println("!!!!!Erro ao BUSCAR o Enfermeiro!!!!!");
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(stmt);
            DB.closeConnection();
        }
        return null;
    }
    
    public ArrayList<Enfermeiro> retornaListaEnfermeiros(){
        ArrayList<Enfermeiro> enfermeiros = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select * from enfermeiro");
            
            System.out.println("----->Enfermeiros Cadastrados na Unidade:");
            
            while(rs.next()){
                int id = rs.getInt("idProfissionalSaude");
                String coren = rs.getString("coren");
                String uf = rs.getString("uf");
                String dataEmissao = rs.getString("dataEmissao");
                int tipo = rs.getInt("tipo");
                
                Enfermeiro enfermeiro = new Enfermeiro(coren, uf, dataEmissao, tipo, id, "", "", "", "", "", "");
                System.out.println(enfermeiro);
                enfermeiros.add(enfermeiro);
            }
            
            return enfermeiros;
            
        } catch (SQLException e){
            System.out.println("!!!!!Erro ao RECUPERAR a Lista de Enfermeiros!!!!!");
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(stmt);
            DB.closeConnection();
        }
        return null;
    }
    
}
