import java.util.Scanner;

public class InputMatkul {

    static Scanner userInput = new Scanner(System.in);

    // string input matkul
    static String[][] course = {
            { "RTI231001", "Pancasila", "2" },
            { "RTI231002", "Konsep Teknologi Informasi", "2" },
            { "RTI231003", "Critical Thinking dan Problem Solving", "2" }
    };

    public static void main(String[] args) {
        System.out.println("=== Dashboard Admin ===");
        System.out.println("1. Input data mata kuliah ke master");
        System.out.println("2. comingsoon");
        System.out.println("3. Logout");
        System.out.println("0. Keluar");
        System.out.print("pilih fitur: ");
        int choice = getUserChoice();
        switch (choice) {
            case 1:
                clearConsole();
                inputDataMatkul();
                break;
            case 2:
                clearConsole();
                cetakKHS();
                break;
            case 3:
                clearConsole();
                break;
            case 0:
                System.exit(choice);
        }
    }

    static void inputDataMatkul() {
        String courseCode, courseName, sks;
        boolean isFind = false;
        renderTitle("Press enter to continue...");
        userInput.nextLine().trim();
        clearConsole();
        renderCourseTable("Course data", course);
        while (!isFind) {
            System.out.print("Course Code       :");
            courseCode = userInput.nextLine();
            System.out.print("Course Name       :");
            courseName = userInput.nextLine();
            System.out.print("SKS               :");
            sks = userInput.nextLine();

            if (courseCode.length() == 9) {
                for (int i = 0; i < course.length; i++) {
                    if (courseCode.equals(course[i][0])) {
                        clearConsole();
                        System.out.println("Course with the Course code of " + courseCode + " already exists!");
                        System.out.println("Masukkan data kembali");
                        isFind = false;
                        break;
                    } else {
                        isFind = true;
                    }
                    ;
                }
            } else {
                clearConsole();
                System.out.println("Kode Mata Kuliah harus 9 digit");
            }
            if (isFind) {
                String[][] newCourse = new String[course.length + 1][3];
                for (int i = 0; i < course.length; i++) {
                    newCourse[i] = course[i];
                }
                newCourse[newCourse.length - 1] = new String[] { courseCode, courseName, sks };
                course = newCourse;
                renderCourseTable("Course data", course);
                renderTitle("press enter to continue...");
                userInput.nextLine().trim();
                clearConsole();
            }
        }
    }

    static void renderCourseTable(String title, String[][] course) {
        renderTitle(title);
        System.out.println("+------+--------------------+----------------------------------------+-----+");
        System.out.println("| No.  |    Course Code     |               Course Name              | SKS |");
        System.out.println("+------+--------------------+----------------------------------------+-----+");
        for (int i = 0; i < course.length; i++) {
            String[] newCourse = course[i];
            System.out.printf("| %-4d | %-18s | %-38s | %-3s |\n", (i + 1), newCourse[0], newCourse[1],
                    newCourse[2]);
        }
        System.out.println("+------+--------------------+----------------------------------------+-----+");
    }

    static void cetakKHS() {

    }

    static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static void renderTitle(String title) {
        System.out.println(title);
    }

    static int getUserChoice() {
        int choice = -1;

        try {
            choice = userInput.nextInt();
            userInput.nextLine();
        } catch (Exception e) {
            System.out.println("Inputan salah");
            userInput.nextLine();
        }
        return choice;
    }
}
