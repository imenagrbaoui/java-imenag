package entities;

public class Animal {
    private String family;
    private String name;
    private int age;
    private boolean isMammal;

    public Animal() {
    }

    public Animal(String family, String name, int age, boolean isMammal) {
        this.family = family;
        this.name = name;
        setAge(age);
        this.isMammal = isMammal;
    }

    public String getFamily() { return family; }
    public void setFamily(String family) { this.family = family; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }

    public void setAge(int age) {
        if (age < 0) {
            System.out.println("Erreur : l'âge d'un animal ne peut pas être négatif.");
        } else {
            this.age = age;
        }
    }

    public boolean isMammal() { return isMammal; }
    public void setMammal(boolean isMammal) { this.isMammal = isMammal; }

    @Override
    public String toString() {
        return "Animal [family=" + family + ", name=" + name + ", age=" + age
                + ", isMammal=" + isMammal + "]";
    }
}