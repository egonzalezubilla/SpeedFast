package model;

public class PedidoEncomienda extends Pedido {

    @Override
    public void asignarRepartidor() {
        System.out.println("Asignando Rerpartidor para llevar encomienda.");
    }

    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("Validando medidas y peso de la encomienda...");
        System.out.println("Repartidor encontrado! " + nombreRepartidor
                + " enviara la encomienda.");
    }
}
