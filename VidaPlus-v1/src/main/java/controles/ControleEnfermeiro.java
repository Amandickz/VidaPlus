/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import classes.Enfermeiro;
import classes.ProfissionalSaude;
import dao.EnfermeiroDAO;
import dao.ProfissionalSaudeDAO;
import java.util.ArrayList;

/**
 *
 * @author Amanda
 */
public class ControleEnfermeiro {
    
    private EnfermeiroDAO enfermeiroDAO;
    private ProfissionalSaudeDAO profissionalSaudeDAO;

    public ControleEnfermeiro() {
        this.enfermeiroDAO = new EnfermeiroDAO();
        this.profissionalSaudeDAO = new ProfissionalSaudeDAO();
    }
    
    public Enfermeiro buscaEnfermeiro(String coren){
        Enfermeiro enfermeiro = enfermeiroDAO.buscaEnfermeiroPorCOREN(coren);
        return enfermeiro;
    }
    
    public boolean cadastraEnfermeiro(Enfermeiro enfermeiro){
        boolean confirmacao = enfermeiroDAO.cadastrarEnfermeiro(enfermeiro);
        return confirmacao;
    }
    
    public ArrayList<Enfermeiro> retornaListaEnfermeiros(){
        ArrayList<Enfermeiro> listaEnfermeiros = enfermeiroDAO.retornaListaEnfermeiros();
        for(Enfermeiro e : listaEnfermeiros){
            ProfissionalSaude ps = profissionalSaudeDAO.buscaProfissionalPorID(e.getId());
            if(ps != null){
                e.setIdAdministracao(ps.getIdAdministracao());
                e.setCpf(ps.getCpf());
                e.setNome(ps.getNome());
                e.setTelefone(ps.getTelefone());
                e.setEmail(ps.getEmail());
                e.setDataNascimento(ps.getDataNascimento());
                e.setDataContratacao(ps.getDataContratacao());
            }
        }
        return listaEnfermeiros;
    }
    
}
