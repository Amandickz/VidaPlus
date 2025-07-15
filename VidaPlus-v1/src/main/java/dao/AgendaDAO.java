/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import classes.Agenda;
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
    
    public boolean cadastrarAgenda(Agenda agenda){
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            pstmt = conn.prepareStatement("INSERT INTO agenda" +
                    "(idMedico, data, hora, status)" +
                    " VALUES(?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            
            pstmt.setInt(1, agenda.getIdMedico());
            pstmt.setString(2, agenda.getData());
            pstmt.setString(3, agenda.getHora());
            pstmt.setInt(4, agenda.getStatus());
            
            int rollsAffected = pstmt.executeUpdate();

            if(rollsAffected > 0){
                ResultSet rs = pstmt.getGeneratedKeys();
                while (rs.next()){
                    int id = rs.getInt(1);
                    agenda.setId(id);
                }
                System.out.println("----->Agenda Cadastrada:");
                System.out.println(agenda);
                return true;
            }
            
        } catch (SQLException e){
            System.out.println("!!!!!Erro ao CADASTRAR a Agenda!!!!!");
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
            
            System.out.println("----->Agenda Completa a partir de " + dataAtual + ": ");
            
            while(rs.next()){
                int id = rs.getInt("id");
                String data = rs.getString("data");
                String hora = rs.getString("hora");
                int status = rs.getInt("status");
                int idPaciente = rs.getInt("idPaciente");
                
                Agenda agenda = new Agenda(id, idPaciente, idMedico, data, hora, status);
                agenda.setIdPaciente(idPaciente);
                System.out.println(agenda);
                agendacompleta.add(agenda);
            }
            
            return agendacompleta;
            
        } catch (SQLException e){
            System.out.println("!!!!!Erro ao RECUPERAR a Agenda Completa!!!!!");
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(stmt);
            DB.closeConnection();
        }
        
        return null;
    }
    
    public ArrayList<Agenda> retornaDatasDisponiveis(String dataAtual, int idMedico){
        ArrayList<Agenda> datasDisponiveis = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select * from agenda where data >= " + dataAtual 
                    + " and idMedico = " + idMedico + " and status = 0");
            
            System.out.println("----->Agenda - Datas Disponíveis a partir de " + dataAtual + ": ");
            
            while(rs.next()){
                int id = rs.getInt("id");
                String data = rs.getString("data");
                String hora = rs.getString("hora");
                int status = rs.getInt("status");
                
                Agenda agenda = new Agenda(id, idMedico, data, hora, status);
                agenda.setIdMedico(idMedico);
                System.out.println(agenda);
                datasDisponiveis.add(agenda);
            }
            
            return datasDisponiveis;
            
        } catch (SQLException e){
            System.out.println("!!!!!Erro ao RECUPERAR as Datas e Horas Disponíveis!!!!!");
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(stmt);
            DB.closeConnection();
        }
        
        return null;
    }
    
    public boolean marcaConsulta(Agenda agenda){
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            pstmt = conn.prepareStatement("update agenda set idPaciente = ?, status = 1"
                    + " where data = ? and hora = ? and idMedico = ?",
                    Statement.RETURN_GENERATED_KEYS);
            
            pstmt.setInt(1, agenda.getIdPaciente());
            pstmt.setString(2, agenda.getData());
            pstmt.setString(3, agenda.getHora());
            pstmt.setInt(4, agenda.getIdMedico());
            
            int rollsAffected = pstmt.executeUpdate();

            if(rollsAffected > 0){
                ResultSet rs = pstmt.getGeneratedKeys();
                while (rs.next()){
                    int id = rs.getInt(1);
                    agenda.setId(id);
                }
                System.out.println("----->Consulta Marcada:");
                System.out.println(agenda);
                return true;
            }
            
        } catch (SQLException e){
            System.out.println("!!!!!Erro ao MARCAR a Consulta!!!!!");
        } finally {
            DB.closeStatement(pstmt);
            DB.closeConnection();
        }
        
        return false;
    }
    
    
    public ArrayList<Agenda> retornaAgendaDia(String dataAtual, int idMedico){
        ArrayList<Agenda> agendacompleta = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select * from agenda where data = '" + dataAtual + "' and idMedico = " + idMedico +
                    " and status = 1");
            
            System.out.println("----->Consultas do Dia:");
            
            while(rs.next()){
                int id = rs.getInt("id");
                int idPaciente = rs.getInt("idPaciente");
                String data = rs.getString("data");
                String hora = rs.getString("hora");
                int status = rs.getInt("status");
                
                Agenda agenda = new Agenda(id, idPaciente, idMedico, data, hora, status);
                System.out.println(agenda);
                agendacompleta.add(agenda);
            }
            
            return agendacompleta;
            
        } catch (SQLException e){
            System.out.println("!!!!!Erro ao RECUPERAR a Agenda do Dia!!!!!");
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(stmt);
            DB.closeConnection();
        }
        
        return null;
    }
    
    public ArrayList<Agenda> retornaProximasConsultasPaciente(int idPaciente, String dataAtual){
        ArrayList<Agenda> agendacompleta = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select * from agenda where idPaciente = " + idPaciente + 
                    " and data >= '" + dataAtual + "'");
            
            System.out.println("----->Próximas consultas do Paciente:");
            
            while(rs.next()){
                int id = rs.getInt("id");
                int idMedico = rs.getInt("idMedico");
                String data = rs.getString("data");
                String hora = rs.getString("hora");
                int status = rs.getInt("status");
                
                Agenda agenda = new Agenda(id, idPaciente, idMedico, data, hora, status);
                System.out.println(agenda);
                agendacompleta.add(agenda);
            }
            
            return agendacompleta;
            
        } catch (SQLException e){
            System.out.println("!!!!!Erro ao RECUPERAR as Consultas do Paciente!!!!!");
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(stmt);
            DB.closeConnection();
        }
        
        return null;
    }
    
    public Agenda retornarConsultaMarcada(String data, String hora, int idPaciente){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select * from agenda where idPaciente = " + idPaciente + 
                    " and data = '" + data + "' and hora = '" + hora + "'");
            
            while(rs.next()){
                int id = rs.getInt("id");
                int idMedico = rs.getInt("idMedico");
                int status = rs.getInt("status");
                
                Agenda agenda = new Agenda(id, idPaciente, idMedico, data, hora, status);
                System.out.println("----->Consulta marcada do Paciente:");
                System.out.println(agenda);
                return agenda;
            }
            
        } catch (SQLException e){
            System.out.println("!!!!!Erro ao RECUPERAR a Consulta Marcada do Paciente!!!!!");
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(stmt);
            DB.closeConnection();
        }
        
        return null;
    }
    
    public boolean confirmarRealizacaoConsulta(int idAgenda){
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            pstmt = conn.prepareStatement("update agenda set status = 2"
                    + " where id = ?",
                    Statement.RETURN_GENERATED_KEYS);
            
            pstmt.setInt(1 , idAgenda);
            
            int rollsAffected = pstmt.executeUpdate();

            if(rollsAffected > 0){
                System.out.println("----->Consulta Realizada!");
                return true;
            }
            
        } catch (SQLException e){
            System.out.println("!!!!!Erro ao ALTERAR REALIZAÇÃO da Consulta na Agenda!!!!!");
        } finally {
            DB.closeStatement(pstmt);
            DB.closeConnection();
        }
        
        return false;
    }
}


/*
Status = 0 (Horário disponível)
Status = 1 (Horário Marcado)
Status = 2 (Consulta realizada)
*/