package Fitur;

import java.util.Scanner;

public class CetakKhs {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String nama = "", matkul = "", matkul1, matkul2, matkul3, matkul4, matkul5, predikat = "";
        matkul1 = "PrakDaspro";
        matkul2 = "Daspro";
        matkul3 = "CTPS";
        matkul4 = "KTI";
        matkul5 = "K3";
        String namaMaster = "dina";
        long nim = 0;
        long nimMaster = 234172005;

        int[] sks = new int[5];
        int[] bobot = new int[5];
        int[] totSKS = new int[1];
        double[] ips = new double[1];
        boolean isFind = false;

        while (!isFind) {
            System.out.print("Masukkan nama    : ");
            nama = input.nextLine();
            System.out.print("Masukkan NIM     : ");
            nim = input.nextLong();
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
                sks[0] = input.nextInt();
                bobot[0] = input.nextInt();
                input.nextLine();
            } else if (matkul.equalsIgnoreCase(matkul2)) {
                sks[1] = input.nextInt();
                bobot[1] = input.nextInt();
                input.nextLine();
            } else if (matkul.equalsIgnoreCase(matkul3)) {
                sks[2] = input.nextInt();
                bobot[2] = input.nextInt();
                input.nextLine();
            } else if (matkul.equalsIgnoreCase(matkul4)) {
                sks[3] = input.nextInt();
                bobot[3] = input.nextInt();
                input.nextLine();
            } else if (matkul.equalsIgnoreCase(matkul5)) {
                sks[4] = input.nextInt();
                bobot[4] = input.nextInt();
                input.nextLine();
            } else {
                i--;
                System.out.println("Matkul invalid");
                continue;
            }
            totSKS[0] += sks[i - 1];

        }

        ips[0] = ((sks[0] * bobot[0]) + (sks[1] * bobot[1]) + (sks[2] * bobot[2]) + (sks[3] * bobot[3])
                + (sks[4] * bobot[4])) / totSKS[0];
        if (ips[0] < 4) {
            if (ips[0] <= 4 && ips[0] > 2) {
                predikat = "anda lulus semester";
            } else {
                predikat = "anda tidak lulus semester";
            }
        } else {
            System.out.println("nilai ips tidak terdefinisi");
        }

        System.out.println("------------------------------------------------------------------");
        System.out.println("|\t\t\t  KARTU HASIL STUDI   \t\t\t|");
        System.out.println("|----------------------------------------------------------------|");
        System.out.println("| Nama          : " + nama);
        System.out.println("| NIM           : " + nim);
        System.out.println(
            "| Mata Kuliah 1 : " + matkul1 + " dengan sks " + sks[0] + " dengan bobot nilai " + bobot[0]);
            System.out.println(
                    "| Mata Kuliah 2 : " + matkul2 + " dengan sks " + sks[1] + " dengan bobot nilai " + bobot[1]);
            System.out.println(
                    "| Mata Kuliah 3 : " + matkul3 + " dengan sks " + sks[2] + " dengan bobot nilai " + bobot[2]);
            System.out.println(
                    "| Mata Kuliah 4 : " + matkul4 + " dengan sks " + sks[3] + " dengan bobot nilai " + bobot[3]);
            System.out.println(
                    "| Mata Kuliah 5 : " + matkul5 + " dengan sks " + sks[4] + " dengan bobot nilai " + bobot[4]);
            System.out.println("| ips           : " + ips[i] + "  \t\t\t\t\t\t |");
            System.out.println("|________________________________________________________________|");
            System.out.println("| Status anda adalah " + predikat + "\t\t\t |");
            System.out.println("|________________________________________________________________|");
    
        }
    }
