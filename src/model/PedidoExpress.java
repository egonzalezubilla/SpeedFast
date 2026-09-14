package model;

public class PedidoExpress extends Pedido {

    public PedidoExpress(String idPedido, String tipoPedido, String direccionPedido,
            double distanciaKm, double tiempoEntrega, EstadoPedido estado) {
        super(idPedido, tipoPedido, direccionPedido, distanciaKm, tiempoEntrega, estado);
    }

    public PedidoExpress() {
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("\nBuscando repartidor con disponibilidad inmediata para compra express.");
    }

    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("Buscando repartidor en las cercanias...");
        System.out.println("Repartidor encontrado! " + nombreRepartidor + " llevara el pedido.\n");
    }

    @Override
    public void calcularTiempoEntrega() {
        if (getDistanciaKm() > 5) {
            setTiempoEntrega(15);
        } else {
            setTiempoEntrega(10);
        }
    }

    @Override
    public void mostrarResumen() {
        super.mostrarResumen();
        System.out.println("Tu encomienda express llega en " + getTiempoEntrega() + " minutos.");
    }
}
