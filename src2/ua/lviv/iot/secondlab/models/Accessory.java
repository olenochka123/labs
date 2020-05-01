package ua.lviv.iot.spring.first.rest.models;

import javax.persistence.*;

@Entity
public class Accessory {
    private String name;
    private Float price;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Accessory() {
    }

    public Accessory(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
