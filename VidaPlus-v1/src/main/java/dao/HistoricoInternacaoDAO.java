/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import classes.HistoricoInternacao;
import classes.Suprimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
                return true;
            }
            
        } catch (SQLException e){
            System.out.println("!!!!!Erro ao SALVAR o Procedimento!!!!!");
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
                    + "where idPrescricao = " + idPrescricao);
            
            while(rs.next()){         
                return true;
            }
            
        } catch (SQLException e){
            System.err.println("********Erro ao Recuperar dados!");
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(stmt);
            DB.closeConnection();
        }
        
        return false;
    }
    
}
