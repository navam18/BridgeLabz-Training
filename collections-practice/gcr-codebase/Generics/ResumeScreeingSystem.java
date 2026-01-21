import java.util.*;

abstract class JobRole {
    abstract String getRoleName();
    abstract boolean isQualified();
}

class SoftwareEngineer extends JobRole {
    String getRoleName() {
        return "Software Engineer";
    }

    boolean isQualified() {
        return true;
    }
}

class DataScientist extends JobRole {
    String getRoleName() {
        return "Data Scientist";
    }

    boolean isQualified() {
        return true;
    }
}

class ProductManager extends JobRole {
    String getRoleName() {
        return "Product Manager";
    }

    boolean isQualified() {
        return false;
    }
}

class Resume<T extends JobRole> {

    private T role;

    public Resume(T role) {
        this.role = role;
    }

    public void screenResume() {
        System.out.println("Screening for role: " + role.getRoleName());

        if (role.isQualified()) {
            System.out.println("Result: Shortlisted");
        } else {
            System.out.println("Result: Rejected");
        }
    }

    public T getRole() {
        return role;
    }
}
class ResumeScreeningPipeline {

    public static void screenAll(List<? extends JobRole> roles) {
        for (JobRole role : roles) {
            System.out.println("AI screening role: " + role.getRoleName());
        }
    }
}


public class ResumeScreeingSystem {
    public static void main(String[] args) {

        Resume<SoftwareEngineer> seResume =
                new Resume<>(new SoftwareEngineer());

        Resume<DataScientist> dsResume =
                new Resume<>(new DataScientist());

        Resume<ProductManager> pmResume =
                new Resume<>(new ProductManager());

        seResume.screenResume();
        dsResume.screenResume();
        pmResume.screenResume();

        List<JobRole> roles = Arrays.asList(
                new SoftwareEngineer(),
                new DataScientist(),
                new ProductManager()
        );

        ResumeScreeningPipeline.screenAll(roles);
    }
}
