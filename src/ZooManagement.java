package main;

import entities.Animal;
import entities.Zoo;

public class ZooManagement {
    public static void main(String[] args) {
        Zoo myZoo = new Zoo("Belvédère", "Tunis");
        Animal lion = new Animal("Felidae", "Simba", 5, true);

        myZoo.addAnimal(lion);
        myZoo.displayZoo();

        lion.setAge(-3);
        myZoo.setName("   ");

        for (int i = 0; i < 30; i++) {
            myZoo.addAnimal(new Animal("Test", "Animal" + i, i, true));
        }
        System.out.println("Zoo plein ? " + myZoo.isZooFull());
    }
}