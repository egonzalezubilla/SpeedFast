package data;

import java.util.ArrayList;
import java.util.List;
import model.Pedido;

public class ZonaDeCarga {
    private List<Pedido> listaPedidos;

    public ZonaDeCarga() {
        this.listaPedidos = new ArrayList<>();
    }

    public synchronized void agregarPedido(Pedido p) {
        listaPedidos.add(p);
        System.out.println("Pedido #" + p.getIdPedido() + " agregado. Destino: " + p.getDireccionPedido());
    }

    public synchronized Pedido retirarPedido() {
        if (!listaPedidos.isEmpty()) {
            return listaPedidos.remove(0);
        }
        return null;
    }

    public synchronized boolean pedidosRestantes() {
        return !listaPedidos.isEmpty();
    }
}
