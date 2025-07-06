/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import classes.Suprimento;
import dao.SuprimentoDAO;
import java.util.ArrayList;

/**
 *
 * @author Amanda
 */
public class ControleSuprimento {
    
    private SuprimentoDAO suprimentoDAO;

    public ControleSuprimento() {
        this.suprimentoDAO = new SuprimentoDAO();
    }
    
    public ArrayList<Suprimento> recuperaSuprimentos(int idAdministracao){
        ArrayList<Suprimento> listaSuprimentos = suprimentoDAO.recuperaSuprimentos(idAdministracao);
        return listaSuprimentos;
    }
    
    public Suprimento buscaSuprimentoPorNome(String nome){
        Suprimento suprimento = suprimentoDAO.buscaSuprimentoPorNome(nome);
        return suprimento;
    }
    
    public boolean cadastrarSuprimento(Suprimento suprimento, int idAdministracao){
        boolean confirmacao = suprimentoDAO.cadastrarSuprimento(suprimento, idAdministracao);
        return confirmacao;
    }
    
}
