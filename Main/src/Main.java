import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
Character c1 = new Character();
System.out.println(c1);

Barbarian b1 = new Barbarian("Fart", 1);
System.out.println(b1);
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
        this("Player",1);
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
        calculateHitPoints();
        calculateArmorClass();
    }

    public Character(String name, int level) {
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
        return sum - lowest;
    }

    private int getAbilityModifier (int score) {
        return (score - 10) / 2;
    }

    private void calculateHitPoints() {
        int dmg = getAbilityModifier(constitution);
        if (level == 1) {
            hit_points = 10 + dmg;
        }
        else {
            hit_points += (level - 1) * (6 + dmg);
        }
    }

    private void calculateArmorClass (){
        armor = 10 + getAbilityModifier(dexterity);
    }

    public void levelUp() {
        level++;
        calculateArmorClass();
        calculateHitPoints();
    }
public void addFeat(String feat){
        feats.add(feat);
}
    public String toString() {
        return "Character: " + name + " | Level: " + level + "\n" + "HP: " + hit_points + " | AC: " + armor + "\n" + "STR: " + strength + " | DEX: " + dexterity + " | CON: " + constitution + " | INT: " + intelligence + " | WIS: " + wisdom + " | CHA: " + charisma + "\n" + "Feats: " + feats;
    }

}
class Barbarian extends Character{
    public Barbarian (String name, int level) {
        super(name, level);
        this.strength += 2;
        this.constitution += 2;
        addFeat("Rage");
        addFeat("Unarmored Defense");
    }
}
