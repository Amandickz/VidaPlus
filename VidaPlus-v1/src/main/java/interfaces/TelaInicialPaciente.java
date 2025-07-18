/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

import classes.Agenda;
import classes.Paciente;
import classes.ProfissionalSaude;
import controles.ControlePaciente;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Amanda
 */
public class TelaInicialPaciente extends javax.swing.JFrame {

    String dataConvertida;
    Paciente paciente;
    DefaultTableModel consultas;
    ControlePaciente controlePaciente = new ControlePaciente();
    
    /**
     * Creates new form TelaInicialAdministrador
     */
    public TelaInicialPaciente(Paciente paciente){
        initComponents();
        this.setLocationRelativeTo(null);
        this.paciente = paciente;
        LocalDate hoje = LocalDate.now();
        DateTimeFormatter formataData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        dataConvertida = hoje.format(formataData);
        String primeiroNome[] = this.paciente.getNome().split(" ");
        this.nomePaciente.setText("Seja Bem-vindo(a) " + primeiroNome[0]);
        this.dataAtual.setText("Data: " + dataConvertida);
        
        consultasProximasLabel.setVisible(false);
        
        consultas = (DefaultTableModel) consultasMarcadas.getModel();
        consultasMarcadas();
    }
    
    private void consultasMarcadas(){
        consultas.setRowCount(0);
        ArrayList<Agenda> agenda = controlePaciente.proximasConsultas(paciente.getId(), dataConvertida);
        if(agenda != null){
            for(Agenda a : agenda){
                ProfissionalSaude profissional = controlePaciente.buscaProfissional(a.getIdMedico());
                consultas.addRow(new Object[]{a.getData(),
                a.getHora(),profissional.getNome()});
                
                if(a.getData().equals(dataConvertida)){
                    consultasProximasLabel.setVisible(true);
                }
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
        nomePaciente = new javax.swing.JLabel();
        dataAtual = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        consultasMarcadas = new javax.swing.JTable();
        consultasProximasLabel = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        sair = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        marcarConsulta = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nomePaciente.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        nomePaciente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nomePaciente.setText("Label Bem Vindo");

        dataAtual.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dataAtual.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dataAtual.setText("Label da Data Atual");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Próximas Consultas");

        consultasMarcadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Hora", "Médico"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        consultasMarcadas.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(consultasMarcadas);
        if (consultasMarcadas.getColumnModel().getColumnCount() > 0) {
            consultasMarcadas.getColumnModel().getColumn(0).setResizable(false);
            consultasMarcadas.getColumnModel().getColumn(0).setPreferredWidth(5);
            consultasMarcadas.getColumnModel().getColumn(1).setResizable(false);
            consultasMarcadas.getColumnModel().getColumn(1).setPreferredWidth(5);
            consultasMarcadas.getColumnModel().getColumn(2).setResizable(false);
        }

        consultasProximasLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        consultasProximasLabel.setForeground(new java.awt.Color(204, 0, 51));
        consultasProximasLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        consultasProximasLabel.setText("Há consultas próximas!");

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

        jMenu1.setText("Consultas");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        marcarConsulta.setText("Marcar Consulta");
        marcarConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marcarConsultaActionPerformed(evt);
            }
        });
        jMenu1.add(marcarConsulta);

        jMenuBar2.add(jMenu1);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(dataAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(consultasProximasLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(nomePaciente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataAtual)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(consultasProximasLabel))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_sairActionPerformed

    private void sairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sairMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_sairMouseClicked

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void marcarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marcarConsultaActionPerformed
        // TODO add your handling code here:
        new TelaMarcarConsulta(paciente).setVisible(true);
        dispose();
    }//GEN-LAST:event_marcarConsultaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable consultasMarcadas;
    private javax.swing.JLabel consultasProximasLabel;
    private javax.swing.JLabel dataAtual;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JMenuItem marcarConsulta;
    private javax.swing.JLabel nomePaciente;
    private javax.swing.JMenu sair;
    // End of variables declaration//GEN-END:variables
}
