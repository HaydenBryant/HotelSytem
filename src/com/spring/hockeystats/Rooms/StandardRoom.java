package com.spring.hockeystats.Rooms;

import com.spring.hockeystats.Client;

public class StandardRoom extends Room implements RoomInterface {


    public StandardRoom(int number, int floor, String type, int averagePrice, int beds, int rooms){
        super(number, floor, "Standard", 100, 2, 1);
    }

//    override reserve = if party size > beds * 2 print unavailable otherwise run standard reserve


    @Override
    public Boolean reserve(Room room, Client client, int occupants) {
        if(occupants > room.getBeds(room) * 2){
            System.out.println("Unavailable");
            return false;
        }

        if (room.isOccupied || room.needsCleaning){
            System.out.println("Room " + room.getNumber(room) + " is unavailable.");
            return false;
        }

        room.occupants = occupants;
        room.isOccupied = true;
        room.occupant = client;
        return true;
    }
}
