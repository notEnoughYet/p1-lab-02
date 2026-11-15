/**
 * Lab02, task 6
 * @autor Андрієвський Михайло
 * */
public class Task6 {

    public static void main(String[] args) {
        // Проходять ОДЗ:
        printResults(4.0, 1);
        printResults(4.0, 2);
        printResults(3.0, 4);

        // Не проходять ОДЗ:
        printResults(-2.0, 1); // t < 0
        printResults(0.0, 2);  // t = 0 при i = 2
        printResults(5.0, 0);  // i < 1
    }
    /**
     * Метод, який виконує обчислення
     */
    public static double calculateX(double t, int i) {
        // 1. ОДЗ
        if (i < 1) {
            throw new IllegalArgumentException("Параметр i має бути >= 1. Передано: " + i);
        }
        if (t < 0) {
            throw new IllegalArgumentException("Параметр t не може бути від'ємним. Передано: " + t);
        }
        if (i == 2 && t == 0) {
            throw new IllegalArgumentException("При i = 2 параметр t не може дорівнювати 0(на нуль ділити не можна)!");
        }

        // 2. Обчислення
        if (i == 1) {
            return Math.sqrt(t);
        } else if (i == 2) {
            return 1.0 / Math.sqrt(t);
        } else {
            double sum = 0.0;
            for (int k = 1; k <= i; k++) {
                sum += k * t;
            }
            return sum;
        }
    }
    /**
     * Допоміжний метод
     */
    static void printResults(double t, int i) {
        System.out.print("t: " + t + " | i: " + i + " | result: ");
        try {
            System.out.println(calculateX(t, i));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}
