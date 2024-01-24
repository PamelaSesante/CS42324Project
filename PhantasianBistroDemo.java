package phantasianbistrodemo;

import java.util.ArrayList;

public class PhantasianBistroDemo {

    public static void main(String[] args) {
        
        Tile grass = new Tile("Grass", false);
        Tile dirt = new Tile("Dirt", false);
        Tile water = new Tile("Water", true);
        
        Item wood = new Item("Wood", "A classic building material.", "Common", 2);
        Item stone = new Item("Stone", "Heavy and sturdy. Another classic building material", "Common", 3);
        Item sakuraBloom = new Item("Sakura Blooms", "A gorgeous pink flower that fits in the palm of your hand.", "Common", 2);
        Item book = new Item("Book", "It's filled with various formulas and equations.", "Common", 10);
        
        Weapon woodSword = new Weapon("Wooden Sword", "The most basic weapon any adventurer should have.", "Common", 10, 0, 1);
        Weapon stoneSword = new Weapon("Stone Sword", "A bit sturdier than a wood sword.", "Common.", 20, 1, 3);
        Weapon dagger = new Weapon("Dagger", "Small and light, ideal for swift attacks.", "Common", 15, 0, 2);
        Weapon mace = new Weapon("Mace", "A bit heavy but can definitely help in many battles.", "Uncommon", 40, 3, 8);
      
        Food tomato = new Food("Tomato","A plump and juicy red fruit, perfect for enhancing the flavor of salads or crafting savory dishes.","Common",6,20,10);
        Food bread = new Food("Bread", "A staple carbohydrate, ideal for crafting sandwiches or served alongside other dishes to complete a satisfying meal.", "Common", 8,20,10);
        Food lettuce = new Food("Lettuce", "Crisp and leafy greens that add a refreshing crunch to salads or act as a crisp bed for various culinary creations.", "Common", 6,20,10);
        Food rice = new Food("Rice","Tiny grains that serve as a versatile base for a myriad of dishes, from stir-fries to sushi.", "Common", 8,25,15); // add components later
        Food seaweed = new Food("Seaweed", "An aquatic plant that adds a unique oceanic flavor, often used in sushi rolls or as a savory garnish.", "Common", 6,20,10);
        Food fish = new Food ("Fish", "Freshly caught aquatic creatures that can be cooked in various ways to create flavorful and nutritious dishes.", "Uncommon", 15,30,20);
        Food cheese = new Food ("Cheese", "A dairy product with diverse textures and flavors, perfect for melting, grating, or enjoying on its own.", "Uncommon", 15,30,20);
        Food pasta = new Food("Pasta", "Versatile dough-based creations that come in various shapes, offering a satisfying foundation for a multitude of sauces.", "Uncommon", 16,35,25);
        Food pineapple = new Food("Pineapple", "A tropical fruit that adds a sweet and tangy twist to both savory and dessert dishes.", "Common", 6,20,10);
        Food sweetberry = new Food("Sweetberry", "A small, sweet fruit that can be used in desserts, jams, or as a flavorful topping.", "Common", 6,20,10);
        Food strawberry = new Food("Strawberry", "Juicy red berries that bring a burst of sweetness to desserts, salads, and breakfast dishes.", "Common", 6,20,10);
        Food sugar = new Food("Sugar", "A sweetening agent that enhances the flavor of baked goods, beverages, and various culinary delights.", "Uncommon", 20,40,20);
        Food egg = new Food("Egg", "A versatile ingredient that can be boiled, fried, or used in baking, adding richness and texture to a variety of dishes.", "Uncommon", 16,30,25);
        Food flour = new Food("Flour", "A fundamental ingredient in baking, this finely ground powder serves as the base for a wide range of delicious treats.", "Uncommon", 16,30,25);
        Food meat = new Food("Meat", "Sourced from various creatures, this protein-rich ingredient can be grilled, roasted, or stewed to create hearty meals.", "Uncommon", 16,30,25);
        
        
        Food dango = new Food("Dango", "A delightful skewer of sweet rice dumplings. Truly a charming and whimsical treat.", "Common", 45, 50, 40, new ArrayList<>() {{
            add(new Object[]{rice, 3});
            add(new Object[]{sugar, 1});
        }});
        Food spaghetti = new Food("Spaghetti", "A classic dish of long, twirlable noodles coated in a savory tomato-based sauce, providing a hearty and comforting meal for adventurers.", "Uncommon", 70, 70, 65, new ArrayList<>() {{
            add(new Object[]{pasta, 1});
            add(new Object[]{tomato, 3});
            add(new Object[]{meat, 2});
            add(new Object[]{cheese, 1});
        }});
        Food berrySweetPlatter = new Food("Berry Sweet Platter", "A vibrant arrangement of assorted berries, providing a visually appealing and refreshing snack.", "Common", 40, 40, 35, new ArrayList<>() {{
            add(new Object[]{sweetberry, 2});
            add(new Object[]{strawberry, 2});
            add(new Object[]{pineapple, 1});
        }});
        Food strawberryShortcake = new Food("Strawberry Shortcake", "A delectable dessert featuring layers of sponge cake, fresh strawberries, and whipped cream, offering a deliciously indulgent health boost.", "Uncommon", 70, 70, 65, new ArrayList<>() {{
            add(new Object[]{flour, 1});
            add(new Object[]{sugar, 2});
            add(new Object[]{strawberry, 4});
            add(new Object[]{egg, 2});
        }});
        Food sushi = new Food("Sushi", "A meticulously crafted assortment of bite-sized rice and fresh fish.", "Unommon", 70, 70, 65, new ArrayList<>() {{
            add(new Object[]{rice, 3});
            add(new Object[]{fish, 3});
            add(new Object[]{seaweed, 3});
        }});
        Food burger = new Food("Burger", "A satisfying stack of grilled meat, lettuce, cheese, and other fixings between soft buns, providing a robust and energizing meal.", "Rare", 100, 80, 85, new ArrayList<>() {{
            add(new Object[]{bread, 2});
            add(new Object[]{meat, 1});
            add(new Object[]{lettuce, 1});
            add(new Object[]{cheese, 1});
            add(new Object[]{tomato, 2});
        }});
        
        NPC mitsuri = new NPC("Mitsuri", 0, 0, 
                "Today feels like a nice day for training!", 
                "Hmm... should I get some cake? Or maybe dango? Oh, I can't choose!", 
                "Hey there!", 
                "Woah! Thanks a lot for this! I'll be sure to cherish it!", 
                "Uh... thanks? I-I'm sorry this is a nice gift but I don't know how to feel about it.", 
                "Oh, thank you.",
                wood, 
                sakuraBloom);
        
        NPC yvian = new NPC("Yvian", 0, 0, 
                "I need to finish my thesis.", 
                "What do you want?", 
                "Make it quick.", 
                "This is actually useful.", 
                "Wow. This is useless.", 
                "Could be worse.",
                stone, 
                book);
        
        NPC synthie = new NPC("Synthie", 0, 0, 
                "Heya, seen any monsters around? How about some bounty posters?", 
                "I hope I can get commissions soon.", 
                "Be careful around these parts. You should go home before night comes.", 
                "How'd you know this is my favorite? Thanks chef!", 
                "Why would you give this... thing to me?", 
                "I can probably make something out of this.",
                stone, 
                spaghetti);
        
        Player pam = new Player("Pam", 0,0, stoneSword);
        
        // Scenario 1
        pam.inventory.put(wood ,1 );
        pam.inventory.put(sakuraBloom ,1 );
        pam.inventory.put(spaghetti ,1 );
        pam.inventory.put(woodSword ,1 );
        
        System.out.println("SCENARIO 1: Talking to an NPC and gifting them something");
        pam.interact(mitsuri); // The line which the NPC says is randomized every time
        System.out.println(mitsuri.getFriendship()); // +10 Friendship
        pam.gift(mitsuri, wood); // disliked gift, -20 friendship
        System.out.println(mitsuri.getFriendship()); 
        pam.gift(mitsuri, sakuraBloom); // liked gift, +20 friendship
        System.out.println(mitsuri.getFriendship());
        pam.gift(mitsuri, spaghetti); // neutral gift, +5 friendship
        System.out.println(mitsuri.getFriendship());
        pam.gift(mitsuri, dango); // no gift
        System.out.println(mitsuri.getFriendship());
        pam.gift(mitsuri, woodSword); // cannot accept weapons as a gift
        System.out.println(mitsuri.getFriendship());
        
        // Scenario 2
        System.out.println("\nSCENARIO 2: cooking");
        pam.inventory.put(rice ,3);
        pam.inventory.put(sugar ,1 ); 
        
        //I: Trying to cook something that can only be gathered in The Forest
        pam.cook(pineapple);
        pam.printInventory(); //Sugar 1, rice 3     
        //II: Cooking with enough ingredients 
        pam.cook(dango);
        pam.printInventory(); // Removed sugar and rice since values are 0, added dango 1       
        //III: Cooking with incomplete ingredients 
        pam.cook(dango);
        pam.printInventory(); 

        // Scenario 3: NPCs ordering random quantities of food items
        System.out.println("\nSCENARIO 3: NPCs ordering and completing the orders");
        pam.inventory.put(tomato ,3 );
        pam.inventory.put(bread,3 );
        pam.inventory.put(strawberry,3 );
        pam.inventory.put(dango ,3 );
        pam.inventory.put(burger ,3 );
        pam.inventory.put(sushi ,3 );
        pam.inventory.put(rice ,3 );
        pam.inventory.put(seaweed,3 );
        pam.inventory.put(fish,3 );
        pam.inventory.put(spaghetti ,3 );
        pam.inventory.put(strawberryShortcake,3 );
        pam.inventory.put(berrySweetPlatter,3 );
        
        mitsuri.placeOrder();
        mitsuri.placeOrder();
        synthie.placeOrder();
        synthie.placeOrder();
        yvian.placeOrder();
        yvian.placeOrder();
        
        System.out.println("Completing Mitsuri's orders");
        pam.completeOrder(mitsuri, 1);
        pam.completeOrder(mitsuri, 2);
        mitsuri.printOrderList(); // prints uncompleted orders if there is any
        
        System.out.println("Completing Synthie's orders");
        pam.completeOrder(synthie, 1);
        pam.completeOrder(synthie, 2);
        synthie.printOrderList();
        
        System.out.println("Completing Yvian's orders");
        pam.completeOrder(yvian, 1);
        pam.completeOrder(yvian, 2);
        pam.completeOrder(yvian, 5); //Trying to search for order that doesn't exist
        yvian.printOrderList();
    }
    
}
