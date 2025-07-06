/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author Amanda
 */
public class Anamnese {
    
    private int id;
    private boolean diabetes;
    private boolean hipertensao;
    private boolean hipotensao;
    private boolean tabagismo;
    private boolean epilepsia;
    private boolean proteseDentaria;
    private boolean problemasRespiratorios;
    private String anotacoesProblemasRespiratorios;
    private boolean cirurgias;
    private String anotacoesCirurgias;
    private boolean exerciciosFisicos;
    private int frequenciaExercicios;
    private boolean alcool;
    private int frequenciaAlcool;
    private boolean alergiaMedicacao;
    private String anotacoesAlergiaMedicacao;
    private boolean alergiaAlimento;
    private String anotacoesAlergiaAlimento;
    private boolean tratamentoMedicoAtual;
    private String anotacoesTratamento;
    private boolean marcaPasso;
    private boolean medicamentoContinuo;
    private String anotacoesMedicamentoContinuo;

    public Anamnese() {
    }

    public Anamnese(boolean diabetes, boolean hipertensao, boolean hipotensao, boolean tabagismo, boolean epilepsia, boolean proteseDentaria, boolean problemasRespiratorios, String anotacoesProblemasRespiratorios, boolean cirurgias, String anotacoesCirurgias, boolean exerciciosFisicos, int frequenciaExercicios, boolean alcool, int frequenciaAlcool, boolean alergiaMedicacao, String anotacoesAlergiaMedicacao, boolean alergiaAlimento, String anotacoesAlergiaAlimento, boolean tratamentoMedicoAtual, String anotacoesTratamento, boolean marcaPasso, boolean medicamentoContinuo, String anotacoesMedicamentoContinuo) {
        this.diabetes = diabetes;
        this.hipertensao = hipertensao;
        this.hipotensao = hipotensao;
        this.tabagismo = tabagismo;
        this.epilepsia = epilepsia;
        this.proteseDentaria = proteseDentaria;
        this.problemasRespiratorios = problemasRespiratorios;
        this.anotacoesProblemasRespiratorios = anotacoesProblemasRespiratorios;
        this.cirurgias = cirurgias;
        this.anotacoesCirurgias = anotacoesCirurgias;
        this.exerciciosFisicos = exerciciosFisicos;
        this.frequenciaExercicios = frequenciaExercicios;
        this.alcool = alcool;
        this.frequenciaAlcool = frequenciaAlcool;
        this.alergiaMedicacao = alergiaMedicacao;
        this.anotacoesAlergiaMedicacao = anotacoesAlergiaMedicacao;
        this.alergiaAlimento = alergiaAlimento;
        this.anotacoesAlergiaAlimento = anotacoesAlergiaAlimento;
        this.tratamentoMedicoAtual = tratamentoMedicoAtual;
        this.anotacoesTratamento = anotacoesTratamento;
        this.marcaPasso = marcaPasso;
        this.medicamentoContinuo = medicamentoContinuo;
        this.anotacoesMedicamentoContinuo = anotacoesMedicamentoContinuo;
    }

    public Anamnese(int id, boolean diabetes, boolean hipertensao, boolean hipotensao, boolean tabagismo, boolean epilepsia, boolean proteseDentaria, boolean problemasRespiratorios, String anotacoesProblemasRespiratorios, boolean cirurgias, String anotacoesCirurgias, boolean exerciciosFisicos, int frequenciaExercicios, boolean alcool, int frequenciaAlcool, boolean alergiaMedicacao, String anotacoesAlergiaMedicacao, boolean alergiaAlimento, String anotacoesAlergiaAlimento, boolean tratamentoMedicoAtual, String anotacoesTratamento, boolean marcaPasso, boolean medicamentoContinuo, String anotacoesMedicamentoContinuo) {
        this.id = id;
        this.diabetes = diabetes;
        this.hipertensao = hipertensao;
        this.hipotensao = hipotensao;
        this.tabagismo = tabagismo;
        this.epilepsia = epilepsia;
        this.proteseDentaria = proteseDentaria;
        this.problemasRespiratorios = problemasRespiratorios;
        this.anotacoesProblemasRespiratorios = anotacoesProblemasRespiratorios;
        this.cirurgias = cirurgias;
        this.anotacoesCirurgias = anotacoesCirurgias;
        this.exerciciosFisicos = exerciciosFisicos;
        this.frequenciaExercicios = frequenciaExercicios;
        this.alcool = alcool;
        this.frequenciaAlcool = frequenciaAlcool;
        this.alergiaMedicacao = alergiaMedicacao;
        this.anotacoesAlergiaMedicacao = anotacoesAlergiaMedicacao;
        this.alergiaAlimento = alergiaAlimento;
        this.anotacoesAlergiaAlimento = anotacoesAlergiaAlimento;
        this.tratamentoMedicoAtual = tratamentoMedicoAtual;
        this.anotacoesTratamento = anotacoesTratamento;
        this.marcaPasso = marcaPasso;
        this.medicamentoContinuo = medicamentoContinuo;
        this.anotacoesMedicamentoContinuo = anotacoesMedicamentoContinuo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDiabetes() {
        return diabetes;
    }

    public void setDiabetes(boolean diabetes) {
        this.diabetes = diabetes;
    }

    public boolean isHipertensao() {
        return hipertensao;
    }

    public void setHipertensao(boolean hipertensao) {
        this.hipertensao = hipertensao;
    }

    public boolean isHipotensao() {
        return hipotensao;
    }

    public void setHipotensao(boolean hipotensao) {
        this.hipotensao = hipotensao;
    }

    public boolean isTabagismo() {
        return tabagismo;
    }

    public void setTabagismo(boolean tabagismo) {
        this.tabagismo = tabagismo;
    }

    public boolean isEpilepsia() {
        return epilepsia;
    }

    public void setEpilepsia(boolean epilepsia) {
        this.epilepsia = epilepsia;
    }

    public boolean isProteseDentaria() {
        return proteseDentaria;
    }

    public void setProteseDentaria(boolean proteseDentaria) {
        this.proteseDentaria = proteseDentaria;
    }

    public boolean isProblemasRespiratorios() {
        return problemasRespiratorios;
    }

    public void setProblemasRespiratorios(boolean problemasRespiratorios) {
        this.problemasRespiratorios = problemasRespiratorios;
    }

    public String getAnotacoesProblemasRespiratorios() {
        return anotacoesProblemasRespiratorios;
    }

    public void setAnotacoesProblemasRespiratorios(String anotacoesProblemasRespiratorios) {
        this.anotacoesProblemasRespiratorios = anotacoesProblemasRespiratorios;
    }

    public boolean isCirurgias() {
        return cirurgias;
    }

    public void setCirurgias(boolean cirurgias) {
        this.cirurgias = cirurgias;
    }

    public String getAnotacoesCirurgias() {
        return anotacoesCirurgias;
    }

    public void setAnotacoesCirurgias(String anotacoesCirurgias) {
        this.anotacoesCirurgias = anotacoesCirurgias;
    }

    public boolean isExerciciosFisicos() {
        return exerciciosFisicos;
    }

    public void setExerciciosFisicos(boolean exerciciosFisicos) {
        this.exerciciosFisicos = exerciciosFisicos;
    }

    public int getFrequenciaExercicios() {
        return frequenciaExercicios;
    }

    public void setFrequenciaExercicios(int frequenciaExercicios) {
        this.frequenciaExercicios = frequenciaExercicios;
    }

    public boolean isAlcool() {
        return alcool;
    }

    public void setAlcool(boolean alcool) {
        this.alcool = alcool;
    }

    public int getFrequenciaAlcool() {
        return frequenciaAlcool;
    }

    public void setFrequenciaAlcool(int frequenciaAlcool) {
        this.frequenciaAlcool = frequenciaAlcool;
    }

    public boolean isAlergiaMedicacao() {
        return alergiaMedicacao;
    }

    public void setAlergiaMedicacao(boolean alergiaMedicacao) {
        this.alergiaMedicacao = alergiaMedicacao;
    }

    public String getAnotacoesAlergiaMedicacao() {
        return anotacoesAlergiaMedicacao;
    }

    public void setAnotacoesAlergiaMedicacao(String anotacoesAlergiaMedicacao) {
        this.anotacoesAlergiaMedicacao = anotacoesAlergiaMedicacao;
    }

    public boolean isAlergiaAlimento() {
        return alergiaAlimento;
    }

    public void setAlergiaAlimento(boolean alergiaAlimento) {
        this.alergiaAlimento = alergiaAlimento;
    }

    public String getAnotacoesAlergiaAlimento() {
        return anotacoesAlergiaAlimento;
    }

    public void setAnotacoesAlergiaAlimento(String anotacoesAlergiaAlimento) {
        this.anotacoesAlergiaAlimento = anotacoesAlergiaAlimento;
    }

    public boolean isTratamentoMedicoAtual() {
        return tratamentoMedicoAtual;
    }

    public void setTratamentoMedicoAtual(boolean tratamentoMedicoAtual) {
        this.tratamentoMedicoAtual = tratamentoMedicoAtual;
    }

    public String getAnotacoesTratamento() {
        return anotacoesTratamento;
    }

    public void setAnotacoesTratamento(String anotacoesTratamento) {
        this.anotacoesTratamento = anotacoesTratamento;
    }

    public boolean isMarcaPasso() {
        return marcaPasso;
    }

    public void setMarcaPasso(boolean marcaPasso) {
        this.marcaPasso = marcaPasso;
    }

    public boolean isMedicamentoContinuo() {
        return medicamentoContinuo;
    }

    public void setMedicamentoContinuo(boolean medicamentoContinuo) {
        this.medicamentoContinuo = medicamentoContinuo;
    }

    public String getAnotacoesMedicamentoContinuo() {
        return anotacoesMedicamentoContinuo;
    }

    public void setAnotacoesMedicamentoContinuo(String anotacoesMedicamentoContinuo) {
        this.anotacoesMedicamentoContinuo = anotacoesMedicamentoContinuo;
    }

    @Override
    public String toString() {
        return "Anamnese{" + "id=" + id + ", diabetes=" + diabetes + ", hipertensao=" + hipertensao + ", hipotensao=" + hipotensao + ", tabagismo=" + tabagismo + ", epilepsia=" + epilepsia + ", proteseDentaria=" + proteseDentaria + ", problemasRespiratorios=" + problemasRespiratorios + ", anotacoesProblemasRespiratorios=" + anotacoesProblemasRespiratorios + ", cirurgias=" + cirurgias + ", anotacoesCirurgias=" + anotacoesCirurgias + ", exerciciosFisicos=" + exerciciosFisicos + ", frequenciaExercicios=" + frequenciaExercicios + ", alcool=" + alcool + ", frequenciaAlcool=" + frequenciaAlcool + ", alergiaMedicacao=" + alergiaMedicacao + ", anotacoesAlergiaMedicacao=" + anotacoesAlergiaMedicacao + ", alergiaAlimento=" + alergiaAlimento + ", anotacoesAlergiaAlimento=" + anotacoesAlergiaAlimento + ", tratamentoMedicoAtual=" + tratamentoMedicoAtual + ", anotacoesTratamento=" + anotacoesTratamento + ", marcaPasso=" + marcaPasso + ", medicamentoContinuo=" + medicamentoContinuo + ", anotacoesMedicamentoContinuo=" + anotacoesMedicamentoContinuo + '}';
    }
    
}
