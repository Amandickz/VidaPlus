/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package enums;

/**
 *
 * @author Amanda
 */
public enum DisponibilidadeLeito {
    
    UM("DISPONÍVEL"),
    DOIS("INDISPONÍVEL"),
    TRES("EM MANUTENÇÃO"),
    QUATRO("COM PACIENTE");
    
    private String disponibilidadeLeito;

    DisponibilidadeLeito(String disponibilidadeLeito) {
        this.disponibilidadeLeito = disponibilidadeLeito;
    }

    public String getDisponibilidadeLeito() {
        return disponibilidadeLeito;
    }
}
