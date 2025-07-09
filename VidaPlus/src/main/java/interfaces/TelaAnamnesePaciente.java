/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

import classes.Agenda;
import classes.Anamnese;
import classes.AnamneseFeminina;
import classes.Medico;
import classes.Paciente;
import classes.ProntuarioMedico;
import controles.ControleProntuario;
import enums.CicloMenstrual;
import enums.ServicoProntuario;
import enums.TipoAnticoncepcional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author Amanda
 */
public class TelaAnamnesePaciente extends javax.swing.JFrame {

    Paciente paciente;
    Medico medico;
    Anamnese anamnese;
    ProntuarioMedico prontuario;
    Agenda agenda;
    AnamneseFeminina anamneseFeminina;
    ControleProntuario controleProntuario = new ControleProntuario();
    boolean primeiraConsulta;
    String dataConvertida;
    
    /**
     * Creates new form TelaInicialAdministrador
     */
    public TelaAnamnesePaciente(Medico medico, Paciente paciente, Agenda agenda){
        initComponents();
        this.setLocationRelativeTo(null);
        this.medico = medico;
        this.paciente = paciente;
        this.agenda = agenda;
        
        System.out.println("----> Consulta Agora (Tela Anamnese Paciente):");
        System.out.println("Médico -> " + medico);
        System.out.println("Paciente -> " + paciente);
        System.out.println("Agenda -> " + agenda);
        
        LocalDate hoje = LocalDate.now();
        DateTimeFormatter formataData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        dataConvertida = hoje.format(formataData);
        
        desativacaoCampos();
        preencheListaCiclo();
        preencheListaAnticoncepcional();
        
        prontuario = controleProntuario.buscaProntuarioPorIDPaciente(paciente.getId());
        
        System.out.println("Prontuário localizado -> " + prontuario);
        
        if(prontuario != null){
            anamnese = controleProntuario.buscaAnamnese(prontuario.getIdAnamnese());
            System.out.println("Anamnese localizada -> " + anamnese);
            configuraCamposAnamnese();
            if(paciente.getSexo() == 0){
                this.anamneseFeminina = controleProntuario.buscaAnamneseFeminina(anamnese);
                configuraCamposAnamnesefeminina();
            } else {
                if(paciente.getSexo() == 1){
                    listaCiclo.setEnabled(false);
                    usoAnticoncepcional.setEnabled(false);
                    listaAnticoncepcional.setEnabled(false);
                }
                JOptionPane.showMessageDialog(null, "Primeira consulta do Paciente!\n"
                        + "Obrigatório preenchimento da Anamnese.");
                primeiraConsulta = true;
            }
        }
    }
    
    
    private void preencheListaCiclo(){
        listaCiclo.removeAllItems();
        for(CicloMenstrual cm : CicloMenstrual.values()){
            listaCiclo.addItem(cm.getCicloMenstrual());
        }
    }
    
    private void preencheListaAnticoncepcional(){
        listaAnticoncepcional.removeAllItems();
        for(TipoAnticoncepcional ta : TipoAnticoncepcional.values()){
            listaAnticoncepcional.addItem(ta.getTipoAnticoncepcional());
        }
    }
    
    private void desativacaoCampos(){
        anotacoesRespiratorios.setEnabled(false);
        anotacoesCirurgias.setEnabled(false);
        exerciciosDias.setEnabled(false);
        bebidaDias.setEnabled(false);
        anotacoesAlergias.setEnabled(false);
        anotacoesAlimentos.setEnabled(false);
        descricaoTratamentoAtual.setEnabled(false);
        descricaoMedicacoes.setEnabled(false);
        listaAnticoncepcional.setEnabled(false);
    }
    
    private void configuraCamposAnamnese(){
        diabetes.setEnabled(anamnese.isDiabetes());
        hipertensao.setEnabled(anamnese.isHipertensao());
        hipotensao.setEnabled(anamnese.isHipotensao());
        tabagismo.setEnabled(anamnese.isTabagismo());
        epilepsia.setEnabled(anamnese.isEpilepsia());
        proteseDentaria.setEnabled(anamnese.isProteseDentaria());
        problemasRespiratorios.setEnabled(anamnese.isProblemasRespiratorios());
        if(anamnese.isProblemasRespiratorios()){
            anotacoesRespiratorios.setEnabled(true);
            anotacoesRespiratorios.setText(anamnese.getAnotacoesProblemasRespiratorios());
        }
        cirurgias.setEnabled(anamnese.isCirurgias());
        if(anamnese.isCirurgias()){
            anotacoesCirurgias.setEnabled(true);
            anotacoesCirurgias.setText(anamnese.getAnotacoesCirurgias());
        }
        exerciciosFisicos.setEnabled(anamnese.isExerciciosFisicos());
        if(anamnese.isExerciciosFisicos()){
            exerciciosDias.setEnabled(true);
            exerciciosDias.setText("" + anamnese.getFrequenciaExercicios());
        }
        alcool.setEnabled(anamnese.isAlcool());
        if(anamnese.isAlcool()){
            bebidaDias.setEnabled(true);
            bebidaDias.setText("" + anamnese.getFrequenciaAlcool());
        }
        alergiaMedicamento.setEnabled(anamnese.isAlergiaMedicacao());
        if(anamnese.isAlergiaMedicacao()){
            anotacoesAlergias.setEnabled(true);
            anotacoesAlergias.setText(anamnese.getAnotacoesAlergiaMedicacao());
        }
        alergiaAlimentos.setEnabled(anamnese.isAlergiaAlimento());
        if(anamnese.isAlergiaAlimento()){
            anotacoesAlimentos.setEnabled(true);
            anotacoesAlimentos.setText(anamnese.getAnotacoesAlergiaAlimento());
        }
        tratamentoAtual.setEnabled(anamnese.isTratamentoMedicoAtual());
        if(anamnese.isTratamentoMedicoAtual()){
            descricaoTratamentoAtual.setEnabled(true);
            descricaoTratamentoAtual.setText(anamnese.getAnotacoesTratamento());
        }
        marcaPasso.setEnabled(anamnese.isMarcaPasso());
        medicacaoContinuo.setEnabled(anamnese.isMedicamentoContinuo());
        if(anamnese.isMedicamentoContinuo()){
            descricaoMedicacoes.setEnabled(true);
            descricaoMedicacoes.setText(anamnese.getAnotacoesMedicamentoContinuo());
        }
    }
    
    private void configuraCamposAnamnesefeminina(){
        listaCiclo.setEnabled(true);
        listaCiclo.setSelectedIndex(anamneseFeminina.getCicloMenstrual());
        usoAnticoncepcional.setEnabled(anamneseFeminina.isAnticoncepcional());
        if(anamneseFeminina.isAnticoncepcional()){
            listaAnticoncepcional.setEnabled(true);
            listaAnticoncepcional.setSelectedIndex(anamneseFeminina.getTipoAnticoncepcional());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        diabetes = new javax.swing.JCheckBox();
        hipertensao = new javax.swing.JCheckBox();
        hipotensao = new javax.swing.JCheckBox();
        tabagismo = new javax.swing.JCheckBox();
        epilepsia = new javax.swing.JCheckBox();
        proteseDentaria = new javax.swing.JCheckBox();
        problemasRespiratorios = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        anotacoesRespiratorios = new javax.swing.JTextField();
        cirurgias = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        anotacoesCirurgias = new javax.swing.JTextField();
        exerciciosFisicos = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        exerciciosDias = new javax.swing.JTextField();
        alcool = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        bebidaDias = new javax.swing.JTextField();
        alergiaMedicamento = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        anotacoesAlergias = new javax.swing.JTextField();
        alergiaAlimentos = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        anotacoesAlimentos = new javax.swing.JTextField();
        tratamentoAtual = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descricaoTratamentoAtual = new javax.swing.JTextArea();
        marcaPasso = new javax.swing.JCheckBox();
        medicacaoContinuo = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        descricaoMedicacoes = new javax.swing.JTextArea();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        listaCiclo = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        usoAnticoncepcional = new javax.swing.JCheckBox();
        jLabel14 = new javax.swing.JLabel();
        listaAnticoncepcional = new javax.swing.JComboBox<>();
        salvar = new javax.swing.JButton();
        voltar = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        sair = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        agendaCompleta = new javax.swing.JMenuItem();
        addNovasDatas = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Anamnese");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Selecione as opções que você tem:");

        diabetes.setText("Diabetes");

        hipertensao.setText("Hipertensão");

        hipotensao.setText("Hipotensão");

        tabagismo.setText("Tabagismo");
        tabagismo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tabagismoActionPerformed(evt);
            }
        });

        epilepsia.setText("Epilepsia");

        proteseDentaria.setText("Prótese Dentária");

        problemasRespiratorios.setText("Problemas Respiratórios");
        problemasRespiratorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                problemasRespiratoriosActionPerformed(evt);
            }
        });

        jLabel4.setText("Se sim, descreva quais:");

        cirurgias.setText("Cirurgias");
        cirurgias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cirurgiasActionPerformed(evt);
            }
        });

        jLabel5.setText("Se sim, descreva quais:");

        exerciciosFisicos.setText("Exercícios Físicos");
        exerciciosFisicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exerciciosFisicosActionPerformed(evt);
            }
        });

        jLabel6.setText("Quantas vezes por semana:");

        alcool.setText("Álcool");
        alcool.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alcoolActionPerformed(evt);
            }
        });

        jLabel7.setText("Quantas vezes por semana:");

        alergiaMedicamento.setText("Alergia a Medicamento(s)");
        alergiaMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alergiaMedicamentoActionPerformed(evt);
            }
        });

        jLabel8.setText("Se sim, descreva quais:");

        alergiaAlimentos.setText("Alergia a Alimentos");
        alergiaAlimentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alergiaAlimentosActionPerformed(evt);
            }
        });

        jLabel9.setText("Se sim, descreva quais:");

        tratamentoAtual.setText("Algum tratamento atual?");
        tratamentoAtual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tratamentoAtualActionPerformed(evt);
            }
        });

        jLabel10.setText("Se sim, descreva sobre ele:");

        descricaoTratamentoAtual.setColumns(20);
        descricaoTratamentoAtual.setRows(5);
        jScrollPane1.setViewportView(descricaoTratamentoAtual);

        marcaPasso.setText("Utiliza Marca Passo?");

        medicacaoContinuo.setText("Utiliza Medicação de uso Contínuo?");
        medicacaoContinuo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medicacaoContinuoActionPerformed(evt);
            }
        });

        jLabel11.setText("Se Sim, qual(is)?");

        descricaoMedicacoes.setColumns(20);
        descricaoMedicacoes.setRows(5);
        jScrollPane2.setViewportView(descricaoMedicacoes);

        jLabel12.setText("Ciclo Menstrual: ");

        listaCiclo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel13.setText("Anticoncepcional?");

        usoAnticoncepcional.setText("Sim");
        usoAnticoncepcional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usoAnticoncepcionalActionPerformed(evt);
            }
        });

        jLabel14.setText("Se sim, qual?");

        listaAnticoncepcional.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        listaAnticoncepcional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaAnticoncepcionalActionPerformed(evt);
            }
        });

        salvar.setText("Salvar e Continuar");
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });

        voltar.setText("Voltar");
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });

        sair.setText("Sair");
        sair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sairMouseClicked(evt);
            }
        });
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });
        jMenuBar2.add(sair);

        jMenu1.setText("Minha Agenda");

        agendaCompleta.setText("Agenda Completa");
        agendaCompleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agendaCompletaActionPerformed(evt);
            }
        });
        jMenu1.add(agendaCompleta);

        addNovasDatas.setText("Adicionar Novas Datas");
        addNovasDatas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNovasDatasActionPerformed(evt);
            }
        });
        jMenu1.add(addNovasDatas);

        jMenuBar2.add(jMenu1);

        jMenu2.setText("Internações");

        jMenuItem2.setText("Nova Internação");
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Gerenciar Internações");
        jMenu2.add(jMenuItem3);

        jMenuBar2.add(jMenu2);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(alcool, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(exerciciosFisicos, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(exerciciosDias, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bebidaDias, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(marcaPasso, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(alergiaMedicamento)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(anotacoesAlergias))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(cirurgias, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(anotacoesCirurgias))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(problemasRespiratorios, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(anotacoesRespiratorios))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(alergiaAlimentos, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(anotacoesAlimentos))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(diabetes, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tabagismo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(150, 150, 150)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(hipertensao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(epilepsia, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(150, 150, 150)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(proteseDentaria, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(hipotensao, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(tratamentoAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(medicacaoContinuo, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(listaCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(usoAnticoncepcional, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(listaAnticoncepcional, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(diabetes)
                    .addComponent(hipertensao)
                    .addComponent(hipotensao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tabagismo)
                    .addComponent(epilepsia)
                    .addComponent(proteseDentaria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(problemasRespiratorios)
                    .addComponent(jLabel4)
                    .addComponent(anotacoesRespiratorios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cirurgias)
                    .addComponent(jLabel5)
                    .addComponent(anotacoesCirurgias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exerciciosFisicos)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(exerciciosDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(bebidaDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(alcool))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alergiaMedicamento)
                    .addComponent(jLabel8)
                    .addComponent(anotacoesAlergias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alergiaAlimentos)
                    .addComponent(jLabel9)
                    .addComponent(anotacoesAlimentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tratamentoAtual)
                        .addComponent(jLabel10))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(marcaPasso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(medicacaoContinuo)
                        .addComponent(jLabel11))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listaCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(usoAnticoncepcional)
                    .addComponent(jLabel14)
                    .addComponent(listaAnticoncepcional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salvar)
                    .addComponent(voltar))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cirurgiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cirurgiasActionPerformed
        // TODO add your handling code here:
        anotacoesCirurgias.setEnabled(cirurgias.isSelected());
    }//GEN-LAST:event_cirurgiasActionPerformed

    private void alcoolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alcoolActionPerformed
        // TODO add your handling code here:
        bebidaDias.setEnabled(alcool.isSelected());
    }//GEN-LAST:event_alcoolActionPerformed

    private void alergiaAlimentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alergiaAlimentosActionPerformed
        // TODO add your handling code here:
        anotacoesAlimentos.setEnabled(alergiaAlimentos.isSelected());
    }//GEN-LAST:event_alergiaAlimentosActionPerformed

    private void problemasRespiratoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_problemasRespiratoriosActionPerformed
        // TODO add your handling code here:
        anotacoesRespiratorios.setEnabled(problemasRespiratorios.isSelected());
    }//GEN-LAST:event_problemasRespiratoriosActionPerformed

    private void exerciciosFisicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exerciciosFisicosActionPerformed
        // TODO add your handling code here:
        exerciciosDias.setEnabled(exerciciosFisicos.isSelected());
    }//GEN-LAST:event_exerciciosFisicosActionPerformed

    private void alergiaMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alergiaMedicamentoActionPerformed
        // TODO add your handling code here:
        anotacoesAlergias.setEnabled(alergiaMedicamento.isSelected());
    }//GEN-LAST:event_alergiaMedicamentoActionPerformed

    private void tratamentoAtualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tratamentoAtualActionPerformed
        // TODO add your handling code here:
        descricaoTratamentoAtual.setEnabled(tratamentoAtual.isSelected());
    }//GEN-LAST:event_tratamentoAtualActionPerformed

    private void medicacaoContinuoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medicacaoContinuoActionPerformed
        // TODO add your handling code here:
        descricaoMedicacoes.setEnabled(medicacaoContinuo.isSelected());
    }//GEN-LAST:event_medicacaoContinuoActionPerformed

    private void usoAnticoncepcionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usoAnticoncepcionalActionPerformed
        // TODO add your handling code here:
        listaAnticoncepcional.setEnabled(usoAnticoncepcional.isSelected());
    }//GEN-LAST:event_usoAnticoncepcionalActionPerformed

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        // TODO add your handling code here:
        int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja voltar?\nIsso pode acarretar em perda de dados.",
                "", JOptionPane.YES_NO_CANCEL_OPTION);
        if(resposta == JOptionPane.YES_OPTION){
            new TelaInicialMedico(medico).setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_voltarActionPerformed

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
        // TODO add your handling code here:
        if(primeiraConsulta){
            anamnese = new Anamnese();
        }
        anamnese.setDataAtualizacao(dataConvertida);
        anamnese.setDiabetes(diabetes.isSelected());
        anamnese.setHipertensao(hipertensao.isSelected());
        anamnese.setHipotensao(hipotensao.isSelected());
        anamnese.setTabagismo(tabagismo.isSelected());
        anamnese.setEpilepsia(epilepsia.isSelected());
        anamnese.setProteseDentaria(proteseDentaria.isSelected());
        anamnese.setProblemasRespiratorios(problemasRespiratorios.isSelected());
        if(problemasRespiratorios.isSelected()){
            anamnese.setAnotacoesProblemasRespiratorios(anotacoesRespiratorios.getText());
        }
        anamnese.setCirurgias(cirurgias.isSelected());
        if(cirurgias.isSelected()){
            anamnese.setAnotacoesCirurgias(anotacoesCirurgias.getText());
        }
        anamnese.setExerciciosFisicos(exerciciosFisicos.isSelected());
        if(exerciciosFisicos.isSelected()){
            anamnese.setFrequenciaExercicios(Integer.parseInt(exerciciosDias.getText()));
        } else {
            anamnese.setFrequenciaExercicios(0);
        }
        anamnese.setAlcool(alcool.isSelected());
        if(alcool.isSelected()){
            anamnese.setFrequenciaAlcool(Integer.parseInt(bebidaDias.getText()));
        } else {
            anamnese.setFrequenciaAlcool(0);
        }
        anamnese.setAlergiaMedicacao(alergiaMedicamento.isSelected());
        if(alergiaMedicamento.isSelected()){
            anamnese.setAnotacoesAlergiaMedicacao(anotacoesAlergias.getText());
        }
        anamnese.setAlergiaAlimento(alergiaAlimentos.isSelected());
        if(alergiaAlimentos.isSelected()){
            anamnese.setAnotacoesAlergiaAlimento(anotacoesAlergias.getText());
        }
        anamnese.setTratamentoMedicoAtual(tratamentoAtual.isSelected());
        if(tratamentoAtual.isSelected()){
            anamnese.setAnotacoesTratamento(descricaoTratamentoAtual.getText());
        }
        anamnese.setMarcaPasso(marcaPasso.isSelected());
        anamnese.setMedicamentoContinuo(medicacaoContinuo.isSelected());
        if(medicacaoContinuo.isSelected()){
            anamnese.setAnotacoesMedicamentoContinuo(descricaoMedicacoes.getText());
        }

        if(paciente.getSexo() == 0){
            if(primeiraConsulta){
                anamneseFeminina = new AnamneseFeminina(false, 0, 0);
            }
            anamneseFeminina.setCicloMenstrual(listaCiclo.getSelectedIndex());
            usoAnticoncepcional.setEnabled(anamneseFeminina.isAnticoncepcional());
            if(usoAnticoncepcional.isSelected()){
                anamneseFeminina.setAnticoncepcional(true);
                anamneseFeminina.setTipoAnticoncepcional(listaAnticoncepcional.getSelectedIndex());
            } else {
                anamneseFeminina.setAnticoncepcional(false);
                anamneseFeminina.setTipoAnticoncepcional(0);
            }   
        }
        
        System.out.println(anamnese);
        
        if(primeiraConsulta){
            anamnese = controleProntuario.cadastraAnamnese(anamnese);
            if(anamnese != null){
                prontuario = new ProntuarioMedico(paciente.getId(), anamnese.getId());
                prontuario.setDataAtualizacao(dataConvertida);
                prontuario.setServico(ServicoProntuario.UM.getServico());
                prontuario = controleProntuario.criarProntuario(prontuario);
                if(prontuario != null){
                    if(paciente.getSexo() == 0){
                        anamneseFeminina.setId(anamnese.getId());
                        anamneseFeminina = controleProntuario.cadastraAnamneseFeminina(anamneseFeminina);
                        if(anamneseFeminina != null){
                            JOptionPane.showMessageDialog(null, "Anamnese Salva!\n"
                                    + "Pode prosseguir com a consulta.");
                            new TelaConsulta(medico, paciente, prontuario, agenda).setVisible(true);
                            dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "Ops! Algo deu errado!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Anamnese Salva!\n"
                                    + "Pode prosseguir com a consulta.");
                        new TelaConsulta(medico, paciente, prontuario, agenda).setVisible(true);
                        dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ops! Algo deu errado!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ops! Algo deu errado!");
            }
        } else {
            boolean confirmacao = controleProntuario.alterarAnamnese(anamnese);
            if(confirmacao){
                prontuario.setDataAtualizacao(dataConvertida);
                prontuario.setServico(ServicoProntuario.UM.getServico());
                controleProntuario.atualizacaoPronturario(prontuario);
                if(paciente.getSexo() == 0){
                    boolean confirmacaoF = controleProntuario.alterarAnamneseFeminina(anamneseFeminina);
                    if(confirmacaoF){
                        JOptionPane.showMessageDialog(null, "Anamnese Atualizada!\n"
                                + "Pode prosseguir com a consulta.");
                        new TelaConsulta(medico, paciente, prontuario, agenda).setVisible(true);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Ops! Algo deu errado!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Anamnese Atualizada!\n"
                                + "Pode prosseguir com a consulta.");
                    new TelaConsulta(medico, paciente, prontuario,agenda).setVisible(true);
                    dispose();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ops! Algo deu errado!");
            }
        }
        
    }//GEN-LAST:event_salvarActionPerformed

    private void sairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sairMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_sairMouseClicked

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_sairActionPerformed

    private void agendaCompletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agendaCompletaActionPerformed
        // TODO add your handling code here:
        new TelaAgendaCompleta(medico).setVisible(true);
        dispose();
    }//GEN-LAST:event_agendaCompletaActionPerformed

    private void addNovasDatasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNovasDatasActionPerformed
        // TODO add your handling code here:
        new TelaCadastroDatasConsultas(medico).setVisible(true);
        dispose();
    }//GEN-LAST:event_addNovasDatasActionPerformed

    private void tabagismoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tabagismoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tabagismoActionPerformed

    private void listaAnticoncepcionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaAnticoncepcionalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listaAnticoncepcionalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addNovasDatas;
    private javax.swing.JMenuItem agendaCompleta;
    private javax.swing.JCheckBox alcool;
    private javax.swing.JCheckBox alergiaAlimentos;
    private javax.swing.JCheckBox alergiaMedicamento;
    private javax.swing.JTextField anotacoesAlergias;
    private javax.swing.JTextField anotacoesAlimentos;
    private javax.swing.JTextField anotacoesCirurgias;
    private javax.swing.JTextField anotacoesRespiratorios;
    private javax.swing.JTextField bebidaDias;
    private javax.swing.JCheckBox cirurgias;
    private javax.swing.JTextArea descricaoMedicacoes;
    private javax.swing.JTextArea descricaoTratamentoAtual;
    private javax.swing.JCheckBox diabetes;
    private javax.swing.JCheckBox epilepsia;
    private javax.swing.JTextField exerciciosDias;
    private javax.swing.JCheckBox exerciciosFisicos;
    private javax.swing.JCheckBox hipertensao;
    private javax.swing.JCheckBox hipotensao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JComboBox<String> listaAnticoncepcional;
    private javax.swing.JComboBox<String> listaCiclo;
    private javax.swing.JCheckBox marcaPasso;
    private javax.swing.JCheckBox medicacaoContinuo;
    private javax.swing.JCheckBox problemasRespiratorios;
    private javax.swing.JCheckBox proteseDentaria;
    private javax.swing.JMenu sair;
    private javax.swing.JButton salvar;
    private javax.swing.JCheckBox tabagismo;
    private javax.swing.JCheckBox tratamentoAtual;
    private javax.swing.JCheckBox usoAnticoncepcional;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
