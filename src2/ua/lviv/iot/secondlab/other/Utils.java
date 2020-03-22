package ua.lviv.iot.secondlab.other;

import java.io.Serializable;
import java.util.*;
import java.util.Comparator;

import ua.lviv.iot.secondlab.models.Accessory;

public final class Utils {

	public static void sortByProducer(List<Accessory> products, boolean isDescending) {
		if (!isDescending) {
			products.sort(Comparator.comparing(Accessory::getProducer));
		} else {
			products.sort(Comparator.comparing(Accessory::getProducer).reversed());
		}
	}
	
	
	public static void sortById(List<Accessory> products, boolean isDescending) {
		if (!isDescending) {
			 products.sort((firstItem, secondItem) -> firstItem.getId() - secondItem.getId());
		} else {
			 products.sort((firstItem, secondItem) -> secondItem.getId() - firstItem.getId());
		}
	}
	
	public class ProductsSorterByName implements Comparator<Accessory> {
	    @Override
	    public int compare(Accessory firstItem, Accessory secondItem) {
	      return firstItem.getName().compareTo(secondItem.getName());
	    }
	  }

	  public static class ProductsSorterByPrice implements Comparator<Accessory>, Serializable {
	    private static final long serialVersionUID = 1L;

	    @Override
	    public int compare(Accessory firstItem, Accessory secondItem) {
	      return Float.compare(firstItem.getPrice(), secondItem.getPrice());
	    }
	  }
	  
	  public static void sortByWeight(List<Accessory> goods, boolean isDescending) {
		    Comparator<Accessory> comparator = new Comparator<Accessory>() {
		      @Override
		      public int compare(Accessory firstItem, Accessory secondItem) {
		        return Float.compare(firstItem.getWeight(), secondItem.getWeight());
		      }
		    };
		    goods.sort(isDescending ? comparator : comparator.reversed());
		  }

}
