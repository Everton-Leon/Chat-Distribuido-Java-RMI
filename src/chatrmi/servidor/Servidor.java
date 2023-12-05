package chatrmi.servidor;

// importações
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.SwingUtilities;
import chatrmi.stub.ChatIF;

public class Servidor extends javax.swing.JFrame {
    
    // criando uma variável global para o objeto remoto
    private static ChatIF objetoRemoto;

    public Servidor() {
        initComponents();
        btnParar.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnIniciar = new javax.swing.JButton();
        btnParar = new javax.swing.JButton();
        lblMsgPorta = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(420, 343));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel2.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 214, 72));
        jLabel2.setText("Servidor");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 144, 0, 0);
        jPanel1.add(jLabel2, gridBagConstraints);

        btnIniciar.setBackground(new java.awt.Color(0, 255, 0));
        btnIniciar.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        btnIniciar.setText("Iniciar");
        btnIniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(23, 76, 0, 0);
        jPanel1.add(btnIniciar, gridBagConstraints);

        btnParar.setBackground(new java.awt.Color(255, 0, 0));
        btnParar.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        btnParar.setText("Parar");
        btnParar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnParar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPararActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(23, 105, 0, 0);
        jPanel1.add(btnParar, gridBagConstraints);

        lblMsgPorta.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        lblMsgPorta.setForeground(new java.awt.Color(255, 255, 255));
        lblMsgPorta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMsgPorta.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 350;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 33, 5, 33);
        jPanel1.add(lblMsgPorta, gridBagConstraints);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/database-server.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 101, 0, 0);
        jPanel1.add(jLabel1, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPararActionPerformed
        try {
            // desvincula o objeto remoto do registro e encerrar o servidor.
            UnicastRemoteObject.unexportObject(objetoRemoto, true);
            System.out.println("Servidor RMI encerrado.");

            // desativa a tela
            setVisible(false);

            // Encerra a aplicação fora da thread de despacho de eventos da interface gráfica
            SwingUtilities.invokeLater(() -> System.exit(0));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnPararActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        // Desativa o botão de iniciar e ativa o botão de parar
        btnIniciar.setEnabled(false);
        btnParar.setEnabled(true);

        // realiza a criação no Objeto remoto, registra e inicializa o servidor
        try {
            objetoRemoto = new ChatObj();
            Registry registro = LocateRegistry.createRegistry(1099); // Cria um registro na porta 1099
            lblMsgPorta.setText("Servidor inicializado na porta 1099");
            registro.rebind("MeuObjetoRemoto", objetoRemoto); // Registra o objeto remoto no registro
            System.out.println("Servidor RMI pronto.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnIniciarActionPerformed
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
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Servidor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnParar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblMsgPorta;
    // End of variables declaration//GEN-END:variables
}
