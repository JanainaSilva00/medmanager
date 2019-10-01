
package medmanager;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Binding;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

/**
 *
 *  Autor: William Chapuis Marciano '-'
 *  
 */
public class GerenciarPaciente extends javax.swing.JInternalFrame {

    private List<Paciente> lstPaciente;
    
    /**
     * Creates new form GerenciarPaciente
     */
    public GerenciarPaciente() {
        
        lstPaciente = new ArrayList<>();
        lstPaciente = ObservableCollections.observableList(lstPaciente);
        
        initComponents();
        
        BindingGroup bg = new BindingGroup();
        JTableBinding tb = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE,
                lstPaciente, tbPaciente);
        JTableBinding.ColumnBinding cb = tb.addColumnBinding(BeanProperty.create("nome"));
        cb.setColumnName("Nome");
        cb = tb.addColumnBinding(BeanProperty.create("cpf"));
        cb.setColumnName("CPF");
        
        bg.addBinding(tb);
        
        Binding b = Bindings.createAutoBinding(
                AutoBinding.UpdateStrategy.READ_WRITE,
                tbPaciente, BeanProperty.create("selectedElement.nome"),
                txtNomePaciente, BeanProperty.create("text"));
        bg.addBinding(b);
        
        b = Bindings.createAutoBinding(
                AutoBinding.UpdateStrategy.READ_WRITE,
                tbPaciente, BeanProperty.create("selectedElement.cpf"),
                txtCPFPaciente, BeanProperty.create("text"));
        bg.addBinding(b);
        
        bg.bind();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbInfPaciente = new javax.swing.JLabel();
        lbNomePaciente = new javax.swing.JLabel();
        lbCPF = new javax.swing.JLabel();
        txtNomePaciente = new javax.swing.JTextField();
        txtCPFPaciente = new javax.swing.JTextField();
        btExcPaciente = new javax.swing.JButton();
        btAdcPaciente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPaciente = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        lbInfPaciente.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbInfPaciente.setText("Informações do Paciente");

        lbNomePaciente.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbNomePaciente.setText("Nome");

        lbCPF.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbCPF.setText("CPF");

        txtNomePaciente.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtNomePaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomePacienteActionPerformed(evt);
            }
        });

        txtCPFPaciente.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        btExcPaciente.setBackground(new java.awt.Color(255, 102, 102));
        btExcPaciente.setText("Excluir");
        btExcPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcPacienteActionPerformed(evt);
            }
        });

        btAdcPaciente.setBackground(new java.awt.Color(102, 255, 102));
        btAdcPaciente.setText("Adicionar");
        btAdcPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdcPacienteActionPerformed(evt);
            }
        });

        tbPaciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nome", "CPF"
            }
        ));
        jScrollPane1.setViewportView(tbPaciente);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btExcPaciente)
                        .addGap(18, 18, 18)
                        .addComponent(btAdcPaciente))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbNomePaciente)
                                    .addComponent(lbCPF))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNomePaciente)
                                    .addComponent(txtCPFPaciente))))))
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 124, Short.MAX_VALUE)
                .addComponent(lbInfPaciente)
                .addGap(125, 125, 125))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbInfPaciente)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNomePaciente)
                    .addComponent(txtNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCPF)
                    .addComponent(txtCPFPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btExcPaciente)
                    .addComponent(btAdcPaciente))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomePacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomePacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomePacienteActionPerformed

    private void btExcPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcPacienteActionPerformed
        
        int v[] = tbPaciente.getSelectedRows();
        
        List<Paciente> c = new LinkedList<>();
        
        for(int i=0; i<v.length; i++)
        {
            int idxTb = v[i];
            int idxList = tbPaciente.convertRowIndexToModel(idxTb);
            c.add(lstPaciente.get(idxList));
        }
        
        lstPaciente.removeAll(c);
        txtNomePaciente.setText("");
        txtCPFPaciente.setText("");
        
    }//GEN-LAST:event_btExcPacienteActionPerformed

    private void btAdcPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdcPacienteActionPerformed
        
        Paciente p = new Paciente();
        if(tbPaciente.getSelectedRows().length==0){
            p.setNome(txtNomePaciente.getText());
            p.setCpf(txtCPFPaciente.getText());
            lstPaciente.add(p);
            txtNomePaciente.setText("");
            txtCPFPaciente.setText("");
        }else{
            lstPaciente.add(p);
            tbPaciente.getSelectionModel().setSelectionInterval(
                    lstPaciente.size()-1, 
                    lstPaciente.size()-1);
        }
        
    }//GEN-LAST:event_btAdcPacienteActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        
        if(getDesktopPane() instanceof AreaDeTrabalho){
            ((AreaDeTrabalho)getDesktopPane()).fecharGerenciarPaciente();
        }
        
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdcPaciente;
    private javax.swing.JButton btExcPaciente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCPF;
    private javax.swing.JLabel lbInfPaciente;
    private javax.swing.JLabel lbNomePaciente;
    private javax.swing.JTable tbPaciente;
    private javax.swing.JTextField txtCPFPaciente;
    private javax.swing.JTextField txtNomePaciente;
    // End of variables declaration//GEN-END:variables
}
