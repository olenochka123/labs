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
