public abstract class Weapon {
    protected String name;       
    protected int damage;        
    protected double weight;    
    protected static int count;  

    public Weapon() {
        count++;
    }

    public Weapon(String name, int damage, double weight) {
        this.name = name;
        this.damage = damage;
        this.weight = weight;
        count++;
    }

    public String getName() { return name; }
    public void setName(String name) { 
        this.name = name; 
    }

    public int getDamage() { 
        return damage; 
    }
    public void setDamage(int damage) { 
        this.damage = damage; 
    }

    public double getWeight() { 
        return weight; 
    }
    public void setWeight(double weight) { 
        this.weight = weight; 
    }

    public abstract void attack();
    public abstract void showInfo();

    public static void showCount() {
        System.out.println("weapons created: " + count);
    }
}
