package TicketMachine;

public enum Tickets {

    NORMAL20(2), HALF20(1), NORMAL60(8), HALF60(4);

    double price;

    Tickets(double price) {
        this.price = price;
    }

    void pictureOfTicket(double price) {
        System.out.println(" <--->\n| " + price +
                " |\n <--->");

    }
}
