package Fitur;

import java.util.Scanner;

public class inputDataMahasiswa {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] mahasiswa = { "andi", "Roy", "Jessica", "Jokowi", "felice" };
        String[] nim = { "0000000001", "0000000002", "0000000003", "0000000004", "0000000005" };
        String[] classPlacement = { "1A", "1B", "2C", "3C", "4C" };

        String namaInput;
        String nimInput;
        String kelasInput;

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

            System.out.print("Masukkan nama mahasiswa   : ");
            namaInput = input.nextLine();
            System.out.print("Masukkan NIM mahasiswa    : ");
            nimInput = input.nextLine();
            System.out.print("Masukkan kelas mahasiswa: ");
            kelasInput = input.nextLine();
            if (nimInput.length() == 10) {
                for (int i = 0; i < nim.length; i++) {
                    if (nimInput.equals(nim[i])) {
                        System.out.println("Student with the NIM of " + nim + " already exists!");
                        System.out.println("Masukkan data lagi");
                        isFind = false;
                        break;

                    } else {
                        isFind = true;
                    }
                }
            } else {
                System.out.println("NIM harus 10 digit");
            }
            if (isFind) {
                String[] newMahasiswa = new String[mahasiswa.length + 1];
                String[] newNIM = new String[nim.length + 1];
                String[] newClassPlacement = new String[classPlacement.length + 1];

                for (int i = 0; i < mahasiswa.length; i++) {
                    newMahasiswa[i] = mahasiswa[i];
                    newNIM[i] = nim[i];
                    newClassPlacement[i] = classPlacement[i];
                }
                newMahasiswa[newMahasiswa.length - 1] = namaInput;
                newNIM[newNIM.length - 1] = nimInput;
                newClassPlacement[newClassPlacement.length - 1] = kelasInput;
                mahasiswa = newMahasiswa;
                nim = newNIM;
                classPlacement = newClassPlacement;

                System.out.println("+------+------------+----------------------+-------+");
                System.out.println("| No.  |    NIM     |      Full Name       | Class |");
                System.out.println("+------+------------+----------------------+-------+");
                for (int i = 0; i < mahasiswa.length; i++) {
                    // String[] student = students[i];
                    System.out.printf("| %-4d | %-10s | %-20s | %-5s |\n", (i + 1), nim[i], mahasiswa[i],
                            classPlacement[i]);
                }
                System.out.println("+------+------------+----------------------+-------+");

            }
        }

    }
}