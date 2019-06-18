package TicketMachine;

import java.util.Scanner;

class Machine {

    private double mMoneyCapacity = 200;
    private double mInsertedMoneyForTicket;
    private Tickets mPriceForTicket;

    private Scanner sc = new Scanner(System.in);

    private void setmInsertedMoneyForTicket(double mInsertedMoneyForTicket) {
        this.mInsertedMoneyForTicket = mInsertedMoneyForTicket;
    }

    private double getmInsertedMoneyForTicket() {
        return mInsertedMoneyForTicket;
    }

    private Tickets getmPriceForTicket() {
        return mPriceForTicket;
    }

    private void setmPriceForTicket(Tickets mPriceForTicket) {
        this.mPriceForTicket = mPriceForTicket;
    }

    private boolean isMoneyInTheMachine(double mMoneyCapacity) {
        if (mMoneyCapacity < getmMoneyCapacity()) {
            System.out.println("machine don't have enough money to give change");
            return false;
        } else {
            this.mMoneyCapacity = mMoneyCapacity;
            return true;
        }
    }

    private double getmMoneyCapacity() {
        return mMoneyCapacity;
    }

    void startSystem() {
        printTicketOptions();
        userChoice(sc.next());
        if (getMoneyForTicket()) {
            printTicket(getmPriceForTicket());
        }
    }

    private void returnChange(double insetedMoney) {
        double change = getmPriceForTicket().price - insetedMoney;
        if (isMoneyInTheMachine(getmMoneyCapacity() - change)) {
            System.out.println("your change: " + Math.abs(change));
        }
    }

    private boolean getMoneyForTicket() {
        System.out.println("insert money: ");
        setmInsertedMoneyForTicket(sc.nextDouble());
        if (getmInsertedMoneyForTicket() == getmPriceForTicket().price) {
            return true;
        } else if (getmInsertedMoneyForTicket() > getmPriceForTicket().price) {
            returnChange(getmInsertedMoneyForTicket());
            return true;
        } else {
            System.out.println("inserted money insufficient");
            return false;
        }
    }

    private void printPriceForTicket(Tickets ticket) {
        System.out.println("to pay: " + ticket.price);
    }

    private void userChoice(String ticket) {
        switch (ticket) {
            case "normal20":
                printPriceForTicket(Tickets.NORMAL20);
                setmPriceForTicket(Tickets.NORMAL20);
                break;

            case "normal60":
                printPriceForTicket(Tickets.NORMAL60);
                setmPriceForTicket(Tickets.NORMAL60);
                break;

            case "half20":
                printPriceForTicket(Tickets.HALF20);
                this.mPriceForTicket = Tickets.HALF20;
                break;

            case "half60":
                printPriceForTicket(Tickets.HALF60);
                setmPriceForTicket(Tickets.HALF60);
                break;

            default:
                System.out.println("wrong selection, try again.");
                userChoice(sc.next());
        }
    }

    private void printTicket(Tickets ticket) {
        System.out.println("Here is your ticket!!");
        ticket.pictureOfTicket(ticket.price);
    }

    private void printTicketOptions() {
        System.out.println(
                "Choose your ticket:\n" +
                        "- normal20\n" +
                        "- normal60\n" +
                        "- half20\n" +
                        "- half60");
    }
}



