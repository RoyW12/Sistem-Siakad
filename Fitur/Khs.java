package Fitur;

import java.util.Scanner;

public class Khs {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] mataKuliah = new String[8];
        String[] daftarMataKuliah = { "Pancasila", "Konsep Teknologi Informasi",
                "Critical Thinking dan problem solving", "Matematika dasar", "Bahasa Inggris", "Dasar pemrograman",
                "Praktikum daspro", "Keselamatan dan kesehatan kerja" };
        String[] kodeMatkul = { "RTI231001", "RTI231002", "RTI231003", "RTI231004", "RTI231005", "RTI231006",
                "RTI231007", "RTI231008" };
        int sks[] = { 2, 3 };
        String nama = "", matkul = "", matkul1, matkul2, matkul3, matkul4, matkul5, predikat = "";
        String namaMaster = "dina";
        int nim = 0;
        long nimMaster = 234172005;
        matkul1 = "PrakDaspro";
        matkul2 = "Daspro";
        matkul3 = "CTPS";
        matkul4 = "KTI";
        matkul5 = "K3";
        int bobotMatkul1 = 0, bobotMatkul2 = 0, bobotMatkul3 = 0, bobotMatkul4 = 0, bobotMatkul5 = 0,
                sks1 = 0,
                sks2 = 0, sks3 = 0, sks4 = 0, sks5 = 0, totSKS = 0;
        double ips;
        boolean isFind = false;

        while (!isFind) {
            System.out.print("Masukkan nama    : ");
            nama = input.nextLine();
            System.out.print("Masukkan NIM     : ");
            nim = input.nextInt();
            input.nextLine();

            if (nama.equals(namaMaster)) {
                if (nim == nimMaster) {
                    isFind = true;
                } else {
                    System.out.println("nim salah");
                    continue;
                }
            } else {
                System.out.println("mahasiswa tidak ditemukan");
                continue;
            }
        }

        int i = 1;
        while (i <= 5) {
            System.out.println("Pilihan Matkul Urut- PrakDaspro, Daspro, CTPS, KTI, K3");
            System.out.print("Masukkan Matkul ke-" + i + ": ");
            matkul = input.next();

            i++;

            if (matkul.equalsIgnoreCase(matkul1)) {
                System.out.print("Masukkan jumlah sks matkul : ");
                sks1 = input.nextInt();
                System.out.print("Masukkan jumlah bobot matkul : ");
                bobotMatkul1 = input.nextInt();
                input.nextLine();
            } else if (matkul.equalsIgnoreCase(matkul2)) {
                System.out.print("Masukkan jumlah sks matkul : ");
                sks2 = input.nextInt();
                System.out.print("Masukkan jumlah bobot matkul : ");
                bobotMatkul2 = input.nextInt();
                input.nextLine();
            } else if (matkul.equalsIgnoreCase(matkul3)) {
                System.out.print("Masukkan jumlah sks matkul : ");
                sks3 = input.nextInt();
                System.out.print("Masukkan jumlah bobot matkul : ");
                bobotMatkul3 = input.nextInt();
                input.nextLine();
            } else if (matkul.equalsIgnoreCase(matkul4)) {
                System.out.print("Masukkan jumlah sks matkul : ");
                sks4 = input.nextInt();
                System.out.print("Masukkan jumlah bobot matkul : ");
                bobotMatkul4 = input.nextInt();
                input.nextLine();
            } else if (matkul.equalsIgnoreCase(matkul5)) {
                System.out.print("Masukkan jumlah sks matkul : ");
                sks5 = input.nextInt();
                System.out.print("Masukkan jumlah bobot matkul : ");
                bobotMatkul5 = input.nextInt();
                input.nextLine();
            } else {
                i--;
                System.out.println("Matkul invalid");
                continue;
            }
            totSKS = sks1 + sks2 + sks3 + sks4 + sks5;

        }

        ips = ((sks1 * bobotMatkul1) + (sks2 * bobotMatkul2) + (sks3 * bobotMatkul3) + (sks4 * bobotMatkul4)
                + (sks5 * bobotMatkul5)) / totSKS;
        if (ips < 4) {
            if (ips <= 4 && ips > 2) {
                predikat = "anda lulus semester";
            } else {
                predikat = "anda tidak lulus semester";
            }
        } else {
            System.out.println("nilai ips tidak terdefinisi");
        }

        System.out.println("+-------------------------------------------------------------------------");
        System.out.println("| KARTU HASIL STUDI   %-10s|");
        System.out.println("+-------------------------------------------------------------------------");
        System.out.println("| Nama        : " + nama + " %-10s|");
        System.out.println("| Nim        : " + nim + " %-10s|");
        System.out.println("+------+------------+----------------------+-------+----------------------+-----+");
        System.out.println("| No.  |    Kode Matkul     |      Mata Kuliah     | SKS |    Nilai Huruf    | Nilai |");
        System.out.println("+------+------------+----------------------+-------+----------------------+-----+");
        // for (int i = 0; i < nama.length; i++) {
        // String[] student = nama[i];
        // System.out.printf("| %-4d | %-10s | %-20s | %-5s | %-20s | %s |\n", (i + 1),
        // student[0], student[1],
        // student[2],
        // student[3], student[4]);
        // }
        // System.out.println("+------+------------+----------------------+-------+----------------------+-----+");

        // System.out.println("------------------------------------------------------------------");
        // System.out.println("|\t\t\t KARTU HASIL STUDI \t\t\t|");
        // System.out.println("|----------------------------------------------------------------|");
        // System.out.println("| Nama : " + nama);
        // System.out.println("| NIM : " + nim);
        // System.out.println(
        // "| Mata Kuliah 1 : " + matkul1 + " dengan sks " + sks1 + " dengan bobot nilai
        // " + bobotMatkul1);
        // System.out.println(
        // "| Mata Kuliah 2 : " + matkul2 + " dengan sks " + sks2 + " dengan bobot nilai
        // " + bobotMatkul2);
        // System.out.println(
        // "| Mata Kuliah 3 : " + matkul3 + " dengan sks " + sks3 + " dengan bobot nilai
        // " + bobotMatkul3);
        // System.out.println(
        // "| Mata Kuliah 4 : " + matkul4 + " dengan sks " + sks4 + " dengan bobot nilai
        // " + bobotMatkul4);
        // System.out.println(
        // "| Mata Kuliah 5 : " + matkul5 + " dengan sks " + sks5 + " dengan bobot nilai
        // " + bobotMatkul5);
        // System.out.println("| ips : " + ips + " \t\t\t\t\t\t |");
        // System.out.println("|________________________________________________________________|");
        // System.out.println("| Status anda adalah " + predikat + "\t\t\t |");
        // System.out.println("|________________________________________________________________|");

    }
}
