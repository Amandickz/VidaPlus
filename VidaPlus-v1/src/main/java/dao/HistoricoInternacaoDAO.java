/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import classes.HistoricoInternacao;
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
public class HistoricoInternacaoDAO {
    
    public boolean solicitacaoSuprimentos(HistoricoInternacao historico){
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            pstmt = conn.prepareStatement("INSERT INTO historicoInternacao" +
                    "(idPrescricao, idEnfermeiro, data, hora, suprimentos, solicitacaoAtendida)"
                    + " VALUES(?,?,?,?,?,false)",
                    Statement.RETURN_GENERATED_KEYS);
            
            pstmt.setInt(1, historico.getIdPrescricao());
            pstmt.setInt(2, historico.getIdEnfermeiro());
            pstmt.setString(3, historico.getData());
            pstmt.setString(4, historico.getHora());
            pstmt.setString(5, historico.getSuprimentos());
            
            int rollsAffected = pstmt.executeUpdate();

            if(rollsAffected > 0){
                ResultSet rs = pstmt.getGeneratedKeys();
                while (rs.next()){
                    int id = rs.getInt(1);
                    historico.setId(id);
                }
                System.out.println("----->Solicitação de Suprimento Realizado:");
                System.out.println(historico);
                return true;
            }
            
        } catch (SQLException e){
            System.out.println("!!!!!Erro ao SOLICITAR os Suprimentos!!!!!");
        } finally {
            DB.closeStatement(pstmt);
            DB.closeConnection();
        }
        
        return false;
    }
    
    public boolean verificaSolicitacaoEmAndamento(int idPrescricao){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select * from historicoInternacao "
                    + "where idPrescricao = " + idPrescricao + " and solicitacaoAtendida = false");
            
            while(rs.next()){
                System.out.println("----->Solicitação ainda está em Andamento");
                return true;
            }
            
        } catch (SQLException e){
            System.out.println("!!!!!Erro ao VERIFICAR A SOLICITAÇÃO dos Suprimentos!!!!!");
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(stmt);
            DB.closeConnection();
        }
        
        return false;
    }
    
    public ArrayList<HistoricoInternacao> retornaSolicitacoes(){
        ArrayList<HistoricoInternacao> listaSolicitacoes = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select * from historicoInternacao "
                    + "where solicitacaoAtendida = false");
            
            System.out.println("----->Lista de Solicitações de Internação em Andamento:");
            
            while(rs.next()){         
                int id = rs.getInt("id");
                int idPrescricao = rs.getInt("idPrescricao");
                int idEnfermeiro = rs.getInt("idEnfermeiro");
                String data = rs.getString("data");
                String hora = rs.getString("hora");
                String suprimentos = rs.getString("suprimentos");
                
                HistoricoInternacao historico = new HistoricoInternacao(id, idPrescricao, idEnfermeiro, data, hora, suprimentos, false);
                System.out.println(historico);
                listaSolicitacoes.add(historico);
            }
            
            return listaSolicitacoes;
            
        } catch (SQLException e){
            System.out.println("!!!!!Erro ao BUSCAR as Internações em Aguardo!!!!!");
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(stmt);
            DB.closeConnection();
        }
        
        return null;
    }
    
}
