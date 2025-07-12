/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import classes.Enfermeiro;
import dao.EnfermeiroDAO;

/**
 *
 * @author Amanda
 */
public class ControleEnfermeiro {
    
    private EnfermeiroDAO enfermeiroDAO;

    public ControleEnfermeiro() {
        this.enfermeiroDAO = new EnfermeiroDAO();
    }
    
    public Enfermeiro buscaEnfermeiro(String coren){
        Enfermeiro enfermeiro = enfermeiroDAO.buscaEnfermeiroPorCOREN(coren);
        return enfermeiro;
    }
    
    public boolean cadastraEnfermeiro(Enfermeiro enfermeiro){
        boolean confirmacao = enfermeiroDAO.cadastrarEnfermeiro(enfermeiro);
        return confirmacao;
    }
    
}
