package DefiningClasses.OpinionPoll;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> myList = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        while (n>0){
            String[] input = scanner.nextLine().split(" ");
            Person current = new Person();
            current.setName(input[0]);
            current.setAge(Integer.parseInt(input[1]));
            myList.add(current);
            n--;
        }
        myList.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
        for (int i = 0; i < myList.size(); i++) {
            Person current = myList.get(i);
            if(current.getAge() > 30){
                System.out.printf("%s - %d%n",current.getName(), current.getAge());
            }
        }
    }
}
