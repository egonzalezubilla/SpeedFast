package data;

import model.Cancelable;
import model.Despachable;
import model.Pedido;

public class GestorDeEnvios implements Despachable, Cancelable {

    private RegistroEnvios registro;

    public GestorDeEnvios(RegistroEnvios registro) {
        this.registro = registro;
    }

    @Override
    public void despachar(Pedido pedido) {
        System.out.println("\nEl pedido " + pedido.getIdPedido()
                + " esta listo, sera recogido por " + pedido.getNombreRepartidor() + " en breve.");
        registro.RegistrarEnvio(pedido);
    }

    @Override
    public void cancelar(Pedido pedido) {
        System.out.println("\nCancelando pedido...");
        System.out.println("Pedido " + pedido.getIdPedido() + " cancelado con exito");
    }
}
