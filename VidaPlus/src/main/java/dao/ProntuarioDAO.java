/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import classes.Paciente;
import classes.ProntuarioMedico;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Amanda
 */
public class ProntuarioDAO {
    
    public ProntuarioMedico buscaProntuarioPorIDPaciente(int idPaciente){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select * from prontuario where idPaciente = '" + idPaciente + "'");
            
            while(rs.next()){
                int id = rs.getInt("id");
                int idAnamnese = rs.getInt("idAnamnese");
                
                ProntuarioMedico prontuarioMedico = new ProntuarioMedico(id, idPaciente, idAnamnese);
                return prontuarioMedico;               
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
    
}
