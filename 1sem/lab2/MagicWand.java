public class MagicWand extends Weapon {
    private int mana; 
    private String spellType; 

    public MagicWand() {
        super();
        this.name = "unnamed magic wand";
        this.damage = 12;
        this.weight = 1.0;
        this.mana = 50;
        this.spellType = "fire";
    }

    public MagicWand(String name, int damage, double weight, int mana, String spellType) {
        super(name, damage, weight);
        this.mana = mana;
        this.spellType = spellType;
    }

    @Override
    public void attack() {
        System.out.println(name + " attacks with a spell (" + spellType + "), damage: " + damage);
    }

    @Override
    public void showInfo() {
        System.out.println("magic wand information");
        System.out.println("name: " + name);
        System.out.println("damage: " + damage);
        System.out.println("weight: " + weight + " kg");
        System.out.println("spell type: " + spellType);
        System.out.println("mana: " + mana);
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public String getSpellType() {
        return spellType;
    }

    public void setSpellType(String spellType) {
        this.spellType = spellType;
    }
}
