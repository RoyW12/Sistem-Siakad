package Fitur;

import java.util.Scanner;

public class InputNilai {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] mahasiswa = {"Hizkia Elsadanta", "Roy Wijaya", "Dina Rahmawati", "Engel Khen", "Andreas Nathanael"};
        String[] nim = {"1234567890", "1234567891", "1234567892", "1234567893", "1234567894"};
        String[] mataKuliah = new String[8];
        int[] nilaiMataKuliah = new int[8];
        String[] daftarMataKuliah = { "Praktikum Daspro", "Daspro", "Pancasila", "CTPS", "Matdas", "Bahasa Inggris", "KTI", "K3" };
        String nama = "";
        String nimInput = "";
        boolean isFind = false;

        while (!isFind) {
            System.out.print("Masukkan nama mahasiswa   : ");
            nama = input.nextLine();
            System.out.print("Masukkan NIM mahasiswa    : ");
            nimInput = input.nextLine();

            for (int i = 0; i < mahasiswa.length; i++) {
                if (nama.equalsIgnoreCase(mahasiswa[i]) && nimInput.equals(nim[i])) {
                    System.out.println("Data ditemukan");
                    isFind = true;
                    break;
                }
            }
            
            if (!isFind) {
                System.out.println("Data tidak ditemukan. Silakan coba lagi.");
            }
        }
        
        System.out.println(" ______________________");
        System.out.println("|  Daftar Mata Kuliah  |");
        System.out.println("|----------------------|");

        for (int i = 0; i < daftarMataKuliah.length; i++) {
            System.out.println(" " + (i + 1) + ". " + daftarMataKuliah[i]);
        }

        System.out.println("|______________________|");
        System.out.print("\n");

        for (int i = 0; i < mataKuliah.length; i++) {
            System.out.println("Mata Kuliah       : " + daftarMataKuliah[i]);
            mataKuliah[i] = daftarMataKuliah[i];

            System.out.print("Nilai matkul ke " + (i + 1) + " : ");
            nilaiMataKuliah[i] = input.nextInt();
            input.nextLine();
            System.out.println("------------------------------------");
        }

        System.out.print("\n");

        System.out.println("-------------------------------------");
        System.out.println("|          Data mahasiswa           |");
        System.out.println("-------------------------------------");
        System.out.println("| Nama        : " + nama);
        System.out.println("| NIM         : " + nimInput);
        System.out.println("-------------------------------------");

        for (int i = 0; i < nilaiMataKuliah.length; i++) {
            System.out.println("| Mata Kuliah : " + mataKuliah[i]);
            System.out.println("| Nilai       : " + nilaiMataKuliah[i]);
            System.out.println("-------------------------------------");
        }

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




       
