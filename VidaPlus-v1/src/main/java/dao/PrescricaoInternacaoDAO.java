/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import classes.PrescricaoInternacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Amanda
 */
public class PrescricaoInternacaoDAO {
    
    public boolean novaPrescricao(PrescricaoInternacao prescricao){
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            pstmt = conn.prepareStatement("INSERT INTO prescricaointernacao" +
                    "(idInternacao,data,prescricao,orientacoes,observacoes,realizado)" +
                    " VALUES(?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            
            pstmt.setInt(1, prescricao.getIdInternacao());
            pstmt.setString(2, prescricao.getData());
            pstmt.setString(3, prescricao.getPrescricao());
            pstmt.setString(4, prescricao.getOrientacoes());
            pstmt.setString(5, prescricao.getObservacoes());
            pstmt.setBoolean(6, prescricao.isRealizado());
            
            
            int rollsAffected = pstmt.executeUpdate();

            if(rollsAffected > 0){
                return true;
            }
            
        } catch (SQLException e){
            System.out.println("!!!!!Erro ao CRIAR nova Prescrição!!!!!");
        } finally {
            DB.closeStatement(pstmt);
            DB.closeConnection();
        }
        
        return false;
    }
    
}
