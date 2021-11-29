package drivers;

import com.revature;

import io.javalin.Javalin;

public class Driver {
	static Pet[] pets;
	static int currentIndex;

	public static void main(String[] args) {
		currentIndex = 0;
		favPet = new favPet[10]; // initializing the pets array

		Javalin app = Javalin.create();

		app.start();

		app.post("/favoritePets", ctx -> {

			Pet pet = new Pet();
			pet.id = ctx.formParam("id");
			pet.species = ctx.formParam("species");
			pet.description = ctx.formParam("description");
			pet.age = Integer.parseInt(ctx.formParam("age"));

			pets[currentIndex] = pet;
			currentIndex++;

			String responseText = "";

			for (Pet eachPet : pets) {
				System.out.println(eachPet);
				if (eachPet != null) {
					responseText += eachPet.name + "<br>";
				}
			}

			ctx.html(responseText);
		});
	}
}