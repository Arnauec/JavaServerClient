package gui;

import chat.ChatClient;
import chat.ChatClient;
import chat.MySocket;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Epicur
 */
public class ChatIniciatGUI extends javax.swing.JFrame implements ActionListener {

    private String usuari;
    ChatClient client;
    private DefaultListModel model;

    /**
     * Creates new form ChatIniciatGUI
     */
    public ChatIniciatGUI(String usuari) {
        initComponents();
        txtEnviar.requestFocus();
        butEnviar.setDefaultCapable(true);

        SwingUtilities.getRootPane(butEnviar).setDefaultButton(butEnviar);

        this.usuari = usuari;
        model = new DefaultListModel<String>();
        lisUsuaris.setModel(model);
        client = new ChatClient("localhost", 50000, this.usuari, this);

        txtEnviar.addActionListener(this);
        butEnviar.addActionListener(this);
        
        
        super.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                client.closeSocket();
                System.out.println("He tancat el socket i ara surto del programa");
                
                System.exit(0);
            }
        }); //To change body of generated methods, choose Tools | Templates.


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panGeneral = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        txtEnviar = new javax.swing.JTextField();
        butEnviar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lisUsuaris = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        panGeneral.setAutoscrolls(true);
        panGeneral.setMinimumSize(new java.awt.Dimension(1, 1));
        panGeneral.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setAutoscrolls(true);

        txtArea.setEditable(false);
        txtArea.setColumns(32);
        txtArea.setRows(20);
        txtArea.setFocusable(false);
        txtArea.setMinimumSize(new java.awt.Dimension(0, 0));
        jScrollPane1.setViewportView(txtArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.75;
        gridBagConstraints.weighty = 0.9;
        panGeneral.add(jScrollPane1, gridBagConstraints);

        txtEnviar.setColumns(32);
        txtEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnviarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.75;
        gridBagConstraints.weighty = 0.1;
        panGeneral.add(txtEnviar, gridBagConstraints);

        butEnviar.setText("Enviar");
        butEnviar.setAlignmentY(0.0F);
        butEnviar.setMaximumSize(new java.awt.Dimension(29, 29));
        butEnviar.setMinimumSize(new java.awt.Dimension(50, 29));
        butEnviar.setPreferredSize(new java.awt.Dimension(120, 29));
        butEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butEnviarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.25;
        gridBagConstraints.weighty = 0.1;
        panGeneral.add(butEnviar, gridBagConstraints);

        jScrollPane2.setPreferredSize(new java.awt.Dimension(150, 320));

        lisUsuaris.setToolTipText("");
        lisUsuaris.setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        lisUsuaris.setEnabled(false);
        lisUsuaris.setFocusTraversalKeysEnabled(false);
        lisUsuaris.setFocusable(false);
        lisUsuaris.setVisibleRowCount(0);
        jScrollPane2.setViewportView(lisUsuaris);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.25;
        gridBagConstraints.weighty = 0.9;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 0, 0);
        panGeneral.add(jScrollPane2, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(557, 387));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void butEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butEnviarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_butEnviarActionPerformed

    private void txtEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnviarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnviarActionPerformed
    public void actionPerformed(ActionEvent evt) {
        String str = txtEnviar.getText();
        if (!(str.equals(""))) {
            client.sendStr(usuari + ": " + str);
            txtEnviar.setText("");
        }
    }

    public void recvText(String str) {
        txtArea.append(str + "\n");
    }

    public void addList(String user) {
        model.addElement(user);
    }

    public void removeList(String user) {
        model.removeElement(user);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butEnviar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> lisUsuaris;
    private javax.swing.JPanel panGeneral;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JTextField txtEnviar;
    // End of variables declaration//GEN-END:variables
}
