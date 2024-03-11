package Game;

public class Boxer {
    String name;
    int damage;
    int health;
    int weight;
    int dodge;

    Boxer(String name, int damage, int health, int weight, int dodge) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.weight = weight;
        this.dodge = dodge;
    }

    int hit(Boxer enemy) {
        // making the damage random
        double randomvalue = Math.random() * 15;
        int converted = (int) randomvalue;

        this.damage = converted;
        // if players health is below than the damage it returns 0 health
        if (enemy.health - this.damage <= 0) {
            System.out.println(this.name + " ==> " + enemy.name + " dealt " + this.damage + " damage!");
            System.out.println("---------------------");
            return 0;
        }
        //showing who hits
        System.out.println(this.name + " ==> " + enemy.name + " dealt " + this.damage + " damage!");

        if (enemy.dodge()) {
            System.out.println(enemy.name + " dodged the incoming damage.");
            System.out.println("++++");
            return enemy.health;
        }

        return enemy.health - this.damage;
    }

    public boolean dodge() {
        double randomValue = Math.random() * 100;  //0.0 to 99.9
        return randomValue <= this.dodge;
    }

    public String toString() {
        String random = "Random";
        return String.format("Name : %-10s | Damage : %-10s | Health : %-5d | Weight : %-5d | Dodge : %-5s |", name, random, health, weight,dodge);
    }
}
