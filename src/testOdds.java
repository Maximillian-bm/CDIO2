import java.util.HashMap;

public class testOdds {
    public static void main(String[] args) {
        // Simulated rolls of two dice
        int[] rolls = new int[1000];

        Die die1 = new Die(6);
        Die die2 = new Die(6);

        for(int i = 0; i < 1000; i++){
            rolls[i] = die1.rollDie()+die2.rollDie();
        }

        // Expected probabilities for each sum
        double[] expectedProbabilities = {
            1.0 / 36, 2.0 / 36, 3.0 / 36, 4.0 / 36, 5.0 / 36, 6.0 / 36, 
            5.0 / 36, 4.0 / 36, 3.0 / 36, 2.0 / 36, 1.0 / 36
        };

        // Create a HashMap to store observed frequencies
        HashMap<Integer, Integer> observedFrequencies = new HashMap<>();

        // Count the observed frequencies
        for (int roll : rolls) {
            observedFrequencies.put(roll, observedFrequencies.getOrDefault(roll, 0) + 1);
        }

        // Calculate the chi-squared statistic
        double chiSquared = 0.0;
        for (int i = 2; i <= 12; i++) {
            int observedFrequency = observedFrequencies.getOrDefault(i, 0);
            double expectedFrequency = expectedProbabilities[i - 2] * 1000; // 1000 rolls in total
            chiSquared += Math.pow(observedFrequency - expectedFrequency, 2) / expectedFrequency;
        }

        // Degrees of freedom
        int degreesOfFreedom = 11;

        // Critical chi-squared value for a significance level of 0.05 (you can change this)
        double criticalChiSquared = 19.675;

        // Compare the calculated chi-squared statistic with the critical value
        if (chiSquared < criticalChiSquared) {
            System.out.println("The observed outcomes are consistent with the expected distribution.");
        } else {
            System.out.println("The observed outcomes are not consistent with the expected distribution.");
        }

        System.out.println("Chi-Squared Statistic: " + chiSquared);
    }
}
