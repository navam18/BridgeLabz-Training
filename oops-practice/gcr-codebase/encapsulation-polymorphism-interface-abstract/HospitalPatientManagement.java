import java.util.ArrayList;

abstract class Patient{
    private int patientId;
    private String name;
    private int age;
    private String diagnosis;
    public Patient(int patientId,String name,int age){
        this.patientId=patientId;
        this.name=name;
        this.age=age;
    }
    public int getPatientId(){
        return patientId;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    protected void setDiagnosis(String diagnosis){
        this.diagnosis=diagnosis;
    }
    protected String getDiagnosis(){
        return diagnosis;
    }
    public abstract double calculateBill();
    public void getPatientDetails(){
        System.out.println("Id:"+patientId+" Name:"+name+" Age:"+age+" Bill:"+calculateBill());
    }
}

interface MedicalRecord{
    void addRecord(String diagnosis);
    void viewRecords();
}

class InPatient extends Patient implements MedicalRecord{
    private int daysAdmitted;
    private double dailyCharge;
    public InPatient(int patientId,String name,int age,int daysAdmitted,double dailyCharge){
        super(patientId,name,age);
        this.daysAdmitted=daysAdmitted;
        this.dailyCharge=dailyCharge;
    }
    public double calculateBill(){
        return daysAdmitted*dailyCharge;
    }
    public void addRecord(String diagnosis){
        setDiagnosis(diagnosis);
    }
    public void viewRecords(){
        System.out.println("Diagnosis:"+getDiagnosis());
    }
}

class OutPatient extends Patient implements MedicalRecord{
    private double consultationFee;
    public OutPatient(int patientId,String name,int age,double consultationFee){
        super(patientId,name,age);
        this.consultationFee=consultationFee;
    }
    public double calculateBill(){
        return consultationFee;
    }
    public void addRecord(String diagnosis){
        setDiagnosis(diagnosis);
    }
    public void viewRecords(){
        System.out.println("Diagnosis:"+getDiagnosis());
    }
}

public class HospitalPatientManagement{
    public static void main(String[] args){
        ArrayList<Patient> patients=new ArrayList<>();
        InPatient p1=new InPatient(1,"Amit",30,5,2000);
        OutPatient p2=new OutPatient(2,"Riya",25,800);
        p1.addRecord("Dengue");
        p2.addRecord("Fever");
        patients.add(p1);
        patients.add(p2);
        for(Patient p:patients){
            p.getPatientDetails();
            if(p instanceof MedicalRecord){
                ((MedicalRecord)p).viewRecords();
            }
        }
    }
}   