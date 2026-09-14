package ui;

import data.GestorDeEnvios;
import data.RegistroEnvios;
import data.ZonaDeCarga;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
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
        
        ZonaDeCarga zonaDeCarga = new ZonaDeCarga();
        System.out.println("[Zona de carga inicializada]");

        Pedido nPedido1 = new PedidoComida("P001", "Combo Hamburguesa Doble", "Baker Street 221B", 12.0, 0.0, null);
        Pedido nPedido2 = new PedidoEncomienda("P002", "Encomienda rapida", "Evergreen Av. 742", 25.0, 0.0, null);
        Pedido nPedido3 = new PedidoExpress("P003", "Peces vivos", "P.Sherman, Calle Wallaby 42, Sidney", 3.0, 0.0, null);
        Pedido nPedido4 = new PedidoComida("P004", "Pizza Familiar Pepperoni", "Avenida Siempre Viva 742", 8.5, 0.0, null);
        Pedido nPedido5 = new PedidoEncomienda("P005", "Documentos Legales", "Calle Falsa 123", 15.0, 0.0, null);
        Pedido nPedido6 = new PedidoExpress("P006", "Medicina Urgente", "Hospital Central Sala 4", 5.2, 0.0, null);
        Pedido nPedido7 = new PedidoExpress("P007", "Repuestos de Auto Urgentes", "Avenida Macondo 100", 14.3, 0.0, null);

        zonaDeCarga.agregarPedido(nPedido1);
        zonaDeCarga.agregarPedido(nPedido2);
        zonaDeCarga.agregarPedido(nPedido3);
        zonaDeCarga.agregarPedido(nPedido4);
        zonaDeCarga.agregarPedido(nPedido5);
        zonaDeCarga.agregarPedido(nPedido6);
        zonaDeCarga.agregarPedido(nPedido7);

        Runnable repartidor1 = new Repartidor("Walter Klose", zonaDeCarga);
        Runnable repartidor2 = new Repartidor("Tina Delousse", zonaDeCarga);        
        Runnable repartidor3 = new Repartidor("Kal Effont", zonaDeCarga);
        
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(repartidor1);
        executor.execute(repartidor2);
        executor.execute(repartidor3);
        
        executor.shutdown();
        
        try {
            if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("\n[Zona de carga vacía]");
                System.out.println("Todas los pedidos han sido entregados correctamente.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
