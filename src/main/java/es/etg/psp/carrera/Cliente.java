package main.java.es.etg.psp.carrera;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {
    static final int PUERTO = 8888;
    static final String HOST = "localhost";
    public String nombre;
    public int posicionCliente;
    static final String MSG_CLIENTE_CONECTADO = "Cliente conectado";
    static final String MSG_RESGISTRO_NOMBRE = "Introduce nombre";
    
    public Cliente(String nombre, int posicionCliente){
        this.nombre = nombre;
        this.posicionCliente = posicionCliente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPosicionCliente(int posicionCliente) {
        this.posicionCliente = posicionCliente;
    }

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(HOST, PUERTO);
            System.out.println(MSG_CLIENTE_CONECTADO);

            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter toServer = new PrintWriter(socket.getOutputStream(), true);

            System.out.print(MSG_RESGISTRO_NOMBRE);
            String solicitud = input.readLine();
            toServer.println(solicitud);

            do {

            String respuesta = fromServer.readLine();
            int nuevaPosicion = Integer.parseInt(respuesta);

            public void setPosicionCliente(int nuevaPosicion){
                this.posicionCliente += nuevaPosicion;
            }

            } while (posicionCliente<100);

        } catch (Exception e) {
            
        }
    }
}