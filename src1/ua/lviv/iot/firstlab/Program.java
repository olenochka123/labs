package ua.lviv.iot.firstlab;

public class Program {
	
	private static final int shipsCount = 4;
	private static Ship[] ships = new Ship[shipsCount];
	
	public static void main(String []args){
        Ship ship1 = new Ship();
        Ship ship2 = new Ship(1, "Kolin", 3, 50);
        Ship ship3 = new Ship(3, "Rekot", 6, 60, "wood", 1500, 30);
        
        System.out.println(ship1.toString());
        System.out.println(ship2.toString());
        System.out.println(ship3.toString());
        
        Ship.printStaticField();
        ship1.printField();
        
        int counter = 0;
        while(counter < shipsCount)
        {
        	ships[counter] = new Ship();
        	System.out.println(ships[counter].toString());
        	counter++;
        }
        
        
     }
}
