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
import java.net.SocketException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Sidimar
 */
public class Servidor {

    private DatagramSocket socket = null;
    private DatagramPacket pacoteEntrada = null;
    private DatagramPacket pacoteSaida = null;
    private byte[] bufferEntrada, BufferSaida;
    private String mensagem, mretorno;
    private int procura_porta;
    boolean resoposta;

    /**
     * @param args the command line arguments
     */
    public Servidor() throws InterruptedException, SocketException {

        final int porta = 8800;
        try {
            setSocket(new DatagramSocket(porta));
            setBufferEntrada(new byte[1024]);
            while (true) {
                System.out.println("esperando por cliente");

                //recebendo datagrama do cliente
                //defite o tamanho do pacote a ser recebido
                setPacoteEntrada(new DatagramPacket(getBufferEntrada(), getBufferEntrada().length));//cria datagrama para receber os dados

                getSocket().receive(getPacoteEntrada());// recebe pacote 

                //extraido dados, ip e porta
                setProcura_porta(getPacoteEntrada().getPort());
                InetAddress procura_endereco = getPacoteEntrada().getAddress();
                trataDados(getPacoteEntrada());// tratando daos
                setMensagem(new String(getPacoteEntrada().getData(), 0, getPacoteEntrada().getLength()));

                System.out.println("Endereco cliente: " + procura_endereco);
                System.out.println("Cliente" + procura_endereco + ":" + getMensagem());

                //enviando resposta para o cliente
                setMretorno("22#@");
                setBufferSaida(getMretorno().getBytes());
                setPacoteSaida(new DatagramPacket(getBufferSaida(), 0, getBufferSaida().length, procura_endereco, getProcura_porta()));
                getSocket().send(getPacoteSaida());
                //  continue;
                //     getSocket().wait();
                //getSocket().close();
                //getSocket().getReuseAddress();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public boolean trataDados(DatagramPacket dt) throws IOException {

        String dadosRetorno = new String(dt.getData(), 0, dt.getLength());
        System.out.println("Server :" + dadosRetorno);
        char opcão = dadosRetorno.charAt(0);
        switch (opcão) {
            case 1://1#login#senha@
                System.out.println("efetuando requerimento de login");
                String[] dados = dadosRetorno.split("#");
                System.out.println(dados[2]);

        }
        if (dadosRetorno.equals("22#@")) {
            resoposta = true;
        } else if (dadosRetorno.startsWith("20")) {
            JOptionPane.showMessageDialog(null, "erro");
            resoposta = false;
        }
        return resoposta;
    }

    public static void main(String[] args) throws SocketException, IOException {

        try {
            new Servidor();
        } catch (InterruptedException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * @return the socket
     */
    public DatagramSocket getSocket() {
        return socket;
    }

    /**
     * @param socket the socket to set
     */
    public void setSocket(DatagramSocket socket) {
        this.socket = socket;
    }

    /**
     * @return the pacoteEntrada
     */
    public DatagramPacket getPacoteEntrada() {
        return pacoteEntrada;
    }

    /**
     * @param pacoteEntrada the pacoteEntrada to set
     */
    public void setPacoteEntrada(DatagramPacket pacoteEntrada) {
        this.pacoteEntrada = pacoteEntrada;
    }

    /**
     * @return the pacoteSaida
     */
    public DatagramPacket getPacoteSaida() {
        return pacoteSaida;
    }

    /**
     * @param pacoteSaida the pacoteSaida to set
     */
    public void setPacoteSaida(DatagramPacket pacoteSaida) {
        this.pacoteSaida = pacoteSaida;
    }

    /**
     * @return the bufferEntrada
     */
    public byte[] getBufferEntrada() {
        return bufferEntrada;
    }

    /**
     * @param bufferEntrada the bufferEntrada to set
     */
    public void setBufferEntrada(byte[] bufferEntrada) {
        this.bufferEntrada = bufferEntrada;
    }

    /**
     * @return the BufferSaida
     */
    public byte[] getBufferSaida() {
        return BufferSaida;
    }

    /**
     * @param BufferSaida the BufferSaida to set
     */
    public void setBufferSaida(byte[] BufferSaida) {
        this.BufferSaida = BufferSaida;
    }

    /**
     * @return the mensagem
     */
    public String getMensagem() {
        return mensagem;
    }

    /**
     * @param mensagem the mensagem to set
     */
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    /**
     * @return the mretorno
     */
    public String getMretorno() {
        return mretorno;
    }

    /**
     * @param mretorno the mretorno to set
     */
    public void setMretorno(String mretorno) {
        this.mretorno = mretorno;
    }

    /**
     * @return the procura_porta
     */
    public int getProcura_porta() {
        return procura_porta;
    }

    /**
     * @param procura_porta the procura_porta to set
     */
    public void setProcura_porta(int procura_porta) {
        this.procura_porta = procura_porta;
    }
}
