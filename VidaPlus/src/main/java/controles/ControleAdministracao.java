/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import classes.Administracao;
import dao.AdministracaoDAO;

/**
 *
 * @author Amanda
 */
public class ControleAdministracao {
    
    private AdministracaoDAO admDAO;

    public ControleAdministracao() {
        this.admDAO = new AdministracaoDAO();
    }
    
    public Administracao buscaAdministrador(String cnpj){
        Administracao adm = admDAO.buscaAdmPorCNPJ(cnpj);
        return adm;
    }
    
}
