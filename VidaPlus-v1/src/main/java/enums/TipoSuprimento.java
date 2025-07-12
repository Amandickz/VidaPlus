/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package enums;

/**
 *
 * @author Amanda
 */
public enum TipoSuprimento {
    
    UM("CONSUMO - DESCARTÁVEL"),
    DOIS("CONSUMO - INSTUMENTO CIRURGICO"),
    TRES("CONSUMO - CURATIVO"),
    QUATRO("MEDICAMENTO"),
    CINCO("EPI"),
    SEIS("LIMPEZA"),
    SETE("ESCRITORIO");
    
    private String tipoSuprimento;

    private TipoSuprimento(String tipoSuprimento) {
        this.tipoSuprimento = tipoSuprimento;
    }

    public String getTipoSuprimento() {
        return tipoSuprimento;
    }
    
}
