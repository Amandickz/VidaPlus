/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import classes.Agenda;
import classes.Paciente;
import classes.ProfissionalSaude;
import dao.AgendaDAO;
import dao.PacienteDAO;
import dao.ProfissionalSaudeDAO;
import java.util.ArrayList;

/**
 *
 * @author Amanda
 */
public class ControlePaciente {
    
    private PacienteDAO pacienteDAO;
    private AgendaDAO agendaDAO;
    private ProfissionalSaudeDAO profissionalSaudeDAO;
    
    public ControlePaciente() {
        this.pacienteDAO = new PacienteDAO();
        this.agendaDAO = new AgendaDAO();
        this.profissionalSaudeDAO = new ProfissionalSaudeDAO();
    }
    
    public boolean cadastrarPaciente(Paciente paciente, int idAdministracao){
        boolean confirmacao = pacienteDAO.cadastrarPaciente(paciente, idAdministracao);
        return confirmacao;
    }
    
    public ArrayList<Paciente> listaPacientes(int idAdministracao){
        ArrayList<Paciente> pacientes = pacienteDAO.retornaListaPacientes(idAdministracao);
        return pacientes;
    }
    
    public Paciente buscaPaciente(String cpf){
        Paciente paciente = pacienteDAO.buscaPacientePorCPF(cpf);
        return paciente;
    }
    
    public ArrayList<Agenda> proximasConsultas(int idPaciente){
        ArrayList<Agenda> agendaPaciente = agendaDAO.retornaConsultasPaciente(idPaciente);
        return agendaPaciente;
    }
    
    public ProfissionalSaude buscaProfissional(int idMedico){
        ProfissionalSaude profissional = profissionalSaudeDAO.buscaProfissionalPorID(idMedico);
        return profissional;
    }
}
