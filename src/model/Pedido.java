package model;

public class Pedido {

    private String idPedido;
    private String tipoPedido;
    private String dirPedido;

    public Pedido() {
    }

    public Pedido(String idPedido, String tipoPedido, String dirPedido) {
        this.idPedido = idPedido;
        this.tipoPedido = tipoPedido;
        this.dirPedido = dirPedido;
    }

    public void asignarRepartidor() {
        System.out.println("Buscando repartidor para asignar al pedido...");
    }

    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("Repartidor encontrado! " + nombreRepartidor + " enviara el pedido.");
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public String getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(String tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public String getDirPedido() {
        return dirPedido;
    }

    public void setDirPedido(String dirPedido) {
        this.dirPedido = dirPedido;
    }

}
