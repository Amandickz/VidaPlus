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
    
    public boolean confirmaInternacao(Internacao internacao){
        boolean confirmacao = internacaoDAO.confirmaInternacao(internacao);
        return confirmacao;
    }
    
    public ArrayList<Internacao> retornaInternacoesAtivas(){
        ArrayList<Internacao> internacoes = internacaoDAO.retornaInternacoesAtivas();
        return internacoes;
    }
    
    public ArrayList<Internacao> retornaInternacoesAtivasPorMedico(int idMedico){
        ArrayList<Internacao> internacoes = internacaoDAO.retornaInternacoesAtivasPorMedico(idMedico);
        return internacoes;
    }
    
    public Internacao retornaSolicitacaoInternacaoPorIDProntuario(int idProntuario){
        Internacao internacao = internacaoDAO.retornaSolicitacaoInternacaoPorIDProntuario(idProntuario);
        return internacao;
    }
    
    public boolean realizarAlta(Internacao internacao){
        boolean confirmacao = internacaoDAO.realizarAlta(internacao);
        return confirmacao;
    }
    
    public Internacao retornaInternacaoPorID(int id){
        Internacao internacao = internacaoDAO.retornaInternacaoPorID(id);
        return internacao;
    }
    
    public Internacao retornaInternacaoPorIDProntuario(int idProntuario){
        Internacao internacao = internacaoDAO.retornaInternacaoPorIDProntuario(idProntuario);
        return internacao;
    }
    
}
