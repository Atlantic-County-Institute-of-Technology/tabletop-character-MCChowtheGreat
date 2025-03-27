import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
Character c1 = new Character("Hero", 5, 20, 10, 10, 10, 10, 10, 10, 10, );
    }
}

class Character {
    protected String name;
    protected int level;
    protected int hit_points;
    protected int armor;
    protected int strength;
    protected int dexterity;
    protected int constitution;
    protected int intelligence;
    protected int wisdom;
    protected int charisma;
    protected ArrayList<String> feats = new ArrayList<>();

    public Character (String name, int level, int hit_points, int armor, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma, ArrayList feats){
        this.name = name;
        this.level = level;
        this.hit_points = hit_points;
        this.armor = armor;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
       // this.feats = feats;

    }
}