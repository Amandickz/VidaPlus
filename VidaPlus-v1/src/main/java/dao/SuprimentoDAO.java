/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

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
public class SuprimentoDAO {
    
    public boolean cadastrarSuprimento(Suprimento suprimento, int idAdministrador){
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            pstmt = conn.prepareStatement("INSERT INTO suprimento" +
                    "(idAdministracao, tipo, nome, valorUnitario, quantEstoque)" +
                    " VALUES(?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            
            pstmt.setInt(1, idAdministrador);
            pstmt.setInt(2, suprimento.getTipo());
            pstmt.setString(3, suprimento.getNome());
            pstmt.setDouble(4, suprimento.getValorUnitario());
            pstmt.setInt(5, suprimento.getQuantidadeEstoque());
            
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
    
    public ArrayList<Suprimento> recuperaSuprimentos(int idAdministracao){
        ArrayList<Suprimento> suprimentos = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select * from suprimento where idAdministracao = " + idAdministracao);
            
            
            while(rs.next()){
                int id = rs.getInt("id");
                int tipo = rs.getInt("tipo");
                String nome = rs.getString("nome");
                double valorUnitario = rs.getDouble("valorUnitario");
                int quantEstoque = rs.getInt("quantEstoque");
                
                Suprimento suprimento = new Suprimento(id, tipo, nome, valorUnitario, quantEstoque);
                suprimentos.add(suprimento);
            }
            
            return suprimentos;
            
        } catch (SQLException e){
            System.out.println("********Erro ao Recuperar dados!");
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(stmt);
            DB.closeConnection();
        }
        
        return null;
    }
    
    public Suprimento buscaSuprimentoPorNome(String nome){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select * from suprimento where nome = '" + nome + "'");
            
            System.out.println(rs);
            
            while(rs.next()){
                int id = rs.getInt("id");
                int tipo = rs.getInt("tipo");
                double valorUnitario = rs.getDouble("valorUnitario");
                int quantEstoque = rs.getInt("quantEstoque");
                
                Suprimento suprimento = new Suprimento(id, tipo, nome, valorUnitario, quantEstoque);
                return suprimento;
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
