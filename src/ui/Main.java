package ui;

import model.Pedido;
import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pedido nPedido1 = new Pedido();
        Pedido nPedido2 = new PedidoComida();
        Pedido nPedido3 = new PedidoEncomienda();
        Pedido nPedido4 = new PedidoExpress();
        String nombreRepartidor = "Turanga Leela";

        nPedido1.asignarRepartidor();
        nPedido1.asignarRepartidor(nombreRepartidor);

        System.out.println("\n---- o ----\n");
        
        nombreRepartidor = "Phillip J. Fry";
        nPedido2.asignarRepartidor();
        nPedido2.asignarRepartidor(nombreRepartidor);
        
        System.out.println("\n---- o ----\n");
        
        nombreRepartidor = "Bender Rodriguez";
        nPedido3.asignarRepartidor();
        nPedido3.asignarRepartidor(nombreRepartidor);
        
        System.out.println("\n---- o ----\n");
        
        nombreRepartidor = "Hubert Farnsworth";
        nPedido4.asignarRepartidor();
        nPedido4.asignarRepartidor(nombreRepartidor);
        
        
        
    }

}
