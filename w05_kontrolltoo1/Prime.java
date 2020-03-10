package w05_kontrolltoo1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Prime
 */
public class Prime {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        System.out.println("Sisesta arv");

        int value = input.nextInt();

        input.close();

        Set<Integer> divisions = divisibleBy(value, new int[] {2, 3, 5, 7});

        if (divisions.size() > 0) {
            System.out.print("Arv jagub järgmiste arvudega:");
            // Ausalt ei viitsi mingit Stringi deklareerida ja kokku liita
            for (int i : divisions) {
                System.out.print(" " + i);
            }
            System.out.println(".\n");
        } else {
            System.out.println("Arv EI jagu nii 2, 3, 5 kui ka 7-ga.");
        }

        
        if (isPrime(value)) {
            System.out.println("Arv on algarv.");
        } else {
            System.out.println("Arv EI ole algarv.");
        }

    }

    static Set<Integer> divisibleBy(int value, int[] divisions) {
        // Siia kogume kõik arvud millega antud arv jagub
        Set<Integer> validDivisions = new HashSet<Integer>();

        for (int i : divisions) {
            if (value % i == 0) {
                validDivisions.add(i);
            }
        }

        return validDivisions;
    }

    static boolean isPrime(int value) {
        final int[] checks = new int[] {0, 2, 4, 5, 6, 8};

        // Kiirelt saame lahti negatiivsetest arvudest
        if (value < 1) {
            return false;
        }

        // Kaval viis saada viimane number arvus
        int lastDigit = value % 10;

        // Kui arvu viimane number vastab checks-is olevale arvule, siis ta ei saa olla algarv (v.a 2 ja 5)
        // See peaks saama lahti enamik arvudest
        if (value != 2 && value != 5) {
            for (int i : checks) {
                if (lastDigit == i) {
                    return false;
                }
            }
        }

        // Lollikindel viis kontrollida kas arv on algarv
        // Tegelikult peaks kogu eelnev kood funktsioonis olema ebavajalik aga see vist on kiirem niimoodi?
        for (int i = 1; i < value; i++) {
            if (value % i == 0 && value != i && i != 1 && value != 1) {
                return false;
            }
        }

        return true;
    }
}