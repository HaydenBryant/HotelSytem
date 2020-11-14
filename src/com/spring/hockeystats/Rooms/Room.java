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
        System.out.println("Room is made and is a room and is occupied " + this.isOccupied);
    }

    public Boolean reserve(Client client, int occupants){
        if(this.isOccupied){
            System.out.println("Occupied");
        }
        if(this.needsCleaning){
            System.out.println("Needs cleaning");
        }
        if (this.isOccupied || this.needsCleaning){
            System.out.println("Room " + this.getNumber() + " is unavailable.");
            return false;
        }

        this.occupants = occupants;
        this.isOccupied = true;
        this.occupant = client;
        return true;
    }

    public Boolean checkout(){
        if(this.isOccupied == false){
            return false;
        }
        System.out.println(this.getOccupant().getName() + " has an outstanding balance of " + (this.getOccupant().getCurrentBill() - this.getOccupant().getPrepaid()) + " left to pay.");

        this.occupant = null;
        this.isOccupied = false;
        this.needsCleaning = true;

        return true;
    }

    public void clean(Room room){
        room.needsCleaning = false;
    }

    public int getNumber() {
        return number;
    }

    public static int getBeds() {
        return beds;
    }

    public static String getType() {
        return type;
    }

    public static int getRooms() {
        return rooms;
    }

    public static Client getOccupant(){
        return occupant;
    }

    public static int getOccupants() {
        return occupants;
    }

    public static int getAveragePrice() {
        return averagePrice;
    }

    public static Boolean isRoomOccupied(){ return isOccupied; }

    public static Boolean isRoomDirty() { return needsCleaning; }
}