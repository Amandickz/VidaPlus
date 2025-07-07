/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import classes.Agenda;
import classes.Medico;
import classes.Suprimento;
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
public class AgendaDAO {
    
    public boolean cadastrarAgenda(Agenda agenda, int idMedico){
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            pstmt = conn.prepareStatement("INSERT INTO agenda" +
                    "(idMedico, data, hora, status)" +
                    " VALUES(?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            
            pstmt.setInt(1, idMedico);
            pstmt.setString(2, agenda.getData());
            pstmt.setString(3, agenda.getHora());
            pstmt.setInt(4, agenda.getStatus());
            
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
    
    public ArrayList<Agenda> retornaAgendaCompleta(String dataAtual, int idMedico){
        ArrayList<Agenda> agendacompleta = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select * from agenda where data >= " + dataAtual + " and idMedico = " + idMedico);
            
            System.out.println(rs);
            
            while(rs.next()){
                int id = rs.getInt("id");
                String data = rs.getString("data");
                String hora = rs.getString("hora");
                int status = rs.getInt("status");
                
                Agenda agenda = new Agenda(id, data, hora, status);
                agendacompleta.add(agenda);
            }
            
            return agendacompleta;
            
        } catch (SQLException e){
            System.out.println("********Erro ao Recuperar dados!");
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(stmt);
            DB.closeConnection();
        }
        
        return null;
    }
    
}
