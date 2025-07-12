/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package enums;

/**
 *
 * @author Amanda
 */
public enum TipoLeito {
    
    UM("AMBULATÓRIO"),
    DOIS("ENFERMARIA"),
    TRES("ENFERMARIA FEMININA"),
    QUATRO("ENFERMARIA MASCULINA"),
    CINCO("QUARTO INDIVIDUAL"),
    SEIS("QUARTO DUPLO"),
    SETE("APARTAMENTO"),
    OITO("SUÍTE"),
    NOVE("UTI");
    
    
    private String tipoLeito;

    TipoLeito(String tipoLeito) {
        this.tipoLeito = tipoLeito;
    }

    public String getTipoLeito() {
        return tipoLeito;
    }
        
}
