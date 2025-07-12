/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package enums;

/**
 *
 * @author Amanda
 */
public enum TipoEnfermeiro {
    
    UM("ENFERMEIRO"),
    DOIS("TÉCNICO DE ENFERMAGEM"),
    TRÊS("AUXILIAR EM ENFERMAGEM");
    
    
    private String tipoEnfermeiro;

    TipoEnfermeiro(String tipoEnfermeiro) {
        this.tipoEnfermeiro = tipoEnfermeiro;
    }

    public String getTipoEnfermeiro() {
        return tipoEnfermeiro;
    }
        
}
