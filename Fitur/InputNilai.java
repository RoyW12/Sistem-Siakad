package Fitur;

import java.util.Scanner;

public class InputNilai {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String mahasiswa1 = "Hizkia"; // data master
        String nama = "";
        long nim = 0;
        long nim1 = 123456789; // data master
        String matkul1 = "", matkul2 = "", matkul3 = "", matkul4 = "", matkul5 = "", matkul6 = "", matkul7 = "",
                matkul8 = "";
        int nilaiMatkul1 = 0, nilaiMatkul2 = 0, nilaiMatkul3 = 0, nilaiMatkul4 = 0, nilaiMatkul5 = 0, nilaiMatkul6 = 0,
                nilaiMatkul7 = 0,
                nilaiMatkul8 = 0;
        boolean isFind = false;

        while (!isFind) {
            System.out.print("Masukkan nama mahasiswa   : ");
            nama = input.nextLine();
            System.out.print("Masukkan NIM mahasiswa    : ");
            nim = input.nextLong();
            input.nextLine();

            if (nama.equals(mahasiswa1)) {
                if (nim == nim1) {
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

        for (int i = 1; i <= 8; i++) {
            System.out.println("masukkan mata kuliah dan nilai mata kuliah ke " + (i) + ": ");

            if (i == 1) {
                System.out.print("nama matkul ke 1: ");
                matkul1 = input.nextLine();
                System.out.print("nilai matkul ke 1: ");
                nilaiMatkul1 = input.nextInt();
                input.nextLine();
            } else if (i == 2) {
                System.out.print("nama matkul ke 2: ");
                matkul2 = input.nextLine();
                System.out.print("nilai matkul ke 2: ");
                nilaiMatkul2 = input.nextInt();
                input.nextLine();
            } else if (i == 3) {
                System.out.print("nama matkul ke 3: ");
                matkul3 = input.nextLine();
                System.out.print("nilai matkul ke 3: ");
                nilaiMatkul3 = input.nextInt();
                input.nextLine();
            } else if (i == 4) {
                System.out.print("nama matkul ke 4: ");
                matkul4 = input.nextLine();
                System.out.print("nilai matkul ke 4: ");
                nilaiMatkul4 = input.nextInt();
                input.nextLine();
            } else if (i == 5) {
                System.out.print("nama matkul ke 5: ");
                matkul5 = input.nextLine();
                System.out.print("nilai matkul ke 5: ");
                nilaiMatkul5 = input.nextInt();
                input.nextLine();
            } else if (i == 6) {
                System.out.print("nama matkul ke 6: ");
                matkul6 = input.nextLine();
                System.out.print("nilai matkul ke 6: ");
                nilaiMatkul6 = input.nextInt();
                input.nextLine();
            } else if (i == 7) {
                System.out.print("nama matkul ke 7: ");
                matkul7 = input.nextLine();
                System.out.print("nilai matkul ke 7: ");
                nilaiMatkul7 = input.nextInt();
                input.nextLine();
            } else if (i == 8) {
                System.out.print("nama matkul ke 8: ");
                matkul8 = input.nextLine();
                System.out.print("nilai matkul ke 8: ");
                nilaiMatkul8 = input.nextInt();
                input.nextLine();
            }

        }

        System.out.println("--------------------");
        System.out.println(" Data mahasiswa ");
        System.out.println("--------------------");
        System.out.println("| Nama : " + nama);
        System.out.println("| NIM : " + nim);
        System.out.println("| Mata Kuliah : " + matkul1 + " dengan nilai: " + nilaiMatkul1);
        System.out.println("| Mata Kuliah : " + matkul2 + " dengan nilai: " + nilaiMatkul2);
        System.out.println("| Mata Kuliah : " + matkul3 + " dengan nilai: " + nilaiMatkul3);
        System.out.println("| Mata Kuliah : " + matkul4 + " dengan nilai: " + nilaiMatkul4);
        System.out.println("| Mata Kuliah : " + matkul5 + " dengan nilai: " + nilaiMatkul5);
        System.out.println("| Mata Kuliah : " + matkul6 + " dengan nilai: " + nilaiMatkul6);
        System.out.println("| Mata Kuliah : " + matkul7 + " dengan nilai: " + nilaiMatkul7);
        System.out.println("| Mata Kuliah : " + matkul8 + " dengan nilai: " + nilaiMatkul8);

        // String nilaiHuruf;
        // if (nilai > 80 && nilai <= 100) {
        // nilaiHuruf = "A";
        // } else if (nilai > 73 && nilai <= 80) {
        // nilaiHuruf = "B+";
        // } else if (nilai > 65 && nilai <= 73) {
        // nilaiHuruf = "B";
        // } else if (nilai > 60 && nilai <= 65) {
        // nilaiHuruf = "C+";
        // } else if (nilai > 50 && nilai <= 60) {
        // nilaiHuruf = "C";
        // } else if (nilai > 39 && nilai <= 50) {
        // nilaiHuruf = "D";
        // } else if (nilai > 0 && nilai <= 39) {
        // nilaiHuruf = "E";
        // } else {
        // nilaiHuruf = "Tidak tersedia";
        // }

        input.close();
    }
}