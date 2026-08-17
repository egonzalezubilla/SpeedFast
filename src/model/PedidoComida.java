package model;

public class PedidoComida extends Pedido {

    @Override
    public void asignarRepartidor() {
        System.out.println("Asignando Repartidor para repartir comida...");
    }

    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("Buscando repartidor con mochila termica disponible...");
        System.out.println("Repartidor con mochila termica encontrado! "
                + nombreRepartidor + " enviara la comida.");
    }
}
