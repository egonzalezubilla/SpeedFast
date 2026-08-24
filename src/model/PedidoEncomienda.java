package model;

public class PedidoEncomienda extends Pedido {

    public PedidoEncomienda(String idPedido, String tipoPedido, String direccionPedido,
            double distanciaKm, double tiempoEntrega) {
        super(idPedido, tipoPedido, direccionPedido, distanciaKm, tiempoEntrega);
    }

    public PedidoEncomienda() {
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("Asignando Rerpartidor para llevar encomienda.");
    }

    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("Validando medidas y peso de la encomienda...");
        System.out.println("Repartidor encontrado! " + nombreRepartidor
                + " enviara la encomienda.");
    }

    @Override
    public void calcularTiempoEntrega() {
        double resultadoRedondeado = Math.ceil(15 + getDistanciaKm() * 1.5);
        setTiempoEntrega(resultadoRedondeado);
    }

    @Override
    public void mostrarResumen() {
        super.mostrarResumen();
        System.out.println("Tiempo estimado de entrega: " + getTiempoEntrega() + " minutos.");
    }
}
