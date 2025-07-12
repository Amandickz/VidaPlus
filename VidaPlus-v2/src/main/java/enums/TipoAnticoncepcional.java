/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package enums;

/**
 *
 * @author Amanda
 */
public enum TipoAnticoncepcional {
    
    UM("NENHUM"),
    DOIS("PÍLULA"),
    TRES("ANEL VAGINAL"),
    QUATRO("ADESIVO"),
    CINCO("INJEÇÃO"),
    SEIS("IMPLANTE"),
    SETE("DIU DE COBRE"),
    OITO("DIU HORMONAL"),
    NOVE("DIAFRAGMA");
    
    private String tipoAnticoncepcional;

    TipoAnticoncepcional(String tipoAnticoncepcional) {
        this.tipoAnticoncepcional = tipoAnticoncepcional;
    }

    public String getTipoAnticoncepcional() {
        return tipoAnticoncepcional;
    }
    
    
    
}
