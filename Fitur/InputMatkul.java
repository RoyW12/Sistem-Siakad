package Fitur;

import java.util.Scanner;

public class InputMatkul {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Jurusan RTI
        String[] kodeRti = { "RTI231001", "RTI231002", "RTI231003", "RTI231004", "RTI231005" };
        String[] matkulRti = { "Pancasila", "Konsep Teknologi Informasi", "Critical Thinking dan Problem Solving",
                "Matdas", "Bahasa Inggris" };
        String[] sksRti = { "2", "2", "2", "3", "2" };
        // JUrusan SIB
        String[] kodeSib = { "SIB231001", "SIB231002", "SIB231003", "SIB231004", "SIB231005" };
        String[] matkulSib = { "Agama", "Konsep Teknologi Informasi", "Critical Thinking dan Problem Solving",
                "Matdas", "Bahasa Indonesia" };
        String[] sksSib = { "2", "2", "2", "3", "2" };

        String kodeInput;
        String matkulInput;
        String sksInput;
        int pilihProdi;

        boolean isContinue = true;
        boolean isFind = false;

        while (isContinue) {
            System.out.println("=======================================");
            System.out.println("Pilih Program Studi :");
            System.out.println("1. Teknik Informatika");
            System.out.println("2. Sistem Informasi Bisnis");
            System.out.println("=======================================");
            System.out.print("Prodi ke- : ");
            pilihProdi = input.nextInt();
            input.nextLine();

            switch (pilihProdi) {
                case 1:
                    if (!isFind) {
                        System.out.println(
                                "+------+--------------------+----------------------------------------+-----+");
                        System.out.println(
                                "| No.  |    Course Code     |               Course Name              | SKS |");
                        System.out.println(
                                "+------+--------------------+----------------------------------------+-----+");
                        for (int i = 0; i < matkulRti.length; i++) {
                            System.out.printf("| %-4d | %-18s | %-38s | %-3s |\n", (i + 1), kodeRti[i], matkulRti[i],
                                    sksRti[i]);
                        }
                        System.out.println(
                                "+------+--------------------+----------------------------------------+-----+");

                        System.out.print("Masukkan kode mata kuliah  : ");
                        kodeInput = input.nextLine();
                        System.out.print("Masukkan nama mata kuliah  : ");
                        matkulInput = input.nextLine();
                        System.out.print("Masukkan sks               : ");
                        sksInput = input.nextLine();
                        if (kodeInput.length() == 9) {
                            for (int i = 0; i < kodeRti.length; i++) {
                                if (kodeInput.equals(kodeRti[i])) {
                                    System.out.println(
                                            "Student with the Course code of " + kodeInput + " already exists!");
                                    System.out.println("Masukkan data lagi");
                                    isFind = false;
                                    break;

                                } else {
                                    isFind = true;
                                }
                            }

                        } else {
                            System.out.println("Kode Mata Kuliah harus 9 digit");
                            isContinue = true;
                            break;
                        }
                        if (isFind) {
                            String[] newKodeRti = new String[kodeRti.length + 1];
                            String[] newMatkulRti = new String[matkulRti.length + 1];
                            String[] newSksRti = new String[sksRti.length + 1];

                            for (int i = 0; i < kodeRti.length; i++) {
                                newKodeRti[i] = kodeRti[i];
                                newMatkulRti[i] = matkulRti[i];
                                newSksRti[i] = sksRti[i];
                            }
                            newKodeRti[newKodeRti.length - 1] = kodeInput;
                            newMatkulRti[newMatkulRti.length - 1] = matkulInput;
                            newSksRti[newSksRti.length - 1] = sksInput;
                            kodeRti = newKodeRti;
                            matkulRti = newMatkulRti;
                            sksRti = newSksRti;

                            System.out.println(
                                    "+------+--------------------+----------------------------------------+-----+");
                            System.out.println(
                                    "| No.  |    Course Code     |               Course Name              | SKS |");
                            System.out.println(
                                    "+------+--------------------+----------------------------------------+-----+");
                            for (int i = 0; i < matkulRti.length; i++) {
                                System.out.printf("| %-4d | %-18s | %-38s | %-3s |\n", (i + 1), kodeRti[i],
                                        matkulRti[i],
                                        sksRti[i]);
                            }
                            System.out.println(
                                    "+------+--------------------+----------------------------------------+-----+");

                        }
                    }
                    isFind = false;
                    break;
                case 2:
                    if (!isFind) {
                        System.out.println(
                                "+------+--------------------+----------------------------------------+-----+");
                        System.out.println(
                                "| No.  |    Course Code     |               Course Name              | SKS |");
                        System.out.println(
                                "+------+--------------------+----------------------------------------+-----+");
                        for (int i = 0; i < matkulSib.length; i++) {
                            System.out.printf("| %-4d | %-18s | %-38s | %-3s |\n", (i + 1), kodeSib[i], matkulSib[i],
                                    sksSib[i]);
                        }
                        System.out.println(
                                "+------+--------------------+----------------------------------------+-----+");

                        System.out.print("Masukkan kode mata kuliah  : ");
                        kodeInput = input.nextLine();
                        System.out.print("Masukkan nama mata kuliah  : ");
                        matkulInput = input.nextLine();
                        System.out.print("Masukkan sks               : ");
                        sksInput = input.nextLine();
                        if (kodeInput.length() == 9) {
                            for (int i = 0; i < kodeSib.length; i++) {
                                if (kodeInput.equals(kodeSib[i])) {
                                    System.out.println(
                                            "Student with the Course code of " + kodeInput + " already exists!");
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
                            String[] newKodeSib = new String[kodeSib.length + 1];
                            String[] newMatkulSib = new String[matkulSib.length + 1];
                            String[] newSksSib = new String[sksSib.length + 1];

                            for (int i = 0; i < kodeSib.length; i++) {
                                newKodeSib[i] = kodeSib[i];
                                newMatkulSib[i] = matkulSib[i];
                                newSksSib[i] = sksSib[i];
                            }
                            newKodeSib[newKodeSib.length - 1] = kodeInput;
                            newMatkulSib[newMatkulSib.length - 1] = matkulInput;
                            newSksSib[newSksSib.length - 1] = sksInput;
                            kodeSib = newKodeSib;
                            matkulSib = newMatkulSib;
                            sksSib = newSksSib;

                            System.out.println(
                                    "+------+--------------------+----------------------------------------+-----+");
                            System.out.println(
                                    "| No.  |    Course Code     |               Course Name              | SKS |");
                            System.out.println(
                                    "+------+--------------------+----------------------------------------+-----+");
                            for (int i = 0; i < matkulSib.length; i++) {
                                System.out.printf("| %-4d | %-18s | %-38s | %-3s |\n", (i + 1), kodeSib[i],
                                        matkulSib[i],
                                        sksSib[i]);
                            }
                            System.out.println(
                                    "+------+--------------------+----------------------------------------+-----+");

                        }
                    }
                    isFind = false;
                    break;
            }
        }

    }
}
