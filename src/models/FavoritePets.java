package models;
import java.util.*;

public class FavoritePet {

	public int id;
	public String name;
	public int age;
	public String breed;
	public String species;
	public String color;
	public String favFood;
	public String sex;
	public int numOfLegs;
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(age, breed, color, favFood, id, name, numOfLegs, sex, species);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FavoritePets other = (FavoritePets) obj;
		return age == other.age && Objects.equals(breed, other.breed) && Objects.equals(color, other.color)
				&& Objects.equals(favFood, other.favFood) && id == other.id && Objects.equals(name, other.name)
				&& numOfLegs == other.numOfLegs && Objects.equals(sex, other.sex)
				&& Objects.equals(species, other.species);
	}
	
}
