public class classObjects{

    public static class Person{
        int age;
        String name;

        public void saysHi(){
            System.out.println("Name" +" : " + name +", " + "Age : " + age);
        }

        //default constructor
        Person(){

        }

        //parameterized constructor
        Person(int age, String name){
            this.age = age;
            this.name = name;

        }

    } 

    public static void main(String args[]){
        Person p1 = new Person();
        p1.age = 10;
        p1.name = "Prince";
        p1.saysHi();

        Person p2 = new Person();
        p2.age = 23;
        p2.name = "Kumar";
        p2.saysHi();

        Person p3 = new Person(45, "Kumari");
        p3.saysHi();

    }
}