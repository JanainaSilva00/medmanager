/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author benini
 */
public class GerenciarFormatoMedicamento extends javax.swing.JInternalFrame {
    private List<FormatoMedicamento> lstFormatoMedicamento;
    /**
     * Creates new form GerenciarFormatoMedicamento
     */
    public GerenciarFormatoMedicamento() {
        
        FormatoMedicamentoDAO fm = new FormatoMedicamentoDAO();
        lstFormatoMedicamento = fm.listar();
       
        initComponents();
        
        BindingGroup bg = new BindingGroup();
        
        JTableBinding tb = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE,
                lstFormatoMedicamento, tbFormatoMedicamento);
        JTableBinding.ColumnBinding cb = tb.addColumnBinding(BeanProperty.create("descricao"));
        cb.setColumnName("Formato do Medicamneto");
               
        bg.addBinding(tb);
        
        Binding b = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE,
                tbFormatoMedicamento, BeanProperty.create("selectedElement.descricao"),
                txtDescricao, BeanProperty.create("text"));
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

        jLabel1 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        adicionar = new javax.swing.JButton();
        excluir = new javax.swing.JButton();
        salvar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbFormatoMedicamento = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Formato Medicamento");

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setText("Informações do Formato do Medicamento");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel2.setText("Descricao");

        adicionar.setText("Adicionar");
        adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarActionPerformed(evt);
            }
        });

        excluir.setText("Excluir");
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
            }
        });

        salvar.setText("Salvar");
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });

        tbFormatoMedicamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        jScrollPane1.setViewportView(tbFormatoMedicamento);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescricao))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(adicionar)
                        .addGap(18, 18, 18)
                        .addComponent(excluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(salvar)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adicionar)
                    .addComponent(excluir)
                    .addComponent(salvar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("Formato Medicamento");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarActionPerformed
        
        FormatoMedicamento fm = new FormatoMedicamento();
        if(tbFormatoMedicamento.getSelectedRows().length==0)
        {
            fm.setDescricao(txtDescricao.getText());
            txtDescricao.setText("");
            lstFormatoMedicamento.add(fm);
        } else{
            lstFormatoMedicamento.add(fm);
            tbFormatoMedicamento.getSelectionModel().setSelectionInterval(
                    lstFormatoMedicamento.size()-1, 
                    lstFormatoMedicamento.size()-1);
        }
        
    }//GEN-LAST:event_adicionarActionPerformed

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
        
        int v[] = tbFormatoMedicamento.getSelectedRows();
        List<FormatoMedicamento> f = new LinkedList<>();
        FormatoMedicamentoDAO fmd = new FormatoMedicamentoDAO();

        for(int i=0;i<v.length;i++) 
        {
            int idxTabela = v[i];
            int idxList = tbFormatoMedicamento.convertRowIndexToModel(idxTabela);
            f.add(lstFormatoMedicamento.get(idxList));
            fmd.remover(lstFormatoMedicamento.get(idxList));
        }
        
        lstFormatoMedicamento.removeAll(f);
        txtDescricao.setText("");
        
    }//GEN-LAST:event_excluirActionPerformed

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
        
        FormatoMedicamentoDAO fm = new FormatoMedicamentoDAO();
        
        for(FormatoMedicamento f:lstFormatoMedicamento){
            if(f.getId()==null) {
                fm.inserir(f);
            } else {
                fm.alterar(f);
            }
        }  
        
    }//GEN-LAST:event_salvarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionar;
    private javax.swing.JButton excluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton salvar;
    private javax.swing.JTable tbFormatoMedicamento;
    private javax.swing.JTextField txtDescricao;
    // End of variables declaration//GEN-END:variables
}