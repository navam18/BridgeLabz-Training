interface Convert {

    static double kmToMiles(double km){
        return km * 0.621371;
    }

    static double kgToLbs(double kg){
        return kg * 2.20462;
    }
}

class Converter{
    public static void main(String[] args){

        System.out.println(Convert.kmToMiles(10));
        System.out.println(Convert.kgToLbs(5));
    }
}
