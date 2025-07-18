/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

import classes.Administracao;
import classes.Internacao;
import classes.Leito;
import classes.Paciente;
import classes.ProfissionalSaude;
import classes.ProntuarioMedico;
import controles.ControleInternacao;
import controles.ControleLeito;
import controles.ControlePaciente;
import controles.ControleProfissional;
import controles.ControleProntuario;
import enums.ServicoConsulta;
import enums.ServicoProntuario;
import enums.TipoLeito;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Amanda
 */
public class TelaSolicitacoesInternacoes extends javax.swing.JFrame {
    /**
     * Creates new form TelaAdministrador
     */
    
    String dataConvertida;
    Administracao adm;
    DefaultTableModel todasSolicitacoes;
    ArrayList<Leito> leitosDisponiveis;
    ControleLeito controleLeito = new ControleLeito();
    ArrayList<Internacao> solicitacoes;
    ControleInternacao controleInternacao = new ControleInternacao();
    ControleProntuario controleProntuario = new ControleProntuario();
    ControlePaciente controlePaciente = new ControlePaciente();
    ControleProfissional controleProfissional = new ControleProfissional();
    
    public TelaSolicitacoesInternacoes(Administracao adm) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.adm = adm;
        
        LocalDate hoje = LocalDate.now();
        DateTimeFormatter formataData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        dataConvertida = hoje.format(formataData);
        
        System.out.println("\n----->Administrador: " + adm);
        
        todasSolicitacoes = (DefaultTableModel) tabelaSolicitacoes.getModel();
        
        atualizaTabela();
        centralizarTextos();
        desativaEdicaoCampos();
        preencheListaLeitos();
        
        listaLeitos.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                if(e.getStateChange() == ItemEvent.SELECTED){
                    int numLeito = Integer.parseInt(e.getItem().toString());
                    System.out.println("Selecionado -> " + numLeito);
                    mostrarInformações(numLeito);
                }
            }
        });
    }
    
    private void atualizaTabela(){
        todasSolicitacoes.setRowCount(0);
        //Busca Internações aguardando aprovações
        this.solicitacoes = controleInternacao.retornaSolicitacoesInternacao();
        if(this.solicitacoes != null){
            for(Internacao i : this.solicitacoes){
                ProntuarioMedico prontuario = controleProntuario.buscaProntuarioPorID(i.getIdProntuario());
                Paciente paciente = controlePaciente.buscaPacientePorID(prontuario.getIdPaciente());
                ProfissionalSaude profissional = controleProfissional.buscaProfissionalPorID(i.getIdMedico());
                if(paciente.getIdAdministrador() == adm.getId() && profissional.getIdAdministracao() == adm.getId()){
                    todasSolicitacoes.addRow(new Object[]{
                        paciente.getNome(),
                        profissional.getNome(),
                        prontuario.getDataAtualizacao()
                    });
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não há Solicitações de Internação no Momento!");
            new TelaInicialAdministrador(adm).setVisible(true);
            dispose();
        }
    }
    
    private void desativaEdicaoCampos(){
        nomePaciente.setEditable(false);
        nomeMedico.setEditable(false);
        listaLeitos.setEditable(false);
        tipoLeito.setEditable(false);
        valorLeito.setEditable(false);
    }
    
    private void preencheListaLeitos(){
        listaLeitos.removeAllItems();
        leitosDisponiveis = controleLeito.retornaLeitosDisponiveis(adm.getId());
        if(leitosDisponiveis != null){
            for(Leito l : leitosDisponiveis){
                listaLeitos.addItem("" + l.getNumero());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum Leito disponível no momento.");
        }
    }
    
    private void centralizarTextos(){
        DefaultTableCellRenderer centralizar = new DefaultTableCellRenderer();
        centralizar.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tabelaSolicitacoes.getColumnCount(); i++) {
            tabelaSolicitacoes.getColumnModel().getColumn(i).setCellRenderer(centralizar);
        }
    }
    
    private void mostrarInformações(int numLeito){
        for(Leito l : leitosDisponiveis){
            if(l.getNumero() == numLeito){
                switch (l.getTipoLeito()) {
                    case 0 -> {
                        tipoLeito.setText(TipoLeito.UM.getTipoLeito());
                    }
                    case 1 -> {
                        tipoLeito.setText(TipoLeito.DOIS.getTipoLeito());
                    }
                    case 2 -> {
                        tipoLeito.setText(TipoLeito.TRES.getTipoLeito());
                    }
                    case 3 -> {
                        tipoLeito.setText(TipoLeito.QUATRO.getTipoLeito());
                    }
                    case 4 -> {
                        tipoLeito.setText(TipoLeito.CINCO.getTipoLeito());
                    }
                    case 5 -> {
                        tipoLeito.setText(TipoLeito.SEIS.getTipoLeito());
                    }
                    case 6 -> {
                        tipoLeito.setText(TipoLeito.SETE.getTipoLeito());
                    }
                    case 7 -> {
                        tipoLeito.setText(TipoLeito.OITO.getTipoLeito());
                    }
                    case 8 -> {
                        tipoLeito.setText(TipoLeito.NOVE.getTipoLeito());
                    }
                    default -> throw new AssertionError();
                }
                valorLeito.setText("R$ " + l.getValor());
            }
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
        jMenuItem2 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaSolicitacoes = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nomePaciente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        nomeMedico = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tipoLeito = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        valorLeito = new javax.swing.JTextField();
        confirmar = new javax.swing.JButton();
        voltar = new javax.swing.JButton();
        listaLeitos = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        logout = new javax.swing.JMenuItem();
        sair = new javax.swing.JMenuItem();
        gerenciar = new javax.swing.JMenu();
        leitos = new javax.swing.JMenu();
        cadastrarLeito = new javax.swing.JMenuItem();
        visualizarLeitos = new javax.swing.JMenuItem();
        suprimentos = new javax.swing.JMenu();
        novoSuprimento = new javax.swing.JMenuItem();
        visualizarSuprimentos = new javax.swing.JMenuItem();
        internacoes = new javax.swing.JMenu();
        solicitacoesInternacao = new javax.swing.JMenuItem();
        internacoesAtuais = new javax.swing.JMenuItem();
        pacientes = new javax.swing.JMenu();
        cadastrarPaciente = new javax.swing.JMenuItem();
        visualizarPacientes = new javax.swing.JMenuItem();
        recursosHumanos = new javax.swing.JMenu();
        medicos = new javax.swing.JMenu();
        novoMedico = new javax.swing.JMenuItem();
        medicosCadastrados = new javax.swing.JMenuItem();
        enfermeiros = new javax.swing.JMenu();
        novoEnfermeiro = new javax.swing.JMenuItem();
        visualizarEnfermeiros = new javax.swing.JMenuItem();
        farmaceuticos = new javax.swing.JMenu();
        novoFarmaceutico = new javax.swing.JMenuItem();
        visualizarFarmaceuticos = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Solicitações de Internações");

        tabelaSolicitacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Paciente", "Médico Responsável", "Data de Solicitação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaSolicitacoes.getTableHeader().setReorderingAllowed(false);
        tabelaSolicitacoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaSolicitacoesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaSolicitacoes);
        if (tabelaSolicitacoes.getColumnModel().getColumnCount() > 0) {
            tabelaSolicitacoes.getColumnModel().getColumn(0).setResizable(false);
            tabelaSolicitacoes.getColumnModel().getColumn(1).setResizable(false);
            tabelaSolicitacoes.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel2.setText("Aprovar Internação");

        jLabel3.setText("Paciente:");

        jLabel4.setText("Médico Responsável:");

        jLabel5.setText("Leitos Disponíveis:");

        jLabel6.setText("Tipo:");

        jLabel7.setText("Valor:");

        confirmar.setText("Confirmar");
        confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarActionPerformed(evt);
            }
        });

        voltar.setText("Voltar");
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });

        listaLeitos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jMenu1.setText("Sair");

        logout.setText("Logout");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        jMenu1.add(logout);

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
        jMenu1.add(sair);

        jMenuBar1.add(jMenu1);

        gerenciar.setText("Gerenciamento Hospitalar");

        leitos.setText("Leitos");

        cadastrarLeito.setText("Cadastrar");
        cadastrarLeito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarLeitoActionPerformed(evt);
            }
        });
        leitos.add(cadastrarLeito);

        visualizarLeitos.setText("Visualizar Leitos");
        visualizarLeitos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizarLeitosActionPerformed(evt);
            }
        });
        leitos.add(visualizarLeitos);

        gerenciar.add(leitos);

        suprimentos.setText("Suprimentos");

        novoSuprimento.setText("Novo Suprimento");
        novoSuprimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoSuprimentoActionPerformed(evt);
            }
        });
        suprimentos.add(novoSuprimento);

        visualizarSuprimentos.setText("Visualizar Suprimentos");
        visualizarSuprimentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizarSuprimentosActionPerformed(evt);
            }
        });
        suprimentos.add(visualizarSuprimentos);

        gerenciar.add(suprimentos);

        internacoes.setText("Internações");

        solicitacoesInternacao.setText("Solicitações em Aguardo");
        solicitacoesInternacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solicitacoesInternacaoActionPerformed(evt);
            }
        });
        internacoes.add(solicitacoesInternacao);

        internacoesAtuais.setText("Internações Atuais");
        internacoesAtuais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                internacoesAtuaisActionPerformed(evt);
            }
        });
        internacoes.add(internacoesAtuais);

        gerenciar.add(internacoes);

        pacientes.setText("Pacientes");

        cadastrarPaciente.setText("Cadastrar Paciente");
        cadastrarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarPacienteActionPerformed(evt);
            }
        });
        pacientes.add(cadastrarPaciente);

        visualizarPacientes.setText("Visualizar Pacientes");
        visualizarPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizarPacientesActionPerformed(evt);
            }
        });
        pacientes.add(visualizarPacientes);

        gerenciar.add(pacientes);

        jMenuBar1.add(gerenciar);

        recursosHumanos.setText("Recursos Humanos");

        medicos.setText("Médicos");

        novoMedico.setText("Novo Médico");
        novoMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoMedicoActionPerformed(evt);
            }
        });
        medicos.add(novoMedico);

        medicosCadastrados.setText("Médicos Cadastrados");
        medicosCadastrados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medicosCadastradosActionPerformed(evt);
            }
        });
        medicos.add(medicosCadastrados);

        recursosHumanos.add(medicos);

        enfermeiros.setText("Enfermeiros");

        novoEnfermeiro.setText("Novo Enfermeiro");
        novoEnfermeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoEnfermeiroActionPerformed(evt);
            }
        });
        enfermeiros.add(novoEnfermeiro);

        visualizarEnfermeiros.setText("Visualizar Enfermeiros");
        visualizarEnfermeiros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizarEnfermeirosActionPerformed(evt);
            }
        });
        enfermeiros.add(visualizarEnfermeiros);

        recursosHumanos.add(enfermeiros);

        farmaceuticos.setText("Farmacêuticos");

        novoFarmaceutico.setText("Novo Farmacêutico");
        novoFarmaceutico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoFarmaceuticoActionPerformed(evt);
            }
        });
        farmaceuticos.add(novoFarmaceutico);

        visualizarFarmaceuticos.setText("Visualizar Farmacêuticos");
        visualizarFarmaceuticos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizarFarmaceuticosActionPerformed(evt);
            }
        });
        farmaceuticos.add(visualizarFarmaceuticos);

        recursosHumanos.add(farmaceuticos);

        jMenuBar1.add(recursosHumanos);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomePaciente))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomeMedico))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(listaLeitos, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tipoLeito, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(confirmar, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(valorLeito))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nomeMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(tipoLeito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(valorLeito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listaLeitos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmar)
                    .addComponent(voltar))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        // TODO add your handling code here:
        new TelaInicialAdministrador(adm).setVisible(true);
        dispose();
    }//GEN-LAST:event_voltarActionPerformed

    private void tabelaSolicitacoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaSolicitacoesMouseClicked
        // TODO add your handling code here:
        int linha = tabelaSolicitacoes.getSelectedRow();
        
        String paciente = String.valueOf(tabelaSolicitacoes.getValueAt(linha, 0));
        String medico = String.valueOf(tabelaSolicitacoes.getValueAt(linha, 1));
        
        System.out.println("Paciente -> " + paciente);
        System.out.println("Médico -> " + medico);
        
        nomePaciente.setText(paciente);
        nomeMedico.setText(medico);
    }//GEN-LAST:event_tabelaSolicitacoesMouseClicked

    private void confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarActionPerformed
        // TODO add your handling code here:
        
        System.out.println("\nConfirmação de Internação");
        
        //Pega as informações do Paciente - localizar pelo nome
        Paciente paciente = controlePaciente.buscaPacientePorNome(nomePaciente.getText());
        System.out.println("Paciente -> " + paciente);
        //Pega as informações do Médico - localizar pelo nome
        ProfissionalSaude profissional = controleProfissional.buscaProfissionalPorNome(nomeMedico.getText());
        System.out.println("Médico -> " + profissional);
        //Pega as informações do prontuário - localizar pelo idPaciente
        ProntuarioMedico prontuario = controleProntuario.buscaProntuarioPorIDPaciente(paciente.getId());
        System.out.println("Prontuário -> " + prontuario);
        //Pega as informações da Internação - localizar pelo idMedico, idProntuario, aguardandoAprovacao = true e statusAlta = false
        Internacao internacao = new Internacao();
        for(Internacao i : solicitacoes){
            if(i.getIdProntuario() == prontuario.getId()){
                internacao = i;
                System.out.println("Internação -> " + internacao);
            }
        }
        //Pegar as informações do Leito - usar o número do leito do JComboBox
        int leitoSelecionado = listaLeitos.getSelectedIndex();
        int numLeito = Integer.parseInt(listaLeitos.getItemAt(leitoSelecionado));
        Leito leito = controleLeito.buscaLeitoPorNumero(numLeito);
        System.out.println("Leito Selecionado -> " + leito);
        
        //Atualizar Internação - colocar Leito e alterar aguardandoAprovação para false
        internacao.setIdLeito(leito.getId());
        internacao.setAguardandoAprovacao(false);
        System.out.println("Internação Atualizada -> " + internacao);
        boolean confirmacao = controleInternacao.confirmaInternacao(internacao);
        
        if(confirmacao){
            /*Atualizar Leito - verificar quantidades de internados com a capacidade,
            caso seja igual, mudar o status para 3,
            se for menor, acrescentar a quantidade de internados,
            caso o leito seja somente para 1 pessoa, mudar o status para 3 e a quantidade de internados*/
            
            int internados = leito.getInternados() + 1;
            if(leito.getCapacidade() == internados){
                leito.setInternados(internados);
                leito.setStatus(3);
            } else {
                leito.setInternados(internados);
            }
            
            System.out.println("Leito Atualizado -> " + leito);
            
            confirmacao = controleLeito.atualizarLeito(leito);
            
            if(confirmacao){
                /*Atualizar Prontuário - atualizar a dataAtualização e serviço para ServicoProntuario.QUATRO*/
                prontuario.setDataAtualizacao(dataConvertida);
                prontuario.setServico(ServicoProntuario.QUATRO.getServico());
                
                System.out.println("Prontuário Atualizado -> " + prontuario);
                
                confirmacao = controleProntuario.atualizacaoPronturario(prontuario);
                
                if(confirmacao){
                    JOptionPane.showMessageDialog(null, "Internação confirmada.");
                    atualizaTabela();
                    centralizarTextos();
                    desativaEdicaoCampos();
                    preencheListaLeitos();
                } else {
                    JOptionPane.showMessageDialog(null, "Ops! Algo deu errado ao alterar Prontuário!");
                }
                
            } else {
                JOptionPane.showMessageDialog(null, "Ops! Algo deu errado ao alterar Leito!");
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Ops! Algo deu ao confirmar Internação!");
        }
        
        
/*
UM("DISPONÍVEL") -> status = 0,
DOIS("INDISPONÍVEL") -> status = 1,
TRES("EM MANUTENÇÃO") -> status = 2,
QUATRO("COM PACIENTE") -> status = 3;
*/
    }//GEN-LAST:event_confirmarActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        new TelaInicial().setVisible(true);
        dispose();
    }//GEN-LAST:event_logoutActionPerformed

    private void sairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sairMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_sairMouseClicked

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_sairActionPerformed

    private void cadastrarLeitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarLeitoActionPerformed
        // TODO add your handling code here:
        new TelaCadastroLeito(adm).setVisible(true);
        dispose();
    }//GEN-LAST:event_cadastrarLeitoActionPerformed

    private void visualizarLeitosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizarLeitosActionPerformed
        // TODO add your handling code here:
        new TelaLeitosCadastrados(adm).setVisible(true);
        dispose();
    }//GEN-LAST:event_visualizarLeitosActionPerformed

    private void novoSuprimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoSuprimentoActionPerformed
        // TODO add your handling code here:
        new TelaCadastroSuprimento(adm).setVisible(true);
        dispose();
    }//GEN-LAST:event_novoSuprimentoActionPerformed

    private void visualizarSuprimentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizarSuprimentosActionPerformed
        // TODO add your handling code here:
        new TelaSuprimentosCadastrados(adm).setVisible(true);
        dispose();
    }//GEN-LAST:event_visualizarSuprimentosActionPerformed

    private void solicitacoesInternacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solicitacoesInternacaoActionPerformed
        // TODO add your handling code here:
        new TelaSolicitacoesInternacoes(adm).setVisible(true);
        dispose();
    }//GEN-LAST:event_solicitacoesInternacaoActionPerformed

    private void internacoesAtuaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_internacoesAtuaisActionPerformed
        // TODO add your handling code here:
        new TelaInternacoesAtuais(adm).setVisible(true);
        dispose();
    }//GEN-LAST:event_internacoesAtuaisActionPerformed

    private void cadastrarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarPacienteActionPerformed
        // TODO add your handling code here:
        new TelaCadastrarPaciente(adm).setVisible(true);
        dispose();
    }//GEN-LAST:event_cadastrarPacienteActionPerformed

    private void visualizarPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizarPacientesActionPerformed
        // TODO add your handling code here:
        new TelaPacientesCadastrados(adm).setVisible(true);
        dispose();
    }//GEN-LAST:event_visualizarPacientesActionPerformed

    private void novoMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoMedicoActionPerformed
        // TODO add your handling code here:
        new TelaCadastrarMedico(adm).setVisible(true);
        dispose();
    }//GEN-LAST:event_novoMedicoActionPerformed

    private void medicosCadastradosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medicosCadastradosActionPerformed
        // TODO add your handling code here:
        new TelaMedicosCadastrados(adm).setVisible(true);
        dispose();
    }//GEN-LAST:event_medicosCadastradosActionPerformed

    private void novoEnfermeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoEnfermeiroActionPerformed
        // TODO add your handling code here:
        new TelaCadastrarEnfermeiro(adm).setVisible(true);
        dispose();
    }//GEN-LAST:event_novoEnfermeiroActionPerformed

    private void visualizarEnfermeirosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizarEnfermeirosActionPerformed
        // TODO add your handling code here:
        new TelaEnfermeirosCadastrados(adm).setVisible(true);
        dispose();
    }//GEN-LAST:event_visualizarEnfermeirosActionPerformed

    private void novoFarmaceuticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoFarmaceuticoActionPerformed
        // TODO add your handling code here:
        new TelaCadastrarFarmaceutico(adm).setVisible(true);
        dispose();
    }//GEN-LAST:event_novoFarmaceuticoActionPerformed

    private void visualizarFarmaceuticosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizarFarmaceuticosActionPerformed
        // TODO add your handling code here:
        new TelaFarmaceuticosCadastrados(adm).setVisible(true);
        dispose();
    }//GEN-LAST:event_visualizarFarmaceuticosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem cadastrarLeito;
    private javax.swing.JMenuItem cadastrarPaciente;
    private javax.swing.JButton confirmar;
    private javax.swing.JMenu enfermeiros;
    private javax.swing.JMenu farmaceuticos;
    private javax.swing.JMenu gerenciar;
    private javax.swing.JMenu internacoes;
    private javax.swing.JMenuItem internacoesAtuais;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JMenu leitos;
    private javax.swing.JComboBox<String> listaLeitos;
    private javax.swing.JMenuItem logout;
    private javax.swing.JMenu medicos;
    private javax.swing.JMenuItem medicosCadastrados;
    private javax.swing.JTextField nomeMedico;
    private javax.swing.JTextField nomePaciente;
    private javax.swing.JMenuItem novoEnfermeiro;
    private javax.swing.JMenuItem novoFarmaceutico;
    private javax.swing.JMenuItem novoMedico;
    private javax.swing.JMenuItem novoSuprimento;
    private javax.swing.JMenu pacientes;
    private javax.swing.JMenu recursosHumanos;
    private javax.swing.JMenuItem sair;
    private javax.swing.JMenuItem solicitacoesInternacao;
    private javax.swing.JMenu suprimentos;
    private javax.swing.JTable tabelaSolicitacoes;
    private javax.swing.JTextField tipoLeito;
    private javax.swing.JTextField valorLeito;
    private javax.swing.JMenuItem visualizarEnfermeiros;
    private javax.swing.JMenuItem visualizarFarmaceuticos;
    private javax.swing.JMenuItem visualizarLeitos;
    private javax.swing.JMenuItem visualizarPacientes;
    private javax.swing.JMenuItem visualizarSuprimentos;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
