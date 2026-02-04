class EmployeeModel implements Cloneable{

    int id;

    EmployeeModel(int id){
        this.id=id;
    }

    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}

public class CloneApp{
    public static void main(String[] args)throws Exception{

        EmployeeModel e1=new EmployeeModel(101);
        EmployeeModel e2=(EmployeeModel)e1.clone();

        System.out.println(e1.id);
        System.out.println(e2.id);
    }
}
