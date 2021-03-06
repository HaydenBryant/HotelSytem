package com.spring.hockeystats;

import com.spring.hockeystats.Client.Client;
import com.spring.hockeystats.Hotel.Hotel;
import com.spring.hockeystats.Rooms.Room;
import com.spring.hockeystats.Rooms.StandardRoom;
import com.spring.hockeystats.Rooms.SuiteRoom;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Hotel hotel = new Hotel("Hotel");
        StandardRoom standRoom = new StandardRoom(101, 1);
        hotel.addRoom(standRoom);
        SuiteRoom suiteRoom = new SuiteRoom(301, 3, true);
        hotel.addRoom(suiteRoom);

        Client client = new Client("Hannah", 2, 50, "5555555555");

        hotel.reserveRoom(client, suiteRoom, 10);
        client.chargeRoom(hotel.checkoutRoom(suiteRoom));

    }
}
