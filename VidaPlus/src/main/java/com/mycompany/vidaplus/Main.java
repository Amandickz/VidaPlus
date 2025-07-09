/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.vidaplus;

import classes.Administracao;
import controles.ControleAdministracao;
import interfaces.TelaInicial;
import java.util.ArrayList;

/**
 *
 * @author Amanda
 */
public class Main {

    public static void main(String[] args) {
        
        ControleAdministracao controleAdministracao = new ControleAdministracao();
        
        ArrayList<Administracao> administradores = controleAdministracao.recuperaAdministracao();
        
        if(administradores.isEmpty()){
            Administracao adm = new Administracao("12.345.678/0001-90", "VidaPlus Saúde", "administracao@vidaplus.com", "(46) 12345-6789");
            boolean confirmacao = controleAdministracao.cadastraAdministracao(adm);
            if(confirmacao){
                System.out.println("\n---> Administrador Padrão cadastrado no banco.\n");
            }
        }
        
        
        new TelaInicial().setVisible(true);
        
    }
}
