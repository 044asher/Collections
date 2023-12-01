package PracticalPart.Task4;

import java.util.HashMap;
import java.util.Scanner;
import java.util.HashSet;

public class Task4 {
    public static void main(String[] args) {
        HashMap<String, String> carOwners = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("Введите гос. номер для добавления. Введите 'СТОП' для завершения или 'СПИСОК' для просмотра номеров ");
            String text = sc.nextLine();
            
            if(text.equalsIgnoreCase("Стоп")){
                break;
            } else if (text.equalsIgnoreCase("Список")) {
                System.out.println("Список автомобилей и владельцев: " + carOwners);
            } else if (text.equalsIgnoreCase("Автомобили")) {
                System.out.println(carOwners.keySet());
            }
            else if (text.equalsIgnoreCase("Владельцы")){
                System.out.println(new HashSet<>(carOwners.values()));
            }
            else {
                System.out.println("Введите имя владельца: ");
                String owner = sc.nextLine();
                carOwners.put(text, owner);
            }
        }
        sc.close();
    }
}
