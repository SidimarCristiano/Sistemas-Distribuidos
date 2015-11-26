/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Cliente {

    PrintWriter escritor;
    public DatagramSocket socket;
    String ip;
    private int porta;
    DatagramPacket dt;
    InetAddress host;
    boolean retorno;

    public void fechaconexao() {

        if (socket.isConnected()) {
            socket.close();
            System.out.println("conexao encerrada");

        } else {
            System.out.println("Voce nao efetuou nenhuma conexao");

        }

    }
    
   

    public boolean configuraRede(String ip, String porta) throws IOException {
        this.ip = ip;
        this.porta = Integer.parseInt(porta);
        boolean retorno  = false;
        socket = new DatagramSocket();
              
        host = InetAddress.getByName(ip);//adiciona o endereco pelo ip
        byte[] buffer = new byte[1024];//adicona os byte do ip ao buffer
        //buffer = dados.getBytes();// adciona dados ao buffer
        dt = new DatagramPacket(buffer, buffer.length, host, Integer.parseInt(porta));//instancia o datagrama com o buffer contendo dados

        socket.send(dt);//envia o pacote com os dados
        //recebendo mensagem do servidor
        byte[] bufferEntrada = new byte[1024];
        DatagramPacket pacoteEntrada = new DatagramPacket(bufferEntrada, bufferEntrada.length);

        socket.receive(pacoteEntrada);

        String dadosRetorno = new String(pacoteEntrada.getData(), 0, pacoteEntrada.getLength());
        System.out.println("Server :" + dadosRetorno);

        if (dadosRetorno.equals("22#@")) {
            retorno = true;
        } else if (dadosRetorno.startsWith("20")) {
            JOptionPane.showMessageDialog(null, "erro");
            retorno = false;
        }
        //        socket.close();
        // System.out.println("chegou aki");
        // System.out.println(Integer.parseInt(porta));
//       escritor  = new PrintWriter(socket.getOutputStream());
//       escritor.println("envio teste");
//       escritor.flush();
        return retorno;
    }
     public void enviaDados(String dados) throws IOException{
        byte[] buffer = new byte[1024];
        buffer = dados.getBytes();
        DatagramPacket dt2 = new DatagramPacket(buffer, buffer.length, host, porta);
        socket.send(dt2);//envia dados
      
    }
     
//   public boolean recebeDados(DatagramPacket dt) throws IOException{
//       
//        byte[] bufferEntrada = new byte[1024];
//        //DatagramPacket pacoteEntrada = new DatagramPacket(bufferEntrada, bufferEntrada.length);
//        socket.receive(dt);
//        String dadosRetorno = new String(dt.getData(), 0, dt.getLength());
//        System.out.println("Server :" + dadosRetorno);
//        if (dadosRetorno.equals("22#@")) {
//            retorno = true;
//        } else if (dadosRetorno.startsWith("20")) {
//            JOptionPane.showMessageDialog(null, "erro");
//            retorno = false;
//        }
//        return retorno;
//    }

//    public byte[] enviaDados(String login, String senha) {
//     byte[] buffer = new byte[1024];
//     buffer = login.getBytes();
//     buffer = senha.getBytes();
//     return buffer;
//        
//        
//    }
    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }
}
