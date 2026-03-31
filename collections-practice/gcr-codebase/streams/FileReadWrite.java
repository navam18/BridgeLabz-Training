package streams;

import java.io.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class FileReadWrite {

    public static void main(String[] args) {

        String sourceFile = "source.txt";
        String destinationFile = "destination.txt";

        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }

            System.out.println("File copied successfully.");

        } catch (IOException e) {
            System.out.println("Source file not found or error while reading file.");
        }
    }
}

