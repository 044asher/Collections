package PracticalPart.task1;


import java.util.ArrayList;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        ArrayList<String> carNumbersList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите гос. номер для добавления. Введите 'СТОП' для завершения или 'СПИСОК' для просмотра номеров ");

        for(;;){
            String text = sc.nextLine();
            if(text.equalsIgnoreCase("Список")){
                System.out.println("Список автомобилей: " + carNumbersList);
            } else if (text.equalsIgnoreCase("Стоп")) {
                break;
            }
            else carNumbersList.add(text);
        }
        sc.close();
    }
}
