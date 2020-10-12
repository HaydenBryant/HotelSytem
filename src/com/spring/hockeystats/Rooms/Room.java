package com.spring.hockeystats.Rooms;

import com.spring.hockeystats.Client.Client;

public class Room implements RoomInterface{

    static protected int number;
    static protected int floor;
    static protected String type;
    static protected Boolean isOccupied;
    static protected Boolean needsCleaning;
    static protected Client occupant;
    static protected int occupants;
    static protected int averagePrice;
    static protected int beds;
    static protected int rooms;

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

    public Boolean reserve(Room room, Client client, int occupants){
        if (room.isOccupied || room.needsCleaning){
            System.out.println("Room " + room.getNumber(room) + " is unavailable.");
            return false;
        }

        room.occupants = occupants;
        room.isOccupied = true;
        room.occupant = client;
        return true;
    }

    public void checkout(Room room, Client client){
        room.occupant = null;
        room.isOccupied = false;
        room.needsCleaning = true;

        System.out.println(client.getName() + " has an outstanding balance of " + (client.getCurrentBill() - client.getPrepaid()) + "left to pay.");
    }

    public void clean(Room room){
        room.needsCleaning = false;
    }

    public int getNumber(Room room) {
        return room.number;
    }

    public static int getBeds(Room room) {
        return room.beds;
    }
}