package ua.lviv.iot.secondlab.models;

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
