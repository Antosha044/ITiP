public class Bow extends Weapon {
    private int range;
    private int arrowsCount;

    public Bow() {
        super();
        this.name = "unnamed bow";
        this.damage = 15;
        this.weight = 3.0;
        this.range = 30;
        this.arrowsCount = 10;
    }

    public Bow(String name, int damage, double weight, int range, int arrowsCount) {
        super(name, damage, weight);
        this.range = range;
        this.arrowsCount = arrowsCount;
    }

    @Override
    public void attack() {
        if (arrowsCount > 0) {
            System.out.println(name + " fired, damage: " + damage);
            arrowsCount--;
        } else {
            System.out.println(name + " can`t atack, no arrows");
        }
    }

    @Override
    public void showInfo() {
        System.out.println("bow information");
        System.out.println("name: " + name);
        System.out.println("damage: " + damage);
        System.out.println("qeight: " + weight + " kg");
        System.out.println("range: " + range + " m");
        System.out.println("arrows: " + arrowsCount);
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getArrowsCount() {
        return arrowsCount;
    }

    public void setArrowsCount(int arrowsCount) {
        this.arrowsCount = arrowsCount;
    }
}
