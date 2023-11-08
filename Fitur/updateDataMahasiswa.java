package Fitur;

import java.util.Scanner;

public class updateDataMahasiswa {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] mahasiswa = { "andi", "Roy", "Jessica", "Jokowi", "felice" };
        String[] nim = { "0000000001", "0000000002", "0000000003", "0000000004", "0000000005" };
        String[] classPlacement = { "1A", "1B", "2C", "3C", "4C" };

        String namaInput = null;
        String nimInput;
        String nimBaru = null;
        String classInput = null;
        int indeks = 0;
        boolean isFind = false;

        while (!isFind) {
            System.out.println("+------+------------+----------------------+-------+");
            System.out.println("| No.  |    NIM     |      Full Name       | Class |");
            System.out.println("+------+------------+----------------------+-------+");
            for (int i = 0; i < mahasiswa.length; i++) {
                System.out.printf("| %-4d | %-10s | %-20s | %-5s |\n", (i + 1), nim[i], mahasiswa[i],
                        classPlacement[i]);
            }
            System.out.println("+------+------------+----------------------+-------+");

            System.out.print("Masukkan NIM mahasiswa    : ");
            nimInput = input.nextLine();

            if (nimInput.length() == 10) {
                for (int i = 0; i < nim.length; i++) {
                    if (nimInput.equals(nim[i])) {
                        indeks = i;
                        System.out.print("Masukkan nama mahasiswa   : ");
                        namaInput = input.nextLine();
                        System.out.print("Masukkan nim baru         : ");
                        nimBaru = input.nextLine();
                        System.out.print("Masukkan kelas mahasiswa  : ");
                        classInput = input.nextLine();
                        isFind = true;
                        break;
                    } else {
                        isFind = false;
                    }
                }
            } else {
                System.out.println("NIM harus 10 digit");
            }

            if (isFind) {
                mahasiswa[indeks] = namaInput;
                nim[indeks] = nimBaru;
                classPlacement[indeks] = classInput;
                System.out.println("+------+------------+----------------------+-------+");
                System.out.println("| No.  |    NIM     |      Full Name       | Class |");
                System.out.println("+------+------------+----------------------+-------+");
                for (int i = 0; i < mahasiswa.length; i++) {
                    System.out.printf("| %-4d | %-10s | %-20s | %-5s |\n", (i + 1), nim[i], mahasiswa[i],
                            classPlacement[i]);
                }
                System.out.println("+------+------------+----------------------+-------+");

            } else {
                System.out.println("Student with the NIM of " + nimInput + " doesn't exists!");
                System.out.println("Masukkan data lagi");
            }
        }
    }
}
