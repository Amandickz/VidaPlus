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
    
    public boolean cadastrarLeito(Leito leito, int idAdministrador){
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            pstmt = conn.prepareStatement("INSERT INTO leito" +
                    "(tipoLeito, numero, valor, status, capacidade, idAdministracao)" +
                    " VALUES(?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            
            pstmt.setInt(1, leito.getTipoLeito());
            pstmt.setInt(2, leito.getNumero());
            pstmt.setDouble(3, leito.getValor());
            pstmt.setInt(4, leito.getStatus());
            pstmt.setInt(5, leito.getCapacidade());
            pstmt.setInt(6, idAdministrador);
            
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
    
    public ArrayList<Leito> recuperaLeito(int idAdministracao){
        ArrayList<Leito> leitos = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select * from leito where idAdministracao = " + idAdministracao);
            
            System.out.println(rs);
            
            while(rs.next()){
                int id = rs.getInt("id");
                int tipoLeito = rs.getInt("tipoLeito");
                int numero = rs.getInt("numero");
                double valor = rs.getDouble("valor");
                int status = rs.getInt("status");
                int capacidade = rs.getInt("capacidade");
                
                Leito leito = new Leito(id, tipoLeito, numero, valor, status, capacidade);
                leitos.add(leito);
            }
            
            System.out.println(leitos);
            
            return leitos;
            
        } catch (SQLException e){
            System.out.println("********Erro ao Recuperar dados!");
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
            
            System.out.println(rs);
            
            while(rs.next()){
                int id = rs.getInt("id");
                int tipoLeito = rs.getInt("tipoLeito");
                double valor = rs.getDouble("valor");
                int status = rs.getInt("status");
                int capacidade = rs.getInt("capacidade");
                
                Leito leito = new Leito(id, tipoLeito, numero, valor, status, capacidade);
                System.out.println(leito);
                return leito;
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
