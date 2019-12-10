package com.partscrib.partscribmanagementsystem;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Helper {

    public static String convertMilliToDate(String timeStamp){

        Date date = new Date(Long.parseLong(timeStamp));

        DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        String finalDateString = formatter.format(date);

        return finalDateString;
    }
}
