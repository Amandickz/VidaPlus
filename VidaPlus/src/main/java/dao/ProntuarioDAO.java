/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import classes.ProntuarioMedico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Amanda
 */
public class ProntuarioDAO {
    
    public ProntuarioMedico criarProntuario(ProntuarioMedico prontuarioMedico){
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            pstmt = conn.prepareStatement("INSERT INTO prontuario "
                    + "(idPaciente, idAnamnese) "
                    + "VALUES (?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            
            pstmt.setInt(1, prontuarioMedico.getIdPaciente());
            pstmt.setInt(2, prontuarioMedico.getIdAnamnese());
            

            int rollsAffected = pstmt.executeUpdate();

            if(rollsAffected > 0){
                ResultSet rs = pstmt.getGeneratedKeys();
                while (rs.next()){
                    int id = rs.getInt(1);
                    prontuarioMedico.setId(id);
                }
                return prontuarioMedico;
            }
            
        } catch (SQLException e){
            System.out.println("!!!!!Erro ao CRIAR Prontuário do Paciente!!!!!");
        } finally {
            DB.closeStatement(pstmt);
            DB.closeConnection();
        }
        return null;
    }
    
    public ProntuarioMedico buscaProntuarioPorIDPaciente(int idPaciente){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select * from prontuario where idPaciente = " + idPaciente);
            
            while(rs.next()){
                int id = rs.getInt("id");
                int idAnamnese = rs.getInt("idAnamnese");
                String dataAtualizacao = rs.getString("dataAtualizacao");
                String servico = rs.getString("servico");
                
                ProntuarioMedico prontuarioMedico = new ProntuarioMedico(id, idPaciente, idAnamnese);
                prontuarioMedico.setDataAtualizacao(dataAtualizacao);
                prontuarioMedico.setServico(servico);
                
                return prontuarioMedico;               
            }
            
        } catch (SQLException e){
            System.out.println("!!!!!Erro ao BUSCAR Prontuário do Paciente por ID!!!!!");
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(stmt);
            DB.closeConnection();
        }
        return null;
    }
    
    public boolean atualizacaoPronturario(ProntuarioMedico prontuarioMedico){
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            pstmt = conn.prepareStatement("UPDATE prontuario SET dataAtualizacao = ?, "
                    + "servico = ? WHERE id = ?");
            
            pstmt.setString(1, prontuarioMedico.getDataAtualizacao());
            pstmt.setString(2, prontuarioMedico.getServico());
            pstmt.setInt(3, prontuarioMedico.getId());
            
            int rollsAffected = pstmt.executeUpdate();

            if(rollsAffected > 0){
                return true;
            }
            
        } catch (SQLException e){
            System.out.println("!!!!!Erro ao ATUALIZAR Prontuário do Paciente!!!!!");
        } finally {
            DB.closeStatement(pstmt);
            DB.closeConnection();
        }
        return false;
    }
    
    public ProntuarioMedico buscaProntuarioPorID(int id){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select * from prontuario where id = " + id);
            
            System.out.println("\n----->Prontuario Localizado: ");
            
            while(rs.next()){
                int idPaciente = rs.getInt("idPaciente");
                int idAnamnese = rs.getInt("idAnamnese");
                String dataAtualizacao = rs.getString("dataAtualizacao");
                String servico = rs.getString("servico");
                
                ProntuarioMedico prontuario = new ProntuarioMedico(id, idPaciente, idAnamnese);
                prontuario.setDataAtualizacao(dataAtualizacao);
                prontuario.setServico(servico);
                
                System.out.println(prontuario);
                
                return prontuario;  
            }
            
        } catch (SQLException e){
            System.out.println("!!!!!Erro ao BUSCAR Prontuário do Paciente por ID!!!!!");
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(stmt);
            DB.closeConnection();
        }
        return null;
    }
    
}
