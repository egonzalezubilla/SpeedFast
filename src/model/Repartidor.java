package model;

import data.ZonaDeCarga;
import dao.EntregaDAO;

public class Repartidor implements Runnable {

    private int id;
    private String nombre;
    private ZonaDeCarga zonaDeCarga;

    public Repartidor() {
    }

    public Repartidor(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public Repartidor(int id, String nombre, ZonaDeCarga zonaDeCarga) {
        this.id = id;
        this.nombre = nombre;
        this.zonaDeCarga = zonaDeCarga;
    }

    public Repartidor(String nombre, ZonaDeCarga zonaDeCarga) {
        this.nombre = nombre;
        this.zonaDeCarga = zonaDeCarga;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
            System.out.println("[Repartidor - " + nombre + "] Retirando pedido #" + pedido.getId() + "...");
            System.out.println("[Repartidor - " + nombre + "] Estado: " + pedido.getEstado());
            pedido.calcularTiempoEntrega();
            pedido.mostrarResumen();

            try {
                int tiempoEspera = 1500 + (int) (Math.random() * 1000);
                System.out.println("[Repartidor - " + nombre + "] Entregando pedido #" + pedido.getId() + "...");
                Thread.sleep(tiempoEspera);

                pedido.setEstado(EstadoPedido.ENTREGADO);
                System.out.println("[Repartidor - " + nombre + "] Estado: " + pedido.getEstado());
                System.out.println("El pedido " + pedido.getId() + ", repartido por " + nombre + " ha sido entregado.");

                EntregaDAO entregaDAO = new EntregaDAO();
                entregaDAO.guardar(pedido.getId(), this.id);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
            pedido = zonaDeCarga.retirarPedido();
        }

        System.out.println(nombre + " ha terminado todos sus repartos.");
    }
}
