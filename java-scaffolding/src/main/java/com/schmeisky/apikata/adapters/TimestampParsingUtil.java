package com.schmeisky.apikata.adapters;

public class TimestampParsingUtil {

    public static String[] parseTimeStamp(String timestamp){
        String[] splits = timestamp.split(" ");

        if(splits.length != 2){
            throw new IllegalStateException();
        }
        return splits;
    }
}
