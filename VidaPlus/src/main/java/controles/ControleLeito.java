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
    
}
