public class EmployeeWageMain{
    public static void main(String[] args){

        System.out.println("Welcome to Employee Wage Computation Program");

        EmpWageDAO dao=new EmpWageDAO();

        dao.addCompany(new CompanyEmpWage("TCS",20,20,100));
        dao.addCompany(new CompanyEmpWage("Infosys",25,22,110));

        EmpWageDAO service=new EmpWageDAO(dao);
        service.computeEmpWage();

        System.out.println("TCS Wage:"+service.getTotalWage("TCS"));
        System.out.println("Infosys Wage:"+service.getTotalWage("Infosys"));
    }
}