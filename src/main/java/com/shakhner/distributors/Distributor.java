package com.shakhner.distributors;

import java.util.ArrayList;
import com.shakhner.model.Elevator;

public interface Distributor {
    public void distribute(ArrayList<Elevator> elevators, Integer floorNumber, Integer direction);
}
