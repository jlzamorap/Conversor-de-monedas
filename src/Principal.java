import java.io.IOException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        ExchangeRateService rateService = new ExchangeRateService();
        CurrencyConverter converter = new CurrencyConverter(rateService);

        while (true) {
            Conversor.mostrarMenu();
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            String fromCurrency = "";
            String toCurrency = "";

            switch (opcion) {
                case 1 -> { fromCurrency = "USD"; toCurrency = "ARS"; }
                case 2 -> { fromCurrency = "ARS"; toCurrency = "USD"; }
                case 3 -> { fromCurrency = "USD"; toCurrency = "BRL"; }
                case 4 -> { fromCurrency = "BRL"; toCurrency = "USD"; }
                case 5 -> { fromCurrency = "USD"; toCurrency = "COP"; }
                case 6 -> { fromCurrency = "COP"; toCurrency = "USD"; }

                case 7 -> {
                    Historial.mostrar();
                    continue;
                }
                case 8 -> {
                    System.out.println("Gracias por usar el conversor. ¡Hasta pronto!");
                    scanner.close();
                    return;
                }
                default -> {
                    System.out.println("Opción no válida. Intente nuevamente.");
                    continue;
                }
            }
            System.out.print("Cantidad a convertir: ");
            double amount = scanner.nextDouble();

            try {
                double result = converter.convert(fromCurrency, toCurrency, amount);
                String registro = String.format("%.2f %s = %.2f %s", amount, fromCurrency, result, toCurrency);
                System.out.println(registro);
                Historial.agregar(registro);
            } catch (Exception e) {
                System.out.println("Error al convertir: " + e.getMessage());
            }
        }
    }

}
