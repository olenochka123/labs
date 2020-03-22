package ua.lviv.iot.secondlab.models;

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
