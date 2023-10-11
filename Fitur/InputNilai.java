package Fitur;

import java.util.Scanner;

public class InputNilai {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan nama mahasiswa   : ");
        String nama = input.nextLine(); 

        System.out.print("Masukkan NIM mahasiswa    : ");
        long nim = input.nextLong();
        input.nextLine(); 

        System.out.println("----------------------");
        System.out.println("  Daftar Mata Kuliah  ");
        System.out.println("----------------------");
        System.out.println("| 1. Praktikum Daspro");
        System.out.println("| 2. Daspro");
        System.out.println("| 3. Pancasila");
        System.out.println("| 4. CTPS");
        System.out.println("| 5. Matdas");
        System.out.println("| 6. Bahasa Inggris");
        System.out.println("| 7. KTI");
        System.out.println("| 8. K3");

        System.out.print("Masukkan mata kuliah      : ");
        String matkul = input.nextLine();

        System.out.print("Masukkan nilai mahasiswa  : ");
        double nilai = input.nextDouble();


        System.out.println("--------------------");
        System.out.println("   Data mahasiswa   ");
        System.out.println("--------------------");
        System.out.println("| Nama        : " + nama);
        System.out.println("| NIM         : " + nim);
        System.out.println("| Mata Kuliah : " + matkul);
        System.out.println("| Nilai       : " + nilai);

        String nilaiHuruf;
        if (nilai > 80 && nilai <= 100) {
            nilaiHuruf = "A";
        } else if (nilai > 73 && nilai <= 80 ) {
            nilaiHuruf = "B+";
        } else if (nilai > 65 && nilai <= 73) {
            nilaiHuruf = "B";
        } else if (nilai > 60 && nilai <= 65) {
            nilaiHuruf = "C+";
        } else if (nilai > 50 && nilai <= 60) {
            nilaiHuruf = "C";
        } else if (nilai > 39 && nilai <= 50) {
            nilaiHuruf = "D";
        } else if (nilai > 0 && nilai <= 39) {
            nilaiHuruf = "E";
        } else {
            nilaiHuruf = "Tidak tersedia";
        }

        System.out.println("| Nilai huruf : " + nilaiHuruf);

        input.close();
    }
}


