/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import classes.Anamnese;
import classes.AnamneseFeminina;
import classes.ProntuarioMedico;
import dao.AnamneseDAO;
import dao.ProntuarioDAO;

/**
 *
 * @author Amanda
 */
public class ControleProntuario {
    
    private ProntuarioDAO prontuarioDAO;
    private AnamneseDAO anamneseDAO;

    public ControleProntuario() {
        this.prontuarioDAO = new ProntuarioDAO();
        this.anamneseDAO = new AnamneseDAO();
    }
    
    public ProntuarioMedico criarProntuario(ProntuarioMedico prontuarioMedico){
        ProntuarioMedico prontuario = prontuarioDAO.criarProntuario(prontuarioMedico);
        return prontuario;
    }
    
    public ProntuarioMedico buscaProntuarioPorIDPaciente(int idPaciente){
        ProntuarioMedico prontuario = prontuarioDAO.buscaProntuarioPorIDPaciente(idPaciente);
        return prontuario;
    }
    
    public Anamnese cadastraAnamnese(Anamnese anamnese){
        anamnese = anamneseDAO.cadastrarAnamnese(anamnese);
        return anamnese;
    }
    
    public AnamneseFeminina cadastraAnamneseFeminina(AnamneseFeminina anamneseFeminina){
        anamneseFeminina = anamneseDAO.cadastrarAnamneseFeminina(anamneseFeminina);
        return anamneseFeminina;
    }
    
    public Anamnese buscaAnamnese(int id){
        Anamnese anamnese = anamneseDAO.buscaAnamnese(id);
        return anamnese;
    }
    
    public AnamneseFeminina buscaAnamneseFeminina(Anamnese anamnese){
        AnamneseFeminina anamneseFeminina = anamneseDAO.buscaAnamneseFeminina(anamnese);
        return anamneseFeminina;
    }
    
    public boolean alterarAnamnese(Anamnese anamnese){
        boolean confirmacao = anamneseDAO.atualizarAnamnese(anamnese);
        return confirmacao;
    }
    
    public boolean alterarAnamneseFeminina(AnamneseFeminina anamneseFeminina){
        boolean confirmacao = anamneseDAO.atualizarAnamneseFeminina(anamneseFeminina);
        return confirmacao;
    }
}
