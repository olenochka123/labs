package ua.lviv.iot.firstlab;

public class Ship{
	private static int numberOfShips;
	private float reservoir;
	private String name;
	private int containersCount;
	private float maxSpeed;
	private String material;
	protected float weight;
	protected int capacity;
	
	public Ship() {
		numberOfShips++;
	}
	
	public Ship(float reservoir, String name, int containersCount, float maxSpeed) {
		this(reservoir, name, containersCount, maxSpeed, null, 0, 0);
	}
	
	public Ship(float reservoir, String name, int containersCount, float maxSpeed, String material, float weight, int capacity) {
		this.reservoir = reservoir;
		this.name = name;
		this.containersCount = containersCount;
		this.maxSpeed = maxSpeed;
		this.material = material;
		this.weight = weight;
		this.capacity = capacity;
		numberOfShips++;
	}
	
	public float getReservoir() {
		return reservoir;
	}
	
	public void setReservoir(float value) {
		reservoir = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String value) {
		name = value;
	}
	
	public int getContainersCount() {
		return containersCount;
	}
	
	public void setContainersCount(int value) {
		containersCount = value;
	}
	
	public float getMaxSpeed() {
		return maxSpeed;
	}
	
	public void setMaxSpeed(float value) {
		maxSpeed = value;
	}
	
	public String getMaterial() {
		return material;
	}
	
	public void setMaterial(String value) {
		material = value;
	}
	
	public float getWeight() {
		return weight;
	}
	
	public void setWeight(float value) {
		weight = value;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public void setCapacity(int value) {
		capacity = value;
	}
	
	@Override
	public String toString() {
		return "This ship have: " + "reservoir = " + reservoir + ", name = " + name 
				+ ", containersCount = " + containersCount + ", maxSpeed = " + maxSpeed 
				+ ", material = " + material + ", weight= " + weight + ", capacity = " + capacity;
	}
	
	public static void printStaticField() {
		System.out.println("numberOfShips = " + numberOfShips);
	}
	
	public void printField() {
		System.out.println("numberOfShips = " + numberOfShips);
	}
	
	public void resetValues(float reservoir, String name, int containersCount, float maxSpeed, String material, float weight, int capacity) {
		this.reservoir = reservoir;
		this.name = name;
		this.containersCount = containersCount;
		this.maxSpeed = maxSpeed;
		this.material = material;
		this.weight = weight;
		this.capacity = capacity;
	}

}


