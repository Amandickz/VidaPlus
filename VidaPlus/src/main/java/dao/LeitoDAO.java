/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import classes.Leito;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Amanda
 */
public class LeitoDAO {
    
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
                boolean status = rs.getBoolean("status");
                int capacidade = rs.getInt("capacidade");
                
                Leito leito = new Leito(id, tipoLeito, numero, valor, status, capacidade);
                leitos.add(leito);
            }
            
            System.out.println(leitos);
            
            return leitos;
            
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
