package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Boxer> boxerList = new ArrayList<>(); // making a list for keeping objects

        Boxer f1 = new Boxer("Fatih", 0, randHealth(), randWeight(), randDodge()); // creating boxers
        Boxer f2 = new Boxer("Esra", 0, randHealth(), randWeight(), randDodge());
        Boxer f3 = new Boxer("Osman", 0, randHealth(), randWeight(), randDodge());
        Boxer f4 = new Boxer("Talha", 0, randHealth(), randWeight(), randDodge());
        Boxer f5 = new Boxer("Esma", 0, randHealth(), randWeight(), randDodge());
        Boxer f6 = new Boxer("Hadise", 0, randHealth(), randWeight(), randDodge());
        Boxer f7 = new Boxer("Elif", 0, randHealth(), randWeight(), randDodge());
        Boxer f8 = new Boxer("Ali", 0, randHealth(), randWeight(), randDodge());

        boxerList.add(f1); // adding boxers to list
        boxerList.add(f2);
        boxerList.add(f3);
        boxerList.add(f4);
        boxerList.add(f5);
        boxerList.add(f6);
        boxerList.add(f7);
        boxerList.add(f8);

        System.out.println("----BOXER LİST----");

        for (int i = 0; i < boxerList.size(); i++) { // navigating the list and printing elements
            System.out.println((i + 1) + ". " + boxerList.get(i));
        }
        System.out.println("---------------------");

        showMatches();

        switch (selectMatch()) {
            case 1:
                Ring match = new Ring(f1, f2, 65, 85);
                match.run(f1, f2);
                break;
            case 2:
                Ring match2 = new Ring(f3, f4, 60, 80);
                match2.run(f3, f4);
                break;
            case 3:
                Ring match3 = new Ring(f7, f5, 75, 90);
                match3.run(f7, f5);
                break;
            case 4:
                Ring match4 = new Ring(f6, f2, 65, 90);
                match4.run(f6, f2);
                break;
            case 5:
                Ring match5 = new Ring(f3, f8, 70, 80);
                match5.run(f3, f8);
                break;
            case 6:
                Ring match6 = new Ring(f5, f2, 60, 85);
                match6.run(f5, f2);
                break;
            case 7:
                Ring match7 = new Ring(f7, f6, 60, 80);
                match7.run(f7, f6);
                break;
            case 8:
                Ring match8 = new Ring(f1, f8, 65, 85);
                match8.run(f1, f8);
                break;
            default:
                System.out.println("Please enter a valid match number!");
                break;
        }
    }

    public static int randHealth() { // for randomly assign players health
        Random random = new Random();
        int min = 85;
        int max = 125;
        return random.nextInt(max - min + 1) + min;
    }

    public static int randWeight() { // for randomly assign players weight
        Random random = new Random();
        int min = 60;
        int max = 90;
        return random.nextInt(max - min + 1) + min;
    }

    public static int randDodge() { // for randomly assign players dodge chance
        Random random = new Random();
        int min = 10;
        int max = 50;
        return random.nextInt(max - min + 1) + min;
    }

    public static void showMatches() {
        String[] matches = {
                "1. Match : Fatih  - Esra",
                "2. Match : Osman  - Talha",
                "3. Match : Elif   - Esma",
                "4. Match : Hadise - Esra",
                "5. Match : Osman  - Ali",
                "6. Match : Esma   - Esra",
                "7. Match : Elif   - Hadise",
                "8. Match : Fatih  - Ali"
        };
        for (String element : matches) {
            System.out.println(element);
        }
    }

    public static int selectMatch() {
        Scanner input = new Scanner(System.in);

        System.out.println("---------------------");
        System.out.print("Choose your match : ");
        int select = input.nextInt();

        return select;
    }
}