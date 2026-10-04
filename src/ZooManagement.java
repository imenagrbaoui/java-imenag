import java.util.Scanner;

public class ZooManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Veuillez entrer le nom du zoo");
        String zooName = sc.nextLine();

        int nbrCages;

        do {
            System.out.println("Entrez le nombre de cages :");
            nbrCages = sc.nextInt();
        } while (nbrCages <= 0);

        System.out.println("Le Zoo " + zooName + " est composé de " + nbrCages + " cages");

        Animal lion = new Animal("Félins", "Lion", 5, true);
        Animal aigle = new Animal("Rapaces", "Aigle royal", 3, false);
        Animal serpent = new Animal("Reptiles", "Python", 2, false);

        Zoo myZoo = new Zoo(zooName, "Ariana", nbrCages);

        myZoo.addAnimal(lion);
        myZoo.addAnimal(aigle);
        myZoo.addAnimal(serpent);

        myZoo.displayZoo();

        System.out.println("----------------------------------------");

        System.out.println(myZoo);
        System.out.println(lion);
        System.out.println(aigle);
        System.out.println(serpent);
    }
}