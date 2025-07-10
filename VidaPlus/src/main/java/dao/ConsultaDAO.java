/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import classes.Consulta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Amanda
 */
public class ConsultaDAO {
    
    public boolean salvarConsulta(Consulta consulta){
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            pstmt = conn.prepareStatement("INSERT INTO consulta" +
                    "(idAgenda, idProntuario, queixa, sintomas, pressao, frequenciaCardiaca,"
                    + " temperatura, diagnostico, prescricao, observacoes)" +
                    " VALUES(?,?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            
            
            
            int rollsAffected = pstmt.executeUpdate();

            if(rollsAffected > 0){
                return true;
            }
            
        } catch (SQLException e){
            System.out.println("!!!!!Erro ao SALVAR a Consulta!!!!!");
        } finally {
            DB.closeStatement(pstmt);
            DB.closeConnection();
        }
        
        return false;
    }
    
}
