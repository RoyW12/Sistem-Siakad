package Fitur;

import java.util.Scanner;

public class InputNilai {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String mahasiswa1 = "Hizkia"; // data master
        long nim1 = 123456789; // data master
        String nama = "";
        long nim = 0;
        String matkul1 = "", matkul2 = "", matkul3 = "", matkul4 = "", matkul5 = "", matkul6 = "", matkul7 = "", matkul8 = "";
        int nilaiMatkul1 = 0, nilaiMatkul2 = 0, nilaiMatkul3 = 0, nilaiMatkul4 = 0, nilaiMatkul5 = 0, nilaiMatkul6 = 0, nilaiMatkul7 = 0, nilaiMatkul8 = 0;
        boolean isFind = false;

        while (!isFind) {
            System.out.print("Masukkan nama mahasiswa   : ");
            nama = input.nextLine();
            System.out.print("Masukkan NIM mahasiswa    : ");
            nim = input.nextLong();
            input.nextLine();

            if ((nama.equals(mahasiswa1)) && (nim == nim1)) {
                isFind = true;
            } else {
                System.out.println("Data tidak ditemukan");
                continue;
            }
        }

        System.out.println(" ______________________");
        System.out.println("|  Daftar Mata Kuliah  |");
        System.out.println("|----------------------|");
        System.out.println("| 1. Praktikum Daspro  |");
        System.out.println("| 2. Daspro            |");
        System.out.println("| 3. Pancasila         |");
        System.out.println("| 4. CTPS              |");
        System.out.println("| 5. Matdas            |");
        System.out.println("| 6. Bahasa Inggris    |");
        System.out.println("| 7. KTI               |");
        System.out.println("| 8. K3                |");
        System.out.println("|______________________|");

        System.out.print("\n");

        for (int i = 1; i <= 8; i++) {

            String mataKuliah;
            switch (i) {
                case 1:
                    mataKuliah = "Praktikum Daspro";
                    break;
                case 2:
                    mataKuliah = "Daspro";
                    break;
                case 3:
                    mataKuliah = "Pancasila";
                    break;
                case 4:
                    mataKuliah = "CTPS";
                    break;
                case 5:
                    mataKuliah = "Matdas";
                    break;
                case 6:
                    mataKuliah = "Bahasa Inggris";
                    break;
                case 7:
                    mataKuliah = "KTI";
                    break;
                case 8:
                    mataKuliah = "K3";
                    break;
                default:
                    mataKuliah = "Mata Kuliah Tidak Valid";
                    break;
            }

            System.out.println("Mata Kuliah       : " + mataKuliah);

            if (i == 1) {
                matkul1 = mataKuliah;
                System.out.print("Nilai matkul ke 1 : ");
                nilaiMatkul1 = input.nextInt();
                input.nextLine();
                System.out.println("------------------------------------");
            } else if (i == 2) {
                matkul2 = mataKuliah;
                System.out.print("Nilai matkul ke 2 : ");
                nilaiMatkul2 = input.nextInt();
                input.nextLine();
                System.out.println("------------------------------------");
            } else if (i == 3) {
                matkul3 = mataKuliah;
                System.out.print("Nilai matkul ke 3 : ");
                nilaiMatkul3 = input.nextInt();
                input.nextLine();
                System.out.println("------------------------------------");
            } else if (i == 4) {
                matkul4 = mataKuliah;
                System.out.print("Nilai matkul ke 4 : ");
                nilaiMatkul4 = input.nextInt();
                input.nextLine();
                System.out.println("------------------------------------");
            } else if (i == 5) {
                matkul5 = mataKuliah;
                System.out.print("Nilai matkul ke 5 : ");
                nilaiMatkul5 = input.nextInt();
                input.nextLine();
                System.out.println("------------------------------------");
            } else if (i == 6) {
                matkul6 = mataKuliah;
                System.out.print("Nilai matkul ke 6 : ");
                nilaiMatkul6 = input.nextInt();
                input.nextLine();
                System.out.println("------------------------------------");
            } else if (i == 7) {
                matkul7 = mataKuliah;
                System.out.print("Nilai matkul ke 7 : ");
                nilaiMatkul7 = input.nextInt();
                input.nextLine();
                System.out.println("------------------------------------");
            } else if (i == 8) {
                matkul8 = mataKuliah;
                System.out.print("Nilai matkul ke 8 : ");
                nilaiMatkul8 = input.nextInt();
                input.nextLine();
                System.out.println("------------------------------------");
            }
        }

        System.out.print("\n");
        
        System.out.println("-------------------------------------");
        System.out.println("|          Data mahasiswa           |");
        System.out.println("-------------------------------------");
        System.out.println("| Nama        : " + nama);
        System.out.println("| NIM         : " + nim);
        System.out.println("-------------------------------------");
        System.out.println("| Mata Kuliah : " + matkul1);
        System.out.println("| Nilai       : " + nilaiMatkul1);
        System.out.println("-------------------------------------");
        System.out.println("| Mata Kuliah : " + matkul2);
        System.out.println("| Nilai       : " + nilaiMatkul2);
        System.out.println("-------------------------------------");
        System.out.println("| Mata Kuliah : " + matkul3);
        System.out.println("| Nilai       : " + nilaiMatkul3);
        System.out.println("-------------------------------------");
        System.out.println("| Mata Kuliah : " + matkul4);
        System.out.println("| Nilai       : " + nilaiMatkul4);
        System.out.println("-------------------------------------");
        System.out.println("| Mata Kuliah : " + matkul5);
        System.out.println("| Nilai       : " + nilaiMatkul5);
        System.out.println("-------------------------------------");
        System.out.println("| Mata Kuliah : " + matkul6);
        System.out.println("| Nilai       : " + nilaiMatkul6);
        System.out.println("-------------------------------------");
        System.out.println("| Mata Kuliah : " + matkul7);
        System.out.println("| Nilai       : " + nilaiMatkul7);
        System.out.println("-------------------------------------");
        System.out.println("| Mata Kuliah : " + matkul8);
        System.out.println("| Nilai       : " + nilaiMatkul8);
        System.out.println("-------------------------------------");


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