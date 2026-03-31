import java.util.*;
class Stock {
    public static void main(String[] args) {
        List<Double> stockPrices = Arrays.asList(
            1520.50,
            1532.75,
            1518.30,
            1540.10,
            1535.60
        );
        stockPrices.stream()
                    .forEach(price ->
                        System.out.println("Stock Price Update: " + price)
                    );
    }
}