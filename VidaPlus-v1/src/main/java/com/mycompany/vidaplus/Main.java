/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.vidaplus;

import classes.Administracao;
import classes.Paciente;
import com.google.gson.Gson;
import controles.ControleAdministracao;
import controles.ControlePaciente;
import controles.ControleProfissional;
import controles.ControleSuprimento;
import interfaces.TelaInicial;
import static spark.Spark.*;
/**
 *
 * @author Amanda
 */
public class Main {

    public static void main(String[] args) {
        
        ControleAdministracao controleAdministracao = new ControleAdministracao();
        ControlePaciente controlePaciente = new ControlePaciente();
        ControleProfissional controleProfissional = new ControleProfissional();
        
        port(4567);
        Gson gson = new Gson();
        
        post("/administrador", (req,res) -> {//cadastra administrador
            String json = req.body();
            Administracao administracao = gson.fromJson(json, Administracao.class);
            return controleAdministracao.cadastraAdministracao(administracao);
        });
        
        get("/administrador",(req,res) -> {//retorna administrador
            return controleAdministracao.recuperaAdministracao();
        });
        
        get("/administrador",(req,res) -> {//retorna administrador por CNPJ
            String cnpj = req.queryParams("cnpj");
            return controleAdministracao.buscaAdministrador(cnpj);
        });
        
        post("/paciente/:idAdministrador", (req,res) -> { //cadastra paciente na unidade
            String idAdm = req.params(":idAdministrador");
            String json = req.body();
            Paciente paciente = gson.fromJson(json, Paciente.class);
            return controlePaciente.cadastrarPaciente(paciente, Integer.parseInt(idAdm));
        });
        
        get("/paciente/unidade/:idAdministrador",(req,res) -> { //retorna pacientes da unidade administradora
            String idAdm = req.params(":idAdministrador");
            return controlePaciente.listaPacientes(Integer.parseInt(idAdm));
        });
        
        get("/paciente/:id",(req,res) -> { //retorna paciente por id
            String id = req.params(":id");
            return controlePaciente.buscaPacientePorID(Integer.parseInt(id));
        });
        
        get("/paciente/:cpf",(req,res) -> { //retonar paciente por CPF
            String cpf = req.params(":cpf");
            return controlePaciente.buscaPaciente(cpf);
        });
        
        get("/profissionalSaude/:idAdministrador",(req,res) -> { //retonar paciente por CPF
            String idAdm = req.params(":idAdministrador");
            return controleProfissional.retornarProfissionais(Integer.parseInt(idAdm));
        });
        
        
        //Criar usuários para facilitar os testes quando o banco de dados estiver sem informações
        
        /*ControleProfissional controleProfissional = new ControleProfissional();
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
        }*/

        new TelaInicial().setVisible(true);
        
    }
}