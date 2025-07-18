/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import classes.Farmaceutico;
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
public class FarmaceuticoDAO {
    
    public boolean cadastrarFarmaceutico(Farmaceutico farmaceutico){
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            pstmt = conn.prepareStatement("INSERT INTO farmaceutico" +
                    "(idProfissionalSaude, crf, uf, categoriaProfissional, dataExpedicao)" +
                    " VALUES(?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            
            pstmt.setInt(1, farmaceutico.getId());
            pstmt.setString(2, farmaceutico.getCrf());
            pstmt.setString(3, farmaceutico.getUf());
            pstmt.setInt(4, farmaceutico.getCategoriaProfissional());
            pstmt.setString(5, farmaceutico.getDataExpedicao());
            
            int rollsAffected = pstmt.executeUpdate();

            if(rollsAffected > 0){
                System.out.println("----->Farmacêutico Cadastrado:");
                System.out.println(farmaceutico);
                return true;
            }
            
        } catch (SQLException e){
            System.out.println("!!!!!Erro ao SALVAR o Farmacêutico!!!!!");
        } finally {
            DB.closeStatement(pstmt);
            DB.closeConnection();
        }
        
        return false;
    }
    
    public Farmaceutico buscaEnfermeiroPorCRF(String crf){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select * from farmaceutico where crf = '" + crf + "'");
            
            while(rs.next()){
                int id = rs.getInt("idProfissionalSaude");
                String uf = rs.getString("uf");
                int categoriaProfissional = rs.getInt("categoriaProfissional");
                String dataExpedicao = rs.getString("dataExpedicao");
                
                Farmaceutico farmaceutico = new Farmaceutico(crf, uf, categoriaProfissional, dataExpedicao, id, "", "", "", "", "", "");
                System.out.println("----->Farmacêutico Localizado pelo CRF:");
                System.out.println(farmaceutico);
                return farmaceutico;
            }
            
        } catch (SQLException e){
            System.out.println("!!!!!Erro ao BUSCAR o Farmacêutico!!!!!");
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(stmt);
            DB.closeConnection();
        }
        return null;
    }
    
    public ArrayList<Farmaceutico> retornaListaFarmaceuticos(){
        ArrayList<Farmaceutico> farmaceuticos = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select * from farmaceutico");
            
            System.out.println("----->Farmacêuticos Cadastrados na Unidade:");
            
            while(rs.next()){
                int id = rs.getInt("idProfissionalSaude");
                String crf = rs.getString("crf");
                String uf = rs.getString("uf");
                int categoriaProfissional = rs.getInt("categoriaProfissional");
                String dataExpedição = rs.getString("dataExpedicao");
                
                Farmaceutico farmaceutico = new Farmaceutico(crf, uf, categoriaProfissional, dataExpedição, id, "", "", "", "", "", "");
                System.out.println(farmaceutico);
                farmaceuticos.add(farmaceutico);
            }
            
            return farmaceuticos;
            
        } catch (SQLException e){
            System.out.println("!!!!!Erro ao RECUPERAR a Lista de Farmacêuticos!!!!!");
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(stmt);
            DB.closeConnection();
        }
        return null;
    }
    
}
