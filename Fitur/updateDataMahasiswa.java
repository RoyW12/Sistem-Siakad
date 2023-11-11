package Fitur;

import java.util.Scanner;

public class updateDataMahasiswa {
    public static void main(String[] args) {
        Scanner sc28 = new Scanner(System.in);

        String[][] students = {
                { "1234560001", "Roy wijaya", "1A", "Teknik Informatika", "L" },
                { "1234560002", "Berta Christabel", "1B", "Teknik Informatika", "P" },
                { "1234560003", "Joko Widodo", "1C", "Teknik Informatika", "L" },
                { "1234560004", "Ganjar Pranowo", "1D", "Teknik Informatika", "L" },
                { "1234560005", "Megawati", "1E", "Manajemen", "P" }
        };
        String newName = null;
        String nimInput;
        String newNIM = null;
        String newClass = null;
        String newStudyProgram = null;
        int indexStudent = 0;
        boolean isFind = false;

        while (!isFind) {
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

            System.out.print("Masukkan NIM mahasiswa    : ");
            nimInput = sc28.nextLine();

            if (nimInput.length() == 10) {
                for (int i = 0; i < students.length; i++) {
                    if (nimInput.equals(students[i][0])) {
                        indexStudent = i;
                        isFind = true;
                        break;
                    }
                }
            } else {
                System.out.println("NIM harus 10 digit");
            }

            if (isFind) {
                System.out.print("Masukkan nama mahasiswa           : ");
                newName = sc28.nextLine();
                System.out.print("Masukkan nim baru                 : ");
                newNIM = sc28.nextLine();
                System.out.print("Masukkan kelas mahasiswa          : ");
                newClass = sc28.nextLine();
                System.out.print("Masukkan program studi mahasiswa  : ");
                newStudyProgram = sc28.nextLine();

                students[indexStudent][0] = newName;
                students[indexStudent][1] = newNIM;
                students[indexStudent][2] = newClass;
                students[indexStudent][3] = newStudyProgram;
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

            } else {
                System.out.println("Student with the NIM of " + nimInput + " doesn't exists!");
                System.out.println("Masukkan data lagi");
            }
        }
    }
}
