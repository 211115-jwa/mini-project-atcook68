package com.revature;

import io.javalin.Javalin;

public class Driver {
	static Collection[] pets;
	static int currentIndex;
// Creating the driver which is housing the main method. 
	public static void main(String[] args) {	
		currentIndex = 0;
		pets = new Collection[10];
// Starting the Javalin application
		Javalin app = Javalin.create();
		app.start();
// Endpoint handlers. 
		app.post("/favoritePets", ctx -> {	// sends the favoritePets form to the website/server to accept.

			Collection pet = new Collection();
			pet.name = ctx.formParam("name");	//context, list all form parameters by name
			pet.age = Integer.parseInt(ctx.formParam("age"));	// listing the form by age (integer)
			pet.breed = ctx.formParam("breed");	//context, list all form parameters by breed

			// ctx.cookieStore(key, value);
			// Thinking of storing the pet information as a key value pair in cookies. Need more research.

			pets[currentIndex] = pet;
			currentIndex++;

			String responseText = " ";

			//	Listing the pet that was just input. On a single line
			for (Collection eachPet : pets) {
				System.out.println(eachPet);
				if (eachPet != null) {
					responseText = "<br>" + eachPet.name  + " " + eachPet.age  + " " + eachPet.breed + "<br>";	
				}
			}

			ctx.html(responseText);
		});
			//	Listing all of the pets that have been input. Each have their own line. 
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
