/**
 * Lab02, task 11
 * @autor Андрієвський Михайло
 * */
public class Task11 {

    public static void main(String[] args) {
        // Проходять ОДЗ:
        printResults(0.01);
        printResults(0.0001);

        // Не проходять ОДЗ:
        printResults(0);     // eps <= 0
        printResults(-0.05); // eps <= 0
    }

    public static double calculateSum(double eps) {
        // 1. ОДЗ
        if (eps <= 0) {
            throw new IllegalArgumentException("Точність eps має бути більше 0. Передано: " + eps);
        }

        double sum = 0.0;
        int i = 1;
        double currentTerm;

        do {
            currentTerm = 1.0 / (i * i); // Обчислюємо доданок
            if (Math.abs(currentTerm) >= eps) {
                sum += currentTerm;      // Додаємо, якщо він достатньо великий
            }
            i++;
        } while (Math.abs(currentTerm) >= eps);

        return sum;
    }

    static void printResults(double eps) {
        System.out.print("eps: " + eps + " | sum: ");
        try {
            System.out.println(calculateSum(eps));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}
