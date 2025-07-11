/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import classes.Internacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

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
    
}
