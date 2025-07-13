/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import classes.Farmaceutico;
import classes.ProfissionalSaude;
import dao.FarmaceuticoDAO;
import dao.ProfissionalSaudeDAO;
import java.util.ArrayList;

/**
 *
 * @author Amanda
 */
public class ControleFarmaceutico {
    
    private FarmaceuticoDAO farmaceuticoDAO;
    private ProfissionalSaudeDAO profissionalSaudeDAO;

    public ControleFarmaceutico() {
        this.farmaceuticoDAO = new FarmaceuticoDAO();
        this.profissionalSaudeDAO = new ProfissionalSaudeDAO();
    }
    
    public Farmaceutico buscaFarmaceutico(String crf){
        Farmaceutico farmaceutico = farmaceuticoDAO.buscaEnfermeiroPorCRF(crf);
        return farmaceutico;
    }
    
    public boolean cadastraFarmaceutico(Farmaceutico farmaceutico){
        boolean confirmacao = farmaceuticoDAO.cadastrarFarmaceutico(farmaceutico);
        return confirmacao;
    }
    
    public ArrayList<Farmaceutico> retornaListaFarmaceuticos(){
        ArrayList<Farmaceutico> listaFarmaceuticos = farmaceuticoDAO.retornaListaFarmaceuticos();
        for(Farmaceutico f : listaFarmaceuticos){
            ProfissionalSaude ps = profissionalSaudeDAO.buscaProfissionalPorID(f.getId());
            if(ps != null){
                f.setIdAdministracao(ps.getIdAdministracao());
                f.setCpf(ps.getCpf());
                f.setNome(ps.getNome());
                f.setTelefone(ps.getTelefone());
                f.setEmail(ps.getEmail());
                f.setDataNascimento(ps.getDataNascimento());
                f.setDataContratacao(ps.getDataContratacao());
            }
        }
        return listaFarmaceuticos;
    }
    
}
