

import java.util.Comparator;

public class Fruit implements Comparable<Fruit>{
	
	public static final Comparator<Fruit> BY_COLOUR  = new Fruit.ByColour();
	public static final Comparator<Fruit> BY_WEIGHT  = new Fruit.ByWeight();
	
	private String name;
	private String colour;
	private int weight;
	private int size;
	
	public Fruit(String name, String colour, int weight, int size) {
		this.name = name;
		this.colour = colour;
		this.weight = weight;
		this.size = size;
	}

	@Override
	public String toString() {
		return "Name: "+name+" Colour: "+colour+" Weight: "+weight+" Size: "+ size;
		
	}
	
	
	public int compareTo(Fruit otherFruit) {
		return this.size - otherFruit.size;
	}
	
	private static class ByWeight implements Comparator<Fruit>{
		@Override
		public int compare(Fruit fruit1, Fruit fruit2) {
			return fruit1.weight-fruit2.weight;
		}	
	}
	
	private static class ByColour implements Comparator<Fruit>{
		@Override
		public int compare(Fruit fruit1, Fruit fruit2) {
			return fruit1.colour.compareToIgnoreCase(fruit2.colour);
		}
	}
	
	public String getName() {
		return name;
	}
	
	public String getColour() {
		return colour;
	}
	
	//Comparator<Fruit> c = Comparator.comparing(Fruit::getName).thenComparing(Fruit::getColour);
	
	
	
	
	
	

}
