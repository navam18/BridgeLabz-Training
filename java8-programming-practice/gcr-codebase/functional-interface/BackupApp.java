import java.io.*;

class BackupUser implements Serializable {

    String name;

    BackupUser(String name){
        this.name=name;
    }
}

class BackupApp{
    public static void main(String[] args)throws Exception{

        BackupUser u=new BackupUser("Navam");

        FileOutputStream fos=new FileOutputStream("data.txt");
        ObjectOutputStream oos=new ObjectOutputStream(fos);

        oos.writeObject(u);

        System.out.println("Backup completed");
    }
}
