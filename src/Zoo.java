package entities;

public class Zoo {
    private Animal[] animals;
    private String name;
    private String city;
    private final int NBR_CAGES = 25;
    private int animalCount;

    public Zoo() {
    }

    public Zoo(String name, String city) {
        animals = new Animal[NBR_CAGES];
        setName(name);
        this.city = city;
    }

    public String getName() { return name; }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Erreur : le nom du zoo ne doit pas être vide.");
        } else {
            this.name = name;
        }
    }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public int getNbrCages() { return NBR_CAGES; }
    public int getAnimalCount() { return animalCount; }

    public boolean isZooFull() {
        return animalCount == NBR_CAGES;
    }

    public boolean addAnimal(Animal animal) {
        if (animal == null) {
            return false;
        }
        if (isZooFull()) {
            System.out.println("Le zoo est plein, impossible d'ajouter " + animal.getName());
            return false;
        }
        animals[animalCount] = animal;
        animalCount++;
        return true;
    }

    public void displayZoo() {
        System.out.println("Zoo : " + name + " - " + city + " (" + animalCount + "/" + NBR_CAGES + ")");
        for (int i = 0; i < animalCount; i++) {
            System.out.println(animals[i]);
        }
    }
}