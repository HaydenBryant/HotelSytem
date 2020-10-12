package com.spring.hockeystats.Client;

public class Client {

    private String name;
    private int partySize;
    private int currentBill;
    private int prepaid;
    private String phoneNumber;
    private int roomNumber;
    private String roomType;

    public String getName() {
        return name;
    }

    public int getCurrentBill() {
        return currentBill;
    }

    public int getPrepaid() {
        return prepaid;
    }

    //    makePayment = increase prepaid
//    chargeRoom = increase current bill
//            getOustanding = get outstanding balance.

    public void makePayment(Client client, int payment){
        client.prepaid = client.getPrepaid() + payment;
    }
}