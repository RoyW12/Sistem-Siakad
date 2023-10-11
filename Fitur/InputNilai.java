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

        if (nilai > 80 && nilai <= 100) {
            System.out.println("| Nilai huruf : A");
        } else if (nilai > 73 && nilai <= 80 ) {
            System.out.println("| Nilai huruf : B+");
        } else if (nilai > 65 && nilai <= 73) {
            System.out.println("| Nilai huruf : B");
        } else if (nilai > 60 && nilai <= 65) {
            System.out.println("| Nilai huruf : C+");
        } else if (nilai > 50 && nilai <= 60) {
            System.out.println("| Nilai huruf : C");
        } else if (nilai > 39 && nilai <= 50) {
            System.out.println("| Nilai huruf : D");
        } else if (nilai <= 39) {
            System.out.println("| Nilai huruf : E");
        } else {
            System.out.println("| Nilai huruf tidak tersedia");
        }

       
        input.close();
    }
}


