package Fitur;

import java.util.Scanner;

public class inputDataMahasiswa {
    static Scanner sc28 = new Scanner(System.in);
    static String[][] students = {
            { "1234560001", "Roy wijaya", "1A", "Teknik Informatika", "L" },
            { "1234560002", "Berta Christabel", "1B", "Teknik Informatika", "P" }

    };

    public static void main(String[] args) {
        inputDataMahasiswa();
    }

    static void inputDataMahasiswa() {
        String nim = null, fullName = null, classPlacement = null, studyProgram = null, sex = null;
        boolean isFind = false;
        System.out.println("+------+------------+----------------------+-------+----------------------+-----+");
        System.out.println("| No.  |    NIM     |      Full Name       | Class |     Study Program    | Sex |");
        System.out.println("+------+------------+----------------------+-------+----------------------+-----+");
        for (int i = 0; i < students.length; i++) {
            String[] student = students[i];
            System.out.printf("| %-4d | %-10s | %-20s | %-5s | %-20s |  %s  |\n", (i + 1), student[0], student[1],
                    student[2],
                    student[3], student[4]);
        }
        System.out.println("+------+------------+----------------------+-------+----------------------+-----+");

        while (!isFind) {
            System.out.print("NIM               :");
            nim = sc28.nextLine();
            if (nim.length() == 10) {
                System.out.print("Full Name         :");
                fullName = sc28.nextLine();
                System.out.print("Class             :");
                classPlacement = sc28.nextLine();
                System.out.print("Study Program     :");
                studyProgram = sc28.nextLine();
                System.out.print("Sex               :");
                sex = sc28.nextLine();
                for (int i = 0; i < students.length; i++) {
                    if (nim.equals(students[i][0])) {
                        System.out.println("Student with the NIM of " + nim + " already exists!");
                        System.out.println("Masukkan data lagi");
                        isFind = false;
                        break;
                    } else {
                        isFind = true;
                    }
                    ;
                }
            } else {
                System.out.println("NIM harus 10 digit");
                System.out.println("Masukkan NIM lagi");
            }
            if (isFind) {
                String[][] newStudents = new String[students.length + 1][5];
                for (int i = 0; i < students.length; i++) {
                    newStudents[i] = students[i];
                }
                newStudents[newStudents.length - 1] = new String[] { nim, fullName, classPlacement, studyProgram, sex };
                students = newStudents;
                System.out.println("+------+------------+----------------------+-------+----------------------+-----+");
                System.out.println("| No.  |    NIM     |      Full Name       | Class |     Study Program    | Sex |");
                System.out.println("+------+------------+----------------------+-------+----------------------+-----+");
                for (int i = 0; i < students.length; i++) {
                    String[] student = students[i];
                    System.out.printf("| %-4d | %-10s | %-20s | %-5s | %-20s |  %s  |\n", (i + 1), student[0],
                            student[1],
                            student[2],
                            student[3], student[4]);
                }
                System.out.println("+------+------------+----------------------+-------+----------------------+-----+");

                System.out.println("press enter to continue...");
                sc28.nextLine().trim();
            }
        }
    }
}
