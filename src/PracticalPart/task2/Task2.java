package PracticalPart.task2;

import java.util.LinkedList;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        LinkedList<String> carNumbersList = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        for(;;){
            System.out.println("Введите гос. номер для добавления. Введите 'СТОП' для завершения или 'СПИСОК' для просмотра номеров ");
            String text = sc.nextLine();

            if(text.equalsIgnoreCase("стоп")){
                break;
            } else if (text.equalsIgnoreCase("Список")) {
                System.out.println("Список автомобилей: " + carNumbersList);
            }
            else {
                System.out.println("Введите номер позиции: ");
                int position = sc.nextInt();
                sc.nextLine();

                if(position >= carNumbersList.size()){
                    carNumbersList.add(text);
                }
                else {
                    carNumbersList.add(position, text);
                }
            }
        }
        sc.close();
    }
}
