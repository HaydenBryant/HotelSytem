package com.spring.hockeystats.Rooms;

import com.spring.hockeystats.Client.Client;

public class SuiteRoom extends Room implements RoomInterface {

    static protected Boolean kitchenette;
    static protected Boolean needsRestock;

    public SuiteRoom(int number, int floor, Boolean kitchenette){
        super(number, floor, "Suite", 300, 3, 3);
        this.kitchenette = kitchenette;
        this.needsRestock = false;
    }

    @Override
    public Boolean reserve(Room room, Client client, int occupants) {

        if (room.isOccupied || needsCleaning || needsRestock){
            System.out.println("Room " + room.getNumber(room) + " is unavailable.");
            return false;
        }

        room.occupants = occupants;
        room.isOccupied = true;
        room.occupant = client;
        return true;
    }

//    @Override
    public void checkout(SuiteRoom room, Client client) {
        room.occupant = null;
        room.isOccupied = false;
        room.needsCleaning = true;
        room.needsRestock = true;

        System.out.println(client.getName() + " has an outstanding balance of " + (client.getCurrentBill() - client.getPrepaid())  + "left to pay.");
    }

    public void restock(SuiteRoom room){
        room.needsRestock = false;
    }
}
