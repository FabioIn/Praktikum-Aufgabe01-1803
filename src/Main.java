import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String[] personsOriginal = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String[] personsCloned = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String[] shuffledList = new String[personsCloned.length];
        int [] exercises = new int[shuffledList.length];
        int exercisesNumber = 5;
        Random rand = new Random();
        int taskNumber = 0;

        //Personen mischen
        for (int i = 0; i < personsCloned.length; i++) {
            int randIndex;
            do {
                randIndex = rand.nextInt(personsCloned.length);
            } while (personsCloned[randIndex].equals("null"));

            shuffledList[i] = personsCloned[randIndex];
            personsCloned[randIndex] = "null";
        }

        //Aufgabe zuweisen
        for (int i = 0; i < personsCloned.length - 1; i++) {
            taskNumber = (i % exercisesNumber) + 1;  // Aufgaben von 1 bis 5 wiederholen
            System.out.println(shuffledList[i] + " hat die Aufgabe " + taskNumber);
        }

    }
}