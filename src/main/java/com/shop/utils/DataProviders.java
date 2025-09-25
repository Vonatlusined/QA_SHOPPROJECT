//package com.shop.utils;

import com.shop.models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//public class DataProviders {
//    @DataProvider
 //   public Iterator<Object[]> AddNewUser() {
//        List<Object[]> list = new ArrayList<>();
//        list.add(new Object[]{"John123@email.com", "John1234.", "John", "Smitt",});
//        list.add(new Object[]{"John65@email.com", "John123456.", "Carl", "Smitt",});
//        list.add(new Object[]{"John88@email.com", "John12345678.", "Joe", "Smitt",});
//        list.add(new Object[]{"John33@email.com", "John12344321.", "Sara", "Carol",});
//        return list.iterator();
//    }

//    @DataProvider
//    public Iterator<Object[]> addNewUserWithScv() throws IOException {
//        List<Object[]> list = new ArrayList<>();
//        BufferedReader reader = new BufferedReader(new FileReader(("src/test/resources/Users.csv")));
//
//        String line = reader.readLine();
//        while (line != null) {
//            String[] split = line.split(",");
//
//            list.add(new Object[]{new User().setEmail(split[0]).setPassword(split[1])});
//
//            line = reader.readLine();
//        }
//        return list.iterator();
//    }
//}
