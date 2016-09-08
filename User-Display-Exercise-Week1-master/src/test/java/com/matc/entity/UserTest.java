package com.matc.entity;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Joe on 9/7/2016.
 */
public class UserTest {

    List<User> users = new ArrayList<User>();
    Calendar c;
    @Before
    public void setUp(){
        c = Calendar.getInstance();
        users.add(new User("Test", "One", "5", "2000/08/01"));
        users.add(new User("Test", "Two", "6", "2000/09/07"));
    }

    @Test
    public void calculateAge() throws Exception {
        assertEquals(7, c.get(Calendar.DAY_OF_MONTH));
        assertEquals(16, users.get(1).calculateAge());
    }

}