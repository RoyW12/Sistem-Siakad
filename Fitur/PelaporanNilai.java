package Fitur;

import java.util.Arrays;
import java.util.Comparator;

public class PelaporanNilai {

    static String[][] students = {
        { "1234560001", "Roy wijaya", "1A", "TI", "L" },
        { "1234560002", "Prabowo Subianto", "1B", "TI", "P" },
        { "1234560003", "Joko Widodo", "1C", "TI", "L" },
        { "1234560004", "Ganjar Pranowo", "1D", "TI", "L" },
        { "1234560005", "Megawati", "1E", "TI", "P" }
    };

    static String[][] course = {
        { "RTI231001", "Pancasila", "2" },
        { "RTI231002", "KTI", "2" },
        { "RTI231003", "CTPS", "2" }
    };

    static String[][] grades = {
        { "90", "A", "80", "B", "96", "C" },
        { "80", "B", "70", "C", "87", "A" },
        { "80", "C", "80", "A", "78", "B" },
        { "80", "A", "60", "B", "60", "C" },
        { "88", "B", "90", "C", "90", "A" }
    };

    public static void main(String[] args) {
        String blueColor = "\u001B[34m";
        String redColor = "\u001B[31m";
        String resetColor = "\u001B[0m";

        Arrays.sort(students, Comparator.comparing(student -> student[1]));

        System.out.println(redColor + "-------------------------------------" + resetColor);
        System.out.println(redColor + "|      Laporan Nilai Mahasiswa       |" + resetColor);
        System.out.println(redColor + "-------------------------------------" + resetColor);

        System.out.println(
                "------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("| %-19s | %-26s | %-16s | %-31s |", blueColor + "NIM" + resetColor, blueColor + "Nama" + resetColor,
                blueColor + "Kelas" + resetColor, blueColor + "Program Studi" + resetColor);

        for (int j = 0; j < course.length; j++) {
            System.out.format(" %-19s |", blueColor + course[j][1] + resetColor);
        }

        System.out.println(
                "\n------------------------------------------------------------------------------------------------------------------------------");

        displayColumnsAndGrades();
    }

    static void displayColumnsAndGrades() {
        for (int i = 0; i < students.length; i++) {
            System.out.format("| %-10s | %-17s | %-7s | %-22s |", students[i][0], students[i][1], students[i][2],
                    students[i][3], students[i][4]);
                    
            for (int j = 0; j < course.length; j++) {
                String grade = grades[i][j * 2];
                String comment = grades[i][j * 2 + 1];

                if (grade == null) {
                    System.out.format(" %-10s |", "-");
                } else {
                    System.out.format(" %-10s |", grade + " (" + comment + ")");
                }
            }
            System.out.println(
                    "\n------------------------------------------------------------------------------------------------------------------------------");
        }
    }
}
