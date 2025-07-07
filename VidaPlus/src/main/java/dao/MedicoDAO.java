/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import classes.Medico;
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
public class MedicoDAO {
    
    public boolean cadastrarMedico(Medico medico, int idAdministrador){
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            pstmt = conn.prepareStatement("INSERT INTO medico" +
                    "(idProfissionalSaude, crm, uf, dataInscricao, especialidade)" +
                    " VALUES(?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            
            pstmt.setInt(1, medico.getId());
            pstmt.setString(2, medico.getCrm());
            pstmt.setString(3, medico.getUf());
            pstmt.setString(4, medico.getDataInscricao());
            pstmt.setInt(5, medico.getEspecialidade());
            
            int rollsAffected = pstmt.executeUpdate();

            if(rollsAffected > 0){
                return true;
            }
            
        } catch (SQLException e){
            System.out.println("********Erro ao Cadastrar dados!");
        } finally {
            DB.closeStatement(pstmt);
            DB.closeConnection();
        }
        
        return false;
    }
    
    public Medico buscaMedicoPorCRM(String crm){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select * from medico where crm = '" + crm + "'");
            
            System.out.println(rs);
            
            while(rs.next()){
                int id = rs.getInt("idProfissionalSaude");
                String uf = rs.getString("uf");
                String dataInscricao = rs.getString("dataInscricao");
                int especialidade = rs.getInt("especialidade");
                
                Medico medico = new Medico(crm, uf, dataInscricao, especialidade, id, "", "", "", "", "", "");
                return medico;
            }
            
        } catch (SQLException e){
            System.err.println("********Erro ao Recuperar dados!");
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(stmt);
            DB.closeConnection();
        }
        return null;
    }
    
    public ArrayList<Medico> retornaListaMedica(){
        ArrayList<Medico> medicos = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select * from medico");
            
            System.out.println(rs);
            
            while(rs.next()){
                int id = rs.getInt("idProfissionalSaude");
                String crm = rs.getString("crm");
                String uf = rs.getString("uf");
                String dataInscricao = rs.getString("dataInscricao");
                int especialidade = rs.getInt("especialidade");
                
                Medico medico = new Medico(crm, uf, dataInscricao, especialidade, id, "", "", "", "", "", "");
                medicos.add(medico);
            }
            
            return medicos;
            
        } catch (SQLException e){
            System.err.println("********Erro ao Recuperar dados!");
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(stmt);
            DB.closeConnection();
        }
        return null;
    }
    
}
