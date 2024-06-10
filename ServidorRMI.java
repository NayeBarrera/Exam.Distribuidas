import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServidorRMI {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            ConversorRemotoImpl objetoRemoto = new ConversorRemotoImpl();
            Naming.rebind("ConversorRemoto", objetoRemoto);
            System.out.println("Servidor RMI listo...");
        } catch (Exception e) {
            System.out.println("Error en el servidor RMI: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
