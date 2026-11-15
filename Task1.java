/**
 * Lab02, task 1
 * @autor Андрієвський Михайло
 * */
public class Task1 {

    public static void main(String[] args) {
        // Проходять ОДЗ:
        printResults(10, 2.5);
        printResults(1, 0.5);
        printResults(30, 1.0);

        // Не проходять ОДЗ:
        printResults(0, 2.5);   // k < 1
        printResults(31, 2.5);  // k > 30
        printResults(10, -5.0); // m < 0
    }

    /**
     * Метод, який вимірює суму
     */
    public static double calculateSum(int k, double m) {
        // 1. ОДЗ
        if (k < 1 || k > 30) {
            throw new IllegalArgumentException("Параметр k повинен бути від 1 до 30. Передано: " + k);
        }
        if (m < 0) {
            throw new IllegalArgumentException("Параметр m не може бути від'ємним(через корінь). Передано: " + m);
        }

        // 2. Вимірювання суми
        double sum = 0.0;
        for (int i = 1; i <= k; i++) {
            sum += Math.sqrt(m * (1.0 / i)) * Math.sin(m * i);
        }

        return sum;
    }

    /**
     * Допоміжний метод
     */
    static void printResults(int k, double m) {
        System.out.print("k: " + k + " | m: " + m + " | result: ");
        try {
            System.out.println(calculateSum(k, m));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}