interface Function {
    void turnOn();
    void turnOff();
}
class Light implements Function {
    public void turnOn() {
        System.out.println("Light is ON");
    }
    public void turnOff() {
        System.out.println("Light is OFF");
    }
}
class AC implements Function {
    public void turnOn() {
        System.out.println("AC is ON");
    }
    public void turnOff() {
        System.out.println("AC is OFF");
    }
}
class TV implements Function {
    public void turnOn() {
        System.out.println("TV is ON");
    }
    public void turnOff() {
        System.out.println("TV is OFF");
    }
}
class Main {
    public static void main(String[] args) {
        Function d1=new Light();
        Function d2=new AC();
        Function d3=new TV();
        d1.turnOn();
        d2.turnOn();
        d3.turnOn();
    }
}