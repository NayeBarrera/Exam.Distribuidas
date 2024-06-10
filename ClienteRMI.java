import java.rmi.Naming;
import java.util.Scanner;

public class ClienteRMI {
    public static void main(String[] args) {
        try {
            ConversorRemoto conversor = (ConversorRemoto) Naming.lookup("//localhost/ConversorRemoto");
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Elija una opcion:");
                System.out.println("1. Fahrenheit a Celsius");
                System.out.println("2. Celsius a Fahrenheit");
                System.out.println("3. Salir");
                int opcion = scanner.nextInt();
                if (opcion == 3) {  
                    break;
                }
                System.out.print("Ingrese la temperatura: ");
                double temperatura = scanner.nextDouble();
                double resultado = 0;
                switch (opcion) {
                    case 1:
                        resultado = conversor.fahrenheitACelsius(temperatura);
                        System.out.println("Resultado: " + resultado + " C");
                        break;
                    case 2:
                        resultado = conversor.celsiusAFahrenheit(temperatura);
                        System.out.println("Resultado: " + resultado + " F");
                        break;
                    default:
                        System.out.println("No hay esa opción");
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.err.println("Excepción del cliente: " + e.toString());
            e.printStackTrace();
        }
    }
}
