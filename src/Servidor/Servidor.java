/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Sidimar
 */
public class Servidor {
    ServerSocket server;
    int porta=5000;
    Scanner s;
   
    public Servidor() throws IOException{
        
        //server = new ServerSocket(5000);
        DatagramSocket socket = new DatagramSocket(porta);//enstancio o socket para receber o pacote
        byte buffer[] =  new byte[1024];
        DatagramPacket pacote = new DatagramPacket(buffer, buffer.length);//defino o tamanho do pacote
        String recebe, envia;
        
       
        
        while(true){
              socket.receive(pacote); //digo que socket espera por um pacote de tao tamanho
              System.out.println(pacote.getPort());
              int porta = pacote.getPort();
              InetAddress endereco = pacote.getAddress();
              String content = new String(pacote.getData(), 0, pacote.getLength());
           // System.out.println(s.nextLine());
            //System.out.println("passou aki");
           // JOptionPane.showMessageDialog(null, "sdfas");
        }
    }
    
    
    
    public static void main(String[] args) throws IOException {
      new Servidor();
       
    }
}
