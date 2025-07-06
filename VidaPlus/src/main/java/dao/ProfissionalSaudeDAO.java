/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import classes.Administracao;
import classes.Enfermeiro;
import classes.Farmaceutico;
import classes.Medico;
import classes.ProfissionalSaude;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Amanda
 */
public class ProfissionalSaudeDAO {
    
    public ProfissionalSaude buscaProfissional(String cpf){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select * from profissionalsaude where cpf = '" + cpf + "'");
            
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                String dataNascimento = rs.getString("dataNascimento");
                String dataContratacao = rs.getString("dataContratacao");
                
                ProfissionalSaude profissional = new ProfissionalSaude(id, cpf, nome, telefone, email, dataNascimento, dataContratacao);
                System.out.println(profissional);
                return profissional;

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
    
    public Medico buscaMedicoPorID(ProfissionalSaude profissional){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select * from medico where idProfissionalSaude = '" + profissional.getId() + "'");
            
            while(rs.next()){
                String crm = rs.getString("crm");
                String uf = rs.getString("uf");
                String dataInscricao = rs.getString("dataInscricao");
                int especialidade = rs.getInt("especialidade");
                
                Medico medico = new Medico(crm, uf, dataInscricao, especialidade,
                        profissional.getId(), profissional.getCpf(), profissional.getNome(),
                        profissional.getTelefone(), profissional.getEmail(),
                        profissional.getDataNascimento(), profissional.getDataContratacao());
                
                System.out.println(medico);
                
                return medico;
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
    
    public Enfermeiro buscaEnfermeiroPorID(ProfissionalSaude profissional){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select * from enfermeiro where idProfissionalSaude = '" + profissional.getId() + "'");
            
            while(rs.next()){
                String coren = rs.getString("coren");
                String uf = rs.getString("uf");
                String dataEmissao = rs.getString("dataEmissao");
                int tipo = rs.getInt("tipo");
                
                Enfermeiro enfermeiro = new Enfermeiro(coren, uf, dataEmissao, tipo,
                        profissional.getId(), profissional.getCpf(), profissional.getNome(),
                        profissional.getTelefone(), profissional.getEmail(),
                        profissional.getDataNascimento(), profissional.getDataContratacao());
                
                System.out.println(enfermeiro);
                
                return enfermeiro;
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
    
    public Farmaceutico buscaFarmaceuticoPorID(ProfissionalSaude profissional){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select * from farmaceutico where idProfissionalSaude = '" + profissional.getId() + "'");
            
            while(rs.next()){
                String crf = rs.getString("crf");
                String uf = rs.getString("uf");
                int categoriaProfissional = rs.getInt("categoriaProfissional");
                String dataConclusao = rs.getString("dataConclusao");
                String dataExpedicao = rs.getString("dataExpedicao");
                
                Farmaceutico farmaceutico = new Farmaceutico(crf, uf, categoriaProfissional, dataConclusao, dataExpedicao,
                        profissional.getId(), profissional.getCpf(), profissional.getNome(),
                        profissional.getTelefone(), profissional.getEmail(),
                        profissional.getDataNascimento(), profissional.getDataContratacao());
                
                System.out.println(farmaceutico);
                
                return farmaceutico;
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
