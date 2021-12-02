package com.revature;

import io.javalin.Javalin;

public class Driver {
	static Collection[] pets;
	static int currentIndex;

	public static void main(String[] args) {
		currentIndex = 0;
		pets = new Collection[10];

		Javalin app = Javalin.create();
		app.start();

		app.post("/favoritePets", ctx -> {

			Collection pet = new Collection();


			pet.name = ctx.formParam("name");
			pet.age = Integer.parseInt(ctx.formParam("age"));
			pet.breed = ctx.formParam("breed");



			pets[currentIndex] = pet;
			currentIndex++;

			String responseText = " ";

			for (Collection eachPet : pets) {
				System.out.println(eachPet);
				if (eachPet != null) {
					responseText = "<br>" + eachPet.name  + " " + eachPet.age  + " " + eachPet.breed + "<br>";	
				}
			}

			ctx.html(responseText);
		});
		app.get("/favoritePets", ctx -> {
			String responseText = " ";
				for (Collection eachPet : pets) {
					System.out.println(eachPet);
					if (eachPet != null) {
						responseText += "<br>" + eachPet.name  + " " + eachPet.age  + " " + eachPet.breed + "<br>";	
					}
		}
				ctx.html(responseText);

	});
	}}
