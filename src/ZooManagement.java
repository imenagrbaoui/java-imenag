import java.util.Scanner;

public class ZooManagement {

    public static void main(String[] args) {
     /*   int nbrCages=20;
        String zooName="my Zoo";

        System.out.println(" Le Zoo "+zooName+" est composé de "+nbrCages+" cages");
*/
        Scanner sc = new Scanner(System.in);

        System.out.println("Veuillez entrer le nom du zoo");
        String zooName = sc.nextLine();

        // Instruction 14 : nbrCages est désormais une constante fixée à 25
        // dans la classe Zoo -> on ne la demande plus à l'utilisateur.
        System.out.println(" Le Zoo " + zooName + " est composé de " + Zoo.MAX_CAGES + " cages");


        Zoo myZoo = new Zoo(zooName, "Ariana");

        Animal lion = new Animal("Félins", "Lion", 5, true);
        Animal aigle = new Animal("Rapaces", "Aigle royal", 3, false);
        Animal serpent = new Animal("Reptiles", "Python", 2, false);

        // ----- Instruction 10 : ajout d'animaux -----
        System.out.println("\n--- Ajout d'animaux ---");
        System.out.println("Ajout du lion : " + myZoo.addAnimal(lion));
        System.out.println("Ajout de l'aigle : " + myZoo.addAnimal(aigle));
        System.out.println("Ajout du serpent : " + myZoo.addAnimal(serpent));

        // ----- Instruction 11.1 : affichage de tous les animaux -----
        System.out.println("\n--- Liste des animaux du zoo ---");
        myZoo.displayAnimals();

        // ----- Instruction 11.2 : recherche d'un animal -----
        System.out.println("\n--- Recherche d'animaux ---");
        int indexLion = myZoo.searchAnimal(lion);
        System.out.println("Index du lion : " + indexLion); // doit être trouvé (0)

        Animal lionBis = new Animal("Félins", "Lion", 5, true); // même nom que "lion"
        int indexLionBis = myZoo.searchAnimal(lionBis);
        System.out.println("Index du lion bis (objet différent, même nom) : " + indexLionBis);
        // -> Même si lionBis est un objet différent en mémoire, la recherche se fait
        //    par nom, donc il est "trouvé" au même index que lion.

        // ----- Instruction 12 : unicité -----
        System.out.println("\n--- Test d'unicité ---");
        boolean ajoutDoublon = myZoo.addAnimal(lionBis);
        System.out.println("Ajout du lion bis (doublon) réussi ? " + ajoutDoublon); // false attendu

        // ----- Instruction 10 (suite) : test de la capacité maximale -----
        System.out.println("\n--- Remplissage du zoo jusqu'à la capacité max ---");
        for (int i = myZoo.getNbAnimals(); i < Zoo.MAX_CAGES + 1; i++) {
            Animal a = new Animal("Famille" + i, "Animal" + i, i % 20, i % 2 == 0);
            boolean ajoute = myZoo.addAnimal(a);
            if (!ajoute) {
                System.out.println("Impossible d'ajouter Animal" + i + " : le zoo est plein.");
            }
        }
        System.out.println("Le zoo est-il plein ? " + myZoo.isZooFull());
        System.out.println("Nombre d'animaux dans le zoo : " + myZoo.getNbAnimals());

        // ----- Instruction 13 : suppression d'un animal -----
        System.out.println("\n--- Suppression du serpent ---");
        boolean suppression = myZoo.removeAnimal(serpent);
        System.out.println("Suppression réussie ? " + suppression);
        System.out.println("Nombre d'animaux après suppression : " + myZoo.getNbAnimals());

        boolean suppressionInexistant = myZoo.removeAnimal(new Animal("X", "Inconnu", 1, false));
        System.out.println("Suppression d'un animal inexistant réussie ? " + suppressionInexistant);

        // ----- Instruction 8 / 9 : affichage général -----
        System.out.println("\n--- Résumé du zoo ---");
        myZoo.displayZoo();
        System.out.println(myZoo);

        // ----- Instruction 15.2 : comparaison de deux zoos -----
        System.out.println("\n--- Comparaison de deux zoos ---");
        Zoo autreZoo = new Zoo("Zoo Voisin", "Tunis");
        autreZoo.addAnimal(new Animal("Félins", "Tigre", 4, true));

        Zoo zooLePlusGrand = Zoo.comparerZoo(myZoo, autreZoo);
        System.out.println("Le zoo avec le plus d'animaux est : " + zooLePlusGrand.getName()
                + " (" + zooLePlusGrand.getNbAnimals() + " animaux)");

        sc.close();
    }

}