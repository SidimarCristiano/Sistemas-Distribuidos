/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JOptionPane;


public class Cliente {

    private Socket socket;
    private int porta;

    public void ConfiguraRede(String ip, String porta) throws IOException {;
        socket = new Socket(ip, Integer.parseInt(porta));
        PrintWriter escritor = new PrintWriter(socket.getOutputStream());
        JOptionPane.showMessageDialog(null, "botao apertado");
        //alteracao
    }

   
    public Socket getSocket() {
        return socket;
        
        //sidibardfgdggdfgd
    }

    
    public void setSocket(Socket socket) {
        this.socket = socket;
    }
//kjsdbfjsfbdsjfbsdjhfbsdjhf
    
 public int getPorta() {
        return porta;
    }

    
    public void setPorta(int porta) {
        this.porta = porta;
    }
}
