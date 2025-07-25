/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import classes.PrescricaoInternacao;
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
public class PrescricaoInternacaoDAO {
    
    public boolean novaPrescricao(PrescricaoInternacao prescricao){
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            pstmt = conn.prepareStatement("INSERT INTO prescricaointernacao" +
                    "(idInternacao,data,prescricao,orientacoes,observacoes,realizado)" +
                    " VALUES(?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            
            pstmt.setInt(1, prescricao.getIdInternacao());
            pstmt.setString(2, prescricao.getData());
            pstmt.setString(3, prescricao.getPrescricao());
            pstmt.setString(4, prescricao.getOrientacoes());
            pstmt.setString(5, prescricao.getObservacoes());
            pstmt.setBoolean(6, prescricao.isRealizado());
            
            
            int rollsAffected = pstmt.executeUpdate();

            if(rollsAffected > 0){
                ResultSet rs = pstmt.getGeneratedKeys();
                while (rs.next()){
                    int id = rs.getInt(1);
                    prescricao.setId(id);
                }
                System.out.println("----->Prescrição Médica da Internção realizada:");
                System.out.println(prescricao);
                return true;
            }
            
        } catch (SQLException e){
            System.out.println("!!!!!Erro ao CRIAR nova Prescrição!!!!!");
        } finally {
            DB.closeStatement(pstmt);
            DB.closeConnection();
        }
        
        return false;
    }
    
    public ArrayList<PrescricaoInternacao> retornaPrescricoesPendentes(){
        ArrayList<PrescricaoInternacao> prescricoesPendentes = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select * from prescricaoInternacao where realizado = false");
            
            System.out.println("----->Prescrição Pendentes:");
            
            while(rs.next()){
                int id = rs.getInt("id");
                int idInternacao = rs.getInt("idInternacao");
                String data = rs.getString("data");
                String prescricao = rs.getString("prescricao");
                String orientacoes = rs.getString("orientacoes");
                String observacoes = rs.getString("observacoes");
                
                PrescricaoInternacao prescricaoInternacao = new PrescricaoInternacao(id, idInternacao, data, prescricao);
                prescricaoInternacao.setOrientacoes(orientacoes);
                prescricaoInternacao.setObservacoes(observacoes);
                System.out.println(prescricaoInternacao);
                prescricoesPendentes.add(prescricaoInternacao);
            }
            
            return prescricoesPendentes;
            
        } catch (SQLException e){
            System.out.println("!!!!!Erro ao RECUPERAR as Prescrições Pendentes!!!!!");
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(stmt);
            DB.closeConnection();
        }
        
        return null;
    }
    
    public PrescricaoInternacao retornaPrescricao(int idInternacao){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select * from prescricaoInternacao where idInternacao = "
                    + idInternacao + " and realizado = false");
            
            while(rs.next()){
                int id = rs.getInt("id");
                String data = rs.getString("data");
                String prescricao = rs.getString("prescricao");
                String orientacoes = rs.getString("orientacoes");
                String observacoes = rs.getString("observacoes");
                
                PrescricaoInternacao prescricaoInternacao = new PrescricaoInternacao(id, idInternacao, data, prescricao);
                prescricaoInternacao.setOrientacoes(orientacoes);
                prescricaoInternacao.setObservacoes(observacoes);
                System.out.println("----->Prescrição Localizada:");
                System.out.println(prescricaoInternacao);
                return prescricaoInternacao;
            }
            
        } catch (SQLException e){
            System.out.println("!!!!!Erro ao RECUPERAR a Prescrição!!!!!");
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(stmt);
            DB.closeConnection();
        }
        
        return null;
    }
    
}
