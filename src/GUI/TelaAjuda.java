/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Segismar Junior
 */
public class TelaAjuda extends javax.swing.JPanel {

    /**
     * Creates new form TelaAjuda
     */
    public TelaAjuda() {
        initComponents();
    }
    
     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_Titulo = new javax.swing.JPanel();
        lblTituloPage = new javax.swing.JLabel();
        lblSubtitulo = new javax.swing.JLabel();
        lblIconPage = new javax.swing.JLabel();
        separaAjuda = new javax.swing.JSeparator();
        pn_Dados = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pn_Titulo.setBackground(new java.awt.Color(49, 76, 212));

        lblTituloPage.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        lblTituloPage.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloPage.setText("Ajuda");

        lblSubtitulo.setFont(new java.awt.Font("Segoe UI Light", 1, 26)); // NOI18N
        lblSubtitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblSubtitulo.setText("Primeiros Passos");

        lblIconPage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconPage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/imgs/user-icon.png"))); // NOI18N

        javax.swing.GroupLayout pn_TituloLayout = new javax.swing.GroupLayout(pn_Titulo);
        pn_Titulo.setLayout(pn_TituloLayout);
        pn_TituloLayout.setHorizontalGroup(
            pn_TituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_TituloLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(pn_TituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSubtitulo)
                    .addGroup(pn_TituloLayout.createSequentialGroup()
                        .addComponent(lblIconPage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTituloPage)))
                .addContainerGap(443, Short.MAX_VALUE))
        );
        pn_TituloLayout.setVerticalGroup(
            pn_TituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_TituloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pn_TituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblIconPage, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTituloPage))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSubtitulo)
                .addContainerGap())
        );

        add(pn_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 100));

        separaAjuda.setForeground(new java.awt.Color(255, 255, 255));
        add(separaAjuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 670, -1));

        pn_Dados.setBackground(new java.awt.Color(255, 255, 255));
        pn_Dados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextPane1.setEditable(false);
        jTextPane1.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jTextPane1.setText("Olá, bem vindo ao Economize!\n\nObrigado por fazer parte desse projeto.\n\nPasso a passo:\n\n1. Ao fazer o login pela primeira vez seu saldo será zero e você deve fazer um cadastro de \"Ganho\" ou \"Gasto\" na opção \"Lançamentos\" localizado no menu lateral esquerdo.\n\n2. Para ver seus lançamentos vá ao menu e clique na opção \"Relatórios\". Para mostrar todas seus lançamentos.\n\n3. Você poderá cadastrar categorias/tipos de \"Ganhos\" ou de \"Gastos\", basta ir no menu \"Lançamentos\" e pressionar o botão de adição \"+\" ao lado de \"Categoria: \".\n\n4. Você poderá cadastrar formas de pagamento, basta ir no menu \"Lançamentos\" e pressionar o botão de adição \"+\" ao lado de \"Forma de pagamento: \".\n\n5. Para cadastrar uma meta, vá ao menu e clique na opção \"Metas\". Você poderá cadastrar uma meta, poderá ver a lista de metas já cadastradas.\n\n6. Você terá todos os dados relacionados ao mês vigente na sua \"Home\", será possível olhar quanto você ganhou e gastou por exemplo.\n");
        jTextPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(jTextPane1);

        pn_Dados.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 600, 280));

        add(pn_Dados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 670, 350));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel lblIconPage;
    private javax.swing.JLabel lblSubtitulo;
    private javax.swing.JLabel lblTituloPage;
    private javax.swing.JPanel pn_Dados;
    private javax.swing.JPanel pn_Titulo;
    private javax.swing.JSeparator separaAjuda;
    // End of variables declaration//GEN-END:variables
}
