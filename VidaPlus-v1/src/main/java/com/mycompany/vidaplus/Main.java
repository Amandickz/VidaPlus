/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.vidaplus;

import classes.Administracao;
import classes.Medico;
import classes.Paciente;
import classes.ProfissionalSaude;
import controles.ControleAdministracao;
import controles.ControleMedico;
import controles.ControlePaciente;
import controles.ControleProfissional;
import interfaces.TelaInicial;
import java.util.ArrayList;
/**
 *
 * @author Amanda
 */
public class Main {

    public static void main(String[] args) {
        
        //Criar usuários para facilitar os testes quando o banco de dados estiver sem informações
        ControleAdministracao controleAdministracao = new ControleAdministracao();
        ControleProfissional controleProfissional = new ControleProfissional();
        ControleMedico controleMedico = new ControleMedico();
        ControlePaciente controlePaciente = new ControlePaciente();
        
        ArrayList<Administracao> administradores = controleAdministracao.recuperaAdministracao();
        
        if(administradores.isEmpty()){
            Administracao adm = new Administracao("12.345.678/0001-90", "VidaPlus Saúde", "administracao@vidaplus.com", "(46) 12345-6789");
            boolean confirmacao = controleAdministracao.cadastraAdministracao(adm);
            if(confirmacao){
                System.out.println("\n---> Administrador Padrão cadastrado no banco.\n");
            }
            
            ProfissionalSaude ps = new ProfissionalSaude("111.111.111-11", "Capim-Limão Silva", "(11) 11111-1111", "capimsilva@vidaplus.com", "01/01/1990", "01/01/2025");
            ps = controleProfissional.cadastraProfissional(ps, 1);
            Medico medico = new Medico("11111111-1", "PR", "01/01/2024", 0,
                    ps.getId(), ps.getCpf(), ps.getNome(), ps.getTelefone(), ps.getEmail(), ps.getDataNascimento(), ps.getDataContratacao());
            confirmacao = controleMedico.cadastraMedico(medico);
            if(confirmacao){
                System.out.println("\n---> Médico Padrão cadastrado no banco.\n");
            }
            
            Paciente paciente = new Paciente("123.123.123-00", "Camila Luiza", "camila.luiza@gmail.com", "(00) 12345-6789", "02/02/2000", 0);
            confirmacao = controlePaciente.cadastrarPaciente(paciente, 1);
            if(confirmacao){
                System.out.println("\n---> Paciente Padrão 1 cadastrado no banco.\n");
            }
            
            paciente = new Paciente("111.222.333-00", "Marcelo Santos Ruiz", "marcelo.ruiz@gmail.com", "(11) 11223-3445", "03/03/2005", 0);
            confirmacao = controlePaciente.cadastrarPaciente(paciente, 1);
            if(confirmacao){
                System.out.println("\n---> Paciente Padrão 2 cadastrado no banco.\n");
            }
        }
        
        new TelaInicial().setVisible(true);
        
    }
}
