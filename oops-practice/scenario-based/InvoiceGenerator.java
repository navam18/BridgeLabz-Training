class InvalidInvoiceFormatException extends Exception {
    InvalidInvoiceFormatException(String m) {
        super(m);
    }
}

class InvoiceGenerator {

    static int getTotalAmount(String s) throws InvalidInvoiceFormatException {
        int sum = 0;
        String[] items = s.split(",");
        for (String item : items) {
            String[] parts = item.split("-");
            if (parts.length != 2)
                throw new InvalidInvoiceFormatException("Invalid format");
            try {
                sum += Integer.parseInt(parts[1].trim().split(" ")[0]);
            } catch (Exception e) {
                throw new InvalidInvoiceFormatException("Invalid amount");
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String s = "Logo Design - 3000 INR, Web Page - 4500 INR";
        try {
            System.out.println(getTotalAmount(s));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
