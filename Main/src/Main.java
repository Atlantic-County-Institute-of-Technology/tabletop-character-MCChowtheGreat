import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
Character c1 = new Character("Hero", 5, 20, 10, 10, 10, 10, 10, 10, 10, );
System.out.println(c1);

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

    public Character(){
        this("Player", 1, 10, 10, 10, 10, 10, 10, 10, 10, );
    }
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
        this.feats = feats;
    }
    private int dice() {
        Random rand = new Random();
        int [] rolls = new int[4];
        int sum = 0;
        int lowest = 7;
        for (int i = 0; i <4; i++){
            rolls[i] = rand.nextInt(6) + 1;
            sum += rolls[i];
            if (rolls[i] < lowest) {
                lowest = rolls[i];
            }
        }
        return sum = lowest;
    }
public void addFeat(String feat){
        feats.add(feat);
}
    public String toString() {
        return "Character: " + name + " | Level: " + level + "\n" + "HP: " + hit_points + " | AC: " + armor + "\n" + "STR: " + strength + " | DEX: " + dexterity + " | CON: " + constitution + " | INT: " + intelligence + " | WIS: " + wisdom + " | CHA: " + charisma + "\n" + "Feats: " + feats;
    }


}