package ua.lviv.iot.secondlab.models;

import ua.lviv.iot.secondlab.other.BikeType;

public class BikeAccessory extends Accessory{
	private BikeType bikeType;
	
	public BikeType getBikeType()
	{
		return bikeType;
	}
	
	public BikeAccessory(int id, String name, float price, float weight, String producer, String color, BikeType bikeType) {
		super(id, name, price, weight, producer, color);
		this.bikeType = bikeType;
	}

}
