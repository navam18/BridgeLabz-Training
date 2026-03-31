import java.util.function.Predicate;

class TemperatureAlert {
    public static void main(String[] args) {

        Predicate<Double> isHighTemp = t -> t > 40;

        double temp = 45;

        if(isHighTemp.test(temp)){
            System.out.println("Alert! High Temperature");
        } else {
            System.out.println("Temperature Normal");
        }
    }
}
