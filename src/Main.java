import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //Deklaration
        String[] personsOriginal = {"Evi Bauer", "Loredana Dickas Vilosola", "Kathrin Gerhard", "Emily Ghindea", "Alexia Guist", "Dana Herrmann", "Florentina Ilazi", "Fabio Interdonato", "Julia Jellen", "Sarah Krammer", "Thi Le", "Alina Moor","Aron Thiele","Joline Weidinger"};
        String[] personsCloned = personsOriginal.clone();  // Kopie der Original-Liste
        String[] shuffledList = new String[personsCloned.length];
        int[][] table = new int[shuffledList.length][2]; // Zweidimensionales Array für Person + Aufgabe
        int [] cache = new int[2];
        int exercisesNumber = 5;
        Random rand = new Random();

        // Personen mischen
        for (int i = 0; i < personsCloned.length; i++) {
            int randIndex;
            do {
                randIndex = rand.nextInt(personsCloned.length);
            } while (personsCloned[randIndex].equals("null"));  //Überprüfung, ob Person bereits verwendet wurde

            shuffledList[i] = personsCloned[randIndex];
            personsCloned[randIndex] = "null";  // Markieren, um nicht erneut verwendet zu werden
        }

        // Aufgaben der Reihe nach zuweisen (rotierend von 1 bis 5)
        for (int i = 0; i < shuffledList.length; i++) {
            table[i][0] = i;  // Spalte 0: Speichert den Index der Person
            table[i][1] = (i % exercisesNumber) + 1;  // Spalte 1: Speichert die zugewiesene Aufgabe von 1 bis 5
        }

        // Bubble Sort nach Aufgaben sortieren
        // Index r steht für Row
        for (int i = 0; i < table.length - 1; i++) { // Durchlaufschleife: Steuert, wie oft iteriert werden soll

            for (int r = 0; r < table.length - 1 - i; r++) {    //Vergleichsschleife: Wir iterieren Zeile für Zeile durch und vergleichen jeweils die benachbarten Zeilen miteinander
                if (table[r][1] > table[r + 1][1]) {            //[r] und [r+1] sind benachbarte Zeilen
                    cache= table[r];                            //Wenn, dann wird die Zeile (1D-Array) in cache (ebenfalls 1D-Array) zwischengespeichert
                    table[r] = table[r + 1];                    //Zeilentausch
                    table[r + 1] = cache;                       //Zeilentausch mh von cache
                }
            }

        }

        // Ausgabe der sortierten Liste
        System.out.println("Die Aufgaben werden wie folgt verteilt:");
        for (int i = 0; i < table.length; i++) {
            System.out.println(shuffledList[table[i][0]] + ": " + table[i][1]);
        }
    }
}