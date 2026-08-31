package model;


public abstract class Pedido {

    private String idPedido;
    private String tipoPedido;
    private String direccionPedido;
    private double distanciaKm;
    private double tiempoEntrega;
    private String nombreRepartidor;

    public Pedido() {
    }

    public Pedido(String idPedido, String tipoPedido, String direccionPedido, double distanciaKm, double tiempoEntrega, String nombreRepartidor) {
        this.idPedido = idPedido;
        this.tipoPedido = tipoPedido;
        this.direccionPedido = direccionPedido;
        this.distanciaKm = distanciaKm;
        this.tiempoEntrega = tiempoEntrega;
        this.nombreRepartidor = "";

    }

    public void asignarRepartidor() {
        System.out.println("Buscando repartidor para asignar al pedido...");
    }

    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("Repartidor encontrado! " + nombreRepartidor + " enviara el pedido.");
    }

    public void mostrarResumen() {
        System.out.println("\n--- RESUMEN DEL PEDIDO ---");
        System.out.println("ID Pedido: " + idPedido);
        System.out.println("Tipo de Pedido: " + tipoPedido);
        System.out.println("Direccion: " + direccionPedido);
        System.out.println("Distancia: " + distanciaKm + "Kms.");
    }

    public void mostrarEnvio() {
        System.out.println("\nID Pedido: " + idPedido);
        System.out.println("Tipo de Pedido: " + tipoPedido);
        System.out.println("Direccion: " + direccionPedido);
        System.out.println("Repartidor: " + nombreRepartidor);
    }
    
        public void procesarEnvio() {
        calcularTiempoEntrega();
        mostrarResumen();
        asignarRepartidor();
        asignarRepartidor(nombreRepartidor);
    }
        

    public abstract void calcularTiempoEntrega();

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

    public String getDireccionPedido() {
        return direccionPedido;
    }

    public void setDireccionPedido(String direccionPedido) {
        this.direccionPedido = direccionPedido;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public void setDistanciaKm(double distanciaKm) {
        this.distanciaKm = distanciaKm;
    }

    public double getTiempoEntrega() {
        return tiempoEntrega;
    }

    public void setTiempoEntrega(double tiempoEntrega) {
        this.tiempoEntrega = tiempoEntrega;
    }

    public String getNombreRepartidor() {
        return nombreRepartidor;
    }

    public void setNombreRepartidor(String nombreRepartidor) {
        this.nombreRepartidor = nombreRepartidor;
    }

}
