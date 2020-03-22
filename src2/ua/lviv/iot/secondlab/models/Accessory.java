package ua.lviv.iot.secondlab.models;

public abstract class Accessory {
	private int id;
	private String name;
	private float price;
	private float weight;
	private String producer;
	private String color;
	
	public int getId() {
		return id;
	}

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

	public Accessory(int id, String name, float price, float weight, String producer, String color) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.weight = weight;
		this.producer = producer;
		this.color = color;
	}
}
