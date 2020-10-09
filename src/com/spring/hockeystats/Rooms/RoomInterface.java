package com.spring.hockeystats.Rooms;

import com.spring.hockeystats.Client;

public interface RoomInterface {
    public Boolean reserve(Room room, Client client, int occupants);
    public void checkout(Room room, Client client);
    public void clean(Room room);
    public int getNumber(Room room);
}
