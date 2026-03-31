interface Export{

    void exportCSV();
    void exportPDF();

    default void exportToJSON(){
        System.out.println("Exported to JSON");
    }
}

class ReportExporter implements Export{

    public void exportCSV(){
        System.out.println("CSV Export");
    }

    public void exportPDF(){
        System.out.println("PDF Export");
    }
}

class Exporter{
    public static void main(String[] args){

        Export e=new ReportExporter();

        e.exportCSV();
        e.exportToJSON();
    }
}
