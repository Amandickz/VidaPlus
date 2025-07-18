/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import classes.Agenda;
import classes.Medico;
import classes.Paciente;
import classes.ProfissionalSaude;
import dao.AgendaDAO;
import dao.MedicoDAO;
import dao.PacienteDAO;
import dao.ProfissionalSaudeDAO;
import java.util.ArrayList;

/**
 *
 * @author Amanda
 */
public class ControleMedico {
    
    private MedicoDAO medicoDAO;
    private ProfissionalSaudeDAO profissionalSaudeDAO;
    private AgendaDAO agendaDAO;
    private PacienteDAO pacienteDAO;

    public ControleMedico() {
        this.medicoDAO = new MedicoDAO();
        this.profissionalSaudeDAO = new ProfissionalSaudeDAO();
        this.agendaDAO = new AgendaDAO();
        this.pacienteDAO = new PacienteDAO();
    }
    
    public ArrayList<Agenda> consultasDoDia(String data, Medico medico){
        ArrayList<Agenda> agendaDoDia = agendaDAO.retornaAgendaDia(data, medico.getId());
        return agendaDoDia;
    }
    
    public Medico buscaMedicoCRM(String crm){
        Medico medico = medicoDAO.buscaMedicoPorCRM(crm);
        return medico;
    }
    
    public ProfissionalSaude buscaProfissionalPorNome(String nome){
        ProfissionalSaude profissionalSaude = profissionalSaudeDAO.buscaProfissionalPorNome(nome);
        return profissionalSaude;
    }
    
    public Paciente buscaPacientePorID(int id){
        Paciente paciente = pacienteDAO.buscaPacientePorID(id);
        return paciente;
    }
    
    public Paciente buscaPacientePorNome(String nome){
        Paciente paciente = pacienteDAO.buscaPacientePorNome(nome);
        return paciente;
    }
    
    public boolean cadastraMedico(Medico medico){
        boolean confirmacao = medicoDAO.cadastrarMedico(medico);
        return confirmacao;
    }
    
    public ArrayList<Medico> retornaListaMedica(){
        ArrayList<Medico> listaMedicos = medicoDAO.retornaListaMedicos();
        for(Medico m : listaMedicos){
            ProfissionalSaude ps = profissionalSaudeDAO.buscaProfissionalPorID(m.getId());
            if(ps != null){
                m.setIdAdministracao(ps.getIdAdministracao());
                m.setCpf(ps.getCpf());
                m.setNome(ps.getNome());
                m.setTelefone(ps.getTelefone());
                m.setEmail(ps.getEmail());
                m.setDataNascimento(ps.getDataNascimento());
                m.setDataContratacao(ps.getDataContratacao());
            }                    
        }
        return listaMedicos;
    }
    
    public ArrayList<Agenda> datasDisponiveis(String dataAtual, int idMedico){
        ArrayList<Agenda> datas = agendaDAO.retornaDatasDisponiveis(dataAtual, idMedico);
        return datas;
    }
    
    
    
}
