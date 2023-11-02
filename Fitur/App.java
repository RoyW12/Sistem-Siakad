package Fitur;

import java.util.Scanner;

public class App {
    static Scanner userInput = new Scanner(System.in);
    static String[][] userAdmin = { { "admin1", "admin1" }, { "admin2", "admin2" }, { "admin3", "admin3" } };
    static String[][] userMahasiswa = { { "mahasiswa1", "mahasiswa1" }, { "mahasiswa2", "mahasiswa2" },
            { "mahasiswa3", "mahasiswa3" } };
    static String[][] students = {
            { "1234560001", "Roy wijaya", "1A", "Teknik Informatika", "L" },
            { "1234560002", "Jessica Wongso", "1B", "Teknik Informatika", "P" },
            { "1234560003", "Joko Widodo", "1C", "Teknik Informatika", "L" },
            { "1234560004", "Ganjar Pranowo", "1D", "Teknik Informatika", "L" },
            { "1234560005", "Megawati", "1E", "Manajemen", "P" }
    };

    public static void main(String[] args) {

        loginView();
    }

    static void loginView() {
        while (true) {
            renderTitle("SISTEM SIAKAD");
            renderTitle("1. admin");
            renderTitle("2. mahasiswa");
            renderTitle("0. keluar");
            renderTitle("Pilih login sebagai => 1.admin 2.mahasiswa atau keluar pilih 0");
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    login(choice);
                    clearConsole();
                    break;
                case 2:
                    login(choice);
                    clearConsole();
                    break;
                case 0:
                    clearConsole();
                    System.exit(choice);
                    break;
                default:
                    System.out.println("user can't be found");
                    continue;
            }
            break;
        }
    }

    static boolean checkUsernamePassword(String username, String password, String[][] userArray) {
        boolean isLoggedIn = true;
        for (int i = 0; i < userArray.length; i++) {
            if (username.equals(userArray[i][0]) && password.equals(userArray[i][1])) {
                isLoggedIn = false;
                clearConsole();
                return true;
            }
        }
        if (isLoggedIn) {
            clearConsole();
            System.out.println("incorrect username and password ");

        }
        return false;
    }

    static boolean adminLogin(String username, String password) {
        return checkUsernamePassword(username, password, userAdmin);
    }

    static boolean mahasiswaLogin(String username, String password) {
        return checkUsernamePassword(username, password, userMahasiswa);
    }

    static void login(int choice) {
        while (true) {
            boolean isBreak = false;
            System.out.println("masukkan username dan password");
            System.out.print("username:");
            String username = userInput.nextLine().trim(); // trim menghapus spasi di awal dan akhir string
            System.out.print("password:");
            String password = userInput.nextLine().trim(); // trim menghapus spasi di awal dan akhir string

            if (choice == 1) {
                isBreak = adminLogin(username, password);
                if (isBreak) {
                    dashboardAdmin(username);
                }
            } else if (choice == 2) {
                isBreak = mahasiswaLogin(username, password);
                if (isBreak) {
                    dashboardMahasiswa(username);
                }
            }
            if (isBreak) {
                break;
            }
        }
    }

    static void dashboardAdmin(String user) {
        while (true) {
            renderTitle("Selamat Datang " + user);
            System.out.println("=== Dashboard Admin ===");
            System.out.println("1. Input data mahasiswa ke master");
            System.out.println("2. Update data mahasiswa");
            System.out.println("3. Input data mata kuliah ke master");
            System.out.println("4. Input nilai");
            System.out.println("5. Logout");
            System.out.println("0. Keluar");
            System.out.print("pilih fitur: ");
            int choice = getUserChoice();
            switch (choice) {
                case 1:
                    clearConsole();
                    inputDataMahasiswa();
                    break;
                case 2:
                    clearConsole();
                    updateDataMahasiswa();
                    break;
                case 3:
                    clearConsole();
                    inputDataMatkul();
                    break;
                case 4:
                    clearConsole();
                    inputNilai();
                    break;
                case 5:
                    clearConsole();
                    loginView();
                    break;
                case 0:
                    System.exit(choice);
            }
        }
    }

    static void inputDataMahasiswa() {
        String nim, fullName, classPlacement, studyProgram, sex;
        boolean isFind = false;
        renderTitle("press enter to continue...");
        userInput.nextLine().trim();
        clearConsole();
        renderStudentsTable("Data's Student", students);
        while (!isFind) {
            System.out.print("NIM               :");
            nim = userInput.nextLine();
            System.out.print("Full Name         :");
            fullName = userInput.nextLine();
            System.out.print("Class             :");
            classPlacement = userInput.nextLine();
            System.out.print("Study Program     :");
            studyProgram = userInput.nextLine();
            System.out.print("Sex               :");
            sex = userInput.nextLine();
            if (nim.length() == 10) {
                for (int i = 0; i < students.length; i++) {
                    if (nim.equals(students[i][0])) {
                        clearConsole();
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
                clearConsole();
                System.out.println("NIM harus 10 digit");
            }
            if (isFind) {
                String[][] newStudents = new String[students.length + 1][2];
                for (int i = 0; i < students.length; i++) {
                    newStudents[i] = students[i];
                }
                newStudents[newStudents.length - 1] = new String[] { nim, fullName, classPlacement, studyProgram, sex };
                students = newStudents;
                renderStudentsTable("Data's Student", students);
                renderTitle("press enter to continue...");
                userInput.nextLine().trim();
                clearConsole();
            }
        }
    }

    static void renderStudentsTable(String title, String[][] students) {
        renderTitle(title);
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
    }

    static void dashboardMahasiswa(String user) {

        while (true) {
            renderTitle("Selamat Datang " + user);
            System.out.println("=== Dashboard Mahasiswa ===");
            renderTitle("1. Cetak KHS");
            renderTitle("2. Logout");
            renderTitle("0. keluar");
            System.out.print("pilih fitur: ");
            int choice = getUserChoice();
            switch (choice) {
                case 1:
                    clearConsole();
                    cetakKHS();
                    break;
                case 2:
                    clearConsole();
                    loginView();
                    break;
                case 0:
                    System.exit(choice);
            }
        }

    }

    static void inputDataMatkul() {

    }

    static void cetakKHS() {

    }

    static void inputNilai() {

    }

    static void updateDataMahasiswa() {

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
