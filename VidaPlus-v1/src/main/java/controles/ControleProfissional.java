/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import classes.Enfermeiro;
import classes.Farmaceutico;
import classes.Medico;
import classes.ProfissionalSaude;
import dao.ProfissionalSaudeDAO;
import java.util.ArrayList;

/**
 *
 * @author Amanda
 */
public class ControleProfissional {
    
    private ProfissionalSaudeDAO profissionalDAO;

    public ControleProfissional() {
        this.profissionalDAO = new ProfissionalSaudeDAO();
    }
    
    public ProfissionalSaude cadastraProfissional(ProfissionalSaude profissional, int idAdministracao){
        profissional = profissionalDAO.cadastraProfissional(profissional, idAdministracao);
        return profissional;
    }
    
    public ArrayList<ProfissionalSaude> retornarProfissionais(int idAdministrador){
        ArrayList<ProfissionalSaude> profissionais = profissionalDAO.retornarProfissionais(idAdministrador);
        return profissionais;
    }
    
    public ProfissionalSaude buscaProfissionalPorID(int id){
        ProfissionalSaude profissional = profissionalDAO.buscaProfissionalPorID(id);
        return profissional;
    }
    
    public ProfissionalSaude buscaProfissional(String cpf){
        System.out.println(cpf);
        ProfissionalSaude profissionalSaude = profissionalDAO.buscaProfissionalPorCPF(cpf);
        return profissionalSaude;
    }
    
    public ProfissionalSaude buscaProfissionalPorNome(String nome){
        ProfissionalSaude profissionalSaude = profissionalDAO.buscaProfissionalPorNome(nome);
        return profissionalSaude;
    }
    
    public Medico buscaMedico(ProfissionalSaude profissional){
        Medico medico = profissionalDAO.buscaMedicoPorID(profissional);
        return medico;
    }
    
    public Enfermeiro buscaEnfermeiro(ProfissionalSaude profissional){
        Enfermeiro enfermeiro = profissionalDAO.buscaEnfermeiroPorID(profissional);
        return enfermeiro;
    }
    
    public Farmaceutico buscaFarmaceutico(ProfissionalSaude profissional){
        Farmaceutico farmaceutico = profissionalDAO.buscaFarmaceuticoPorID(profissional);
        return farmaceutico;
    }
    
}
