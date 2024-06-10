import java.rmi.Naming;
import java.util.Locale;
import java.util.Scanner; // Importa la clase Locale

public class ClienteRMI {
    public static void main(String[] args) {
        try {
             ConversorRemoto stub = (ConversorRemoto) Naming.lookup("localhost");
            
            // Configura el escáner para usar el punto como separador decimal
            Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

            int opcion;
            do {
                System.out.println("Elija una opción:");
                System.out.println("1. Convertir de Fahrenheit a Celsius");
                System.out.println("2. Convertir de Celsius a Fahrenheit");
                System.out.println("3. Salir");
                opcion = scanner.nextInt();

                double temperatura;
                double resultado;

                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese la temperatura en Fahrenheit:");
                        temperatura = scanner.nextDouble();
                        resultado = stub.fahrenheitToCelsius(temperatura);
                        System.out.println("Resultado: " + resultado + " ºC");
                        break;
                    case 2:
                        System.out.println("Ingrese la temperatura en Celsius:");
                        temperatura = scanner.nextDouble();
                        resultado = stub.celsiusToFahrenheit(temperatura);
                        System.out.println("Resultado: " + resultado + " ºF");
                        break;
                    case 3:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, seleccione nuevamente.");
                }
            } while (opcion != 3);

        } catch (Exception e) {
            System.out.println("Error en el cliente RMI: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
