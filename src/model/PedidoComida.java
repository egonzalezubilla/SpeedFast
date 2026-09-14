package model;

public class PedidoComida extends Pedido {

    public PedidoComida(String idPedido, String tipoPedido, String direccionPedido, 
            double distanciaKm, double tiempoEntrega, EstadoPedido estado) {
        super(idPedido, tipoPedido, direccionPedido, distanciaKm, tiempoEntrega, estado);
    }

    public PedidoComida() {
    }

    
    
    @Override
    public void asignarRepartidor() {
        System.out.println("\nAsignando Repartidor para repartir comida...");
    }

    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("Buscando repartidor con mochila termica disponible...");
        System.out.println("Repartidor con mochila termica encontrado! "
                + nombreRepartidor + " enviara la comida.\n");
    }
    
    @Override
    public void calcularTiempoEntrega() {
        setTiempoEntrega(15 + getDistanciaKm() * 2);
    }

    @Override
    public void mostrarResumen() {
        super.mostrarResumen();
        System.out.println("Tu comida sera entregada en: " + getTiempoEntrega() + " minutos.");
    }
}
