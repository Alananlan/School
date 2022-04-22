package Assignments;

import java.util.*;

public class Catalog {
    private String name;
    private ArrayList<Item> list = new ArrayList<>();
    
    public Catalog (String name) {
        this.name = name;
    }
    public void add(Item item) {
        list.add(item);
    }
    public int size() {
        return list.size();
    }
    public Item get(int index) {
        return list.get(index);
    }
    public String getName() {
        return name;
    }
}
