import java.util.ArrayList;
import java.util.List;

public class Historial {

    private static final List<String> conversiones = new ArrayList<>();

    public static void agregar(String conversion) {
        conversiones.add(conversion);
    }

    public static void mostrar() {
        if (conversiones.isEmpty()) {
            System.out.println("No hay conversiones registradas.");
        } else {
            System.out.println("\n--- Historial de Conversiones ---");
            for (String c : conversiones) {
                System.out.println(c);
            }
            System.out.println("----------------------------------\n");
        }
    }
}
