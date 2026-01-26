package streams;

import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;

class ImageByteArrayExample {
    public static void main(String[] args) {

        String source = "original.jpg";
        String copy = "copy.jpg";

        try {
            FileInputStream fis = new FileInputStream(source);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            byte[] imageBytes = baos.toByteArray();

            ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
            FileOutputStream fos = new FileOutputStream(copy);

            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            fis.close(); fos.close();

            boolean same = Arrays.equals(Files.readAllBytes(new File(source).toPath()),
                    Files.readAllBytes(new File(copy).toPath()));

            System.out.println("Images identical: " + same);

        } catch (IOException e) {
            System.out.println("Image processing error.");
        }
    }
}
