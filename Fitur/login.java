package Fitur;

import java.util.Scanner;

public class login {
    static String[][] userAdmin = { { "admin", "admin123" }, { "admin", "admin456" } };
    static String[][] userMahasiswa = { { "mahasiswa", "mahasiswa" }, { "mahasiswa1", "mahasiswa1" } };
    static Scanner sc28 = new Scanner(System.in);

    public static void main(String[] args) {

        login();
    }

    static void login() {
        boolean isBreak = false;
        String level = null;
        while (!isBreak) {
            System.out.println("masukkan username dan password");
            System.out.print("username:");
            String username = sc28.nextLine().trim(); // trim menghapus spasi di awal dan akhir string
            System.out.print("password:");
            String password = sc28.nextLine().trim(); // trim menghapus spasi di awal dan akhir string
            if (username.equals("admin")) {
                for (int i = 0; i < userAdmin.length; i++) {
                    if (username.equalsIgnoreCase(userAdmin[i][0]) && password.equalsIgnoreCase(userAdmin[i][1])) {
                        isBreak = true;
                        level = "admin";
                    }
                }

            } else if (username.equals("mahasiswa")) {
                for (int i = 0; i < userMahasiswa.length; i++) {
                    if (username.equalsIgnoreCase(userMahasiswa[i][0])
                            && password.equalsIgnoreCase(userMahasiswa[i][1])) {
                        isBreak = true;
                        level = "mahasiswa";
                    }
                }
            } else {
                System.out.println("user tidak ditemukan");
                isBreak = false;
            }
        }
        if (level == "admin") {
            dashboardAdmin();
        } else if (level == "mahasiswa") {
            dashboardMahasiswa();
        }
    }

    static void dashboardAdmin() {
        System.out.println("selamat datang admin");
        System.out.println("pilih fitur: ");
        System.out.println("1. edit bio");
        System.out.println("2. input nilai");
        System.out.println("3. input data nata kuliah");
        System.out.println("4. keluar");
    }

    static void dashboardMahasiswa() {
        System.out.println("selamat datang mahasiswa");
        System.out.println("pilih fitur: ");
        System.out.println("1. cetak khs");
        System.out.println("2. keluar");
    }
}
