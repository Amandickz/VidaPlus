/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import classes.Paciente;
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
public class PacienteDAO {
    
    public boolean cadastrarPaciente(Paciente paciente, int idAdministrador){
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            pstmt = conn.prepareStatement("INSERT INTO paciente" +
                    "(cpf,nome,email,telefone,dataNascimento,sexo,idAdministracao)" +
                    " VALUES(?,?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            
            pstmt.setString(1, paciente.getCpf());
            pstmt.setString(2, paciente.getNome());
            pstmt.setString(3, paciente.getEmail());
            pstmt.setString(4, paciente.getTelefone());
            pstmt.setString(5, paciente.getDataNascimento());
            pstmt.setInt(6, paciente.getSexo());
            pstmt.setInt(7, idAdministrador);
            
            int rollsAffected = pstmt.executeUpdate();

            if(rollsAffected > 0){
                return true;
            }
            
        } catch (SQLException e){
            System.out.println("!!!!!Erro ao CADASTRAR o Paciente!!!!!");
        } finally {
            DB.closeStatement(pstmt);
            DB.closeConnection();
        }
        
        return false;
    }
    
    public ArrayList<Paciente> retornaListaPacientes(int idAdministracao){
        ArrayList<Paciente> pacientes = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select * from paciente where idAdministracao = " + idAdministracao);
            
            System.out.println("\n----->Pacientes Recuperados da Unidade:");
            
            while(rs.next()){
                int id = rs.getInt("id");
                String cpf = rs.getString("cpf");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String telefone = rs.getString("telefone");
                String dataNascimento = rs.getString("dataNascimento");
                int sexo = rs.getInt("sexo");
                
                Paciente paciente = new Paciente(id, cpf, nome, email, telefone, dataNascimento, sexo);
                pacientes.add(paciente);
                System.out.println(paciente);
                System.out.println("\n");
            }
            
            return pacientes;
            
        } catch (SQLException e){
            System.out.println("!!!!!Erro ao RECUPERAR dados dos Paciente!!!!!");
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(stmt);
            DB.closeConnection();
        }
        return null;
    }
    
    public Paciente buscaPacientePorCPF(String cpf){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select * from paciente where cpf = '" + cpf + "'");
            
            System.out.println("\n----->Paciente Recuperado pelo CPF digitado:");
            
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String telefone = rs.getString("telefone");
                String dataNascimento = rs.getString("dataNascimento");
                int sexo = rs.getInt("sexo");
                
                Paciente paciente = new Paciente(id, cpf, nome, email, telefone, dataNascimento, sexo);
                System.out.println(paciente);
                System.out.println("\n");
                return paciente;
            }
            
        } catch (SQLException e){
            System.out.println("!!!!!Erro ao RECUPERAR dados do Paciente!!!!!");
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(stmt);
            DB.closeConnection();
        }
        return null;
    }
    
    public Paciente buscaPacientePorID(int id){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select * from paciente where id = " + id);
            
            System.out.println("\n----->Paciente Recuperado pelo ID digitado:");
            
            while(rs.next()){
                String cpf = rs.getString("cpf");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String telefone = rs.getString("telefone");
                String dataNascimento = rs.getString("dataNascimento");
                int sexo = rs.getInt("sexo");
                int idAdministracao = rs.getInt("idAdministracao");
                
                Paciente paciente = new Paciente(id, cpf, nome, email, telefone, dataNascimento, sexo);
                paciente.setIdAdministrador(idAdministracao);
                System.out.println(paciente);
                System.out.println("\n");
                return paciente;
            }
            
        } catch (SQLException e){
            System.out.println("!!!!!Erro ao RECUPERAR dados do Paciente!!!!!");
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(stmt);
            DB.closeConnection();
        }
        return null;
    }
    
    public Paciente buscaPacientePorNome(String nome){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select * from paciente where nome = '" + nome + "'");
            
            System.out.println("\n----->Paciente Recuperado pelo NOME digitado:");
            
            while(rs.next()){
                int id = rs.getInt("id");
                String cpf = rs.getString("cpf");
                String email = rs.getString("email");
                String telefone = rs.getString("telefone");
                String dataNascimento = rs.getString("dataNascimento");
                int sexo = rs.getInt("sexo");
                
                Paciente paciente = new Paciente(id, cpf, nome, email, telefone, dataNascimento, sexo);
                System.out.println(paciente);
                System.out.println("\n");
                return paciente;
            }
            
        } catch (SQLException e){
            System.out.println("!!!!!Erro ao RECUPERAR dados do Paciente!!!!!");
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(stmt);
            DB.closeConnection();
        }
        return null;
    }
    
}
