import java.util.stream.IntStream;

class DnDCharacter {

    private final int strength, dexterity, constitution,
            intelligence, wisdom, charisma, hitpoints;

    DnDCharacter(){
        this.strength = ability();
        this.dexterity = ability();
        this.constitution = ability();
        this.intelligence = ability();
        this.wisdom = ability();
        this.charisma = ability();
        this.hitpoints = 10 + modifier(constitution);
    }

    int ability() {
        return (int) (3 + 15 * Math.random());
    }

    int modifier(int input) {
        return Math.floorDiv(input - 10,  2);
    }

    int getStrength() {
        return strength;
    }

    int getDexterity() {
        return dexterity;
    }

    int getConstitution() {
        return constitution;
    }

    int getIntelligence() {
        return intelligence;
    }

    int getWisdom() {
        return wisdom;
    }

    int getCharisma() {
        return charisma;
    }

    int getHitpoints() {
        return hitpoints;
    }

}
