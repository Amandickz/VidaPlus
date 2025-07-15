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
                    " VALUES(?,?,?,?,?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            
            pstmt.setInt(1, consulta.getIdAgenda());
            pstmt.setInt(2, consulta.getIdProntuario());
            pstmt.setString(3, consulta.getQueixa());
            pstmt.setString(4, consulta.getSintomas());
            pstmt.setInt(5, consulta.getPressao());
            pstmt.setInt(6, consulta.getFrequenciaCardiaca());
            pstmt.setInt(7, consulta.getTemperatura());
            pstmt.setString(8, consulta.getDiagnostico());
            pstmt.setString(9, consulta.getPrescricao());
            pstmt.setString(10, consulta.getObservacoes());
            
            int rollsAffected = pstmt.executeUpdate();

            if(rollsAffected > 0){
                System.out.println("----->Consulta Realizada:");
                System.out.println(consulta);
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
