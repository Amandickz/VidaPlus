/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package enums;

/**
 *
 * @author Amanda
 */
public enum CategoriaProfissional {
    
    I("ALIMENTOS"),
    II("ANÁLISES CLÍNICO-LABORATORIAIS"),
    III("EDUCAÇÃO"),
    IV("FARMÁCIA"),
    V("FARMÁCIA HOSPITALAR E CLÍNICA"),
    VI("FARMÁCIA INDUSTRIAL"),
    VII("GESTÃO"),
    VIII("PRÁTICAS INTEGRATIVAS E COMPLEMENTARES"),
    IX("SAÚDE PÚBLICA"),
    X("TOXICOLOGIA");
    
    private String categoriaProfissional;

    CategoriaProfissional(String categoriaProfissional) {
        this.categoriaProfissional = categoriaProfissional;
    }

    public String getCategoriaProfissional() {
        return categoriaProfissional;
    }
    
}
