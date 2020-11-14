package com.spring.hockeystats.Rooms;

import com.spring.hockeystats.Client.Client;

public interface RoomInterface {
    public Boolean reserve(Client client, int occupants);
    public Boolean checkout(Room room);
    public void clean(Room room);
    public int getNumber();
}
