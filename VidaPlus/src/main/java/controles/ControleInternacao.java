/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import classes.Internacao;
import dao.InternacaoDAO;
import java.util.ArrayList;

/**
 *
 * @author Amanda
 */
public class ControleInternacao {
    
    private InternacaoDAO internacaoDAO;

    public ControleInternacao() {
        this.internacaoDAO = new InternacaoDAO();
    }
    
    public boolean solicitarInternacao(Internacao internacao){
        boolean confirmacao = internacaoDAO.solicitarInternacao(internacao);
        return confirmacao;
    }
    
    public ArrayList<Internacao> retornaSolicitacoesInternacao(){
        ArrayList<Internacao> internacoes = internacaoDAO.retornaSolicitacoesInternacao();
        return internacoes;
    }
    
}
