/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import classes.PrescricaoInternacao;
import dao.PrescricaoInternacaoDAO;
import java.util.ArrayList;

/**
 *
 * @author Amanda
 */
public class ControlePrescricao {
    
    PrescricaoInternacaoDAO prescricaoDAO;

    public ControlePrescricao() {
        this.prescricaoDAO = new PrescricaoInternacaoDAO();
    }
    
    public boolean novaPrescricao(PrescricaoInternacao prescricao){
        boolean confirmacao = prescricaoDAO.novaPrescricao(prescricao);
        return confirmacao;
    }
    
    public ArrayList<PrescricaoInternacao> retornaPrescricoesPendentes(){
        ArrayList<PrescricaoInternacao> prescricoesPendentes = prescricaoDAO.retornaPrescricoesPendentes();
        return prescricoesPendentes;
    }
    
    public PrescricaoInternacao retornaPrescricao(int idInternacao){
        PrescricaoInternacao prescricao = prescricaoDAO.retornaPrescricao(idInternacao);
        return prescricao;
    }
    
}
