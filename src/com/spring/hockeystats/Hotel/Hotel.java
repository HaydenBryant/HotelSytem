package com.spring.hockeystats.Hotel;

import com.spring.hockeystats.Client.Client;
import com.spring.hockeystats.Rooms.Room;
import com.spring.hockeystats.Rooms.StandardRoom;
import com.spring.hockeystats.Rooms.SuiteRoom;

import java.util.List;

public class Hotel {

    private String name;
    private int rooms;
    private List<Room> availableStandards;
    private List<Room> reservedStandards;
    private List<Room> availableSuites;
    private List<Room> reservedSuites;
    private List<Client> clients;

    public Hotel(String name){
        this.name = name;
    }

    public void setRooms(Hotel hotel){
        hotel.rooms = hotel.getAvailableStandards().size() + hotel.getReservedStandards().size() + hotel.getAvailableSuites().size() + hotel.getReservedSuites().size();
    }

    public void addSuite(SuiteRoom room) {
        if (room.getType().contains("Suite")) {
            availableSuites.add(room);
        } else {
            availableStandards.add(room);
        }
        this.setRooms(this);
        return;
    }

    public Boolean reserveRoom(Client client, Room room, int occupants){
        if(room.reserve(room, client, occupants)){
            if (room.getType().contains("Suite")) {
                availableSuites.remove(room);
                reservedSuites.add(room);
            } else {
                availableStandards.remove(room);
                reservedStandards.add(room);
            }
            return true;
        }
        return false;
    }

    public Boolean checkoutRoom(Room room){
        if(room.checkout(room)){
            if (room.getType().contains("Suite")) {
                availableSuites.add(room);
                reservedSuites.remove(room);
            } else {
                availableStandards.add(room);
                reservedStandards.remove(room);
            }
            return true;
        }
        return false;
    }

//    public Boolean cleanRoom(Room room){
//
//        return true;
//    }

    public int getRooms() {
        return rooms;
    }

    public List<Room> getAvailableStandards() {
        return availableStandards;
    }

    public List<Room> getReservedStandards() {
        return reservedStandards;
    }

    public List<Room> getAvailableSuites() {
        return availableSuites;
    }

    public List<Room> getReservedSuites() {
        return reservedSuites;
    }
}
