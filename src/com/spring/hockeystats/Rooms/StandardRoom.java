package com.spring.hockeystats.Rooms;

import com.spring.hockeystats.Client;

public class StandardRoom extends Room implements RoomInterface {


    private final boolean needsCleaning;
    private final boolean isOccupied;

    public StandardRoom(int number, int floor, String type, int averagePrice, int beds, int rooms){
        super(number, floor, "Standard", 100, 2, 1);
        this.isOccupied = false;
        this.needsCleaning = false;
    }


}
