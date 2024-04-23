import java.util.HashMap;
import java.util.Map;

public class CodigosMoneda {
    private static final Map<Integer, String> CODIGOS = new HashMap<>();

    static {

        CODIGOS.put(1, "ARS");
        CODIGOS.put(2, "USD");
        CODIGOS.put(3, "BRL");
        CODIGOS.put(4, "PEN");
        CODIGOS.put(5, "COP");
        CODIGOS.put(6, "JPY");
        CODIGOS.put(7, "CLP");
        CODIGOS.put(8, "EUR");
        CODIGOS.put(9, "UYU");
        CODIGOS.put(10, "PYG");
    }

    public static String obtenerCodigo(int numero) {
        return CODIGOS.get(numero);
    }
}
