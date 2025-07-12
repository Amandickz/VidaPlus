/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author Amanda
 */
public class AnamneseFeminina extends Anamnese{
    
    private boolean anticoncepcional;
    private int tipoAnticoncepcional;
    private int cicloMenstrual;

    public AnamneseFeminina(boolean anticoncepcional, int tipoAnticoncepcional, int cicloMenstrual) {
        this.anticoncepcional = anticoncepcional;
        this.tipoAnticoncepcional = tipoAnticoncepcional;
        this.cicloMenstrual = cicloMenstrual;
    }

    public AnamneseFeminina(boolean anticoncepcional, int tipoAnticoncepcional, int cicloMenstrual, String dataAtualizacao, boolean diabetes, boolean hipertensao, boolean hipotensao, boolean tabagismo, boolean epilepsia, boolean proteseDentaria, boolean problemasRespiratorios, String anotacoesProblemasRespiratorios, boolean cirurgias, String anotacoesCirurgias, boolean exerciciosFisicos, int frequenciaExercicios, boolean alcool, int frequenciaAlcool, boolean alergiaMedicacao, String anotacoesAlergiaMedicacao, boolean alergiaAlimento, String anotacoesAlergiaAlimento, boolean tratamentoMedicoAtual, String anotacoesTratamento, boolean marcaPasso, boolean medicamentoContinuo, String anotacoesMedicamentoContinuo) {
        super(dataAtualizacao, diabetes, hipertensao, hipotensao, tabagismo, epilepsia, proteseDentaria, problemasRespiratorios, anotacoesProblemasRespiratorios, cirurgias, anotacoesCirurgias, exerciciosFisicos, frequenciaExercicios, alcool, frequenciaAlcool, alergiaMedicacao, anotacoesAlergiaMedicacao, alergiaAlimento, anotacoesAlergiaAlimento, tratamentoMedicoAtual, anotacoesTratamento, marcaPasso, medicamentoContinuo, anotacoesMedicamentoContinuo);
        this.anticoncepcional = anticoncepcional;
        this.tipoAnticoncepcional = tipoAnticoncepcional;
        this.cicloMenstrual = cicloMenstrual;
    }

    public AnamneseFeminina(boolean anticoncepcional, int tipoAnticoncepcional, int cicloMenstrual, int id, String dataAtualizacao, boolean diabetes, boolean hipertensao, boolean hipotensao, boolean tabagismo, boolean epilepsia, boolean proteseDentaria, boolean problemasRespiratorios, String anotacoesProblemasRespiratorios, boolean cirurgias, String anotacoesCirurgias, boolean exerciciosFisicos, int frequenciaExercicios, boolean alcool, int frequenciaAlcool, boolean alergiaMedicacao, String anotacoesAlergiaMedicacao, boolean alergiaAlimento, String anotacoesAlergiaAlimento, boolean tratamentoMedicoAtual, String anotacoesTratamento, boolean marcaPasso, boolean medicamentoContinuo, String anotacoesMedicamentoContinuo) {
        super(id, dataAtualizacao, diabetes, hipertensao, hipotensao, tabagismo, epilepsia, proteseDentaria, problemasRespiratorios, anotacoesProblemasRespiratorios, cirurgias, anotacoesCirurgias, exerciciosFisicos, frequenciaExercicios, alcool, frequenciaAlcool, alergiaMedicacao, anotacoesAlergiaMedicacao, alergiaAlimento, anotacoesAlergiaAlimento, tratamentoMedicoAtual, anotacoesTratamento, marcaPasso, medicamentoContinuo, anotacoesMedicamentoContinuo);
        this.anticoncepcional = anticoncepcional;
        this.tipoAnticoncepcional = tipoAnticoncepcional;
        this.cicloMenstrual = cicloMenstrual;
    }

    public boolean isAnticoncepcional() {
        return anticoncepcional;
    }

    public void setAnticoncepcional(boolean anticoncepcional) {
        this.anticoncepcional = anticoncepcional;
    }

    public int getTipoAnticoncepcional() {
        return tipoAnticoncepcional;
    }

    public void setTipoAnticoncepcional(int tipoAnticoncepcional) {
        this.tipoAnticoncepcional = tipoAnticoncepcional;
    }

    public int getCicloMenstrual() {
        return cicloMenstrual;
    }

    public void setCicloMenstrual(int cicloMenstrual) {
        this.cicloMenstrual = cicloMenstrual;
    }

    @Override
    public String toString() {
        return "AnamneseFeminina{" + "anticoncepcional=" + anticoncepcional + ", tipoAnticoncepcional=" + tipoAnticoncepcional + ", cicloMenstrual=" + cicloMenstrual + '}';
    }
   
}
