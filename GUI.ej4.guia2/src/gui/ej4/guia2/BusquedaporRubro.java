/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.ej4.guia2;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lourdes
 */
public class BusquedaporRubro extends javax.swing.JInternalFrame {
private DefaultTableModel modelo = new DefaultTableModel(){
    public boolean isCellEditable (int fila, int columna){
        return false;
    }
};
    /**
     * Creates new form BusquedaporRubro
     */
    public BusquedaporRubro() {
        initComponents();
        armarCabecera();
        cargarCombo();
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
        jLabel2 = new javax.swing.JLabel();
        jcRubro = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabla = new javax.swing.JTable();

        setClosable(true);
        setVisible(true);

        jLabel1.setText("Listado de Productos por Rubros");

        jLabel2.setText("Elija rubro:");

        jcRubro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcRubroItemStateChanged(evt);
            }
        });
        jcRubro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcRubroActionPerformed(evt);
            }
        });

        jtTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtTabla);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jcRubro, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jLabel1)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcRubro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcRubroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcRubroItemStateChanged
        // TODO add your handling code here:
        Categoria rubro;
        if (jcRubro.getModel().getSelectedItem() == Categoria.COMESTIBLES){
            rubro = Categoria.COMESTIBLES;
        } else if (jcRubro.getModel().getSelectedItem() == Categoria.LIMPIEZA){
            rubro= Categoria.LIMPIEZA;
        }else if (jcRubro.getModel().getSelectedItem() == Categoria.PERFUMERIA){
            rubro= Categoria.PERFUMERIA;
        }else {
            rubro= Categoria.ROPA;
        }
        
        if(evt.getStateChange()==java.awt.event.ItemEvent.DESELECTED){
            borrarFilas();
            for(Producto pro : ProductosAdmi.listaProductos){
                if(pro.getRubro() == rubro){
                    modelo.addRow(new Object[]{pro.getCodigo(),pro.getDescripcion(),pro.getPrecio(),pro.getStock()});
                }
        }
    }//GEN-LAST:event_jcRubroItemStateChanged
    }
    private void jcRubroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcRubroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcRubroActionPerformed
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<Categoria> jcRubro;
    private javax.swing.JTable jtTabla;
    // End of variables declaration//GEN-END:variables

private void armarCabecera(){
        modelo.addColumn("Código");
        modelo.addColumn("Descripción");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock");
        jtTabla.setModel(modelo);
    }
private void cargarCombo(){ // Cargar combo es para cargar los item adentro 
    
    jcRubro.addItem(Categoria.COMESTIBLES);
    jcRubro.addItem(Categoria.LIMPIEZA);
    jcRubro.addItem(Categoria.PERFUMERIA);
    jcRubro.addItem(Categoria.ROPA);
    
}
private void borrarFilas(){
    int filas= jtTabla.getRowCount()-1;
    
    for(int f=filas;f>=0; f--){
        modelo.removeRow(f);
    }
        
    }
  
}
