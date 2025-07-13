/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

import classes.Enfermeiro;
import classes.Internacao;
import classes.Leito;
import classes.Paciente;
import classes.PrescricaoInternacao;
import classes.ProfissionalSaude;
import classes.ProntuarioMedico;
import controles.ControleInternacao;
import controles.ControleLeito;
import controles.ControlePaciente;
import controles.ControlePrescricao;
import controles.ControleProfissional;
import controles.ControleProntuario;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Amanda
 */
public class TelaInicialEnfermeiro extends javax.swing.JFrame {

    String dataConvertida, horaFormatada;
    Enfermeiro enfermeiro;
    DefaultTableModel aRealizar, pacientesInternados;
    ControlePrescricao controlePrescricao = new ControlePrescricao();
    ControleInternacao controleInternacao = new ControleInternacao();
    ControleLeito controleLeito = new ControleLeito();
    ControleProfissional controleProfissional = new ControleProfissional();
    ControleProntuario controleProntuario = new ControleProntuario();
    ControlePaciente controlePaciente = new ControlePaciente();
    
    /**
     * Creates new form TelaInicialAdministrador
     */
    public TelaInicialEnfermeiro(Enfermeiro enfermeiro){
        initComponents();
        this.setLocationRelativeTo(null);
        this.enfermeiro = enfermeiro;
        LocalDate hoje = LocalDate.now();
        LocalTime hora = LocalTime.now();
        DateTimeFormatter formataData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        dataConvertida = hoje.format(formataData);
        horaFormatada = hora.getHour() + ":" + hora.getMinute();
        this.nomeEnfermeiro.setText("Seja Bem-vindo, " + this.enfermeiro.getNome());
        this.dataHoraAtual.setText("Data: " + dataConvertida + " | Hora: " + horaFormatada);
        
        aRealizar = (DefaultTableModel) procedimentosRealizar.getModel();
        pacientesInternados = (DefaultTableModel) procedimentosRealizados.getModel();
        
        preencheASerRealizados();
        centralizarTextosProcedimentos();
        
        /*preencheConsultasdoDia();
        preencheListaInternados();
        centralizarTextosConsultas();
        centralizarTextosInternados();*/
    }
    
    private void preencheASerRealizados(){
        aRealizar.setRowCount(0);
        ArrayList<PrescricaoInternacao> prescricoes = controlePrescricao.retornaPrescricoesPendentes();
        if(prescricoes != null){
            for(PrescricaoInternacao p : prescricoes){
                //Buscar Internação
                Internacao internacao = controleInternacao.retornaInternacaoPorID(p.getIdInternacao());
                //Buscar Leito
                Leito leito = controleLeito.buscaLeitoPorID(internacao.getIdLeito());
                //Busca Médico
                ProfissionalSaude profissional = controleProfissional.buscaProfissionalPorID(internacao.getIdMedico());
                //Buscar Prontuario
                ProntuarioMedico prontuario = controleProntuario.buscaProntuarioPorID(internacao.getIdProntuario());
                //Buscar Paciente
                Paciente paciente = controlePaciente.buscaPacientePorID(prontuario.getIdPaciente());
                
                //Preenche tabela - Leito/Paciente/Médico/Status
                aRealizar.addRow(new Object[]{
                    leito.getNumero(),
                    paciente.getNome(),
                    profissional.getNome(),
                    prontuario.getServico()
                });
                
            }
        }
    }
    
    private void centralizarTextosProcedimentos(){
        DefaultTableCellRenderer centralizar = new DefaultTableCellRenderer();
        centralizar.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < procedimentosRealizar.getColumnCount(); i++) {
            procedimentosRealizar.getColumnModel().getColumn(i).setCellRenderer(centralizar);
        }
    }
    
    /*private void preencheConsultasdoDia(){
        consultasDoDia.setRowCount(0);
        ArrayList<Agenda> agendaDoDia = controleMedico.consultasDoDia(dataConvertida, medico);
        if(agendaDoDia != null){
            for(Agenda a : agendaDoDia){
                Paciente paciente = controleMedico.buscaPacientePorID(a.getIdPaciente());
                consultasDoDia.addRow(new Object[]{a.getHora(),paciente.getNome()});
            }
        }
    }
    
    private void preencheListaInternados(){
        pacientesInternados.setRowCount(0);
        ArrayList<Internacao> internacoes = controleInternacao.retornaInternacoesAtivasPorMedico(medico.getId());
        if(internacoes != null){
            for(Internacao i : internacoes){
                ProntuarioMedico prontuario = controleProntuario.buscaProntuarioPorID(i.getIdProntuario());
                Leito leito = controleLeito.buscaLeitoPorID(i.getIdLeito());
                Paciente paciente = controlePaciente.buscaPacientePorID(prontuario.getIdPaciente());
                
                pacientesInternados.addRow(new Object[]{
                    leito.getNumero(),
                    paciente.getNome()
                });
            }
        }
    }
    
    private void centralizarTextosInternados(){
        DefaultTableCellRenderer centralizar = new DefaultTableCellRenderer();
        centralizar.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < procedimentosRealizados.getColumnCount(); i++) {
            procedimentosRealizados.getColumnModel().getColumn(i).setCellRenderer(centralizar);
        }
    }*/

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        nomeEnfermeiro = new javax.swing.JLabel();
        dataHoraAtual = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        procedimentosRealizar = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        procedimentosRealizados = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        logout = new javax.swing.JMenuItem();
        sair = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nomeEnfermeiro.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        nomeEnfermeiro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nomeEnfermeiro.setText("Label Bem Vindo");

        dataHoraAtual.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dataHoraAtual.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dataHoraAtual.setText("Label da Data e Hora Atual");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Procedimento a serem Realizados");

        procedimentosRealizar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Leito", "Paciente", "Médico", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        procedimentosRealizar.getTableHeader().setReorderingAllowed(false);
        procedimentosRealizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                procedimentosRealizarMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(procedimentosRealizar);
        if (procedimentosRealizar.getColumnModel().getColumnCount() > 0) {
            procedimentosRealizar.getColumnModel().getColumn(0).setResizable(false);
            procedimentosRealizar.getColumnModel().getColumn(1).setResizable(false);
            procedimentosRealizar.getColumnModel().getColumn(1).setPreferredWidth(200);
            procedimentosRealizar.getColumnModel().getColumn(2).setResizable(false);
            procedimentosRealizar.getColumnModel().getColumn(2).setPreferredWidth(200);
            procedimentosRealizar.getColumnModel().getColumn(3).setResizable(false);
        }

        procedimentosRealizados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Leito", "Paciente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        procedimentosRealizados.getTableHeader().setReorderingAllowed(false);
        procedimentosRealizados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                procedimentosRealizadosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(procedimentosRealizados);
        if (procedimentosRealizados.getColumnModel().getColumnCount() > 0) {
            procedimentosRealizados.getColumnModel().getColumn(0).setResizable(false);
            procedimentosRealizados.getColumnModel().getColumn(1).setResizable(false);
            procedimentosRealizados.getColumnModel().getColumn(1).setPreferredWidth(245);
        }

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Procedimentos Realizados");

        jButton1.setText("Solicitar Suprimentos");

        jMenu3.setText("Sair");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });

        logout.setText("Logout");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        jMenu3.add(logout);

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
        jMenu3.add(sair);

        jMenuBar2.add(jMenu3);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(304, 304, 304)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dataHoraAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 402, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nomeEnfermeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 729, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSeparator2)
                                .addComponent(jScrollPane2)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 729, Short.MAX_VALUE)
                                .addComponent(jScrollPane3)))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(nomeEnfermeiro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataHoraAtual)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu3ActionPerformed

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu3MouseClicked

    private void procedimentosRealizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_procedimentosRealizarMouseClicked
        // TODO add your handling code here:
        /*int linha = procedimentosRealizar.getSelectedRow();
        
        hora = String.valueOf(procedimentosRealizar.getValueAt(linha, 0));
        nomePaciente = String.valueOf(procedimentosRealizar.getValueAt(linha, 1));
        
        System.out.println(hora + " -> " + nomePaciente);*/
    }//GEN-LAST:event_procedimentosRealizarMouseClicked

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_sairActionPerformed

    private void sairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sairMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_sairMouseClicked

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        new TelaInicial().setVisible(true);
        dispose();
    }//GEN-LAST:event_logoutActionPerformed

    private void procedimentosRealizadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_procedimentosRealizadosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_procedimentosRealizadosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dataHoraAtual;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JMenuItem logout;
    private javax.swing.JLabel nomeEnfermeiro;
    private javax.swing.JTable procedimentosRealizados;
    private javax.swing.JTable procedimentosRealizar;
    private javax.swing.JMenuItem sair;
    // End of variables declaration//GEN-END:variables
}
