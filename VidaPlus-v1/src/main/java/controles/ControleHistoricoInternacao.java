/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import classes.HistoricoInternacao;
import dao.HistoricoInternacaoDAO;

/**
 *
 * @author Amanda
 */
public class ControleHistoricoInternacao {

    private HistoricoInternacaoDAO historicoDAO;
    
    public ControleHistoricoInternacao() {
        this.historicoDAO = new HistoricoInternacaoDAO();
    }
    
    public boolean realizacaoDoProcedimento(HistoricoInternacao historico){
        boolean confirmacao = historicoDAO.realizacaoDoProcedimento(historico);
        return confirmacao;
    }
    
}
