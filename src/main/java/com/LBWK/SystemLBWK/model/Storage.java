package com.LBWK.SystemLBWK.model;

import com.LBWK.SystemLBWK.exception.PartUnavailableException;

import java.util.Map;
import java.util.HashMap;

public class Storage {
    Map<String, Integer> partsAvailable = new HashMap<>();

    public void addPartToStorage(String partName, int quantity){
        int currentQuantity = partsAvailable.getOrDefault(partName, 0);
        partsAvailable.put(partName, currentQuantity + quantity);
    }
    public void usePart(String partName, int quantity){
        int available = partsAvailable.getOrDefault(partName, 0);
        if (available < quantity){
            throw new PartUnavailableException(partName);
        }
        partsAvailable.put(partName, available - quantity);
    }

    public void listParts(){
        partsAvailable.forEach((key, value) -> {
            System.out.println("Part: " + key + ", Quantity: " + value);
        });
    }

    public int verifyParts(String partName){
        return partsAvailable.getOrDefault(partName, 0);
    }
}