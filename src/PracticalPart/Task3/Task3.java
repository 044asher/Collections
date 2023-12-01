package PracticalPart.Task3;

import java.util.HashSet;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        HashSet<String> carNumbersList = new HashSet<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите гос. номер для добавления. Введите 'СТОП' для завершения или 'СПИСОК' для просмотра номеров ");

        while(true){
            String text = sc.nextLine();

            if(text.equalsIgnoreCase("Стоп")){
                break;
            } else if (text.equalsIgnoreCase("Список")) {
                System.out.println("Список автомобилей: " + carNumbersList);
            }
            else {
                carNumbersList.add(text);
            }
        }
        sc.close();
    }
}
