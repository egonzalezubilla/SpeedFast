package data;

import java.util.ArrayList;
import model.Pedido;
import model.Rastreable;

public class RegistroEnvios implements Rastreable {

    private ArrayList<Pedido> historial = new ArrayList<>();

    public void RegistrarEnvio(Pedido pedido) {
        historial.add(pedido);
    }

    @Override
    public void verHistorial() {
        System.out.println("\n\n---- HISTORIAL DE ENVIOS ----\n");
        for (Pedido pedido : historial) {
            pedido.mostrarEnvio();
            System.out.println("Estado de pedido: DESPACHADO.");
        }

    }

}
