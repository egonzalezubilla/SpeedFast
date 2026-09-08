package model;

import java.util.ArrayList;

public class Repartidor implements Runnable {

    private String nombre;
    private ArrayList<Pedido> listaPedidos = new ArrayList<>();

    public Repartidor() {
    }

    public Repartidor(String nombre, ArrayList<Pedido> listaPedidos) {
        this.nombre = nombre;
        this.listaPedidos = listaPedidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(ArrayList<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    @Override
    public void run() {
        for (Pedido pedido : listaPedidos) {
            System.out.println("PROCESANDO PEDIDO...");
            pedido.calcularTiempoEntrega();
            pedido.mostrarResumen();
            System.out.println("El pedido tardara " + pedido.getTiempoEntrega() + " minutos.");
            System.out.println("El pedido sera entregado por: " + nombre);

            try {
                int tiempoEspera = 1500 + (int) (Math.random() * 1000);
                Thread.sleep(tiempoEspera);

                System.out.println("El pedido " + pedido.getIdPedido() + ", repartido por " + nombre + " ha sido entregado.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

}
