
interface Animal{
    void eat();
    void travel();
}

class Mammal implements Animal{
    public void eat(){
        System.out.println("Mammal eats");
    }
    public void travel(){
        System.out.println("Mammal travels");
    }
}

public class AnimalBehavior{
    public static void main(String[] args) {
        Mammal mal = new Mammal();
        mal.eat();
        mal.travel();
    }
}

