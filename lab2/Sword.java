public class Sword extends Weapon {
    private String bladeMaterial; 
    private boolean twoHanded;    

    public Sword() {
        super(); 
        this.name = "unnamed sword";
        this.damage = 10;
        this.weight = 2.5;
        this.bladeMaterial = "steel";
        this.twoHanded = false;
    }

    public Sword(String name, int damage, double weight, String bladeMaterial, boolean twoHanded) {
        super(name, damage, weight);
        this.bladeMaterial = bladeMaterial;
        this.twoHanded = twoHanded;
    }

    @Override
    public void attack() {
        System.out.println("sword strike, damage: " + damage);
    }

    @Override
    public void showInfo() {
        System.out.println("sword information");
        System.out.println("name: " + name);
        System.out.println("damage: " + damage);
        System.out.println("weight: " + weight + " kg");
        System.out.println("blade material : " + bladeMaterial);
        System.out.println("two-handed: " + (twoHanded ? "yes" : "no"));
    }

    public String getBladeMaterial() { 
        return bladeMaterial; 
    }

    public void setBladeMaterial(String bladeMaterial) { 
        this.bladeMaterial = bladeMaterial; 
    }

    public boolean isTwoHanded() { 
        return twoHanded; 
    }

    public void setTwoHanded(boolean twoHanded) { 
        this.twoHanded = twoHanded; 
    }
}
