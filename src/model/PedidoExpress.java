package model;

public class PedidoExpress extends Pedido {

    @Override
    public void asignarRepartidor() {
        System.out.println("Buscando repartidor con disponibilidad inmediata para compra express.");
    }

    public void asignarRepartidor(double distanciaKm, String nombreRepartidor) {
        System.out.println("Buscando repartidor en " + distanciaKm + " kilometros a la redonda...");
        System.out.println("Repartidor encontrado! " + nombreRepartidor + " llevará el pedido.");
    }
}
