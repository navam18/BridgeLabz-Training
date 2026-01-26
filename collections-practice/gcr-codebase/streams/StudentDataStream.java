package streams;

import java.io.*;

class StudentDataStream {

    public static void main(String[] args) {

        String file = "student.dat";

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
            dos.writeInt(101);
            dos.writeUTF("Kapil");
            dos.writeDouble(8.9);
        } catch (IOException e) {}

        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            System.out.println("Roll: " + dis.readInt());
            System.out.println("Name: " + dis.readUTF());
            System.out.println("GPA : " + dis.readDouble());
        } catch (IOException e) {}
    }
}
