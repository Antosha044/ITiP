public class Main {
    public static void main(String[] args) {
        Sword sword1 = new Sword();
        Sword sword2 = new Sword("paladin sword", 25, 4.0, "metal", true);

        Bow bow1 = new Bow();
        Bow bow2 = new Bow("Bow", 20, 3.5, 50, 15);

        MagicWand wand1 = new MagicWand();
        MagicWand wand2 = new MagicWand("supercharged", 30, 0.2, 100, "lightning");

        sword1.showInfo();
        sword2.showInfo();

        bow1.showInfo();
        bow2.showInfo();

        wand1.showInfo();
        wand2.showInfo();

        //полиморфизм
        Weapon[] weapons = {sword1, sword2, bow1, bow2, wand1, wand2};

        for (Weapon w : weapons) {
            w.attack(); 
        }

        sword1.setTwoHanded(true);
        bow1.setArrowsCount(0);
        wand1.setMana(0);

        //после изменений
        sword1.showInfo();
        bow1.showInfo();
        wand1.showInfo();

        System.out.println("blade material is: " + sword2.getBladeMaterial());
        System.out.println("range " + bow2.getRange());
        System.out.println("spell type is: " + wand2.getSpellType());

        Weapon.showCount();
    }
}
