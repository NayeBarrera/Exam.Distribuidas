import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServidorRMI {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            ConversorRemotoImpl obj = new ConversorRemotoImpl();
            Naming.rebind("//localhost/ConversorRemoto", obj);
            System.out.println("Servidor remoto iniciado.");
        } catch (Exception e) {
            System.err.println("Excepción del servidor: " + e.toString());
            e.printStackTrace();
        }
    }
}
    