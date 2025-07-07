/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import classes.Agenda;
import dao.AgendaDAO;
import enums.IntervaloConsultas;
import static enums.IntervaloConsultas.CINCO;
import static enums.IntervaloConsultas.DOIS;
import static enums.IntervaloConsultas.QUATRO;
import static enums.IntervaloConsultas.TRES;
import static enums.IntervaloConsultas.UM;
import java.util.ArrayList;

/**
 *
 * @author Amanda
 */
public class ControleAgenda {
    
    private AgendaDAO agendaDAO;

    public ControleAgenda() {
        this.agendaDAO = new AgendaDAO();
    }
    
    public boolean cadastrarData(Agenda agenda, int idMedico){
        boolean confirmacao = agendaDAO.cadastrarAgenda(agenda, idMedico);
        return confirmacao;
    }
    
    public ArrayList<Agenda> retornaAgendaCompleta(String data, int idMedico){
        ArrayList<Agenda> agendacompleta = agendaDAO.retornaAgendaCompleta(data, idMedico);
        return agendacompleta;
    }
    
    public boolean marcarConsulta(int idMedico, Agenda agenda, int idPaciente){
        boolean confirmacao = agendaDAO.marcaConsulta(idMedico, agenda, idPaciente);
        return confirmacao;
    }
    
    public ArrayList<Agenda> gerarNovasConsultas(String data, String horaInicial, String horaFinal, IntervaloConsultas intervalo){
        ArrayList<Agenda> listaHorarios = new ArrayList<>();
        int tempo = 0, cont = 0;
        switch (intervalo) {
            case UM -> {
                tempo = 10;
            }
            case DOIS -> {
                tempo = 15;
            }
            case TRES -> {
                tempo = 30;
            }
            case QUATRO -> {
                tempo = 45;
            }
            case CINCO -> {
                tempo = 60; 
            }
            default -> throw new AssertionError();
        }
        String[] quebraInicio = horaInicial.split(":");
        String[] quebraFim = horaFinal.split(":");
        for(int i = Integer.parseInt(quebraInicio[0]); i < Integer.parseInt(quebraFim[0]); i++){//Contagem Hora
            for(int j = Integer.parseInt(quebraInicio[1]); j < 60; j = j + tempo){//Contagem Minutos
                String horario;
                if(j < 9){
                    horario = "" + i + ":" + j + "0";
                } else {
                    horario = "" + i + ":" + j;
                }
                
                Agenda agenda = new Agenda(data, horario, 0);
                listaHorarios.add(agenda);
                cont++;
            }
        }
        return listaHorarios;
    }
}
