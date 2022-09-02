import java.util.Random;
import java.util.Scanner;

public class Main {

    Random random = new Random();

    Scanner scanner = new Scanner(System.in);

    int y = random.nextInt(1,100) + 1;

    int t = random.nextInt(1,500) + 1;

    int r = random.nextInt(1,1000) + 1;

    int count = 0;
    int count2 = 0;
    int count3 = 0;

    public void option() {
        System.out.println("Chosit un level entre un nombre (1-100):taper 1 (1-500):taper 2 (1-1000):taper 3) ou : 0 pour quitter le jeu");

        int level = scanner.nextInt();

        if (level == 0){
            System.exit(0);
        }

        if (level == 1) {
            System.out.println("---------------------------------------");
            System.out.println("Tu as chosit le level 1. Tu as donc 7 chance pour trouver un nombre compris entre (1-100) ");
            level1();
        } else if (level == 2) {
            System.out.println("Tu as chosit le level 2. Tu as donc 10 chance pour trouver un nombre compris entre (1-500) ");
            level2();
        } else if (level == 3) {
            System.out.println("Tu as chosit le level 3. Tu as donc 15 chance pour trouver un nombre compris entre (1-1000) ");
            level3();
        } else if (level != 1 || level != 2 || level != 3) {
            System.out.println("Erreur : Choisit bien un nombre entre 1,2 et 3");
            option();
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.option();
        main.level1();
        main.level2();
        main.level3();
    }

    public void level1() {

            long start = System.nanoTime();

            while (true) {
                int x = scanner.nextInt();
                count++;

                if (x == 0 || x > 100) {
                    System.out.println("Nombre invalide");
                    count--;
                    break;
                }

                if (x > y) {
                    System.out.println("Trop grand, redis un nombre plus petit");
                } else if (x < y) {
                    System.out.println("Trop petit, redis un nombre plus grand");
                } else if (x == y) {
                    long duration = (System.nanoTime() - start) / 1000000000;
                    System.out.println("GG Tu as gagner :) en : " + count + " essai" + " et en " + duration + " s");
                    System.out.println("---------------------------------------");
                    restart();
                }
                if (count == 7) {
                    System.out.println("Désolé tu as perdu :(");
                    System.out.println("---------------------------------------");
                    restart();
                }
            }
        }

    public void level2() {
        long start = System.nanoTime();

            while (true) {

                int m = scanner.nextInt();
                count2++;

                if (m == 0 || m>500 ){
                    System.out.println("Nombre invalide");
                    count --;
                    break;
                }

                if (m > t) {
                    System.out.println("Trop grand, redis un nombre plus petit");
                } else if (m < t) {
                    System.out.println("Trop petit, redis un nombre plus grand");
                } else if (m == t) {
                    long duration = (System.nanoTime() - start) / 1000000000;
                    System.out.println("GG Tu as gagner ! en : " + count2 + " essai" + " et en " + duration + " s");
                    restart();
                }
                if (count2 == 10) {
                    System.out.println("Désolé tu as perdu :(");
                    restart();
                }
            }
        }

    private void restart() {
        random = new Random();
        t = random.nextInt(1,500) + 1;
        y = random.nextInt(1,100) + 1;
        r = random.nextInt(1,1000) + 1;
        count = 0;
        count2 = 0;
        count3 = 0;
        System.out.println("Veut tu rejouer ? oui/non");
        String g = scanner.next();
        if (g.equals("oui")){
            option();
        }
        else {
            System.exit(0);
        }
    }

    public void level3() {
        long start = System.nanoTime();

        while (true) {

            int p = scanner.nextInt();
            count3++;

            if (p == 0 || p>1000 ){
                System.out.println("Nombre invalide");
                count --;
                break;
            }

            if (p > r) {
                System.out.println("Trop grand, redis un nombre plus petit");
            } else if (p < r) {
                System.out.println("Trop petit, redis un nombre plus grand");
            } else if (p == r) {
                long duration = (System.nanoTime() - start) / 1000000000;
                System.out.println("GG Tu as gagner ! en : " + count3 + " essai" + " et en " + duration + " s");
                restart();
            }
            if (count3 == 15) {
                System.out.println("Désolé tu as perdu :(");
                restart();
            }
        }
    }
}
