package DefiningClasses.OpinionPoll;



//Create Person class with two fields String name and int age, write a program that reads from the console N lines of
//personal information and then prints all people whose age is more than 30 years, sorted in alphabetical order.
//Note: you can use stream() to filter people.
public class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
