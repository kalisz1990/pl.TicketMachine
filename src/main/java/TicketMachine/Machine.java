package TicketMachine;

import java.util.Scanner;

public class Machine {

    private double moneyCapacity = 200;
    Tickets mPriceForTicket;

    Scanner sc = new Scanner(System.in);

    public Tickets getmPriceForTicket() {
        return mPriceForTicket;
    }

    public void setmPriceForTicket(Tickets mPriceForTicket) {
        this.mPriceForTicket = mPriceForTicket;
    }

    public double getMoneyCapacity() {
        return moneyCapacity;
    }

    public void setMoneyCapacity(double moneyCapacity) {
        if (moneyCapacity > 0) {
            this.moneyCapacity = moneyCapacity;
        } else {
            System.out.println("error");
        }
    }

    void startSystem() {
        printTicketOptions();
        userChoice(sc.next());
        getMoneyForTicket();
    }

    void getMoneyForTicket() {
        System.out.println("insert money: ");
        double moneyForTicket = sc.nextDouble();
        if (moneyForTicket == getmPriceForTicket().price) {
            printTicket(getmPriceForTicket());
        }
    }

    void printTicket(Tickets ticket) {
        System.out.println("Here is your ticket!!");
        ticket.pictureOfTicket(ticket.price);
    }

    void printPriceForTicket(Tickets ticket) {
        System.out.println("to pay: " + ticket.price);
    }

    Tickets userChoice(String ticket) {
        switch (ticket) {
            case "normal20":
                printPriceForTicket(Tickets.NORMAL20);
                this.mPriceForTicket = Tickets.NORMAL20;
                break;

            case "normal60":
                printPriceForTicket(Tickets.NORMAL60);
                break;

            case "half20":
                printPriceForTicket(Tickets.HALF20);
                break;

            case "half60":
                printPriceForTicket(Tickets.HALF60);
                break;

            default:
                System.out.println("wrong selection, try again.");
                userChoice(sc.next());
        }
        return null;
    }

    void printTicketOptions() {
        System.out.println(
                "Choose your ticket:\n" +
                        "- normal20\n" +
                        "- normal60\n" +
                        "- half20\n" +
                        "- half60");

    }
}



