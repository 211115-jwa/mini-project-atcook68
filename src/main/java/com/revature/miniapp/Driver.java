package com.revature.miniapp;

import io.javalin.Javalin;

public class Driver {
	static Collection[] pet;
	static int currentIndex;

	public static void main(String[] args) {
		currentIndex = 0;
		pet = new Collection[10];

		Javalin app = Javalin.create();
		app.start(8080);

		app.post("/favoritePets", ctx -> {

			Collection pet = new Collection();

//			pet.id = ctx.formParam("id");
			pet.name = ctx.formParam("name");
//			pet.age = Integer.parseInt(ctx.formParam("age"));
			pet.breed = ctx.formParam("breed");
			pet.species = ctx.formParam("species");
			pet.color = ctx.formParam("color");
			pet.favFood = ctx.formParam("favFood");
//			pet.numOfLegs = ctx.formParam("numOfLegs");

			pet[currentIndex] = pet;
			currentIndex++;

			String responseText = " ";

			for (Collection eachPet : pet) {
				System.out.println(eachPet);
				if (eachPet != null) {
					responseText += eachPet.name + "<br>";
				}
			}

			ctx.html(responseText);
		});
	}
	}
