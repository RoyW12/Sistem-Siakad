package Fitur;

import java.util.Scanner;

public class App {
    static Scanner userInput = new Scanner(System.in);
    static String[][] userAdmin = { { "admin1", "admin1" }, { "admin2", "admin2" }, { "admin3", "admin3" } };
    static String[][] userMahasiswa = { { "mahasiswa1", "mahasiswa1" }, { "mahasiswa2", "mahasiswa2" },
            { "mahasiswa3", "mahasiswa3" } };

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
                    break;
                case 2:
                    login(choice);
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

    static boolean dosenMahasiswa(String username, String password) {
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
                isBreak = dosenMahasiswa(username, password);
                if (dosenMahasiswa(username, password)) {
                    dashboardMahasiswa(username);
                }
            }
            if (isBreak) {
                break;
            }
        }
    }

    static void dashboardAdmin(String user) {
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

    static void dashboardMahasiswa(String username) {
        renderTitle("Selamat Datang " + username);
        renderTitle("1. Cetak KHS");
        renderTitle("2. Logout");
        renderTitle("0. keluar");
    }

    static void inputDataMahasiswa() {

    }

    static void inputDataMatkul() {

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
