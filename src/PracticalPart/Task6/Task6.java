package PracticalPart.Task6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class User implements Comparable<User>{
    int id;
    String firstName;
    String lastName;
    int age;
    public User(int id, String firstName, String lastName, int age){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    @Override
    public int compareTo(User o) {
        return Integer.compare(this.id, o.id);
    }
    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
class UserComparator implements Comparator<User>{

    @Override
    public int compare(User o1, User o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }
}

public class Task6 {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(7, "John", "Doe", 24));
        users.add(new User(1, "Lady", "Gaga", 21));
        users.add(new User(8, "Arthur", "Morgan", 40));
        users.add(new User(4, "John", "Marston", 36));
        users.add(new User(2, "Dutch", "Van Der Linde", 55));
        users.add(new User(9, "Sadie", "Adler", 36));
        users.add(new User(5, "Micah", "Bell", 45));
        users.add(new User(6, "Barack", "Obama", 50));
        users.add(new User(10, "Joe", "Baden", 70));
        users.add(new User(3, "Albert", "Einstein", 82));

        System.out.println("List before sorting: ");
        for (User user : users){
            System.out.println(user);
        }
        Collections.sort(users);

//        System.out.println("\nList after sorting: ");
//        for (User user: users){
//            System.out.println(user);
//        }



//        Collections.sort(users, new UserComparator());
//
//        System.out.println("\nList after sorting: ");
//        for (User user: users){
//            System.out.println(user);
//        }



//        Collections.sort(users, Comparator.comparing(User::getId));
//
//        System.out.println("\nList after sorting: ");
//        for (User user: users){
//            System.out.println(user);
//        }

    }
}
