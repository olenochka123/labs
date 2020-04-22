package ua.lviv.iot.spring.first.rest.models;

public class Accessory {
	
	private Integer id;
	private String name;
	private Float price;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public float getPrice() {
		return price;
	}

	public Accessory() {
		
	}
	
	public Accessory(int id, String name, float price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
}
