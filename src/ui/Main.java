package ui;

import data.GestorDeEnvios;
import data.RegistroEnvios;
import model.Pedido;
import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        RegistroEnvios registro = new RegistroEnvios();
        GestorDeEnvios gestor = new GestorDeEnvios(registro);

        
        Pedido nPedido1 = new PedidoComida("P001","Combo Hamburguesa Doble","Baker Street 221B", 12.0,0.0,"");
        Pedido nPedido2 = new PedidoEncomienda("P002","Encomienda rapida","Evergreen Av. 742",25.0,0.0,"");
        Pedido nPedido3 = new PedidoExpress("P003","Peces vivos","P.Sherman, Calle Wallaby 42, Sidney",3.0,0.0,"");
    
        Pedido[] pedidos = new Pedido[3];
        pedidos[0] = nPedido1;
        pedidos[1] = nPedido2;
        pedidos[2] = nPedido3;
        
        nPedido1.setNombreRepartidor("Walter Klose");
        nPedido2.setNombreRepartidor("Tina Delousse");
        nPedido3.setNombreRepartidor("Courtis Nah");
        
        for (Pedido pedido : pedidos) {
            pedido.procesarEnvio();
        }
        
        gestor.despachar(nPedido1);
        gestor.despachar(nPedido2);
        gestor.cancelar(nPedido3);
        
        registro.verHistorial();
    }

}
