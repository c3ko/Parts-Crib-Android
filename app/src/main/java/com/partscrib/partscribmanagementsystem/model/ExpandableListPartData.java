package com.partscrib.partscribmanagementsystem;

import com.partscrib.partscribmanagementsystem.model.PartModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListPartData {
    public static String[] categories = {"Resistor", "Capacitor", "Power Cable", "Board"};
    private List<PartModel> partsList;
    private HashMap<String, List<String>> expandableListDetail ;
    public ExpandableListPartData(){
        this.expandableListDetail = new HashMap<String, List<String>>();

    }
    public HashMap<String, List<String>> ExpandableListPartData(List<PartModel> parts){
        this.partsList = parts;
        //TODO: fetch categories from
        this.expandableListDetail = new HashMap<String, List<String>>();

        for (String category: categories){
            List<String> currentCategory = new ArrayList<String>();

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
