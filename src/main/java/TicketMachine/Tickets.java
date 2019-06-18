package TicketMachine;

public enum Tickets {
   
    NORMAL20(2), HALF20(1), NORMAL60(8), HALF60(4);
    
    int price;
    
    private Tickets(int price){
        this.price = price;  
    }
    
    void pictureOfTicket(int price){
        System.out.println("-----\n| " + price + 
        " |\n-----");
        
    }
}
