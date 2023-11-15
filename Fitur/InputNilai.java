package Fitur;

import java.util.Scanner;

public class InputNilai {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        String nama = "";
        int indexStudent = -1;

        String[][] students = {
                { "1234560001", "Roy wijaya", "1A", "Teknik Informatika", "L" },
                { "1234560002", "Jessica Wongso", "1B", "Teknik Informatika", "P" },
                { "1234560003", "Joko Widodo", "1C", "Teknik Informatika", "L" },
                { "1234560004", "Ganjar Pranowo", "1D", "Teknik Informatika", "L" },
                { "1234560005", "Megawati", "1E", "Manajemen", "P" }
        };

        String[][] course = {
                { "RTI231001", "Pancasila", "2" },
                { "RTI231002", "Konsep Teknologi Informasi", "2" },
                { "RTI231003", "Critical Thinking dan Problem Solving", "2" },
                { "RTI231004", "Matematika Dasar", "2" },
                { "RTI231005", "Dasar Pemrograman", "3" }

        };

        String[][] grades = new String[students.length][course.length * 3]; 

        while (indexStudent == -1) {
            System.out.print("Masukkan nama mahasiswa   : ");
            nama = userInput.nextLine();
            for (int i = 0; i < students.length; i++) {
                if (nama.equalsIgnoreCase(students[i][1])) {
                    indexStudent = i;
                    System.out.println("Data ditemukan");
                    System.out.println(
                            "+------+------------+----------------------+-------+----------------------+-----+");
                    System.out.println(
                            "| No.  |    NIM     |      Full Name       | Class |     Study Program    | Sex |");
                    System.out.println(
                            "+------+------------+----------------------+-------+----------------------+-----+");
                    System.out.printf("| %-4d | %-10s | %-20s | %-5s | %-20s |  %s  |\n", 1,
                            students[i][0],
                            students[i][1],
                            students[i][2],
                            students[i][3],
                            students[i][4]);
                    System.out.println(
                            "+------+------------+----------------------+-------+----------------------+-----+");
                }
            }
            if (indexStudent == -1) {
                System.out.println("Data tidak ditemukan. Silakan coba lagi.");
            }
        }
        System.out.println("press enter to continue...");
        userInput.nextLine().trim();
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println(
                "+------+--------------------+----------------------------------------+-----+----------------+----------------+------------------+");
        System.out.println(
                "| No.  |    Course Code     |               Course Name              | SKS | Value (Number) | Value (Letter) |     Predicate    |");
        System.out.println(
                "+------+--------------------+----------------------------------------+-----+----------------+----------------+------------------+");
        for (int i = 0; i < course.length; i++) {
            String[] newCourse = course[i];
            int baseIndex = i * 3; // Mulai dari indeks yang sesuai di array grades
            String[] values = {grades[indexStudent][baseIndex], grades[indexStudent][baseIndex + 1], grades[indexStudent][baseIndex + 2]};
            for (int j = 0; j < values.length; j++) {
                if (values[j] == null) {
                    values[j] = "-";
                }
            }
            System.out.printf("| %-4d | %-18s | %-38s | %-3s | %-14s | %-14s | %-16s |\n", (i + 1), newCourse[0],
                    newCourse[1],
                    newCourse[2], values[0], values[1], values[2]);
        }
        System.out.println(
                "+------+--------------------+----------------------------------------+-----+----------------+----------------+------------------+");

        if (indexStudent != -1) {
            int i = 0;
            while (i < course.length) {
                int numericValue;
                while (true) {
                    System.out.print("Nilai matkul " + course[i][1] + " : ");
                    numericValue = userInput.nextInt();
                    userInput.nextLine();
                    if (numericValue < 0 || numericValue > 100) {
                        System.out.println("The value must be in the range 1-100. Please try again.....");

                    } else {
                        break;
                    }
                }

                System.out.println("------------------------------------");

                String letterValue;
                String predicate = "";
                if (numericValue > 80 && numericValue <= 100) {
                    letterValue = "A";
                    predicate = "Sangat baik";
                } else if (numericValue > 73 && numericValue <= 80) {
                    letterValue = "B+";
                    predicate = "Lebih dari baik";
                } else if (numericValue > 65 && numericValue <= 73) {
                    letterValue = "B";
                    predicate = "Baik";
                } else if (numericValue > 60 && numericValue <= 65) {
                    letterValue = "C+";
                    predicate = "Lebih dari cukup";
                } else if (numericValue > 50 && numericValue <= 60) {
                    letterValue = "C";
                    predicate = "Cukup";
                } else if (numericValue > 39 && numericValue <= 50) {
                    letterValue = "D";
                    predicate = "Kurang";
                } else if (numericValue > 0 && numericValue <= 39) {
                    letterValue = "E";
                    predicate = "Gagal";
                } else {
                    letterValue = "Tidak tersedia";
                }
                int baseIndex = i * 3; // Mulai dari indeks yang sesuai di array grades
                grades[indexStudent][baseIndex] = String.valueOf(numericValue);
                grades[indexStudent][baseIndex + 1] = letterValue;
                grades[indexStudent][baseIndex + 2] = predicate;
                i++;
            }
        }
        System.out.print("\n");

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("-------------------------------------");
        System.out.println("|          Data mahasiswa           |");
        System.out.println("-------------------------------------");
        System.out.println("| Nama        : " + nama);
        System.out.println("| NIM         : " + students[indexStudent][0]);
        System.out.println("-------------------------------------");

        System.out.println(
                "+------+--------------------+----------------------------------------+-----+----------------+----------------+------------------+");
        System.out.println(
                "| No.  |    Course Code     |               Course Name              | SKS | Value (Number) | Value (Letter) |     Predicate    |");
        System.out.println(
                "+------+--------------------+----------------------------------------+-----+----------------+----------------+------------------+");
        for (int i = 0; i < course.length; i++) {
            String[] newCourse = course[i];
            int baseIndex = i * 3; // Mulai dari indeks yang sesuai di array grades
            String[] values = {grades[indexStudent][baseIndex], grades[indexStudent][baseIndex + 1], grades[indexStudent][baseIndex + 2]};
            for (int j = 0; j < values.length; j++) {
                if (values[j] == null) {
                    values[j] = "-";
                }
            }
            System.out.printf("| %-4d | %-18s | %-38s | %-3s | %-14s | %-14s | %-16s |\n", (i + 1), newCourse[0],
                    newCourse[1],
                    newCourse[2], values[0], values[1], values[2]);
        }
        System.out.println(
                "+------+--------------------+----------------------------------------+-----+----------------+----------------+------------------+");

    }
}
