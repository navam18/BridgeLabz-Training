package exceptions;
import java.io.*;
class CheckedException{
    public static void main(String args[]){
        BufferedReader br=null;
        try{
            br =new BufferedReader(new FileReader("data.txt"));
            String line;
            while((line=br.readLine())!=null){
                System.out.println(line);
            }
        }
        catch (IOException e){
            System.out.println("File not found");
        }
        finally{
            try{
                if(br!=null){
                    br.close();
                }
            }
            catch(IOException e){
                System.out.println("Error closing the  file");
            }
        }
    }
}