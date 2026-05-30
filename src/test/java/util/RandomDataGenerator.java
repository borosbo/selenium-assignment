package util;

import java.util.UUID;
import java.util.Random;

public class RandomDataGenerator {

    private static final Random random = new Random();

    public static String randomAdTitle() {
        String[] items = {"GPU", "CPU", "Monitor", "Laptop", "SSD", "RAM"};
        String[] adj = {"Teszt", "Selenium", "Automatizált"};
        return items[random.nextInt(items.length)] + " - "
             + adj[random.nextInt(adj.length)] + " hirdetés";
    }

    public static String randomDescription() {
        return "Teszt leírás, generált adat: " + UUID.randomUUID().toString().substring(0, 8);
    }

    public static String randomPrice() {
        return String.valueOf(10000 + random.nextInt(990000));
    }

    public static String randomCategory(){
        String[] categories = {"Hardver", "Notebook", "Konzol", "Egyéb"};
        return categories[random.nextInt(categories.length)];
    }
}
