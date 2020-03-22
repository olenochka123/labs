package ua.lviv.iot.secondlab.models;

public class Flashlight {
	private float flashPower;
	private boolean isOn;

	public void triggerLight()
	{
		isOn = !isOn;
	}
}
