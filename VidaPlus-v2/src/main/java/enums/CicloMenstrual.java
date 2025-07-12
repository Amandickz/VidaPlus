/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package enums;

/**
 *
 * @author Amanda
 */
public enum CicloMenstrual {
    
    UM("NÃO SEI"),
    DOIS("REGULAR"),
    DTRES("IRREGULAR");
    
    private String cicloMenstrual;

    CicloMenstrual(String cicloMenstrual) {
        this.cicloMenstrual = cicloMenstrual;
    }

    public String getCicloMenstrual() {
        return cicloMenstrual;
    }
    
    
    
}
