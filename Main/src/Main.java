import java.util.ArrayList;
import java.util.Random;


public class Main {
//Prints out the constructors or the character details
    public static void main(String[] args) {
Character c1 = new Character();
System.out.println(c1);
Barbarian b1 = new Barbarian("Fart", 2);

Cleric cl1 = new Cleric("Summer", 2);
System.out.println(cl1);
cl1.levelUp();
System.out.println(cl1);
    }
}

//declares the variables for the characters
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


    //The default constructor
    public Character(){
        this.name= "Player";
        this.level = 1;
        this.strength = 10;
        this.dexterity = 10;
        this.constitution = 10;
        this.intelligence = 10;
        this.wisdom = 10;
        this.charisma = 10;
        this.feats = feats;
        calculateHitPoints();
        calculateArmorClass();
    }

    //The dice or stat bonus function that adds stats based on a roll of a dice. Uses a for loop to roll the dice 3 times and gets average.
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

    //Constructor for the classes
    public Character (String name, int level){
        this.name = name;
        this.level = level;
        this.strength = dice();
        this.dexterity = dice();
        this.constitution = dice();
        this.intelligence = dice();
        this.wisdom = dice();
        this.charisma = dice();
        this.feats = feats;
        calculateHitPoints();
        calculateArmorClass();
    }

    private int getAbilityModifier (int score) {
        return (score - 10) / 2;
    }
//Gives the players the HP value starting at 10.
    private void calculateHitPoints() {
        int dmg = getAbilityModifier(constitution);
        if (level == 1) {
            hit_points = 10 + dmg;
        }
        else {
            hit_points += (level - 1) * (6 + dmg);
        }
    }
//Gives the players the Defense stat
    private void calculateArmorClass (){
        armor = 10 + getAbilityModifier(dexterity);
    }
//When the character levels up the HP and Hit points increase, this increases the stats as well.
    public void levelUp() {
        level++;
        calculateArmorClass();
        calculateHitPoints();
    }
    //An arraylist that gives the character features or skills.
public void addFeat(String feat){
        feats.add(feat);
}
    public String toString() {
        return "Character: " + name + " | Level: " + level + "\n" + "HP: " + hit_points + " | AC: " + armor + "\n" + "STR: " + strength + " | DEX: " + dexterity + " | CON: " + constitution + " | INT: " + intelligence + " | WIS: " + wisdom + " | CHA: " + charisma + "\n" + "Feats: " + feats;
    }

}

//Series of subclasses using a taking the superclass of name and level then adding their own gimmick.
class Barbarian extends Character{
    public Barbarian (String name, int level) {
        super(name, level);
        this.strength += 2;
        this.constitution += 1;
        addFeat("Rage");
        addFeat("Unarmored Defense");
    }
}

class Bard extends Character{
    public Bard (String name, int level) {
        super(name, level);
        this.charisma += 2;
        this.dexterity += 1;
        addFeat("Inspiration");
        addFeat("Jack of all Trades");
    }
}

class Cleric extends Character{
    public Cleric (String name, int level) {
        super(name, level);
        this.wisdom += 2;
        this.constitution += 1;
        addFeat("Channel Divinity");
        addFeat("Turn Undead");
    }
}

class Druid extends Character{
    public Druid (String name, int level) {
        super(name, level);
        this.wisdom += 2;
        this.constitution += 1;
        addFeat("Wild Shape");
        addFeat("Commune with Nature");
    }
}

class Fighter extends Character{
    public Fighter (String name, int level) {
        super(name, level);
        this.dexterity += 2;
        this.constitution += 1;
        addFeat("Action Surge");
        addFeat("");
    }
}

class Monk extends Character{
    public Monk (String name, int level) {
        super(name, level);
        this.dexterity += 2;
        this.wisdom += 1;
        addFeat("Unarmored Movement");
        addFeat("Stunning Strike");
    }
}

class Paladin extends Character{
    public Paladin (String name, int level) {
        super(name, level);
        this.strength += 2;
        this.charisma += 1;
        addFeat("Divine Smite");
        addFeat("Aura of Protection");
    }
}

class Ranger extends Character{
    public Ranger (String name, int level) {
        super(name, level);
        this.dexterity += 2;
        this.wisdom += 1;
        addFeat("Favored Enemy");
        addFeat("Surefooted");
    }
}

class Rogue extends Character{
    public Rogue (String name, int level) {
        super(name, level);
        this.dexterity += 2;
        this.intelligence += 1;
        addFeat("Sneak Attack");
        addFeat("Uncanny Dodge");
    }
}

class Sorcerer extends Character{
    public Sorcerer (String name, int level) {
        super(name, level);
        this.charisma += 2;
        this.constitution += 1;
        addFeat("Wild Magic");
        addFeat("Flexible Spellcasting");
    }
}

class Warlock extends Character{
    public Warlock (String name, int level) {
        super(name, level);
        this.charisma += 2;
        this.constitution += 1;
        addFeat("Eldritch Patron");
        addFeat("Pact Magic");
    }
}

class Wizard extends Character{
    public Wizard (String name, int level) {
        super(name, level);
        this.intelligence += 2;
        this.constitution += 1;
        addFeat("Arcane Recovery");
        addFeat("Spell Mastery");
    }
}


