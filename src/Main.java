import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String[] studs = {"Антошкин Антон", "Бибикин Платон", "Грыжнова Апполинария", "Артемий Гусев",
                "Жижкина Анастасия", "Красотулин Матвей", "Александрова Александра", "Непоняткин Денис"};
        int[] marks = new int[studs.length]; // Массив с итоговыми оценками за пару
        int[] answers = new int[studs.length]; // Массив с количеством ответов каждого студента на паре
        System.out.println("Добрый день, Александр Александрович! Введите команду.");
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        while (true) {
            String command = input.nextLine();
            if (Objects.equals(command, "/r")) {
                int index = rand.nextInt(studs.length);
                System.out.println(studs[index]);
                System.out.print("Оценка: ");
                int mark = input.nextInt();
                if (answers[index] == 0)
                    marks[index] = mark;
                else
                    marks[index] = (marks[index] * answers[index] + mark + 1) / (answers[index] + 1);
                answers[index] += 1;
            } else if (Objects.equals(command, "/p")) {
                for (int i = 0; i < studs.length; i++) {
                    System.out.print("\n" + studs[i]);
                    System.out.print("  ");
                    if (marks[i] == 0) {
                        System.out.print("-");
                    } else {
                        System.out.print(marks[i]);
                    }
                }
                System.out.println("\n");
            } else if (Objects.equals(command, "/q")) {
                System.out.println("Всего хорошего!");
                break;
            }
        }
    }
}
