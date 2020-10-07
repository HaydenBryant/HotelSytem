package com.spring.hockeystats.Rooms;

import com.spring.hockeystats.Client;

public class Room implements RoomInterface{

    static private int number;
    static private int floor;
    static private String type;
    static private Boolean isOccupied;
    static private Boolean needsCleaning;
    static private Client occupant;
    static private int occupants;
    static private int averagePrice;
    static private int beds;
    static private int rooms;

    public Room(int number, int floor, String type, int averagePrice, int beds, int rooms){
        this.number = number;
        this.floor = floor;
        this.type = type;
        this.averagePrice = averagePrice;
        this.beds = beds;
        this.rooms = rooms;
        this.isOccupied = false;
        this.needsCleaning = false;
    }

    public Boolean reserve(Room room, Client client){
        if (room.isOccupied == true || room.needsCleaning == true){
            System.out.println("Room " + room.getNumber(room) + " is unavailable.");
            return false;
        }

        room.isOccupied = true;
        room.occupant = client;
        return true;
    }

    public void checkout(Room room, Client client){
        room.occupant = null;
        room.isOccupied = false;
        room.needsCleaning = true;

        System.out.println(client.getName() + " has an outstanding balance of " + client.getCurrentBill() + "left to pay.");
    }

    public void clean(Room room){
        room.needsCleaning = false;
    }

    public int getNumber(Room room) {
        return room.number;
    }

}