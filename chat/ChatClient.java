/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import gui.ChatIniciatGUI;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Epicur
 */
public class ChatClient {

    private MySocket clientSocket;
    private ChatIniciatGUI gui;

    public ChatClient(String host, int port, String nick, ChatIniciatGUI gui) {

        this.gui = gui;
        clientSocket = new MySocket(host, port);
        clientSocket.write_str(nick);
        // Input Thread        
        // Passem el nom d'usuari
        /*new Thread() {
            public void run() {
                String out;
                try {
                    while (!clientSocket.socket.isInputShutdown()) {
                        while ((out = outputLine.readLine()) != null) {
                            clientSocket.write_str(nick+": "+out);
                        }
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }.start();
         */

        // Output Thread
        new Thread() {
            public void run() {
                String inputLine;
                while ((inputLine = clientSocket.read_str()) != null) {
                    if (inputLine.contains("/newuser ")) {
                        String[] outStr = inputLine.split(" ", 2);
                        addToList(outStr[1]);
                    } else if (inputLine.contains("/deleteuser ")) {
                        String[] outStr = inputLine.split(" ", 2);
                        removeFromList(outStr[1]);
                    } else {
                        appendMessage(inputLine);
                    }

                }
            }
        }.start();
    }

    public void sendStr(String str) {
        if (!clientSocket.socket.isInputShutdown()) {
            clientSocket.write_str(str);
        }
    }

    public void appendMessage(final String str) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                gui.recvText(str);
            }

        });
    }

    public void addToList(String str) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                gui.addList(str);
            }

        });
    }

    public void removeFromList(String str) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                gui.removeList(str);
            }

        });
    }

    public void closeSocket() {
        try {
            clientSocket.socket.shutdownOutput();
            System.exit(0);
        } catch (IOException ex) {
            Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
