package com.spring.hockeystats;

import com.spring.hockeystats.Client.Client;
import com.spring.hockeystats.Hotel.Hotel;
import com.spring.hockeystats.Rooms.StandardRoom;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Hotel hotel = new Hotel("Hotel");
        StandardRoom standRoom = new StandardRoom(101, 1);
        hotel.addRoom(standRoom);
        Client client = new Client("Hannah", 2, 50, "5555555555");
        hotel.reserveRoom(client, standRoom, 2);
        System.out.println(hotel.checkoutRoom(standRoom));
    }
}
