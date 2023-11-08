package Fitur;

import java.util.Scanner;

public class InputMatkul {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] kode = { "RTI231001", "RTI231002", "RTI231003", "RTI231004", "RTI231005" };
        String[] matkul = { "Pancasila", "Konsep Teknologi Informasi", "Critical Thinking dan Problem Solving",
                "Matdas", "Bahasa Inggris" };
        String[] sks = { "2", "2", "2", "3", "2" };

        String kodeInput;
        String matkulInput;
        String sksInput;

        boolean isFind = false;

        while (!isFind) {
            System.out.println("+------+--------------------+----------------------------------------+-----+");
            System.out.println("| No.  |    Course Code     |               Course Name              | SKS |");
            System.out.println("+------+--------------------+----------------------------------------+-----+");
            for (int i = 0; i < matkul.length; i++) {
                System.out.printf("| %-4d | %-18s | %-38s | %-3s |\n", (i + 1), kode[i], matkul[i],
                        sks[i]);
            }
            System.out.println("+------+--------------------+----------------------------------------+-----+");

            System.out.print("Masukkan kode mata kuliah  : ");
            kodeInput = input.nextLine();
            System.out.print("Masukkan nama mata kuliah  : ");
            matkulInput = input.nextLine();
            System.out.print("Masukkan sks               : ");
            sksInput = input.nextLine();
            if (kodeInput.length() == 9) {
                for (int i = 0; i < kode.length; i++) {
                    if (kodeInput.equals(kode[i])) {
                        System.out.println("Student with the Course code of " + kodeInput + " already exists!");
                        System.out.println("Masukkan data lagi");
                        isFind = false;
                        break;

                    } else {
                        isFind = true;
                    }
                }

            } else {
                System.out.println("Kode Mata Kuliah harus 9 digit");
            }
            if (isFind) {
                String[] newKode = new String[kode.length + 1];
                String[] newMatkul = new String[matkul.length + 1];
                String[] newSks = new String[sks.length + 1];

                for (int i = 0; i < kode.length; i++) {
                    newKode[i] = kode[i];
                    newMatkul[i] = matkul[i];
                    newSks[i] = sks[i];
                }
                newKode[newKode.length - 1] = kodeInput;
                newMatkul[newMatkul.length - 1] = matkulInput;
                newSks[newSks.length - 1] = sksInput;
                kode = newKode;
                matkul = newMatkul;
                sks = newSks;

                System.out.println("+------+--------------------+----------------------------------------+-----+");
                System.out.println("| No.  |    Course Code     |               Course Name              | SKS |");
                System.out.println("+------+--------------------+----------------------------------------+-----+");
                for (int i = 0; i < matkul.length; i++) {
                    System.out.printf("| %-4d | %-18s | %-38s | %-3s |\n", (i + 1), kode[i], matkul[i],
                            sks[i]);
                }
                System.out.println("+------+--------------------+----------------------------------------+-----+");

            }
        }

    }
}
