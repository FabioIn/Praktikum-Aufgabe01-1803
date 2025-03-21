import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String[] personsOriginal = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
        String[] personsCloned = personsOriginal.clone();  // Kopie der Original-Liste
        String[] shuffledList = new String[personsCloned.length];
        int[][] table = new int[shuffledList.length][2]; // Zweidimensionales Array für Person + Aufgabe
        int [] cache = new int[2];

        int exercisesNumber = 5;
        Random rand = new Random();

        // Personen mischen (Fisher-Yates Shuffle)
        for (int i = 0; i < personsCloned.length; i++) {
            int randIndex;
            do {
                randIndex = rand.nextInt(personsCloned.length);
            } while (personsCloned[randIndex].equals("USED"));

            shuffledList[i] = personsCloned[randIndex];
            personsCloned[randIndex] = "USED";  // Markieren, um nicht erneut verwendet zu werden
        }

        // Aufgaben zufällig zuweisen (rotierend von 1 bis 5)
        for (int i = 0; i < shuffledList.length; i++) {
            table[i][0] = i;  // Speichert den Index der Person
            table[i][1] = (i % exercisesNumber) + 1;  // Aufgabe von 1 bis 5
        }

        // Bubble Sort nach Aufgaben sortieren
        for (int i = 0; i < table.length - 1; i++) { // Durchlaufschleife

            for (int r = 0; r < table.length - 1 - i; r++) { //Vergleichsschleife
                if (table[r][1] > table[r + 1][1]) {
                    cache= table[r];
                    table[r] = table[r + 1];
                    table[r + 1] = cache;
                }
            }
        }

        // Ausgabe der sortierten Liste
        System.out.println("Die Aufgaben werden wie folgt verteilt:");
        for (int i = 0; i < table.length; i++) {
            System.out.print(shuffledList[table[i][0]] + ": " + table[i][1]+ " ; ");
        }
    }
}