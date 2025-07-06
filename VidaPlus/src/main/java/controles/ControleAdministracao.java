/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import classes.Administracao;
import classes.Paciente;
import classes.Suprimento;
import dao.AdministracaoDAO;
import dao.PacienteDAO;
import dao.SuprimentoDAO;
import java.util.ArrayList;

/**
 *
 * @author Amanda
 */
public class ControleAdministracao {
    
    private AdministracaoDAO admDAO;
    private PacienteDAO pacienteDAO;
    private SuprimentoDAO suprimentoDAO;

    public ControleAdministracao() {
        this.admDAO = new AdministracaoDAO();
        this.pacienteDAO = new PacienteDAO();
        this.suprimentoDAO = new SuprimentoDAO();
    }
    
    public Administracao buscaAdministrador(String cnpj){
        Administracao adm = admDAO.buscaAdmPorCNPJ(cnpj);
        return adm;
    }
    
    public Paciente buscarPaciente(String cpf){
        Paciente paciente = pacienteDAO.buscaPacientePorCPF(cpf);
        return paciente;
    }
    
    public boolean cadastrarPaciente(Paciente paciente, int idAdministracao){
        boolean confirmacao = pacienteDAO.cadastrarPaciente(paciente, idAdministracao);
        return confirmacao;
    }
       
}
