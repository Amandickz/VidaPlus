/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import classes.Paciente;
import dao.PacienteDAO;

/**
 *
 * @author Amanda
 */
public class ControlePaciente {
    
    private PacienteDAO pacienteDAO;

    public ControlePaciente() {
        this.pacienteDAO = new PacienteDAO();
    }
    
    public Paciente buscaPaciente(String cpf){
        Paciente paciente = pacienteDAO.buscaPacientePorCPF(cpf);
        return paciente;
    }
    
}
