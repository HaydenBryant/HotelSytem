package com.spring.hockeystats.Rooms;

import com.spring.hockeystats.Client.Client;

public class SuiteRoom extends Room implements RoomInterface {

    static protected Boolean kitchenette;
    static protected Boolean needsRestock;

    public SuiteRoom(int number, int floor, Boolean kitchenette){
        super(number, floor, "Suite", 300, 3, 3);
        this.isOccupied = false;
        this.needsCleaning = false;
        this.kitchenette = kitchenette;
        this.needsRestock = false;
    }

    @Override
    public Boolean reserve(Client client, int occupants) {

        if (this.isOccupied || this.needsCleaning || this.needsRestock){
            System.out.println("Room " + this.getNumber() + " is unavailable.");
            return false;
        }

        this.occupants = occupants;
        this.isOccupied = true;
        this.occupant = client;
        return true;
    }

//    @Override
    public void checkout(Client client) {
        this.occupant = null;
        this.isOccupied = false;
        this.needsCleaning = true;
        this.needsRestock = true;

        System.out.println(client.getName() + " has an outstanding balance of " + (client.getCurrentBill() - client.getPrepaid())  + "left to pay.");
    }

    public void restock(){
        this.needsRestock = false;
    }
}
