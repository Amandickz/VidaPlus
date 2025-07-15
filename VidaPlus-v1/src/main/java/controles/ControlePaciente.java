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
    
    public boolean cadastrarPaciente(Paciente paciente){
        boolean confirmacao = pacienteDAO.cadastrarPaciente(paciente);
        return confirmacao;
    }
    
    public Paciente buscaPacientePorID(int id){
        Paciente paciente = pacienteDAO.buscaPacientePorID(id);
        return paciente;
    }
    
    public ArrayList<Paciente> listaPacientes(int idAdministracao){
        ArrayList<Paciente> pacientes = pacienteDAO.retornaListaPacientes(idAdministracao);
        return pacientes;
    }
    
    public Paciente buscaPaciente(String cpf){
        Paciente paciente = pacienteDAO.buscaPacientePorCPF(cpf);
        return paciente;
    }
    
    public Paciente buscaPacientePorNome(String nome){
        Paciente paciente = pacienteDAO.buscaPacientePorNome(nome);
        return paciente;
    }
    
    public ArrayList<Agenda> proximasConsultas(int idPaciente, String dataAtual){
        ArrayList<Agenda> agendaPaciente = agendaDAO.retornaProximasConsultasPaciente(idPaciente, dataAtual);
        return agendaPaciente;
    }
    
    public ProfissionalSaude buscaProfissional(int idMedico){
        ProfissionalSaude profissional = profissionalSaudeDAO.buscaProfissionalPorID(idMedico);
        return profissional;
    }
}
