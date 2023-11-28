package Examples;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class MenuItem{
    public void serve(){
        System.out.println("Strange Item from Menu served.");
    }
}
class Food extends MenuItem{
    public void serveFood(){
        System.out.println("Food served.");
    }
}
class Meat extends Food{
    public void serveMeat(){
        System.out.println("Meat served.");
    }
}
class Soup extends Food{
    public void serveSoup(){
        System.out.println("Soup served.");
    }
}

public class Wildcards {
    public static void iterateFood(Collection<? extends MenuItem> items){
        for (MenuItem item: items){
            System.out.println("served");
        }
    }
    public static void iterateNotSoup(Collection<? super Meat> notSoupItems){
        for (int i = 0; i < notSoupItems.size(); i++){
            System.out.println("Not Soup Served!");
        }
    }

    public static void main(String[] args) {
        List<Meat> meats = new ArrayList<>();
        meats.add(new Meat());
        meats.add(new Meat());

        iterateFood(meats);
        System.out.println();

        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem());
        menuItems.add(new MenuItem());

        iterateFood(menuItems);

        List<Soup> soups = new ArrayList<>();
        soups.add(new Soup());
        soups.add(new Soup());

        iterateFood(soups);


        //iterateNotSoup(soups);
        iterateNotSoup(meats);
        iterateNotSoup(menuItems);
    }
}
