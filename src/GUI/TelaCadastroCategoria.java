/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controller.PrincipalController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Lidia
 */
public class TelaCadastroCategoria extends javax.swing.JFrame {

    private PrincipalController principal;
    private Object telaAnterior;

    public TelaCadastroCategoria(boolean rdGanho, boolean rdGasto, Object o) {
        initComponents();
        this.principal = new PrincipalController();
        telaAnterior= o;
        setRD(rdGanho, rdGasto);
    }

    private void setRD(boolean rdGanho, boolean rdGasto){
        radio_Ganho.setSelected(rdGanho);
        radio_Gasto.setSelected(rdGasto);
        
        if(rdGanho)
            txtDescricao.setForeground(new Color(0,153,0));
        if(rdGasto)
            txtDescricao.setForeground(new Color(255,0,0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_Background = new javax.swing.JPanel();
        pnTitulo = new javax.swing.JPanel();
        lblTituloPage = new javax.swing.JLabel();
        lblSubtitulo = new javax.swing.JLabel();
        lblIconPage = new javax.swing.JLabel();
        separatorContent = new javax.swing.JSeparator();
        pn_DadosCategoria = new javax.swing.JPanel();
        radio_Ganho = new javax.swing.JRadioButton();
        radio_Gasto = new javax.swing.JRadioButton();
        lblTipoCategoria = new javax.swing.JLabel();
        lblDescricao = new javax.swing.JLabel();
        btnLancar = new javax.swing.JButton();
        txtDescricao = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pn_Background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnTitulo.setBackground(new java.awt.Color(49, 76, 212));

        lblTituloPage.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        lblTituloPage.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloPage.setText("Cadastro de Categorias");

        lblSubtitulo.setFont(new java.awt.Font("Segoe UI Light", 1, 26)); // NOI18N
        lblSubtitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblSubtitulo.setText("Categoria");

        lblIconPage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconPage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/imgs/categoria-icon.png"))); // NOI18N

        javax.swing.GroupLayout pnTituloLayout = new javax.swing.GroupLayout(pnTitulo);
        pnTitulo.setLayout(pnTituloLayout);
        pnTituloLayout.setHorizontalGroup(
            pnTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTituloLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(pnTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSubtitulo)
                    .addGroup(pnTituloLayout.createSequentialGroup()
                        .addComponent(lblIconPage, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTituloPage)))
                .addContainerGap(177, Short.MAX_VALUE))
        );
        pnTituloLayout.setVerticalGroup(
            pnTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTituloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblIconPage, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTituloPage))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSubtitulo)
                .addContainerGap())
        );

        pn_Background.add(pnTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 100));

        separatorContent.setForeground(new java.awt.Color(207, 207, 207));
        pn_Background.add(separatorContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 410, 10));

        pn_DadosCategoria.setBackground(new java.awt.Color(255, 255, 255));
        pn_DadosCategoria.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        radio_Ganho.setBackground(new java.awt.Color(255, 255, 255));
        radio_Ganho.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        radio_Ganho.setForeground(new java.awt.Color(0, 153, 0));
        radio_Ganho.setSelected(true);
        radio_Ganho.setText("Ganho");
        radio_Ganho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radio_GanhoMouseClicked(evt);
            }
        });
        pn_DadosCategoria.add(radio_Ganho, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, -1, -1));

        radio_Gasto.setBackground(new java.awt.Color(255, 255, 255));
        radio_Gasto.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        radio_Gasto.setForeground(new java.awt.Color(255, 0, 0));
        radio_Gasto.setText("Gasto");
        radio_Gasto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radio_GastoMouseClicked(evt);
            }
        });
        pn_DadosCategoria.add(radio_Gasto, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, -1));

        lblTipoCategoria.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTipoCategoria.setText("Tipo de Categoria: ");
        pn_DadosCategoria.add(lblTipoCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, 30));

        lblDescricao.setBackground(new java.awt.Color(255, 255, 255));
        lblDescricao.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDescricao.setText("Descrição: ");
        pn_DadosCategoria.add(lblDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        btnLancar.setBackground(new java.awt.Color(255, 255, 255));
        btnLancar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLancar.setText("Lançar");
        btnLancar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLancar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLancarMouseClicked(evt);
            }
        });
        pn_DadosCategoria.add(btnLancar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, -1, -1));

        txtDescricao.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        pn_DadosCategoria.add(txtDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 200, 30));

        pn_Background.add(pn_DadosCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 410, 220));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pn_Background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_Background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radio_GanhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radio_GanhoMouseClicked
        radio_Gasto.setSelected(false);
        //txtDescricao.setFont(new Font("Sergoe UI", Font.PLAIN, 18));
        txtDescricao.setForeground(new Color(0,153,0));
    }//GEN-LAST:event_radio_GanhoMouseClicked

    private void radio_GastoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radio_GastoMouseClicked
        radio_Ganho.setSelected(false);
        txtDescricao.setForeground(new Color(255,0,0));
    }//GEN-LAST:event_radio_GastoMouseClicked

    private void btnLancarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLancarMouseClicked
        String tipoLanc = getTipoLancamento();
        String descricao = txtDescricao.getText();

        if(this.principal.encaminhaCadastroCategoria(tipoLanc, descricao)){
            JOptionPane.showMessageDialog(null, "Categoria cadastrada");
            this.dispose();
            
            carrega(this.telaAnterior);
            
        }
    }//GEN-LAST:event_btnLancarMouseClicked
    private void carrega(Object o){
        if(o instanceof TelaCadastroLancamento){
            TelaCadastroLancamento tela = (TelaCadastroLancamento) o;
            tela.carregaCategorias();
            tela.setRadioGanho(radio_Ganho.isSelected());
            tela.setRadioGasto(radio_Gasto.isSelected());
            tela.validate();
        }else{
            TelaCadastroMetas tela = (TelaCadastroMetas) o;
            tela.carregaCategorias();
            tela.validate();
        }       
    }
    
    
    private String getTipoLancamento(){
        if(radio_Ganho.isSelected())
            return "ganho";
        return "gasto";
    }
    
    public void setRBganho(){
        radio_Ganho.setVisible(false);
        radio_Gasto.setSelected(true);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                boolean rdGanho = true; boolean rdGasto = false;
                new TelaCadastroCategoria(rdGanho, rdGasto, this).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLancar;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblIconPage;
    private javax.swing.JLabel lblSubtitulo;
    private javax.swing.JLabel lblTipoCategoria;
    private javax.swing.JLabel lblTituloPage;
    private javax.swing.JPanel pnTitulo;
    private javax.swing.JPanel pn_Background;
    private javax.swing.JPanel pn_DadosCategoria;
    private javax.swing.JRadioButton radio_Ganho;
    private javax.swing.JRadioButton radio_Gasto;
    private javax.swing.JSeparator separatorContent;
    private javax.swing.JTextField txtDescricao;
    // End of variables declaration//GEN-END:variables
}
