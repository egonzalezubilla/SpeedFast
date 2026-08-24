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

        
        System.out.println("\n---- o ----\n");
        
        Pedido nPedido1 = new PedidoComida("P001","Combo Hamburguesa Doble","Baker Street 221B", 12.0,0.0);
        nPedido1.calcularTiempoEntrega();
        nPedido1.mostrarResumen();
        
        System.out.println("\n---- o ----\n");
        
        Pedido nPedido2 = new PedidoEncomienda("P002","Encomienda rapida","Evergreen Av. 742",25.0,0.0);
        nPedido2.calcularTiempoEntrega();
        nPedido2.mostrarResumen();
        
        System.out.println("\n---- o ----\n");
        
        Pedido nPedido3 = new PedidoExpress("P003","Peces vivos","P.Sherman, Calle Wallaby 42, Sidney",3.0,0.0);
        nPedido3.calcularTiempoEntrega();
        nPedido3.mostrarResumen();
    }

}
