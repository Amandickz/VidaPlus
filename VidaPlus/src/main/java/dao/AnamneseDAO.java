/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import classes.Anamnese;
import classes.AnamneseFeminina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Amanda
 */
public class AnamneseDAO {
    
    public Anamnese cadastrarAnamnese(Anamnese anamnese){
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            pstmt = conn.prepareStatement("INSERT INTO anamnese" +
                    "(diabetes,hipertensao,hipotensao,tabagismo,epilepsia,proteseDentaria,"
                    + "problemasRespitatorios,anotacoesRespiratorias,cirurgias,anotacoesCirurgias,"
                    + "exerciciosFisicos,frequenciaExercicios,alcool,frequenciaAlcool,alergiaMedicacao,"
                    + "anotacoesAlergiasMedicamento,alergiaAlimento,anotacoesAlergiaAlimento,"
                    + "tratamentoAtual,anotacoesTratamento,marcaPasso,medicamentoContinuo,"
                    + "anotacoesMedicamentoContinuo) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            
            pstmt.setBoolean(1, anamnese.isDiabetes());
            pstmt.setBoolean(2, anamnese.isHipertensao());
            pstmt.setBoolean(3, anamnese.isHipotensao());
            pstmt.setBoolean(4, anamnese.isTabagismo());
            pstmt.setBoolean(5, anamnese.isEpilepsia());
            pstmt.setBoolean(6, anamnese.isProteseDentaria());
            pstmt.setBoolean(7, anamnese.isProblemasRespiratorios());
            pstmt.setString(8, anamnese.getAnotacoesProblemasRespiratorios());
            pstmt.setBoolean(9, anamnese.isCirurgias());
            pstmt.setString(10, anamnese.getAnotacoesCirurgias());
            pstmt.setBoolean(11, anamnese.isExerciciosFisicos());
            pstmt.setInt(12, anamnese.getFrequenciaExercicios());
            pstmt.setBoolean(13, anamnese.isAlcool());
            pstmt.setInt(14, anamnese.getFrequenciaAlcool());
            pstmt.setBoolean(15, anamnese.isAlergiaMedicacao());
            pstmt.setString(16, anamnese.getAnotacoesAlergiaMedicacao());
            pstmt.setBoolean(17, anamnese.isAlergiaAlimento());
            pstmt.setString(18, anamnese.getAnotacoesAlergiaAlimento());
            pstmt.setBoolean(19, anamnese.isTratamentoMedicoAtual());
            pstmt.setString(20, anamnese.getAnotacoesTratamento());
            pstmt.setBoolean(21, anamnese.isMarcaPasso());
            pstmt.setBoolean(22, anamnese.isMedicamentoContinuo());
            pstmt.setString(23, anamnese.getAnotacoesMedicamentoContinuo());

            int rollsAffected = pstmt.executeUpdate();

            if(rollsAffected > 0){
                ResultSet rs = pstmt.getGeneratedKeys();
                while (rs.next()){
                    int id = rs.getInt(1);
                    anamnese.setId(id);
                }
                return anamnese;
            }
            
        } catch (SQLException e){
            System.out.println(e);
            System.out.println("********Erro ao Cadastrar dados!");
        } finally {
            DB.closeStatement(pstmt);
            DB.closeConnection();
        }
        return null;
    }
    
    public AnamneseFeminina cadastrarAnamneseFeminina(AnamneseFeminina anamneseFeminina){
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            pstmt = conn.prepareStatement("INSERT INTO anamnesefeminina "
                    + "(idAnamnese, anticoncepcional, tipoAnticoncepcional,cicloMenstrual) "
                    + "VALUES (?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            
            pstmt.setInt(1, anamneseFeminina.getId());
            pstmt.setBoolean(2, anamneseFeminina.isAnticoncepcional());
            pstmt.setInt(3, anamneseFeminina.getTipoAnticoncepcional());
            pstmt.setInt(4, anamneseFeminina.getCicloMenstrual());

            int rollsAffected = pstmt.executeUpdate();

            if(rollsAffected > 0){
                return anamneseFeminina;
            }
            
        } catch (SQLException e){
            System.out.println("********Erro ao Cadastrar dados!");
        } finally {
            DB.closeStatement(pstmt);
            DB.closeConnection();
        }
        return null;
    }
    
    public Anamnese buscaAnamnese(int id){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select * from anamnese where id = " + id + "");
            
            while(rs.next()){
                boolean diabetes = rs.getBoolean("diabetes");
                boolean hipertensao = rs.getBoolean("hipertensao");
                boolean hipotensao = rs.getBoolean("hipotensao");
                boolean tabagismo = rs.getBoolean("tabagismo");
                boolean epilepsia = rs.getBoolean("epilepsia");
                boolean proteseDentaria = rs.getBoolean("proteseDentaria");
                boolean problemasRespitatorios = rs.getBoolean("problemasRespitatorios");
                String anotacoesRespiratorias = rs.getString("anotacoesRespiratorias");
                boolean cirurgias = rs.getBoolean("cirurgias");
                String anotacoesCirurgias = rs.getString("anotacoesCirurgias");
                boolean exerciciosFisicos = rs.getBoolean("exerciciosFisicos");
                int frequenciaExercicios = rs.getInt("frequenciaExercicios");
                boolean alcool = rs.getBoolean("alcool");
                int frequenciaAlcool = rs.getInt("frequenciaAlcool");
                boolean alergiaMedicacao = rs.getBoolean("alergiaMedicacao");
                String anotacoesAlergiasMedicamento = rs.getString("anotacoesAlergiasMedicamento");
                boolean alergiaAlimento = rs.getBoolean("alergiaAlimento");
                String anotacoesAlergiaAlimento = rs.getString("anotacoesAlergiaAlimento");
                boolean tratamentoAtual = rs.getBoolean("tratamentoAtual");
                String anotacoesTratamento = rs.getString("anotacoesTratamento");
                boolean marcaPasso = rs.getBoolean("marcaPasso");
                boolean medicamentoContinuo = rs.getBoolean("medicamentoContinuo");
                String anotacoesMedicamentoContinuo = rs.getString("anotacoesMedicamentoContinuo"); 
                
                Anamnese anamnese = new Anamnese(id, diabetes, hipertensao, hipotensao, tabagismo,
                        epilepsia, proteseDentaria, problemasRespitatorios, anotacoesRespiratorias,
                        cirurgias, anotacoesCirurgias, exerciciosFisicos, frequenciaExercicios, alcool,
                        frequenciaAlcool, alergiaMedicacao, anotacoesAlergiasMedicamento, alergiaAlimento,
                        anotacoesAlergiaAlimento, tratamentoAtual, anotacoesTratamento, marcaPasso,
                        medicamentoContinuo, anotacoesMedicamentoContinuo);
                
                return anamnese;
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
    
    public AnamneseFeminina buscaAnamneseFeminina(Anamnese anamnese){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select * from anamnese where idAnamnese = " + anamnese.getId() + "");
            
            while(rs.next()){
                boolean anticoncepcional = rs.getBoolean("anticoncepcional");
                int tipoAnticoncepcional = rs.getInt("tipoAnticoncepcional");
                int cicloMenstrual = rs.getInt("cicloMenstrual");
                
                AnamneseFeminina anamneseFeminina = new AnamneseFeminina(anticoncepcional, tipoAnticoncepcional, cicloMenstrual, anamnese.getId(),
                        anamnese.isDiabetes(), anamnese.isHipertensao(), anamnese.isHipotensao(), anamnese.isTabagismo(),
                        anamnese.isEpilepsia(), anamnese.isProteseDentaria(), anamnese.isProblemasRespiratorios(),
                        anamnese.getAnotacoesProblemasRespiratorios(), anamnese.isCirurgias(), anamnese.getAnotacoesCirurgias(),
                        anamnese.isExerciciosFisicos(), anamnese.getFrequenciaExercicios(), anamnese.isAlcool(),
                        anamnese.getFrequenciaAlcool(), anamnese.isAlergiaMedicacao(), anamnese.getAnotacoesAlergiaMedicacao(),
                        anamnese.isAlergiaAlimento(), anamnese.getAnotacoesAlergiaAlimento(), anamnese.isTratamentoMedicoAtual(),
                        anamnese.getAnotacoesTratamento(), anamnese.isMarcaPasso(), anamnese.isMedicamentoContinuo(),
                        anamnese.getAnotacoesMedicamentoContinuo());
                
                return anamneseFeminina;
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
    
    public boolean atualizarAnamnese(Anamnese anamnese){
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            pstmt = conn.prepareStatement("UPDATE anamnese SET " +
                    "diabetes = ?, hipertensao = ?, hipotensao = ?, tabagismo = ?, epilepsia = ?, proteseDentaria = ?, "
                    + "problemasRespitatorios = ?, anotacoesRespiratorias = ?, cirurgias  = ?,anotacoesCirurgias  = ?, "
                    + "exerciciosFisicos  = ?, frequenciaExercicios  = ?, alcool = ?, frequenciaAlcool  = ?, alergiaMedicacao = ?, "
                    + "anotacoesAlergiasMedicamento,alergiaAlimento,alergiaAlimento,anotacoesAlergiaAlimento,"
                    + "anotacoesAlergiaAlimento = ?, tratamentoAtual = ?, anotacoesTratamento = ?, marcaPasso  = ?, medicamentoContinuo = ?, "
                    + "anotacoesMedicamentoContinuo = ? "
                    + "WHERE id = ?", Statement.RETURN_GENERATED_KEYS);
            
            pstmt.setBoolean(1, anamnese.isDiabetes());
            pstmt.setBoolean(2, anamnese.isHipertensao());
            pstmt.setBoolean(3, anamnese.isHipotensao());
            pstmt.setBoolean(4, anamnese.isTabagismo());
            pstmt.setBoolean(5, anamnese.isEpilepsia());
            pstmt.setBoolean(6, anamnese.isProteseDentaria());
            pstmt.setBoolean(7, anamnese.isProblemasRespiratorios());
            pstmt.setString(8, anamnese.getAnotacoesProblemasRespiratorios());
            pstmt.setBoolean(9, anamnese.isCirurgias());
            pstmt.setString(10, anamnese.getAnotacoesCirurgias());
            pstmt.setBoolean(11, anamnese.isExerciciosFisicos());
            pstmt.setInt(12, anamnese.getFrequenciaExercicios());
            pstmt.setBoolean(13, anamnese.isAlcool());
            pstmt.setInt(14, anamnese.getFrequenciaAlcool());
            pstmt.setBoolean(15, anamnese.isAlergiaMedicacao());
            pstmt.setString(16, anamnese.getAnotacoesAlergiaMedicacao());
            pstmt.setBoolean(17, anamnese.isAlergiaAlimento());
            pstmt.setString(18, anamnese.getAnotacoesAlergiaAlimento());
            pstmt.setBoolean(19, anamnese.isTratamentoMedicoAtual());
            pstmt.setString(20, anamnese.getAnotacoesTratamento());
            pstmt.setBoolean(21, anamnese.isMarcaPasso());
            pstmt.setBoolean(22, anamnese.isMedicamentoContinuo());
            pstmt.setString(23, anamnese.getAnotacoesMedicamentoContinuo());
            pstmt.setInt(24, anamnese.getId());

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
    
    public boolean atualizarAnamneseFeminina(AnamneseFeminina anamneseFeminina){
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            
            conn = DB.getConeConnection();
            
            pstmt = conn.prepareStatement("UPDATE anamnesefeminina SET "
                    + "idAnamnese = ?, anticoncepcional = ?, tipoAnticoncepcional = ?, cicloMenstrual = ? "
                    + "WHERE idAnamnese = ?",
                    Statement.RETURN_GENERATED_KEYS);
            
            pstmt.setInt(1, anamneseFeminina.getId());
            pstmt.setBoolean(2, anamneseFeminina.isAnticoncepcional());
            pstmt.setInt(3, anamneseFeminina.getTipoAnticoncepcional());
            pstmt.setInt(4, anamneseFeminina.getCicloMenstrual());
            pstmt.setInt(5, anamneseFeminina.getId());

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
    
}
