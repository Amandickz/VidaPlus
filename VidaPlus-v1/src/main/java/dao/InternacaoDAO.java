/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import classes.Internacao;
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
public class InternacaoDAO {
    
    public boolean solicitarInternacao(Internacao internacao){
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            pstmt = conn.prepareStatement("INSERT INTO internacao" +
                    "(idConsulta, idMedico, idProntuario, aguardandoAprovacao,"
                    + " statusAlta, observacoes)"
                    + " VALUES(?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            
            pstmt.setInt(1, internacao.getIdConsulta());
            pstmt.setInt(2, internacao.getIdMedico());
            pstmt.setInt(3, internacao.getIdProntuario());
            pstmt.setBoolean(4, internacao.isAguardandoAprovacao());
            pstmt.setBoolean(5, internacao.isStatusAlta());
            pstmt.setString(6, internacao.getObservacoes());
            
            int rollsAffected = pstmt.executeUpdate();

            if(rollsAffected > 0){
                ResultSet rs = pstmt.getGeneratedKeys();
                while (rs.next()){
                    int id = rs.getInt(1);
                    internacao.setId(id);
                }
                System.out.println("----->Solicitação de Internação realizada:");
                System.out.println(internacao);
                return true;
            }
            
        } catch (SQLException e){
            System.out.println("!!!!!Erro ao SOLICITAR a Internação!!!!!");
        } finally {
            DB.closeStatement(pstmt);
            DB.closeConnection();
        }
        
        return false;
    }
    
    public ArrayList<Internacao> retornaSolicitacoesInternacao(){
        ArrayList<Internacao> internacoes = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select * from internacao where aguardandoAprovacao = true");
            
            System.out.println("----->Internações recuperadas:");
            
            while(rs.next()){
                int id = rs.getInt("id");
                int idConsulta = rs.getInt("idConsulta");
                int idMedico = rs.getInt("idMedico");
                int idProntuario = rs.getInt("idProntuario");
                String observacoes = rs.getString("observacoes");
                
                Internacao internacao = new Internacao(id, idConsulta, idMedico, idProntuario, true, false);
                internacao.setObservacoes(observacoes);
                internacoes.add(internacao);
                System.out.println(internacao);
            }
            
            return internacoes;
            
        } catch (SQLException e){
            System.out.println("!!!!!Erro ao RECUPERAR Solicitações de Internação!!!!!");
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(stmt);
            DB.closeConnection();
        }
        return null;
    }
    
    public boolean confirmaInternacao(Internacao internacao){
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            pstmt = conn.prepareStatement("UPDATE internacao SET idLeito = ?, "
                    + "aguardandoAprovacao = ? WHERE id = ?");
            
            pstmt.setInt(1, internacao.getIdLeito());
            pstmt.setBoolean(2, internacao.isAguardandoAprovacao());
            pstmt.setInt(3, internacao.getId());
            
            int rollsAffected = pstmt.executeUpdate();

            if(rollsAffected > 0){
                System.out.println("----->Internação Confirmada pela Administração: ");
                System.out.println(internacao);
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
    
    public ArrayList<Internacao> retornaInternacoesAtivas(){
        ArrayList<Internacao> internacoes = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select * from internacao where aguardandoAprovacao = false and statusAlta = false");
            
            System.out.println("----->Internações Ativas Recuperadas:");
            
            while(rs.next()){
                int id = rs.getInt("id");
                int idConsulta = rs.getInt("idConsulta");
                int idMedico = rs.getInt("idMedico");
                int idLeito = rs.getInt("idLeito");
                int idProntuario = rs.getInt("idProntuario");
                String observacoes = rs.getString("observacoes");
                
                Internacao internacao = new Internacao(id, idConsulta, idMedico, idProntuario, false, false);
                internacao.setIdLeito(idLeito);
                internacao.setObservacoes(observacoes);
                System.out.println(internacao);
                internacoes.add(internacao);
            }           
            return internacoes;
            
        } catch (SQLException e){
            System.out.println("!!!!!Erro ao RECUPERAR Solicitações de Internação!!!!!");
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(stmt);
            DB.closeConnection();
        }
        return null;
    }
    
    public ArrayList<Internacao> retornaInternacoesAtivasPorMedico(int idMedico){
        ArrayList<Internacao> internacoes = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select * from internacao where idMedico = " + idMedico 
                    + " and aguardandoAprovacao = false and statusAlta = false");
            
            System.out.println("----->Internações recuperadas:");
            
            while(rs.next()){
                int id = rs.getInt("id");
                int idConsulta = rs.getInt("idConsulta");
                int idLeito = rs.getInt("idLeito");
                int idProntuario = rs.getInt("idProntuario");
                String observacoes = rs.getString("observacoes");
                
                Internacao internacao = new Internacao(id, idConsulta, idMedico, idProntuario, false, false);
                internacao.setIdLeito(idLeito);
                internacao.setObservacoes(observacoes);
                System.out.println(internacao);
                internacoes.add(internacao);
            }
                     
            return internacoes;
            
        } catch (SQLException e){
            System.out.println("!!!!!Erro ao RECUPERAR Solicitações de Internação!!!!!");
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(stmt);
            DB.closeConnection();
        }
        return null;
    }
    
    public Internacao retornaSolicitacaoInternacaoPorIDProntuario(int idProntuario){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select * from internacao where idProntuario = " + idProntuario 
                    + " and aguardandoAprovacao = false and statusAlta = false");
            
            while(rs.next()){
                int id = rs.getInt("id");
                int idConsulta = rs.getInt("idConsulta");
                int idMedico = rs.getInt("idMedico");
                int idLeito = rs.getInt("idLeito");
                String observacoes = rs.getString("observacoes");
                
                Internacao internacao = new Internacao(id, idConsulta, idMedico, idProntuario, false, false);
                internacao.setIdLeito(idLeito);
                internacao.setObservacoes(observacoes);
                System.out.println("----->Solicitação de Internações recuperada pelo Prontuário:");
                System.out.println(internacao);
                return internacao;
            }
            
            
        } catch (SQLException e){
            System.out.println("!!!!!Erro ao RECUPERAR Solicitações de Internação!!!!!");
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(stmt);
            DB.closeConnection();
        }
        return null;
    }
    
    public boolean realizarAlta(Internacao internacao){
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            pstmt = conn.prepareStatement("UPDATE internacao SET statusAlta = ?"
                    + " WHERE id = ?");
            
            pstmt.setBoolean(1, internacao.isStatusAlta());
            pstmt.setInt(2, internacao.getId());
            
            int rollsAffected = pstmt.executeUpdate();

            if(rollsAffected > 0){
                System.out.println("----->Alta do Paciente Realizada!");
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
    
    public Internacao retornaInternacaoPorID(int id){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select * from internacao where id = " + id);
            
            while(rs.next()){
                int idConsulta = rs.getInt("idConsulta");
                int idMedico = rs.getInt("idMedico");
                int idLeito = rs.getInt("idLeito");
                int idProntuario = rs.getInt("idProntuario");
                boolean aguardandoAprovacao = rs.getBoolean("aguardandoAprovacao");
                boolean statusAlta = rs.getBoolean("statusAlta");
                String observacoes = rs.getString("observacoes");
                
                Internacao internacao = new Internacao(id, idConsulta, idMedico, idProntuario, aguardandoAprovacao, statusAlta);
                internacao.setIdLeito(idLeito);
                internacao.setObservacoes(observacoes);
                System.out.println("----->Internação Localizada: ");
                System.out.println(internacao);
                return internacao;
            }
            
            
        } catch (SQLException e){
            System.out.println("!!!!!Erro ao RECUPERAR Solicitações de Internação!!!!!");
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(stmt);
            DB.closeConnection();
        }
        return null;
    }
    
    public Internacao retornaInternacaoPorIDProntuario(int idProntuario){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select * from internacao where idProntuario = " + idProntuario 
                    + " and statusAlta = false");
            
            while(rs.next()){
                int id = rs.getInt("id");
                int idConsulta = rs.getInt("idConsulta");
                int idMedico = rs.getInt("idMedico");
                int idLeito = rs.getInt("idLeito");
                String observacoes = rs.getString("observacoes");
                
                Internacao internacao = new Internacao(id, idConsulta, idMedico, idProntuario, true, false);
                internacao.setIdLeito(idLeito);
                internacao.setObservacoes(observacoes);
                System.out.println("----->Internação recuperada pelo Prontuário:");
                System.out.println(internacao);
                return internacao;
            }
            
            
        } catch (SQLException e){
            System.out.println("!!!!!Erro ao RECUPERAR Solicitações de Internação!!!!!");
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(stmt);
            DB.closeConnection();
        }
        return null;
    }
    
}
