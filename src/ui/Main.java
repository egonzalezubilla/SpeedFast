package ui;

import data.GestorDeEnvios;
import data.RegistroEnvios;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import model.Pedido;
import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;
import model.Repartidor;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        RegistroEnvios registro = new RegistroEnvios();
        GestorDeEnvios gestor = new GestorDeEnvios(registro);

        Pedido nPedido1 = new PedidoComida("P001", "Combo Hamburguesa Doble", "Baker Street 221B", 12.0, 0.0, "");
        Pedido nPedido2 = new PedidoEncomienda("P002", "Encomienda rapida", "Evergreen Av. 742", 25.0, 0.0, "");
        Pedido nPedido3 = new PedidoExpress("P003", "Peces vivos", "P.Sherman, Calle Wallaby 42, Sidney", 3.0, 0.0, "");
        Pedido nPedido4 = new PedidoComida("P004", "Pizza Familiar Pepperoni", "Avenida Siempre Viva 742", 8.5, 0.0, "");
        Pedido nPedido5 = new PedidoEncomienda("P005", "Documentos Legales", "Calle Falsa 123", 15.0, 0.0, "");
        Pedido nPedido6 = new PedidoExpress("P006", "Medicina Urgente", "Hospital Central Sala 4", 5.2, 0.0, "");

        ArrayList<Pedido> pedidosRepartidor1 = new ArrayList<>();
        pedidosRepartidor1.add(nPedido1);
        pedidosRepartidor1.add(nPedido4);

        ArrayList<Pedido> pedidosRepartidor2 = new ArrayList<>();
        pedidosRepartidor2.add(nPedido2);
        pedidosRepartidor2.add(nPedido5);

        ArrayList<Pedido> pedidosRepartidor3 = new ArrayList<>();
        pedidosRepartidor3.add(nPedido3);
        pedidosRepartidor3.add(nPedido6);

        Runnable repartidor1 = new Repartidor("Walter Klose", pedidosRepartidor1);
        Runnable repartidor2 = new Repartidor("Tina Delousse", pedidosRepartidor2);        
        Runnable repartidor3 = new Repartidor("Kal Effont", pedidosRepartidor3);
        
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(repartidor1);
        executor.execute(repartidor2);
        executor.execute(repartidor3);
        
        executor.shutdown();
        
    }

}
