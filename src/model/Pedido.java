package model;

public abstract class Pedido {

    private String idPedido;
    private String tipoPedido;
    private String descripcion;
    private String direccionPedido;
    private double distanciaKm;
    private double tiempoEntrega;
    private String repartidorAsignado;
    private EstadoPedido estado;

    public Pedido() {
        this.repartidorAsignado = "Sin asignar";
        this.estado = EstadoPedido.PENDIENTE;
    }

    public Pedido(String idPedido, String tipoPedido, String descripcion, String direccionPedido,
            double distanciaKm, double tiempoEntrega, EstadoPedido estado) {
        this.idPedido = idPedido;
        this.tipoPedido = tipoPedido;
        this.descripcion = descripcion;
        this.direccionPedido = direccionPedido;
        this.distanciaKm = distanciaKm;
        this.tiempoEntrega = tiempoEntrega;
        this.estado = (estado != null) ? estado : EstadoPedido.PENDIENTE;
        this.repartidorAsignado = "Sin asignar";
    }

    public void asignarRepartidor() {
        System.out.println("Buscando repartidor para asignar al pedido...");
    }

    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("Repartidor encontrado! " + nombreRepartidor + " enviara el pedido.");
    }

    public String obtenerInformacionCompleta() {
        return "ID Pedido          : " + idPedido + "\n"
                + "Tipo de Pedido     : " + (tipoPedido != null ? tipoPedido : "General") + "\n"
                + "Descripción        : " + (descripcion != null ? descripcion : "Sin descripción") + "\n"
                + "Dirección          : " + direccionPedido + "\n"
                + "Distancia          : " + distanciaKm + " km\n"
                + "Tiempo Estimado    : " + tiempoEntrega + " min\n"
                + "Repartidor Asign.  : " + repartidorAsignado + "\n"
                + "Estado             : " + (estado != null ? estado : EstadoPedido.PENDIENTE) + "\n";
    }

    public void mostrarResumen() {
        System.out.println("\n--- RESUMEN DEL PEDIDO ---");
        System.out.println("ID Pedido: " + idPedido);
        System.out.println("Tipo de Pedido: " + descripcion);
        System.out.println("Direccion: " + direccionPedido);
        System.out.println("Distancia: " + distanciaKm + "Kms.");
    }

    public void mostrarEnvio() {
        System.out.println("\nID Pedido: " + idPedido);
        System.out.println("Tipo de Pedido: " + descripcion);
        System.out.println("Direccion: " + direccionPedido);
        System.out.println("Estado de entrega: " + estado);
    }

    public void procesarEnvio() {
        calcularTiempoEntrega();
        mostrarResumen();
        asignarRepartidor();
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public String getRepartidorAsignado() {
        return repartidorAsignado;
    }

    public void setRepartidorAsignado(String repartidorAsignado) {
        this.repartidorAsignado = repartidorAsignado;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

}
