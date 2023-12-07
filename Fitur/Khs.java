package Fitur;

public class Khs {
    static String[] students = { "1234560005", "Sinta", "1E", "TI", "P" };

    static String[][] course = {
            { "RTI231001", "Pancasila", "2" },
            { "RTI231002", "KTI", "2" },
            { "RTI231003", "CTPS", "3" },
            { "RTI231004", "Prakdaspro", "3" },
    };

    static String[][] grades = {
            { "90", "A", "4.0" },
            { "59", "C", "2.0" },
            { "78", "B+", "3.5" },
            { "70", "B", "3.0" },
    };

    public static void main(String[] args) {
        displayStudentData();
        renderKhsTable();
    }

    static void displayStudentData() {
        System.out.println("-------------------------------------");
        System.out.println("|      Study Results Card           |");
        System.out.println("-------------------------------------");
        System.out.println("| Full Name     : " + students[1]);
        System.out.println("| NIM           : " + students[0]);
        System.out.println("| Class         : " + students[2]);
        System.out.println("| Study Program : " + students[3]);
        System.out.println(
                "\n-------------------------------------");
    }

    static void renderKhsTable() {

        System.out.println(
                "+------+--------------------+----------------------------------------+--------------------+----------------+------+------------+");
        System.out.println(
                "| No.  |    Course Code     |               Course Name              | Value (equivalent) | Value (Letter) |  SKS |   N X SKS  |");
        System.out.println(
                "+------+--------------------+----------------------------------------+--------------------+----------------+------+------------+");
        Double totResult = 0.0, totSks = 0.0, ip = 0.0;
        String status = "";
        for (int i = 0; i < course.length; i++) {
            String[] newCourse = course[i];
            String[] values = grades[i];
            Double result = Double.parseDouble(newCourse[2]) * Double.parseDouble(values[2]);
            totSks += Double.parseDouble(newCourse[2]);
            totResult += result;
            System.out.printf("| %-4d | %-18s | %-38s | %-18s | %-14s | %-4s | %-10s |\n", (i + 1), newCourse[0],
                    newCourse[1],
                    values[2], values[1], newCourse[2], result);
        }
        System.out.println(
                "+------+--------------------+----------------------------------------+--------------------+----------------+------+------------+");
        System.out.printf("| %-104s | %-4s | %-10s |\n", "Jumlah", totSks, totResult);
        System.out.println(
                "+------+--------------------+----------------------------------------+--------------------+----------------+------+------------+");
        ip = totResult / totSks;
        System.out.printf("| %-124s |\n", "IP = " + ip);
        for (int i = 0; i < course.length; i++) {
            String[] values = grades[i];
            if (values[1] == "E") {
                status = "Tidak Lulus";
                break;
            } else {
                status = "Lulus";
            }
        }
        System.out.printf("| %-124s |\n", "Status = " + status);
        System.out.println(
                "+------+--------------------+----------------------------------------+--------------------+----------------+------+------------+");
    }
}
