/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.vidaplus;

import classes.Administracao;
import classes.Enfermeiro;
import classes.Farmaceutico;
import classes.Leito;
import classes.Medico;
import classes.Paciente;
import classes.ProfissionalSaude;
import classes.Suprimento;
import com.google.gson.Gson;
import controles.ControleAdministracao;
import controles.ControleEnfermeiro;
import controles.ControleFarmaceutico;
import controles.ControleLeito;
import controles.ControleMedico;
import controles.ControlePaciente;
import controles.ControleProfissional;
import controles.ControleSuprimento;
import interfaces.TelaInicial;
import interfaces.TelaPrimeiroAcessoADM;
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
        ControleMedico controleMedico = new ControleMedico();
        ControleEnfermeiro controleEnfermeiro = new ControleEnfermeiro();
        ControleFarmaceutico controleFarmaceutico = new ControleFarmaceutico();
        ControleLeito controleLeito = new ControleLeito();
        ControleSuprimento controleSuprimento = new ControleSuprimento();
        
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
        
        post("/paciente/novo", (req,res) -> {//cadastra paciente
            Paciente paciente = gson.fromJson(req.body(), Paciente.class);
            return controlePaciente.cadastrarPaciente(paciente);
        });
        
        get("/paciente/:idAdm",(req,res) -> {//retorna pacientes
            return controlePaciente.listaPacientes(Integer.parseInt(req.params(":idAdm")));
        });
        
        get("/paciente/busca/:cpf",(req,res) -> {//Busca Paciente por CPF
            return controlePaciente.buscaPaciente(req.params(":cpf"));
        });
        
        post("/profissional", (req,res) -> {//cadastra profissional
            ProfissionalSaude profissional = gson.fromJson(req.body(), ProfissionalSaude.class);
            return controleProfissional.cadastraProfissional(profissional, profissional.getIdAdministracao());
        });
        
        get("/profissional/:idAdm",(req,res) -> {//retorna profissionais da unidade
            return controleProfissional.retornarProfissionais(Integer.parseInt(req.params(":idAdm")));
        });
        
        post("/medico", (req,res) -> {//cadastra medico
            Medico medico = gson.fromJson(req.body(), Medico.class);
            return controleMedico.cadastraMedico(medico);
        });
        
        get("/medico",(req,res) -> {//retorna lista de medicos
            return controleMedico.retornaListaMedica();
        });
        
        get("/medico/busca/:crm",(req,res) -> {//retorna medico via CRM
            return controleMedico.buscaMedicoCRM(req.params(":crm"));
        });
        
        post("/enfermeiro", (req,res) -> {//cadastra enfermeiro
            Enfermeiro enfermeiro = gson.fromJson(req.body(), Enfermeiro.class);
            return controleEnfermeiro.cadastraEnfermeiro(enfermeiro);
        });
        
        get("/enfermeiro",(req,res) -> {//retorna lista de enfermeiros
            return controleEnfermeiro.retornaListaEnfermeiros();
        });
        
        get("/enfermeiro/busca/:coren",(req,res) -> {//retorna enfermeiro via coren
            return controleEnfermeiro.buscaEnfermeiro(req.params(":coren"));
        });
        
        post("/farmaceutico", (req,res) -> {//cadastra farmaceutico
            Farmaceutico farmaceutico = gson.fromJson(req.body(), Farmaceutico.class);
            return controleFarmaceutico.cadastraFarmaceutico(farmaceutico);
        });
        
        get("/farmaceutico",(req,res) -> {//retorna lista de farmaceuticos
            return controleFarmaceutico.retornaListaFarmaceuticos();
        });
        
        get("/farmaceutico/busca/:crf",(req,res) -> {//retorna farmaceutico via crf
            return controleFarmaceutico.buscaFarmaceutico(req.params(":crf"));
        });
        
        post("/leito", (req,res) -> {//cadastra leito
            Leito leito = gson.fromJson(req.body(), Leito.class);
            return controleLeito.cadastrarLeito(leito);
        });
        
        get("/leito/:idAdm",(req,res) -> {//retorna lista de leitos
            return controleLeito.recuperaLeitos(Integer.parseInt(req.params(":idAdm")));
        });
        
        get("/leito/busca/:num",(req,res) -> {//retorna o leito de acordo com o número do quarto
            return controleLeito.buscaLeitoPorNumero(Integer.parseInt(req.params(":num")));
        });
        
        get("/leito/disponiveis/:idAdm",(req,res) -> {//retorna o leito de acordo com o número do quarto
            return controleLeito.retornaLeitosDisponiveis(Integer.parseInt(req.params(":idAdm")));
        });
        
        post("/suprimento", (req,res) -> {//cadastra suprimento
            Suprimento suprimento = gson.fromJson(req.body(), Suprimento.class);
            return controleSuprimento.cadastrarSuprimento(suprimento);
        });
        
        get("/suprimento",(req,res) -> {//retorna lista de suprimentos
            return controleSuprimento.recuperaSuprimentos(Integer.parseInt(req.queryParams("idAdm")));
        });
        
        get("/suprimento/busca/:nome",(req,res) -> {//retorna suprimento por nome
            return controleSuprimento.buscaSuprimentoPorNome(req.params(":nome"));
        });
        
        if(controleAdministracao.recuperaAdministracao() == null){
            new TelaPrimeiroAcessoADM().setVisible(true);
        } else {
            new TelaInicial().setVisible(true);
        }
        
    }
}