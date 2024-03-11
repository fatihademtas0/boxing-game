package Game;

public class Ring {
    Boxer f1;
    Boxer f2;
    int minWeight;
    int maxWeight;

    Ring(Boxer f1, Boxer f2, int minWeight, int maxWeight) {
        this.f1 = f1;
        this.f2 = f2;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    void run(Boxer f1, Boxer f2) {
        this.f1 = f1;
        this.f2 = f2;

        int i = 1; // increasing the round number
        if (isCheck(f1, f2)) {
            System.out.print("Fighters Health : ");
            System.out.println(this.f1.name + " " + this.f1.health + " HP ---- " + this.f2.health + " HP " + this.f2.name);
            while (this.f1.health > 0 && this.f2.health > 0) { // fight continues as long as a player is alive

                System.out.println("----" + i + ". ROUND----");
                i++;

                this.f2.health = this.f1.hit(this.f2); //player is attacking

                if (isWin(f1, f2)) {
                    System.out.println("****");
                    break;
                }
                System.out.println("****");

                this.f1.health = this.f2.hit(this.f1); //player is attacking

                if (isWin(f1, f2)) {
                    System.out.println("****");
                    break;
                }
                System.out.println("---------------------"); // shows the health of the players
                System.out.println(this.f1.name + " " + this.f1.health + " HP ---- " + this.f2.health + " HP " + this.f2.name);
                System.out.println("---------------------");
            }
        } else { // if weights doesnt match show players kilos and show message
            System.out.println(this.f1.name + " : " + this.f1.weight + " kilos.");
            System.out.println(this.f2.name + " : " + this.f2.weight + " kilos.");
            System.out.println("The weights of the fighters do not match.");
        }
    }

    boolean isCheck(Boxer f1, Boxer f2) { // checks the weight of the players
        this.f1 = f1;
        this.f2 = f2;
        return (this.f1.weight >= minWeight && this.f1.weight <= maxWeight) && (this.f2.weight >= minWeight && this.f2.weight <= maxWeight);
    }

    boolean isWin(Boxer f1, Boxer f2) { // checks winning situation
        this.f1 = f1;
        this.f2 = f2;
        if (this.f1.health == 0) { // if player one is dead
            System.out.println(this.f1.name + " " + this.f1.health + " HP ---- " + this.f2.health + " HP " + this.f2.name);

            System.out.println("*********************");
            System.out.println(this.f1.name + " is dead!");
            System.out.println(this.f2.name + " WON!");
            return true;
        } else if (this.f2.health == 0) { // if player two is dead
            System.out.println(this.f1.name + " " + this.f1.health + " HP ---- " + this.f2.health + " HP " + this.f2.name);

            System.out.println("*********************");
            System.out.println(this.f2.name + " is dead!");
            System.out.println(this.f1.name + " WON!");
            return true;
        }
        return false; // as long as someone alive it returns false for keep fighting
    }
}

