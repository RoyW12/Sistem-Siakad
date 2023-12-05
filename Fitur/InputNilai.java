package Fitur;

import java.util.Scanner;

public class InputNilai {

    static Scanner input15 = new Scanner(System.in);

    public static void main(String[] args) {

        String nim = "";
        int indexStudent = -1;

        String[][] students = {
                { "1234560001", "Roy wijaya", "1A", "Teknik Informatika", "L" },
                { "1234560002", "Hizkia Elsadanta", "1G", "Teknik Informatika", "L" },
                { "1234560003", "Joko Widodo", "1C", "Teknik Informatika", "L" },
                { "1234560004", "Ganjar Pranowo", "1D", "Teknik Informatika", "L" },
                { "1234560005", "Megawati", "1E", "Manajemen", "P" }
        };

        String[][] course = {
                { "RTI231001", "Pancasila", "2" },
                { "RTI231002", "KTI", "2" },
                { "RTI231003", "CTPS", "2" }
        };

        String[][] grades = new String[students.length][course.length * 4]; 

        while (indexStudent == -1) {
            System.out.print("Masukkan NIM mahasiswa   : ");
            nim = input15.nextLine();
            for (int i = 0; i < students.length; i++) {
                if (nim.equalsIgnoreCase(students[i][0])) {
                    indexStudent = i;
                    displayStudentInfo(students[indexStudent]);
                }
            }
            if (indexStudent == -1) {
                System.out.println("Data tidak ditemukan. Silakan coba lagi.");
            }
        }

        input15.nextLine(); 
        clearConsole();

        displayCourseInfo(course, grades, indexStudent);

        inputGrades(course, grades, indexStudent);
        
        displayStudentInfo(students[indexStudent]);
        displayCourseInfo(course, grades, indexStudent);
    }

    private static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void displayStudentInfo(String[] student) {
        System.out.println("-------------------------------");
        System.out.println("|          Data mahasiswa     |");
        System.out.println("-------------------------------");
        System.out.println("| Nama        : " + student[1]);
        System.out.println("| NIM         : " + student[0]);
        System.out.println("-------------------------------");
    }

    private static void displayCourseInfo(String[][] course, String[][] grades, int indexStudent) {
        System.out.println("+------+--------------------+----------------------------------------+-----+----------------+----------------+------------------+");
        System.out.println("| No.  |    Course Code     |               Course Name              | SKS | Value (Number) | Value (Letter) |     Predicate    |");
        System.out.println("+------+--------------------+----------------------------------------+-----+----------------+----------------+------------------+");
        for (int i = 0; i < course.length; i++) {
            String[] newCourse = course[i];
            int baseIndex = i * 4;
            String[] values = { grades[indexStudent][baseIndex], grades[indexStudent][baseIndex + 1],
                    grades[indexStudent][baseIndex + 2], grades[indexStudent][baseIndex + 3] };
            for (int j = 0; j < values.length; j++) {
                if (values[j] == null) {
                    values[j] = "-";
                }
            }
            System.out.printf("| %-4d | %-18s | %-38s | %-3s | %-14s | %-14s | %-16s |\n", (i + 1), newCourse[0],
                    newCourse[1],
                    newCourse[2], values[0], values[1], values[2]);
        }
        System.out.println("+------+--------------------+----------------------------------------+-----+----------------+----------------+------------------+");
    }

    private static void inputGrades(String[][] course, String[][] grades, int indexStudent) {
        for (int i = 0; i < course.length; i++) {
            int numericValue;
            while (true) {
                System.out.print("Nilai matkul " + course[i][1] + " : ");
                numericValue = input15.nextInt();
                input15.nextLine();
                if (numericValue < 0 || numericValue > 100) {
                    System.out.println("The value must be in the range 0-100. Please try again.....");
                } else {
                    break;
                }
            }

            String letterValue;
            String predicate = "";
            double equivalentValue = 0.0;
            if (numericValue > 80 && numericValue <= 100) {
                letterValue = "A";
                predicate = "Sangat baik";
                equivalentValue = 4;
            } else if (numericValue > 73 && numericValue <= 80) {
                letterValue = "B+";
                predicate = "Lebih dari baik";
                equivalentValue = 3.5;
            } else if (numericValue > 65 && numericValue <= 73) {
                letterValue = "B";
                predicate = "Baik";
                equivalentValue = 3;
            } else if (numericValue > 60 && numericValue <= 65) {
                letterValue = "C+";
                predicate = "Lebih dari cukup";
                equivalentValue = 2.5;
            } else if (numericValue > 50 && numericValue <= 60) {
                letterValue = "C";
                predicate = "Cukup";
                equivalentValue = 2;
            } else if (numericValue > 39 && numericValue <= 50) {
                letterValue = "D";
                predicate = "Kurang";
                equivalentValue = 1;
            } else if (numericValue > 0 && numericValue <= 39) {
                letterValue = "E";
                predicate = "Gagal";
                equivalentValue = 0;
            } else {
                letterValue = "Tidak tersedia";
            }

            int baseIndex = i * 4;
            grades[indexStudent][baseIndex] = String.valueOf(numericValue);
            grades[indexStudent][baseIndex + 1] = letterValue;
            grades[indexStudent][baseIndex + 2] = predicate;
            grades[indexStudent][baseIndex + 3] = Double.toString(equivalentValue);
        }
    }
}
