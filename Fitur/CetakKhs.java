package Fitur;

import java.util.Scanner;

public class CetakKhs {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String nama, matkul1, matkul2, matkul3, matkul4, matkul5, predikat;
        long nim;
        double bobotMatkul1, bobotMatkul2, bobotMatkul3, bobotMatkul4, bobotMatkul5, ips;
        int sks1, sks2, sks3, sks4, sks5;

        System.out.print("Masukkan Nama : ");
        nama = input.nextLine();
        System.out.print("Masukkan Nim : ");
        nim = input.nextLong();
        System.out.print("Masukkan sks 1 : ");
        sks1 = input.nextInt();
        System.out.print("Masukkan sks 2 : ");
        sks2 = input.nextInt();
        System.out.print("Masukkan sks 3 : ");
        sks3 = input.nextInt();
        System.out.print("Masukkan sks 4 : ");
        sks4 = input.nextInt();
        System.out.print("Masukkan sks 5 : ");
        sks5 = input.nextInt();
        System.out.print("Masukkan Matkul 1 : ");
        matkul1 = input.nextLine();
        System.out.print("Masukkan Matkul 2 : ");
        matkul2 = input.nextLine();
        System.out.print("Masukkan Matkul 3 : ");
        matkul3 = input.nextLine();
        System.out.print("Masukkan Matkul 4 : ");
        matkul4 = input.nextLine();
        System.out.print("Masukkan Matkul 5 : ");
        matkul5 = input.nextLine();
        System.out.print("Masukkan Bobot Matkul 1 : ");
        bobotMatkul1 = input.nextDouble();
        System.out.print("Masukkan Bobot Matkul 2 : ");
        bobotMatkul2 = input.nextDouble();
        System.out.print("Masukkan Bobot Matkul 3 : ");
        bobotMatkul3 = input.nextDouble();
        System.out.print("Masukkan Bobot Matkul 4 : ");
        bobotMatkul4 = input.nextDouble();
        System.out.print("Masukkan Bobot Matkul 5 : ");
        bobotMatkul5 = input.nextDouble();

        ips = (bobotMatkul1 * sks1) + (bobotMatkul2 * sks2) + (bobotMatkul3 * sks3) + (bobotMatkul4 * sks4)
                + (bobotMatkul5 * sks5);

        System.out.println("--------------------");
        System.out.println("   KHS mahasiswa   ");
        System.out.println("--------------------");
        System.out.println("| Nama                 : " + nama);
        System.out.println("| NIM                  : " + nim);
        System.out.println("| SKS 1 - 5            : " + sks1 + "," + sks2 + "," + sks3 + "," + sks4 + "," + sks5);
        System.out.println("| Bobot Matkul 1 - 5   : " + bobotMatkul1 + "," + bobotMatkul2 + "," + bobotMatkul3 + ","
                + bobotMatkul4 + "," + bobotMatkul5);
        System.out.println("| IPS                 : " + ips);

        predikat = "belum terdefinisi";
        if (ips < 4) {
            if (ips < 4 && ips > 2) {
                predikat = "Anda lulus semester";
            } else {
                predikat = "Anda tidak lulus semester";
            }
        } else {
            System.out.println("Nilai Ips tidak terdefinisi");
        }
        System.out.println("| Predikat            : " + predikat);

        input.close();
    }
}
