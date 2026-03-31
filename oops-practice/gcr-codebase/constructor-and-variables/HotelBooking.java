class HotelBooking{
    String guestName;
    String roomType;
    int nights;

    HotelBooking(){
        guestName="";
        roomType="";
        nights=0;
    }

    HotelBooking(String guestName,String roomType,int nights){
        this.guestName=guestName;
        this.roomType=roomType;
        this.nights=nights;
    }

    HotelBooking(HotelBooking h){
        this.guestName=h.guestName;
        this.roomType=h.roomType;
        this.nights=h.nights;
    }

    public static void main(String[] args){
        HotelBooking b1=new HotelBooking();
        HotelBooking b2=new HotelBooking("Rahul","Deluxe",3);
        HotelBooking b3=new HotelBooking(b2);
        System.out.println("Guest Name: " + b1.guestName + ", Room Type: " + b1.roomType + ", Nights: " + b1.nights);
        System.out.println("Guest Name: " + b2.guestName + ", Room Type: " + b2.roomType + ", Nights: " + b2.nights);
        System.out.println("Guest Name: " + b3.guestName + ", Room Type: " + b3.roomType + ", Nights: " + b3.nights);
    }
}
