package chatapplication;

import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author n00153466
 */
public class Server extends javax.swing.JFrame {

    static ServerSocket serverSocket;
    static Socket socket;
    static DataInputStream dtinput;
    static DataOutputStream dtoutput;

    /**
     * Creates new form Server
     */
    public Server() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        chatBox = new javax.swing.JTextArea();
        sendButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        typedInText = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Server");

        chatBox.setEditable(false);
        chatBox.setColumns(20);
        chatBox.setLineWrap(true);
        chatBox.setRows(5);
        jScrollPane1.setViewportView(chatBox);

        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Type your Message Here:");

        typedInText.setColumns(20);
        typedInText.setRows(5);
        typedInText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                typedInTextKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(typedInText);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sendButton)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sendButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
//        try{
//            String msgOut = "";                             //declares a sent message variable and sets the text field to be empty before typing
//            msgOut = typedInText.getText().trim();          //gets the text typed in the text field
//            dtoutput.writeUTF(msgOut);                      //uses dataOutputStream writeUTF method and passes the variable msgOut which contains the text typed in the text box.
//            chatBox.append(System.lineSeparator() + "me: "+ msgOut);    //displays the message that the client typed and adds me: infront of it.
//            typedInText.setText("");                        //resets the text box to be empty after the message is sent.
//
//        }catch(IOException e){
//            System.out.println("Error"+ e.getMessage());    //catches any exceptions and displays them in the console.
//        }
        sendMessage();
    }//GEN-LAST:event_sendButtonActionPerformed

    private void typedInTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_typedInTextKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            sendMessage();
        }
    }//GEN-LAST:event_typedInTextKeyPressed

    private void sendMessage() {
        try {
            String msgOut = "";                             //declares a sent message variable and sets the text field to be empty before typing
            msgOut = typedInText.getText().trim();          //gets the text typed in the text field
            dtoutput.writeUTF(msgOut);                      //uses dataOutputStream writeUTF method and passes the variable msgOut which contains the text typed in the text box.
            chatBox.append(System.lineSeparator() + "me: " + msgOut);    //displays the message that the client typed and adds me: infront of it.
            typedInText.setText("");                        //resets the text box to be empty after the message is sent.

        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());    //catches any exceptions and displays them in the console.
        }
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>
//            chatBox.setText("me: "+typedInText.getText().trim());
//            typedInText.setText("");

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {        //method invoked when the application is launched.
            public void run() {
                new Server().setVisible(true);                  //makes the client window visible.
            }
        });
        try {

            serverSocket = new ServerSocket(1201);                      //creates server socket and sets the port
            socket = serverSocket.accept();                             //accepts connections to the server using the port 

            dtinput = new DataInputStream(socket.getInputStream());     //gets input stream that is later used to display the message sent from the client to the server.
            dtoutput = new DataOutputStream(socket.getOutputStream());  //data output stream sends out the message.
            String msgin = "";                                          //declares the message in variable that is used to display the message in the message window

            while (!msgin.equals("exit")) {
                msgin = dtinput.readUTF();                              //reads the input UTF stream
                chatBox.setText(chatBox.getText().trim() + "\n Client: " + msgin);    //displays the message sent from the client.
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTextArea chatBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton sendButton;
    private javax.swing.JTextArea typedInText;
    // End of variables declaration//GEN-END:variables
}
