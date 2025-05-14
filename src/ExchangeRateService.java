import java.util.Map;

public class ExchangeRateService {
    private final ConsultaCambio consulta = new ConsultaCambio();

    public Map<String, Double> getRates(String baseCurrency) {
        TasaCambio cambio = consulta.obtenerCambio(baseCurrency);
        return cambio.getConversion_rates();
    }
}
