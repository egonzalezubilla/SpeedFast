package model;

import data.ZonaDeCarga;

public class Repartidor implements Runnable {

    private String nombre;
    private ZonaDeCarga zonaDeCarga;

    public Repartidor() {
    }

    public Repartidor(String nombre, ZonaDeCarga zonaDeCarga) {
        this.nombre = nombre;
        this.zonaDeCarga = zonaDeCarga;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ZonaDeCarga getZonaDeCarga() {
        return zonaDeCarga;
    }

    public void setZonaDeCarga(ZonaDeCarga zonaDeCarga) {
        this.zonaDeCarga = zonaDeCarga;
    }

    @Override
    public void run() {
        Pedido pedido = zonaDeCarga.retirarPedido();

        while (pedido != null) {
            pedido.setEstado(EstadoPedido.EN_REPARTO);
            System.out.println("[Repartidor - " + nombre + "] Retirando pedido #" + pedido.getIdPedido() + "...");
            System.out.println("[Repartidor - " + nombre + "] Estado: " + pedido.getEstado());
            pedido.calcularTiempoEntrega();
            pedido.mostrarResumen();

            try {
                int tiempoEspera = 1500 + (int) (Math.random() * 1000);
                System.out.println("[Repartidor - " + nombre + "] Entregando pedido #" + pedido.getIdPedido() + "...");
                Thread.sleep(tiempoEspera);

                pedido.setEstado(EstadoPedido.ENTREGADO);
                System.out.println("[Repartidor - " + nombre + "] Estado: " + pedido.getEstado());
                System.out.println("El pedido " + pedido.getIdPedido() + ", repartido por " + nombre + " ha sido entregado.");

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
            pedido = zonaDeCarga.retirarPedido();
        }

        System.out.println(nombre + " ha terminado todos sus repartos.");
    }

}
