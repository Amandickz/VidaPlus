/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import classes.Medico;
import dao.MedicoDAO;

/**
 *
 * @author Amanda
 */
public class ControleMedico {
    
    private MedicoDAO medicoDAO;

    public ControleMedico() {
        this.medicoDAO = new MedicoDAO();
    }
    
    public Medico buscaMedico(String crm){
        Medico medico = medicoDAO.buscaMedicoPorCRM(crm);
        return medico;
    }
    
    public boolean cadastraMedico(Medico medico, int idAdministrador){
        boolean confirmacao = medicoDAO.cadastrarMedico(medico, idAdministrador);
        return confirmacao;
    }
    
}
