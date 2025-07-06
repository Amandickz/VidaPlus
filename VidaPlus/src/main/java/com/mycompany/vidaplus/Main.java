/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.vidaplus;

import dao.AdministracaoDAO;
import dao.LeitoDAO;
import interfaces.TelaInicial;

/**
 *
 * @author Amanda
 */
public class Main {

    public static void main(String[] args) {
        
        AdministracaoDAO admDAO = new AdministracaoDAO();
        admDAO.recuperaAdministracao();
        
        LeitoDAO leitoDAO = new LeitoDAO();
        leitoDAO.recuperaLeito();
        
        new TelaInicial().setVisible(true);
        
    }
}
