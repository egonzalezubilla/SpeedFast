package model;

public class PedidoEncomienda extends Pedido {

    public PedidoEncomienda(String tipoPedido, String descripcion, String direccionPedido,
            double distanciaKm, double tiempoEntrega, EstadoPedido estado) {
        super(tipoPedido, descripcion, direccionPedido, distanciaKm, tiempoEntrega, estado);
    }

    public PedidoEncomienda(int idPedido, String tipoPedido, String descripcion, String direccionPedido, double distanciaKm, double tiempoEntrega, EstadoPedido estado) {
        super(idPedido, tipoPedido, descripcion, direccionPedido, distanciaKm, tiempoEntrega, estado);
    }

    public PedidoEncomienda() {
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("\nAsignando Rerpartidor para llevar encomienda.");
    }

    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("Validando medidas y peso de la encomienda...");
        System.out.println("Repartidor encontrado! " + nombreRepartidor
                + " enviara la encomienda.\n");
    }

    @Override
    public void calcularTiempoEntrega() {
        double resultadoRedondeado = Math.ceil(20 + getDistanciaKm() * 1.5);
        setTiempoEntrega(resultadoRedondeado);
    }

    @Override
    public void mostrarResumen() {
        super.mostrarResumen();
        System.out.println("Tiempo estimado de entrega: " + getTiempoEntrega() + " minutos.");
    }
}
