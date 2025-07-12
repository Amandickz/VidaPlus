/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package enums;

/**
 *
 * @author Amanda
 */
public enum IntervaloConsultas {
    
    UM("A CADA 10 MINUTOS"),
    DOIS("A CADA 15 MINUTOS"),
    TRES("A CADA 30 MINUTOS"),
    QUATRO("A CADA 45 MINUTOS"),
    CINCO("A CADA HORA");
    
    private String intervaloConsultas;

    private IntervaloConsultas(String intervaloConsultas) {
        this.intervaloConsultas = intervaloConsultas;
    }

    public String getIntervaloConsultas() {
        return intervaloConsultas;
    }
    
    
    
}
