package Fitur;

import java.util.Scanner;

public class InputMatkul {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String username = "", password = "";
        String jurusan = "";
        String matkul = "";
        int sks = 0;
        int bobot = 0;

        // Login admin
        System.out.print("Masukkan username : ");
        username = input.nextLine();
        System.out.print("Masukkan password : ");
        password = input.nextLine();

        if (username.equals("admin") && password.equals("admin")) {

            // Pilih jurusan
            System.out.println("Pilih jurusan : ");
            System.out.println("1. Teknik Informatika");
            System.out.println("2. Sistem Informasi");
            int pilihanJurusan = input.nextInt();

            switch (pilihanJurusan) {
                case 1:
                    jurusan = "Teknik Informatika";
                    break;
                case 2:
                    jurusan = "Sistem Informasi";
                    break;
                default:
                    System.out.println("Pilihan jurusan tidak valid");
                    return;
            }

            // Input data mata kuliah
            System.out.println("Masukkan nama mata kuliah : ");
            matkul = input.nextLine();
            System.out.println("Masukkan jumlah sks : ");
            sks = input.nextInt();
            System.out.println("Masukkan bobot nilai : ");
            bobot = input.nextInt();

            // Tampilkan data mata kuliah
            System.out.println("Data mata kuliah : ");
            System.out.println("Jurusan : " + jurusan);
            System.out.println("Nama mata kuliah : " + matkul);
            System.out.println("Jumlah sks : " + sks);
            System.out.println("Bobot nilai : " + bobot);
        } else {
            System.out.println("Login gagal");
        }
    }
}
