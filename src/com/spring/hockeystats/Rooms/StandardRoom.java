package com.spring.hockeystats.Rooms;

import com.spring.hockeystats.Client.Client;

public class StandardRoom extends Room implements RoomInterface {


    public StandardRoom(int number, int floor){
        super(number, floor, "Standard", 100, 2, 1);
    }


    @Override
    public Boolean reserve(Room room, Client client, int occupants) {
        if(occupants > room.getBeds(room) * 2 + 2 * room.getRooms()){
            System.out.println("Unavailable");
            return false;
        }

        if (room.isOccupied || needsCleaning){
            System.out.println("Room " + room.getNumber(room) + " is unavailable.");
            return false;
        }

        room.occupants = occupants;
        room.isOccupied = true;
        room.occupant = client;
        return true;
    }
}
