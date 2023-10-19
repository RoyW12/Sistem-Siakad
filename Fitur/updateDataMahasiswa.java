package Fitur;

import java.util.Scanner;

public class updateDataMahasiswa {
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
        String nama;
        String nim;
        String kelas;
        boolean isFind = false;
        boolean isEqual = false;

        while (!isFind) {
            System.out.print("Masukkan NIM mahasiswa    : ");
            nim = input.nextLine();

            if (nim.equals(nim1)) {
                System.out.printf("nim dengan nomor     :%s\n", nim1);
                System.out.printf("Nama                 :%s\n", mahasiswa1);
                System.out.printf("Kelas                :%s\n", kelasMhs1);
                System.out.print("Masukkan Nama baru    :");
                nama = input.nextLine();
                System.out.print("Masukkan Kelas baru   :");
                kelas = input.nextLine();
                System.out.print("Masukkan Nim baru     :");
                nim = input.nextLine();

                mahasiswa1 = nama;
                nim1 = nim;
                kelasMhs1 = kelas;

                System.out.println("+-------------------------------------------+");
                System.out.println("biodata mahasiswa yang telah diganti menjadi: ");
                System.out.println("+-------------------------------------------+");
                System.out.printf("Nama Mahasiswa       :%s \n", mahasiswa1);
                System.out.printf("Nim Mahasiswa        :%s \n", nim1);
                System.out.printf("Kelas Mahasiswa      :%s \n", kelasMhs1);

                isFind = true;

            } else if (nim.equals(nim2)) {
                System.out.printf("nim dengan nomor     :%s\n", nim2);
                System.out.printf("Nama                 :%s\n", mahasiswa2);
                System.out.printf("Kelas                :%s\n", kelasMhs2);
                System.out.print("Masukkan Nama baru    :");
                nama = input.nextLine();
                System.out.print("Masukkan Kelas baru   :");
                kelas = input.nextLine();
                System.out.print("Masukkan Nim baru     :");
                nim = input.nextLine();
                mahasiswa2 = nama;
                nim2 = nim;
                kelasMhs2 = kelas;
                System.out.println("+-------------------------------------------+");
                System.out.println("biodata mahasiswa yang telah diganti menjadi: ");
                System.out.println("+-------------------------------------------+");
                System.out.printf("Nama Mahasiswa       :%s \n", mahasiswa2);
                System.out.printf("Nim Mahasiswa        :%s \n", nim2);
                System.out.printf("Kelas Mahasiswa      :%s \n", kelasMhs2);
                isFind = true;

            } else if (nim.equals(nim3)) {
                System.out.printf("nim dengan nomor     :%s\n", nim3);
                System.out.printf("Nama                 :%s\n", mahasiswa3);
                System.out.printf("Kelas                :%s\n", kelasMhs3);
                System.out.print("Masukkan Nama baru    :");
                nama = input.nextLine();
                System.out.print("Masukkan Kelas baru   :");
                kelas = input.nextLine();
                System.out.print("Masukkan Nim baru     :");
                mahasiswa3 = nama;
                nim3 = nim;
                kelasMhs3 = kelas;
                System.out.println("+-------------------------------------------+");
                System.out.println("biodata mahasiswa yang telah diganti menjadi: ");
                System.out.println("+-------------------------------------------+");
                System.out.printf("Nama Mahasiswa       :%s \n", mahasiswa3);
                System.out.printf("Nim Mahasiswa        :%s \n", nim3);
                System.out.printf("Kelas Mahasiswa      :%s \n", kelasMhs3);
                nim = input.nextLine();
                isFind = true;

            } else if (nim.equals(nim4)) {
                System.out.printf("nim dengan nomor     :%s\n ", nim4);
                System.out.printf("Nama                 :%s\n", mahasiswa4);
                System.out.printf("Kelas                :%s\n", kelasMhs4);
                System.out.print("Masukkan Nama baru    :");
                nama = input.nextLine();
                System.out.print("Masukkan Kelas baru   :");
                kelas = input.nextLine();
                System.out.print("Masukkan Nim baru     :");
                nim = input.nextLine();
                mahasiswa4 = nama;
                nim4 = nim;
                kelasMhs4 = kelas;
                System.out.println("+-------------------------------------------+");
                System.out.println("biodata mahasiswa yang telah diganti menjadi: ");
                System.out.println("+-------------------------------------------+");
                System.out.printf("Nama Mahasiswa       :%s \n", mahasiswa4);
                System.out.printf("Nim Mahasiswa        :%s \n", nim4);
                System.out.printf("Kelas Mahasiswa      :%s \n", kelasMhs4);
                isFind = true;

            } else if (nim.equals(nim5)) {
                System.out.printf("nim dengan nomor     :%s\n ", nim5);
                System.out.printf("Nama                 :%s\n", mahasiswa5);
                System.out.printf("Kelas                :%s\n", kelasMhs5);
                System.out.print("Masukkan Nama baru    :");
                nama = input.nextLine();
                System.out.print("Masukkan Kelas baru   :");
                kelas = input.nextLine();
                System.out.print("Masukkan Nim baru     :");
                nim = input.nextLine();
                mahasiswa5 = nama;
                nim5 = nim;
                kelasMhs5 = kelas;
                System.out.println("+-------------------------------------------+");
                System.out.println("biodata mahasiswa yang telah diganti menjadi: ");
                System.out.println("+-------------------------------------------+");
                System.out.printf("Nama Mahasiswa       :%s \n", mahasiswa5);
                System.out.printf("Nim Mahasiswa        :%s \n", nim5);
                System.out.printf("Kelas Mahasiswa      :%s \n", kelasMhs5);
                isFind = true;
            } else {
                System.out.println("nim tidak ditemukan");
                continue;
            }
        }
    }
}
