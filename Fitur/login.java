package Fitur;

import java.util.Scanner;

public class login {
    public static void main(String[] args) {
        Scanner input28 = new Scanner(System.in);
        String usernameAdmin = "admin";
        String passwordAdmin = "admin123";
        String usernameMahasiswa = "mahasiswa";
        String passwordMahasiswa = "mahasiswa123";
        String userInput, passInput;
        String level = "";
        boolean isFind = false;
        while (!isFind) {
            System.out.println("input username");
            userInput = input28.nextLine();
            System.out.println("input password");
            passInput = input28.nextLine();
            if (userInput.equals(usernameAdmin)) {
                if (passInput.equals(passwordAdmin)) {
                    level = "admin";
                    isFind = true;
                } else {
                    System.out.println("password salah");
                }
            } else if (userInput.equals(usernameMahasiswa)) {
                if (passInput.equals(passwordMahasiswa)) {
                    level = "mahasiswa";
                    isFind = true;
                } else {
                    System.out.println("Password salah");
                }
            } else {
                System.out.println("user tidak ditemukan");
            }
        }
        if (level == "admin") {
            System.out.println("selamat datang admin");
            System.out.println("pilih fitur: ");
            System.out.println("1. edit bio");
            System.out.println("2. input nilai");
            System.out.println("3. input data nata kuliah");
            System.out.println("4. keluar");
        } else if (level == "mahasiswa") {
            System.out.println("selamat datang mahasiswa");
            System.out.println("pilih fitur: ");
            System.out.println("1. cetak khs");
            System.out.println("2. keluar");
        }

    }
}
