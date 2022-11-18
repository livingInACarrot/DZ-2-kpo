import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Student {
    public String name;
    public int mark;
    public int answers;
    public Student(String N, int M, int A) {
        name = N;
        mark = M;
        answers = A;
    }
}

public class Main {
    public static Student[] studentsReading() {
        ArrayList<Student> stu = new ArrayList<>();
        try {
            File file = new File("students.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                stu.add(new Student(line, 0, 0));
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Что-то не так с файлом");
        }
        Student[] studs = new Student[stu.size()];
        stu.toArray(studs);
        return studs;
    }

    public static void commandsReading(Scanner input, Student[] studs) {
        Random rand = new Random();
        loop:
        while (true) {
            String command = input.nextLine().trim();
            switch (command) {
                case "/r":
                    int index = rand.nextInt(studs.length);
                    System.out.println(studs[index].name);
                    System.out.print("Оценка: ");
                    int mark = input.nextInt();
                    if (studs[index].answers == 0)
                        studs[index].mark = mark;
                    else
                        studs[index].mark = (studs[index].mark * studs[index].answers + mark + 1) / (studs[index].answers + 1);
                    studs[index].answers += 1;
                    break;
                case "/p":
                    for (Student stud : studs) {
                        System.out.print("\n" + stud.name);
                        System.out.print("  ");
                        if (stud.mark == 0) {
                            System.out.print("-");
                        } else {
                            System.out.print(stud.mark);
                        }
                    }
                    System.out.println("\n");
                    break;
                case "/q":
                    System.out.println("Всего хорошего!");
                    break loop;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Добрый день, Александр Александрович! Введите команду.");

        Scanner input = new Scanner(System.in);
        Student[] studs = studentsReading();
        commandsReading(input, studs);
    }
}
