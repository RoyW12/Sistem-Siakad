package Fitur;

import java.util.Scanner;

public class inputDataMahasiswa {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String mahasiswa1 = "andi"; // data master
        String nim1 = "0000000001"; // data master
        String kelasMhs1 = "1A";
        String mahasiswa2 = "Roy"; // data master
        String nim2 = "0000000002"; // data master
        String kelasMhs2 = "1A";
        String mahasiswa3 = "Jessica"; // data master
        String nim3 = "0000000003"; // data master
        String kelasMhs3 = "1A";
        String mahasiswa4 = "Jokowi"; // data master
        String nim4 = "0000000004"; // data master
        String kelasMhs4 = "1A";
        String mahasiswa5 = "felice"; // data master
        String nim5 = "0000000005"; // data master
        String kelasMhs5 = "1A";
        String nama = "";
        String nim = "";
        String kelas = "";
        String namaMaba;
        String nimMaba;
        String kelasMaba;

        boolean isFind = false;

        while (!isFind) {
            System.out.print("Masukkan nama mahasiswa   : ");
            nama = input.nextLine();
            System.out.print("Masukkan NIM mahasiswa    : ");
            nim = input.nextLine();
            System.out.print("Masukkan kelas mahasiswa: ");
            kelas = input.nextLine();

            if (nim.equals(nim1) || nim.equals(nim2) || nim.equals(nim3) || nim.equals(nim4) || nim.equals(nim5)) {
                System.out.println("Nim sudah terpakai");
                continue;
            } else if (!(nim.length() == 10)) {
                System.out.println("nim harus berdigit 10");
                continue;

            } else {
                isFind = true;

            }
        }
        namaMaba = nama;
        nimMaba = nim;
        kelasMaba = kelas;

        System.out.println("+--------------------------------------+");
        System.out.println("biodata mahasiswa yang telah diinput: ");
        System.out.println("+--------------------------------------+");
        System.out.printf("Nama Mahasiswa       :%s \n", namaMaba);
        System.out.printf("Nim Mahasiswa        :%s \n", nimMaba);
        System.out.printf("Kelas Mahasiswa      :%s \n", kelasMaba);

    }
}