package com.donishchenko.airbnb;

import com.donishchenko.airbnb.model.Apartment;
import com.donishchenko.airbnb.model.Reservation;
import com.donishchenko.airbnb.model.User;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SortOfDataBase {
    public static Map<Integer, User> clients = new HashMap<>();
    public static Map<Integer, User> hosts = new HashMap<>();
    public static Set<String> uniqueCities = new HashSet<>();
    public static Map<Integer, Apartment> apartments = new HashMap<>();
    public static Map<Integer, Reservation> reservations = new HashMap<>();
}
