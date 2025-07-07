/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import classes.Agenda;
import classes.Medico;
import classes.ProfissionalSaude;
import dao.AgendaDAO;
import dao.MedicoDAO;
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

    public ControleMedico() {
        this.medicoDAO = new MedicoDAO();
        this.profissionalSaudeDAO = new ProfissionalSaudeDAO();
        this.agendaDAO = new AgendaDAO();
    }
    
    public Medico buscaMedicoCRM(String crm){
        Medico medico = medicoDAO.buscaMedicoPorCRM(crm);
        return medico;
    }
    
    public ProfissionalSaude buscaProfissionalPorNome(String nome){
        ProfissionalSaude profissionalSaude = profissionalSaudeDAO.buscaProfissionalPorNome(nome);
        return profissionalSaude;
    }
    
    public boolean cadastraMedico(Medico medico, int idAdministrador){
        boolean confirmacao = medicoDAO.cadastrarMedico(medico, idAdministrador);
        return confirmacao;
    }
    
    public ArrayList<Medico> retornaListaMedica(){
        ArrayList<Medico> listaMedicos = medicoDAO.retornaListaMedica();
        for(Medico m : listaMedicos){
            ProfissionalSaude ps = profissionalSaudeDAO.buscaProfissionalPorID(m.getId());
            if(ps != null){
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
