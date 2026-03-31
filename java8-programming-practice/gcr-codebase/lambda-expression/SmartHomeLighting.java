@FunctionalInterface
interface LightAction{
    void run();
}

public class SmartHomeLighting{
    public static void main(String[] args){
        LightAction motion=()->System.out.println("Lights ON: Motion detected");
        LightAction night=()->System.out.println("Lights DIM: Night mode");
        LightAction voice=()->System.out.println("Lights ON: Voice command");

        motion.run();
        night.run();
        voice.run();
    }
}
