package streams;

import java.io.*;

class PipedStreamExample {

    public static void main(String[] args) throws Exception {

        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis = new PipedInputStream(pos);

        Thread writer = new Thread(() -> {
            try {
                pos.write("Hello from Writer Thread".getBytes());
                pos.close();
            } catch (IOException e) {}
        });

        Thread reader = new Thread(() -> {
            try {
                int data;
                while ((data = pis.read()) != -1) {
                    System.out.print((char) data);
                }
            } catch (IOException e) {}
        });

        writer.start();
        reader.start();
    }
}
