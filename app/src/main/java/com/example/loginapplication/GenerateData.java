package com.example.loginapplication;

import java.util.Arrays;
import java.util.List;

public class GenerateData {

    public static Data[] names = new Data[20];

    public static void setData() {
        for (int i = 0; i < names.length; i++) {
            names[i] = new Data();
            names[i].setName("Milind" + i);
        }
    }

    public static List<Data> getData() {
        List<Data> dataList = Arrays.asList(names);
        return dataList;
    }
}
