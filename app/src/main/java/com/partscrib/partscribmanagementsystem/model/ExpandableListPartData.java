package com.partscrib.partscribmanagementsystem.model;

import com.partscrib.partscribmanagementsystem.model.PartModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListPartData {
    public static String[] categories = {"Resistor", "Capacitor", "Power Cable", "Board", "LED"};

    public static HashMap<String, List<String>> getData(List<PartModel> parts){

        HashMap<String, List<String>> expandableListDetail = new HashMap<>();

        for (String category: categories){
            List<String> currentCategory = new ArrayList<>();

            for (PartModel part: parts){
                if (part.getCategory().equals(category)){
                    currentCategory.add(part.getName());
                }
            }

            expandableListDetail.put(category, currentCategory);
        }
        return expandableListDetail;
    }

}
