package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Adapter;

import java.util.ArrayList;
import java.util.List;

public class Recipes extends AppCompatActivity {

    RecyclerView recyclerView;
    List<FoodData> foodDataList;
    FoodData foodData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_recipes);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(Recipes.this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);

        foodDataList = new ArrayList<>();

        foodData = new FoodData("Chicken Biryani","Chicken Biryani is a delicious savory rice dish that is loaded with spicy marinated chicken, caramelized onions, and flavorful saffron rice.\n\n\nProcedure:\n\nStep 1 : Prepare saffron and kewra water\n" +
                "To make delightful chicken biryani, soak saffron in water to prepare saffron water. Next, mix kewra drops in water and mix well to make kewra water.\n\n"+
                "Step 2 : Saute onions and tomatoes for 2-3 minutes\n" +
                "In the meanwhile, heat refined oil in a deep bottomed pan. Once the oil is hot enough. Add cumin seeds, bay leaf, green cardamom, black cardamom, cloves in it, and saute for about a minute. Then, add chopped onion in it and saute until pink. Now, add chicken into it with slit green chillies, turmeric, salt to taste, ginger garlic paste, red chilli powder, and green chilli paste. Mix well all the spices and cook for 2-3 minutes. Then, add hung curd into it\n\n"+
                "Step 3 : Cook biryani on low heat for 5-6 minutes\n" +
                "Turn the flame to medium again and add garam masala in it along with ginger julienned, coriander and mint leaves. Add kewra water, rose water and saffron water in it. Cook till the chicken is tender.\n\n"+"" +
                "Step 4 : Serve hot chicken biryani with your favourite chutney or raita\n" +
                "Then add 1 cup cooked rice and spread evenly. Then add saffron water and pour ghee over it. Cook for 15-20 minutes with closed lid and garnish with 1 tbsp fried onions and coriander leaves. Serve hot chicken biryani.",R.drawable.chicken_biryani);
        foodDataList.add(foodData);

        foodData = new FoodData("Creamy Cashew Butter Paneer Masala","Paneer Butter Masala is a creamy and mildly sweet gravy made with butter, tomatoes, cashews, spices and paneer\n\n\nProcedure:\n\nStep 1 : Heat a large skillet over medium heat and add 1 tablespoon coconut oil (or ghee). Once hot, add the cubed paneer in batches and cook about 2 minutes per side or until crisp. Remove from the heat and drain on paper towels. Repeat with any remaining paneer. Reserve the skillet and set the paneer aside.\n\n"+"" +
                "Step 2 : To a food processor or high powered blender, add the cashews and coconut milk. Blend on high until completely smooth and silky, about 3-4 minutes. Add the tomato paste, yogurt and 1/2 cup water. Blend until smooth. Set aside.\n\n"+"" +
                "Step 3 : To the same skillet you fried the paneer, add the remaining tablespoon of oil. Once hot, add the onion, garlic and ginger, cook about 5-8 minutes or until the onion is soft and lightly caramelized. Add the curry powder, thai red curry paste, garam masala, turmeric, cayenne and salt. Cook one minute and then stir in the cashew/coconut mixture. Bring the sauce to a gentle boil and if it seems too thick for your liking, stir in water or coconut milk to thin. Once the sauce is at your desired consistency, stir in the crispy paneer and saffron if using. Add the broccoli and cook until warmed through and the sauce thickened slightly, about 5 minutes. Remove from the heat and serve over a bed of hot rice sprinkled with chopped cilantro. And don't forget the naan for dipping!",R.drawable.creamy_cashew_indian_butter_paneer);
        foodDataList.add(foodData);

        foodData = new FoodData("Indian Spiced Chickpea Flatbread","This socca recipe produces a wonderful savory chickpea flatbread that happens to be vegan and gluten free. It’s great for eating on its own or dipping into stews or curries.\n\n\nProcedure: Step 1 : In a medium bowl, whisk together the chickpea flour, water, 1 tablespoon plus 1 teaspoon olive oil, salt, ground coriander and turmeric.\n\n"+
                "Step 2 : Cover with plastic wrap and let the mixture rest at room temperature for at least 2 hours.\n\n"+
                "Step 3 : Preheat the broiler, with the rack set 7 to 8 inches from the element.\n\n"+
                "Step 4 : Heat 1 teaspoon of olive oil in a large nonstick skillet set over medium-high heat.\n\n"+
                "Step 5 : Add the onion and cook until starting to brown, about 2 minutes. Stir in the tomato and cook for 3 minutes. Add the garlic and cook for 30 seconds. Stir the vegetables into the chickpea flour batter.\n\n"+
                "Step 6 : Place a large (10-inch) cast iron skillet in the oven to preheat for 5 minutes.\n\n"+
                "Step 7 : Using an oven mitt or potholder, carefully remove the cast iron skillet from the oven. Pour in 1 tablespoon olive oil and swirl to coat the pan.\n\n" +
                "Step 8 : Pour in half of the batter and immediately swirl to coat the bottom of the pan.\n\n"+
                "Step 9 : Place under the broiler and cook until the top and edges are starting to blacken and blister, 4 to 6 minutes.\n\n" +
                "Step 10 : Carefully transfer the flatbread to a cutting board, cut into 8 wedges, garnish with cilantro and serve.\n\n" +
                "Step 11 : Repeat with the remaining 1 tablespoon olive oil, batter and cilantro.",R.drawable.indianspicedchickpeaflatbread);
        foodDataList.add(foodData);

        foodData = new FoodData("Homemade Naan","Our easy Naan recipe gives you perfectly textured, lightly charred, soft and chewy homemade Naan that is the perfect accompaniment to a saucy curry or lentil dal.\n\n\nProcedure:\n\nStep 1 : Activate the yeast: \nBriefly stir together the warm water and honey in the bowl of a stand mixer.  (Or see notes below about how to make the dough by hand.)  Sprinkle the yeast on top of the water and give it a quick stir, then let the mixture rest for 5-10 minutes until the yeast is foamy.\n\n"+
                "Step 2 : Mix the dough: \nAdd the flour, yogurt, salt, baking powder, and egg.  Using the dough attachment, mix the dough on medium-low speed for 2-3 minutes until smooth.  (The dough will still be slightly sticky, but should form into a ball that pulls away from the sides of the mixing bowl.  If it’s too sticky, add a bit more flour.)\n\n" +
                "Step 3 : Let the dough rise: \nRemove dough from the mixing bowl and use your hands to shape it into a ball.  Grease the mixing bowl (or a separate bowl) lightly with cooking spray, then place the dough ball back in the bowl and cover it with a damp towel.  Place the bowl in a warm location (I set mine by a sunny window) and let it rise for 1 hour until the dough has nearly doubled in size.\n\n" +
                "Step 4 : (Optional) Make the garlic butter: \nDuring the last 10 minutes of the dough’s rise time, heat the butter in a small sauté pan over medium heat until melted.  Add the garlic and cook for 1-2 minutes until fragrant.  Remove the pan from heat and stir in some chopped herbs, if desired.  (You can also strain out the garlic chunks if you prefer the garlic butter to be completely smooth.)\n\n" +
                "Step 5 : Roll out the dough: \nOnce the dough is ready to go, transfer it to a floured work surface and shape it into an even(ish) circle.  Cut the dough into 8 equally-sized wedges and roll each wedge into a ball with your hands.  Then use a rolling pin to roll out the dough ball until it forms an oval about 1/4-inch thick.  (I recommend multi-tasking this process — rolling out the next dough ball while you cook one on the stove.)\n\n" +
                "Step 6 : Cook the dough: \nHeat a large cast-iron skillet or non-stick sauté pan over medium-high heat until it is nice and hot.  Add a piece of the rolled-out dough to the pan and cook for 1 minute, or until the top of the dough begins to bubble and the bottom turns lightly golden.  Flip the dough and cook on the second side for 30-60 seconds, or until the bottom is golden as well, then transfer the dough to a clean plate.  (If you are making garlic naan, brush one or both side(s) of the dough with the garlic butter once the naan has cooked.)  Sprinkle the naan with a pinch of flaky sea salt, if desired. Then lightly cover the naan with a clean towel so that it stays warm.  Repeat with remaining dough until all of the naan pieces are cooked, adjusting the heat of the pan if needed to keep it hot (but not overly-hot so that it burns the bread).\n\n" +
                "Step 7 : Serve: \nServe warm and enjoy!",R.drawable.home_made_naan);
        foodDataList.add(foodData);

        foodData = new FoodData("Instant Pot Butter Shrimp","This Instant Pot Indian Butter Shrimp recipe allows you to have restaurant quality Indian food at home. Cooking this meal in the Instant Pot produces so much flavor. The smell is amazing. Serve over some Basmati or Jasmine rice to soak up all of the creamy, delicious sauce.\n\n\nProcedure: \n\nStep 1 : In a medium bowl, mix together yogurt, cumin, paprika, garam masala, lime juice, salt, ginger and garlic to make marinade. Stir in shrimp. Refrigerate for 15 minutes to 1 hour.\n\n" +
                "Step 2 : While shrimp are marinating, prepare the sauce. Turn Instant Pot to \"saute\" and add 2 tablespoons butter.\n\n" +
                "Step 3 : Once butter has melted, add shallots and a pinch of salt. Cook until golden brown, 4 to 6 minutes.\n\n" +
                "Step 4 : Stir in garlic, ginger, red pepper flakes, and 1/4 teaspoon salt and cook another 1 to 2 minutes.\n\n" +
                "Step 5 : Stir in tomatoes and their juice, heavy cream, and another pinch of salt. Bring mixture to a boil. Then cover and set on high pressure for 8 minutes. Make sure valve is turned to \"sealing\". Release the pressure maunally. When pin drops, remove the lid.\n\n" +
                "Step 6 : Turn on \"saute\" mode and simmer the sauce to thicken, about 4 to 7 minutes.\n\n" +
                "Step 7 : Stir in the shrimp and marinade, the remaining 2 tablespoons butter, and the lime zest and cook 2 to 5 minutes, or until shrimp are pink, being careful not to overcook. They will continue to cook in the sauce once you remove them from the Instant Pot.\n\n" +
                "Step 8 : Serve with rice and cilantro.",R.drawable.instant_pot_butter_shrimp);
        foodDataList.add(foodData);

        foodData = new FoodData("German Chocolate Cake","This show stopping German chocolate cake has a gooey coconut and toasted pecan filling, a dark and super-moist chocolate cake, and deliciously creamy chocolate buttercream on top!\n\n\nProcedure:\n\nStep 1 : Preheat oven to 350°. Line three 9” cake pans with parchment and grease with cooking spray. In a large bowl, whisk together flour, cocoa powder, salt, baking soda, and baking powder. \n\n" +
                "Step 2 : In another large bowl, whisk together vegetable oil, sugars, and eggs and whisk until incorporated, then add melted chocolate and vanilla and whisk until incorporated. Add chocolate mixture, buttermilk, and coffee to dry ingredients and mix just until combined.\n\n" +
                "Step 3 : Divide batter evenly between prepared cake pans and bake until a toothpick inserted in the middle comes out clean, about 20 minutes. Let cakes cool 10 minutes, then invert onto a wire baking rack and cool completely. \n\n" +
                "Step 4 : Meanwhile, make filling: Spread coconut and pecans onto 2 separate baking sheets. Toast in a 350° oven until coconut is golden and pecans are darkened and smell nutty, stirring halfway through. Coconut will take 10 to 12 minutes and pecans will need 15 to 18 minutes. Combine into a large bowl. \n\n" +
                "Step 5 : In a medium saucepan over medium heat, combine evaporated milk, egg yolks, sugar, and salt. Whisk until thickened, 8 to 10 minutes. Sauce should be able to coat the back of a wooden spoon and not run when a finger is swiped through it. Remove from heat and stir in butter and vanilla until incorporated. Pour over pecans and coconut and stir to coat. Let cool completely. Sauce will continue to thicken as it cools. \n\n" +
                "Step 6 : Make ganache: Place chocolate chips into a heat safe bowl. In a small saucepan over medium heat, warm heavy cream until bubbles form around the edges. Pour heavy cream over chocolate chips and let sit 1 minute, then whisk until smooth. Let cool until ganache is thick enough to spread, at least 30 minutes. \n\n" +
                "Step 7 : Assemble cake: Place one layer of cake onto a cake stand or serving platter. Spread ⅓ of ganache on top and then spread ⅓ of coconut filling on top. Top with a second layer of cake and repeat with remaining ganache, coconut filling, and cake.",R.drawable.delish_german_chocolate_cake);
        foodDataList.add(foodData);

        foodData = new FoodData("Birthday Cake","For a festive occasion, few treats can match the celebratory spirit of a classic birthday cake—and this easy-to-follow formula is the only one you’ll ever need. Our birthday cake recipe yields two dense layers of buttery, vanilla-forward white cake wrapped in classically rich buttercream frosting. For the signature, picture perfect birthday cake look, don’t forget to garnish your frosted cake with rainbow sprinkles.  \n\n\n Procedure:  \n\nStep 1 :   Make cake: Preheat oven to 350° and line three 8\" cake pans with parchment paper.\n\n" +
                "Step 2 :   In a large bowl using hand mixer (or in the bowl of a stand mixer), beat together butter and sugar until light and fluffy. Add eggs one at a time, beating well after each addition. Add vanilla and mix until combined.\n\n" +
                "Step 3 :   In another large bowl, whisk together flour, cornstarch, baking powder, and salt. Add half of the dry ingredients to the wet ingredients, beating until just combined. Pour in the milk and mix until fully incorporated. Add remaining dry ingredients and stir until just combined. Fold in sprinkles.\n\n" +
                "Step 4 :   Divide batter evenly between prepared cake pans. Bake until slightly golden on top and a toothpick inserted into the middle comes out clean, about 30 to 35 minutes. Let cool completely.\n\n" +
                "Step 5 :   Meanwhile, make buttercream: in a large bowl using a hand mixer, beat butter until light and fluffy, 2 to 3 minutes. Add powdered sugar, sour cream, vanilla, heavy cream, and salt and beat until smooth.\n\n" +
                "Step 6 :   Assemble cake: Place the bottom layer of the cake on your serving platter and spread with buttercream; repeat with the second layer of cake. Place the last layer of cake on top, then frost the entire cake with buttercream. Garnish with more sprinkles, if desired.",R.drawable.birthday_cake);
        foodDataList.add(foodData);

        foodData = new FoodData("Strawberry Cake","Fresh Strawberry Cake with strawberry cream cheese frosting is here to give us a reason to celebrate each and every day.\n\n\nProcedure:\n\nStep 1 : In a food processor, puree strawberries then add to a small saucepan with sugar and lemon juice. Place over medium low heat. Cook, stirring often, until thickened and reduce by about half, about 20 minutes. You should have about 1½ cups of strawberry compote. Remove from heat and let cool completely.\n\n" +
                "Step 2 : Preheat oven to 350° and grease and line two 8” round cake pans. In a large bowl, whisk together flour, cornstarch, baking powder, baking soda, and salt. \n\n" +
                "Step 3 : In another large bowl, with a hand mixer, beat together butter and sugar until light and fluffy. Add eggs, one at a time, beating well after each addition. Beat in strawberry compote and vanilla until fully incorporated, then add milk. Add dry ingredients, mixing until just combined. (If you want a super pink cake, stir in some pink food coloring.)\n\n" +
                "Step 4 : Divide batter evenly into prepared pans and bake until a toothpick inserted into the middle of each comes out clean, 25 minutes. Let cakes cool for 15 minutes then invert onto cooling racks to cool completely. \n\n" +
                "Step 5 : Make frosting: In a large bowl using a hand mixer, beat cream cheese and butter until no lumps remain, then beat in strawberry compote. Add powdered sugar and beat until fully incorporated. Add vanilla and a pinch of salt. If your frosting is too loose, refrigerate for 20 minutes before frosting the cake. \n\n" +
                "Step 6 : Spread a thick layer of frosting on top of one cake layer. Top with second layer of cake, then frost all over sides and top. Garnish with fresh strawberries, if using. ",R.drawable.strawberry_cake);
        foodDataList.add(foodData);

        MyAdapter myAdapter = new MyAdapter(Recipes.this, foodDataList);
        recyclerView.setAdapter(myAdapter);

    }
}