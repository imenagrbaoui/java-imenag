public class Zoo {

    // Instruction 14 : nombre maximum de cages fixé à 25 (constante)
    public static final int MAX_CAGES = 25;

    // Attributs
    private Animal[] animals; // tableau d'animaux, taille = MAX_CAGES
    private String name;
    private String city;
    private final int nbrCages; // devient constant, fixé via le constructeur
    private int nbAnimals = 0;  // compteur d'animaux réellement ajoutés

    // Constructeur par défaut
    public Zoo() {
        this.animals = new Animal[MAX_CAGES];
        this.nbrCages = MAX_CAGES;
    }

    // Constructeur paramétré (Instruction 6, adapté à l'Instruction 14)
    public Zoo(String name, String city) {
        this.name = name;
        this.city = city;
        this.animals = new Animal[MAX_CAGES];
        this.nbrCages = MAX_CAGES; // on applique la constante dans le constructeur
    }

    // Getters et setters
    public Animal[] getAnimals() {
        return animals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    // Plus de setter pour nbrCages : il est désormais constant
    public int getNbrCages() {
        return nbrCages;
    }

    public int getNbAnimals() {
        return nbAnimals;
    }

    // ---------- Instruction 10 : ajout d'un animal ----------
    public boolean addAnimal(Animal animal) {
        if (isZooFull()) {
            System.out.println("Échec : le zoo " + name + " est plein (" + nbrCages + " cages).");
            return false;
        }
        // Instruction 12 : unicité -> on refuse si l'animal est déjà présent
        if (searchAnimal(animal) != -1) {
            System.out.println("Échec : " + animal.getName() + " est déjà présent dans le zoo.");
            return false;
        }
        animals[nbAnimals] = animal;
        nbAnimals++;
        return true;
    }

    // ---------- Instruction 11.1 : affichage de tous les animaux ----------
    public void displayAnimals() {
        if (nbAnimals == 0) {
            System.out.println("Aucun animal dans le zoo.");
            return;
        }
        for (int i = 0; i < nbAnimals; i++) {
            System.out.println(animals[i]);
        }
    }

    // ---------- Instruction 11.2 : recherche d'un animal (par nom) ----------
    public int searchAnimal(Animal animal) {
        for (int i = 0; i < nbAnimals; i++) {
            if (animals[i].getName().equals(animal.getName())) {
                return i;
            }
        }
        return -1;
    }

    // ---------- Instruction 13 : suppression d'un animal ----------
    public boolean removeAnimal(Animal animal) {
        int index = searchAnimal(animal);
        if (index == -1) {
            return false;
        }
        // On décale les éléments suivants d'une case vers la gauche
        for (int i = index; i < nbAnimals - 1; i++) {
            animals[i] = animals[i + 1];
        }
        animals[nbAnimals - 1] = null;
        nbAnimals--;
        return true;
    }

    // ---------- Instruction 15.1 : le zoo est-il plein ? ----------
    public boolean isZooFull() {
        return nbAnimals >= nbrCages;
    }

    // ---------- Instruction 15.2 : comparer deux zoos ----------
    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        return (z1.nbAnimals >= z2.nbAnimals) ? z1 : z2;
    }

    // Méthode displayZoo() (Instruction 8)
    public void displayZoo() {
        System.out.println("Nom du zoo : " + name);
        System.out.println("Ville : " + city);
        System.out.println("Nombre de cages : " + nbrCages);
        System.out.println("Nombre d'animaux : " + nbAnimals);
    }

    // Redéfinition de toString() (Instruction 9)
    @Override
    public String toString() {
        return "Zoo{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", nbrCages=" + nbrCages +
                ", nbAnimals=" + nbAnimals +
                '}';
    }
}