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

/**
 *
 * @author Sidimar
 */
public class Cliente {

    private Socket socket;
    private int porta;

    public void ConfiguraRede(String ip, int porta) throws IOException {;
        socket = new Socket(ip, porta);
        PrintWriter escritor = new PrintWriter(socket.getOutputStream());
        JOptionPane.showMessageDialog(null, "botao apertado");
    }

    /**
     * @return the socket
     */
    public Socket getSocket() {
        return socket;
    }

    /**
     * @param socket the socket to set
     */
    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    /**
     * @return the porta
     */
    public int getPorta() {
        return porta;
    }

    /**
     * @param porta the porta to set
     */
    public void setPorta(int porta) {
        this.porta = porta;
    }
}
