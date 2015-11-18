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
       
    
    }

   
    public Socket getSocket() {
        return socket;
        
       
    }

    
    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    
    public int getPorta() {
        return porta;
    }

    
    public void setPorta(int porta) {
        this.porta = porta;
    }
}
