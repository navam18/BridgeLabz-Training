class Device {
    int deviceId;
    boolean status;
}

class Thermostat extends Device {
    int temperatureSetting;

    void displayStatus() {
        System.out.println("Temperature set to: " + temperatureSetting);
    }
}

public class DeviceTest {
    public static void main(String[] args) {
        Thermostat thermostat = new Thermostat();
        thermostat.deviceId = 1;
        thermostat.status = true;
        thermostat.temperatureSetting = 24;

        thermostat.displayStatus();
    }
}
