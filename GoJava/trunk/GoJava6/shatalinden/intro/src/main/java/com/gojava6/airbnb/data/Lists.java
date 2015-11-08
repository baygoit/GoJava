package com.gojava6.airbnb.data;

import com.gojava6.airbnb.apartment.Apartment;
import com.gojava6.airbnb.user.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by shata on 02.10.2015.
 */
public class Lists {
    public static List<User> hostList = new ArrayList<>();
    public static List<User> clientList = new ArrayList<>();
    public static Set<String> cities = new HashSet<>();
    public static List<Apartment> apartments = new ArrayList<>();
}