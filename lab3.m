package ua.lviv.iot.secondlab;

import ua.lviv.iot.secondlab.managers.ProductManager;
import ua.lviv.iot.secondlab.models.BikeAccessory;
import ua.lviv.iot.secondlab.other.BikeType;
import ua.lviv.iot.secondlab.other.Utils;

public class Program {
    public static void main(String[] args) {
        BikeAccessory ba_1 = new BikeAccessory("yulo1", 2000, 310, "mercedes", "grey", BikeType.MOUNTAIN);
        BikeAccessory ba_2 = new BikeAccessory("yulo2", 2000, 300, "mercedes", "grey", BikeType.URBAN);
        BikeAccessory ba_3 = new BikeAccessory("yulo3", 2000, 320, "bmw", "grey", BikeType.TRACK);
        BikeAccessory ba_4 = new BikeAccessory("yulo4", 2000, 20, "nissan", "grey", BikeType.TRACK);
        BikeAccessory ba_5 = new BikeAccessory("yulo5", 2000, 3, "nissan", "grey", BikeType.URBAN);
    }
}
-----------------------------------------------------------------------------------
package ua.lviv.iot.secondlab.managers;

import java.util.*;

import ua.lviv.iot.secondlab.models.Accessory;

public class ProductManager {
    public List<Accessory> accessories = new ArrayList<>();
    
    public List<Accessory> getAccessories()
    {
        return accessories;
    }

    public void addProductToList(Accessory accessory) {
        accessories.add(accessory);
    }

    public void removeProductFromList(Accessory accessory) {
        accessories.remove(accessory);
    }

    public List<Accessory> getProductsByProducer(String producer) {
        List<Accessory> resultArray = new ArrayList<>();

        for (int i = 0; i < accessories.size(); i++) {
            if (accessories.get(i).getProducer() == producer) {
                resultArray.add(accessories.get(i));
            }
        }

        return resultArray;
    }

    public void printList(List<Accessory> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName());
        }

        System.out.println();
    }

}
-----------------------------------------------------------------------------------
package ua.lviv.iot.secondlab.models;

public abstract class Accessory {
    private String name;
    private float price;
    private float weight;
    private String producer;
    private String color;

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }
    
    public float getWeight() {
        return weight;
    }

    public String getProducer() {
        return producer;
    }
    
    public String getColor() {
        return color;
    }

    public Accessory(String name, float price, float weight, String producer, String color) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.producer = producer;
        this.color = color;
    }
}
-----
import ua.lviv.iot.secondlab.other.BikeType;

public class BikeAccessory extends Accessory{
    private BikeType bikeType;
    
    public BikeType getBikeType()
    {
        return bikeType;
    }
    
    public BikeAccessory(String name, float price, float weight, String producer, String color, BikeType bikeType) {
        super(name, price, weight, producer, color);
        this.bikeType = bikeType;
    }

}
-----
public class Flashlight {
    private float flashPower;
    private boolean isOn;

    public void triggerLight()
    {
        isOn = !isOn;
    }
}
-----
public class Lock {
    private int securityLevel;
    private boolean isLocked;
    
    public void lock()
    {
        isLocked = true;
    }

    public void unlock()
    {
        isLocked = false;
    }
}
-----
public class Speedometer {
    private float speed;
    private float distance;
    private boolean isOn;
    
    public void turnOn()
    {
        isOn = true;
    }
    
    public void turnOff()
    {
        isOn = false;
    }

    public void reserDistance()
    {
        distance = 0;
    }
}
-----------------------------------------------------------------------------------
package ua.lviv.iot.secondlab.other;

public enum BikeType {
    MOUNTAIN,
    URBAN,
    TRACK
}
-----
import java.util.*;
import java.util.Comparator;

import ua.lviv.iot.secondlab.models.Accessory;

public final class Utils {
    
    public static void sortByWeight(List<Accessory> products, boolean isDescending) {
        if (!isDescending) {
            products.sort(Comparator.comparing(Accessory::getWeight));
        } else {
            products.sort(Comparator.comparing(Accessory::getWeight).reversed());
        }
    }

    public static void sortByProducer(List<Accessory> products, boolean isDescending) {
        if (!isDescending) {
            products.sort(Comparator.comparing(Accessory::getProducer));
        } else {
            products.sort(Comparator.comparing(Accessory::getProducer).reversed());
        }
    }

}
-----------------------------------------------------------------------------------
package ua.lviv.iot.secondlab.test;

import ua.lviv.iot.secondlab.managers.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ua.lviv.iot.secondlab.models.*;
import ua.lviv.iot.secondlab.other.BikeType;
import java.util.*;

public class TestJunit {
    private ProductManager manager;
    
    @BeforeClass
    public void run()
    {
        manager = new ProductManager();
        BikeAccessory ba_1 = new BikeAccessory("yulo1", 2000, 310, "mercedes", "grey", BikeType.MOUNTAIN);
        BikeAccessory ba_2 = new BikeAccessory("yulo2", 2000, 300, "mercedes", "grey", BikeType.URBAN);
        BikeAccessory ba_3 = new BikeAccessory("yulo3", 2000, 320, "bmw", "grey", BikeType.TRACK);
        BikeAccessory ba_4 = new BikeAccessory("yulo4", 2000, 20, "nissan", "grey", BikeType.TRACK);
        BikeAccessory ba_5 = new BikeAccessory("yulo5", 2000, 3, "nissan", "grey", BikeType.URBAN);
        
        
    }
    
    @Test
    public List<Accessory> findProducts() {
        return manager.getProductsByProducer("nissan");
    }
}


