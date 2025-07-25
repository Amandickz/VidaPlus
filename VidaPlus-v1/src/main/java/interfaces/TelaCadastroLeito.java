/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

import classes.Administracao;
import classes.Leito;
import controles.ControleLeito;
import enums.DisponibilidadeLeito;
import enums.TipoLeito;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Amanda
 */
public class TelaCadastroLeito extends javax.swing.JFrame {
    /**
     * Creates new form TelaInicialAdministrador
     */
    
    Administracao adm;
    DefaultTableModel tabelaLeito;
    ControleLeito controleLeito = new ControleLeito();
    
    public TelaCadastroLeito(Administracao adm){
        initComponents();
        this.setLocationRelativeTo(null);
        this.adm = adm;
        
        this.tabelaLeito = (DefaultTableModel) leitosCadastrados.getModel();
        
        desativarLimparCampos();
        preencheTipoLeito();
        preencheTipoDisponibilidade();
        preencheTabela();
        centralizarTextos();
    }
    
    private void preencheTipoLeito(){
        listaTipoLeito.removeAllItems();
        for(TipoLeito l : TipoLeito.values()){
            listaTipoLeito.addItem(l.getTipoLeito());
        }
    }
    
    private void preencheTipoDisponibilidade(){
        listaDisponibilidade.removeAllItems();
        for(DisponibilidadeLeito d : DisponibilidadeLeito.values()){
            listaDisponibilidade.addItem(d.getDisponibilidadeLeito());
        }
    }
    
    private void preencheTabela(){
        String tipoLeito;
        tabelaLeito.setRowCount(0);
        ArrayList<Leito> todosLeitos = controleLeito.recuperaLeitos(adm.getId());
        if(todosLeitos != null){
            for(Leito l : todosLeitos){
                switch (l.getTipoLeito()) {
                    case 0 -> {
                        tipoLeito = TipoLeito.UM.getTipoLeito();
                    }
                    case 1 -> {
                        tipoLeito = TipoLeito.DOIS.getTipoLeito();
                    }
                    case 2 -> {
                        tipoLeito = TipoLeito.TRES.getTipoLeito();
                    }
                    case 3 -> {
                        tipoLeito = TipoLeito.QUATRO.getTipoLeito();
                    }
                    case 4 -> {
                        tipoLeito = TipoLeito.CINCO.getTipoLeito();
                    }
                    case 5 -> {
                        tipoLeito = TipoLeito.SEIS.getTipoLeito();
                    }
                    case 6 -> {
                        tipoLeito = TipoLeito.SETE.getTipoLeito();
                    }
                    case 7 -> {
                        tipoLeito = TipoLeito.OITO.getTipoLeito();
                    }
                    case 8 -> {
                        tipoLeito = TipoLeito.NOVE.getTipoLeito();
                    }
                    default -> tipoLeito = "OUTROS";
                }
                
                if(l.getStatus() == 0){
                    tabelaLeito.addRow(new Object[]{
                        l.getNumero(),
                        tipoLeito,
                        "R$ " + l.getValor(),
                        l.getCapacidade(),
                        "Disponível"});
                } else {
                    tabelaLeito.addRow(new Object[]{
                        l.getNumero(),
                        tipoLeito,
                        "R$ " + l.getValor(),
                        l.getCapacidade(),
                        "Indisponível"});
                }
            }
        }
    }
    
    private void centralizarTextos(){
        DefaultTableCellRenderer centralizar = new DefaultTableCellRenderer();
        centralizar.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < leitosCadastrados.getColumnCount(); i++) {
            leitosCadastrados.getColumnModel().getColumn(i).setCellRenderer(centralizar);
        }
    }
    
    private void desativarLimparCampos(){
        numeroLeito.setText("");
        preencheTipoLeito();
        listaTipoLeito.setEnabled(false);
        capacidadeQuarto.setText("");
        capacidadeQuarto.setEnabled(false);
        valorLeito.setText("");
        valorLeito.setEnabled(false);
        preencheTipoDisponibilidade();
        listaDisponibilidade.setEnabled(false);
        buscar.setEnabled(true);
    }
    
    private void ativaCamposCadastro(){
        listaTipoLeito.setEnabled(true);
        capacidadeQuarto.setText("");
        capacidadeQuarto.setEnabled(true);
        valorLeito.setText("");
        valorLeito.setEnabled(true);
        listaDisponibilidade.setEnabled(true);
    }
    
    private void mostrarInformacoes(Leito leito){
        listaTipoLeito.setEnabled(true);
        preencheTipoLeito();
        listaTipoLeito.setSelectedIndex(leito.getTipoLeito());
        listaTipoLeito.setEditable(false);
        capacidadeQuarto.setEnabled(true);
        capacidadeQuarto.setEditable(false);
        capacidadeQuarto.setText("" + leito.getCapacidade());
        valorLeito.setEnabled(true);
        valorLeito.setEditable(false);
        valorLeito.setText("" + leito.getValor());
        preencheTipoDisponibilidade();
        listaDisponibilidade.setEnabled(true);
        listaDisponibilidade.setSelectedIndex(leito.getStatus());
        listaDisponibilidade.setEditable(false);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        leitosCadastrados = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        numeroLeito = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        listaTipoLeito = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        valorLeito = new javax.swing.JFormattedTextField();
        jSeparator1 = new javax.swing.JSeparator();
        voltar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        listaDisponibilidade = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        capacidadeQuarto = new javax.swing.JTextField();
        cadastrar = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastrar Leito");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Cadastro de Leitos");

        leitosCadastrados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Leito", "Tipo de Leito", "Valor", "Capacidade", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(leitosCadastrados);

        jLabel2.setText("Número do Leito:");

        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        jLabel3.setText("Tipo:");

        listaTipoLeito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Valor:");

        voltar.setText("Voltar");
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });

        jLabel5.setText("Disponibilidade:");

        listaDisponibilidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("Capacidade do Quarto:");

        cadastrar.setText("Cadastrar");
        cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarActionPerformed(evt);
            }
        });

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numeroLeito)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscar))
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(listaTipoLeito, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(capacidadeQuarto))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(valorLeito, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(listaDisponibilidade, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 525, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(voltar)
                        .addGap(381, 381, 381))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cadastrar)
                        .addGap(378, 378, 378))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(numeroLeito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(listaTipoLeito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(capacidadeQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(valorLeito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(listaDisponibilidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(cadastrar)
                .addGap(30, 30, 30)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(voltar)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        // TODO add your handling code here:
        new TelaInicialAdministrador(adm).setVisible(true);
        dispose();
    }//GEN-LAST:event_voltarActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        // TODO add your handling code here:
        int numero = Integer.parseInt(numeroLeito.getText());
        
        if(controleLeito.recuperaLeitos(adm.getId()) == null){
            ativaCamposCadastro();
        } else {
            Leito leito = controleLeito.buscaLeitoPorNumero(numero);
            if(leito == null){
                ativaCamposCadastro();
            } else {
                JOptionPane.showMessageDialog(null, "Leito localizado!\nMostrando as informações.");
                mostrarInformacoes(leito);
            }
        }
    }//GEN-LAST:event_buscarActionPerformed

    private void cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarActionPerformed
        // TODO add your handling code here:

        //Pega Informações do Leito
        int tipoLeito = listaTipoLeito.getSelectedIndex();
        int numero = Integer.parseInt(numeroLeito.getText());
        Double valor = Double.valueOf(valorLeito.getText());
        int status = listaDisponibilidade.getSelectedIndex();
        int capacidade = Integer.parseInt(capacidadeQuarto.getText());
        
        //Cria Objeto Leito
        Leito leito = new Leito(adm.getId(), tipoLeito, numero, valor, status, capacidade, 0);
        
        //Solicita cadastro
        boolean confirmacao = controleLeito.cadastrarLeito(leito);
        
        if(confirmacao){
            JOptionPane.showMessageDialog(null, "Leito Cadastrado com sucesso!");
            preencheTabela();
            desativarLimparCampos();
        } else {
            JOptionPane.showMessageDialog(null, "Ops! Algo deu errado.");
        }
        
        
    }//GEN-LAST:event_cadastrarActionPerformed

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
    private javax.swing.JButton buscar;
    private javax.swing.JButton cadastrar;
    private javax.swing.JMenuItem cadastrarLeito;
    private javax.swing.JMenuItem cadastrarPaciente;
    private javax.swing.JTextField capacidadeQuarto;
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JMenu leitos;
    private javax.swing.JTable leitosCadastrados;
    private javax.swing.JComboBox<String> listaDisponibilidade;
    private javax.swing.JComboBox<String> listaTipoLeito;
    private javax.swing.JMenuItem logout;
    private javax.swing.JMenu medicos;
    private javax.swing.JMenuItem medicosCadastrados;
    private javax.swing.JMenuItem novoEnfermeiro;
    private javax.swing.JMenuItem novoFarmaceutico;
    private javax.swing.JMenuItem novoMedico;
    private javax.swing.JMenuItem novoSuprimento;
    private javax.swing.JTextField numeroLeito;
    private javax.swing.JMenu pacientes;
    private javax.swing.JMenu recursosHumanos;
    private javax.swing.JMenuItem sair;
    private javax.swing.JMenuItem solicitacoesInternacao;
    private javax.swing.JMenu suprimentos;
    private javax.swing.JFormattedTextField valorLeito;
    private javax.swing.JMenuItem visualizarEnfermeiros;
    private javax.swing.JMenuItem visualizarFarmaceuticos;
    private javax.swing.JMenuItem visualizarLeitos;
    private javax.swing.JMenuItem visualizarPacientes;
    private javax.swing.JMenuItem visualizarSuprimentos;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
