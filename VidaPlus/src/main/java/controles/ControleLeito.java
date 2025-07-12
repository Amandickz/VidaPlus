/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import classes.Leito;
import dao.LeitoDAO;
import java.util.ArrayList;

/**
 *
 * @author Amanda
 */
public class ControleLeito {
    
    private LeitoDAO leitoDAO;

    public ControleLeito() {
        this.leitoDAO = new LeitoDAO();
    }
    
    public ArrayList<Leito> recuperaLeitos(int idAdministracao){
        ArrayList<Leito> listaLeitos = leitoDAO.recuperaLeito(idAdministracao);
        return listaLeitos;
    }
    
    public Leito buscaLeitoPorNumero(int numero){
        Leito leito = leitoDAO.buscaLeitoPorNumero(numero);
        return leito;
    }
    
    public boolean cadastrarLeito(Leito leito, int idAdministracao){
        boolean confirmacao = leitoDAO.cadastrarLeito(leito, idAdministracao);
        return confirmacao;
    }
    
    public ArrayList<Leito> retornaLeitosDisponiveis(int idAdministracao){
        ArrayList<Leito> leitos = leitoDAO.retornaLeitosDisponiveis(idAdministracao);
        return leitos;
    }
    
    public boolean atualizarLeito(Leito leito){
        boolean confirmacao = leitoDAO.atualizarLeito(leito);
        return confirmacao;
    }
    
}
