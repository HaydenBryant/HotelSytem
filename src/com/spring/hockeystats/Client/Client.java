package com.spring.hockeystats.Client;

public class Client {

    private String name;
    private int partySize;
    private int currentBill;
    private int prepaid;
    private String phoneNumber;
    private int roomNumber;
    private String roomType;

    public Client(String name, int partySize, int prepaid, String phoneNumber) {
        this.name = name;
        this.partySize = partySize;
        this.prepaid = prepaid;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getCurrentBill() {
        return currentBill;
    }

    public int getPrepaid() {
        return prepaid;
    }



    public void makePayment(int payment){
        this.prepaid = this.getPrepaid() + payment;
    }

    public int chargeRoom(int charge){
        this.currentBill = this.getCurrentBill() + charge;
        return this.currentBill;
    }
}
