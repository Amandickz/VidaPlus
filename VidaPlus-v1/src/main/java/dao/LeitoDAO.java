/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import classes.Leito;
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
public class LeitoDAO {
    
    public boolean cadastrarLeito(Leito leito){
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            pstmt = conn.prepareStatement("INSERT INTO leito" +
                    "(tipoLeito, numero, valor, status, capacidade, " + 
                    "idAdministracao, internados)" +
                    " VALUES(?,?,?,?,?,?,0)",
                    Statement.RETURN_GENERATED_KEYS);
            
            pstmt.setInt(1, leito.getTipoLeito());
            pstmt.setInt(2, leito.getNumero());
            pstmt.setDouble(3, leito.getValor());
            pstmt.setInt(4, leito.getStatus());
            pstmt.setInt(5, leito.getCapacidade());
            pstmt.setInt(6, leito.getIdAdministracao());
            
            int rollsAffected = pstmt.executeUpdate();

            if(rollsAffected > 0){
                return true;
            }
            
        } catch (SQLException e){
            System.out.println("!!!!!Erro ao CADASTRAR o Leito!!!!!");
        } finally {
            DB.closeStatement(pstmt);
            DB.closeConnection();
        }
        
        return false;
    }
    
    public ArrayList<Leito> recuperaLeito(int idAdministracao){
        ArrayList<Leito> leitos = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select * from leito where idAdministracao = " + idAdministracao);
            
            System.out.println("\n----->Leitos Recuperados da Unidade:");
            
            while(rs.next()){
                int id = rs.getInt("id");
                int tipoLeito = rs.getInt("tipoLeito");
                int numero = rs.getInt("numero");
                double valor = rs.getDouble("valor");
                int status = rs.getInt("status");
                int capacidade = rs.getInt("capacidade");
                int internados = rs.getInt("internados");
                
                Leito leito = new Leito(id, idAdministracao, tipoLeito, numero, valor, status, capacidade, internados);
                leito.setInternados(internados);
                leitos.add(leito);
                System.out.println(leito);
                System.out.println("\n");
            }
            
            return leitos;
            
        } catch (SQLException e){
            System.out.println("!!!!!Erro ao RECUPERAR o Leito!!!!!");
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(stmt);
            DB.closeConnection();
        }
        
        return null;
    }
    
    public Leito buscaLeitoPorID(int id){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select * from leito where id = " + id);
            
            System.out.println("\n----->Leitos Recuperado na Unidade:");
            
            while(rs.next()){
                int idAdministracao = rs.getInt("idAdministracao");
                int tipoLeito = rs.getInt("tipoLeito");
                int numero = rs.getInt("numero");
                double valor = rs.getDouble("valor");
                int status = rs.getInt("status");
                int capacidade = rs.getInt("capacidade");
                int internados = rs.getInt("internados");
                
                Leito leito = new Leito(id, idAdministracao, tipoLeito, numero, valor, status, capacidade, internados);
                leito.setInternados(internados);
                System.out.println(leito);
                System.out.println("\n");
                return leito;
            }
            
        } catch (SQLException e){
            System.out.println("!!!!!Erro ao LOCALIZAR o Leito!!!!!");
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(stmt);
            DB.closeConnection();
        }
        
        return null;
    }
    
    public Leito buscaLeitoPorNumero(int numero){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select * from leito where numero = " + numero);
            
            System.out.println("\n----->Leitos Recuperado na Unidade:");
            
            while(rs.next()){
                int id = rs.getInt("id");
                int idAdministracao = rs.getInt("idAdministracao");
                int tipoLeito = rs.getInt("tipoLeito");
                double valor = rs.getDouble("valor");
                int status = rs.getInt("status");
                int capacidade = rs.getInt("capacidade");
                int internados = rs.getInt("internados");
                
                Leito leito = new Leito(id, idAdministracao, tipoLeito, numero, valor, status, capacidade, internados);
                leito.setInternados(internados);
                System.out.println(leito);
                System.out.println("\n");
                return leito;
            }
            
        } catch (SQLException e){
            System.out.println("!!!!!Erro ao LOCALIZAR o Leito!!!!!");
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(stmt);
            DB.closeConnection();
        }
        
        return null;
    }
    
    public ArrayList<Leito> retornaLeitosDisponiveis(int idAdministracao){
        ArrayList<Leito> leitos = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select * from leito where status = 0 and "
                    + "idAdministracao = " + idAdministracao + " and internados < capacidade");
            
            System.out.println("\n----->Leitos Disponíveis na Unidade:");
            
            while(rs.next()){
                int id = rs.getInt("id");
                int tipoLeito = rs.getInt("tipoLeito");
                int numero = rs.getInt("numero");
                double valor = rs.getDouble("valor");
                int status = rs.getInt("status");
                int capacidade = rs.getInt("capacidade");
                int internados = rs.getInt("internados");
                
                Leito leito = new Leito(id, idAdministracao, tipoLeito, numero, valor, status, capacidade, internados);
                leito.setInternados(internados);
                leitos.add(leito);
                System.out.println(leito);
                System.out.println("\n");
            }
            
            return leitos;
            
        } catch (SQLException e){
            System.out.println("!!!!!Erro ao RECUPERAR os Leitos Disponíveis!!!!!");
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(stmt);
            DB.closeConnection();
        }
        
        return null;
    }
    
    public boolean atualizarLeito(Leito leito){
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            pstmt = conn.prepareStatement("UPDATE leito SET status = ?, "
                    + "internados = ? WHERE id = ?");
            
            pstmt.setInt(1, leito.getStatus());
            pstmt.setInt(2, leito.getInternados());
            pstmt.setInt(3, leito.getId());
            
            int rollsAffected = pstmt.executeUpdate();

            if(rollsAffected > 0){
                return true;
            }
            
        } catch (SQLException e){
            System.out.println("!!!!!Erro ao ATUALIZAR Prontuário do Paciente!!!!!");
        } finally {
            DB.closeStatement(pstmt);
            DB.closeConnection();
        }
        return false;
    }
    
}
