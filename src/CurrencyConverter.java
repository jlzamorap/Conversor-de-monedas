import java.util.Map;

public class CurrencyConverter {

    private final ExchangeRateService rateService;

    public CurrencyConverter(ExchangeRateService rateService) {
        this.rateService = rateService;
    }

    public double convert(String fromCurrency, String toCurrency, double amount) {
        Map<String, Double> rates = rateService.getRates(fromCurrency);
        Double rate = rates.get(toCurrency.toUpperCase());

        if (rate == null) {
            throw new IllegalArgumentException("Moneda de destino no válida.");
        }

        return amount * rate;
    }

}
