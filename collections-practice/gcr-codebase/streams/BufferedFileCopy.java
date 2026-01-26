package streams;
import java.io.*;

class BufferedFileCopy {

    private static final int BUFFER_SIZE = 4096;

    public static void main(String[] args) {

        String source = "largeFile.dat";
        String destUnbuffered = "copy_unbuffered.dat";
        String destBuffered = "copy_buffered.dat";

        copyUsingUnbufferedStreams(source, destUnbuffered);
        copyUsingBufferedStreams(source, destBuffered);
    }

    static void copyUsingUnbufferedStreams(String src, String dest) {
        long start = System.nanoTime();

        try (FileInputStream fis = new FileInputStream(src);
             FileOutputStream fos = new FileOutputStream(dest)) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            long end = System.nanoTime();
            System.out.println("Unbuffered Time: " + (end - start) / 1_000_000 + " ms");

        } catch (IOException e) {
            System.out.println("Error in unbuffered copy");
        }
    }

    static void copyUsingBufferedStreams(String src, String dest) {
        long start = System.nanoTime();

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

            long end = System.nanoTime();
            System.out.println("Buffered Time: " + (end - start) / 1_000_000 + " ms");

        } catch (IOException e) {
            System.out.println("Error in buffered copy");
        }
    }
}
