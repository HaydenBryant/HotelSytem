package com.spring.hockeystats.Rooms;

import com.spring.hockeystats.Client.Client;

public class StandardRoom extends Room implements RoomInterface {


    public StandardRoom(int number, int floor){
        super(number, floor, "Standard", 100, 2, 1);
        this.isOccupied = false;
        this.needsCleaning = false;
        System.out.println("Room is made and is a Standard room and is occupied " + this.isOccupied);
    }


    @Override
    public Boolean reserve(Client client, int occupants) {
        if(occupants > this.getBeds() * 2 + 2 * this.getRooms()){
            System.out.println("Unavailable");
            return false;
        }

        if(this.isRoomOccupied()){
            System.out.println("room occ");
        }


        if (this.isRoomOccupied() || this.isRoomDirty()){
            System.out.println("Room " + this.getNumber() + " is unavailable.");
            return false;
        }

        this.occupants = occupants;
        this.isOccupied = true;
        this.occupant = client;
        return true;
    }
}
