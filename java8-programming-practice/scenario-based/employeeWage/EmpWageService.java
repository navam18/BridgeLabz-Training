public class EmpWageService{

    private EmpWageService dao;

    public EmpWageService(EmpWageService dao){
        this.dao=dao;
    }

    public void computeEmpWage(){
        for(CompanyEmpWage company:dao.getCompanies()){
            int totalHours=0;
            int totalDays=0;

            while(totalHours<=company.maxHoursPerMonth&&totalDays<company.numOfWorkingDays){
                totalDays++;
                int empCheck=(int)Math.floor(Math.random()*3);
                int empHours=0;

                switch(empCheck){
                    case 1:
                        empHours=4;
                        break;
                    case 2:
                        empHours=8;
                        break;
                    default:
                        empHours=0;
                }

                totalHours+=empHours;
                int dailyWage=empHours*company.wagePerHour;
                company.dailyWages.add(dailyWage);
            }
            company.setTotalEmpWage(totalHours*company.wagePerHour);
        }
    }

    private CompanyEmpWage[] getCompanies() {
        throw new UnsupportedOperationException("Unimplemented method 'getCompanies'");
    }

    public int getTotalWage(String company){
        return dao.getCompany(company).totalEmpWage;
    }

    private CompanyEmpWage getCompany(String company) {
        throw new UnsupportedOperationException("Unimplemented method 'getCompany'");
    }
}