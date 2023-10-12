package Fitur;

import java.util.Scanner;

public class JadwalKuliah {
    /**
    *
    */
    public static void main(String[] args) {
        Scanner Masuk = new Scanner(System.in);
        // identifikasi tipe data
        int num = 0;
        int Jadwal_MataKuliah;
        String Pilih;

        while (num <= 1) {
            System.out.println("======= PILIH JADWAL HARI =======");
            System.out.println("1. Senin");
            System.out.println("1. Senin");
            System.out.println("2. Selasa");
            System.out.println("3. Rabu");
            System.out.println("4. Kamis");
            System.out.println("5. Jumat");

            System.out.print("Masukan Nomor = ");
            Jadwal_MataKuliah = Masuk.nextInt();

            switch (Jadwal_MataKuliah) {
                case 1:
                    System.out.println("=======JADWAL KULIAH SENIN=======");
                    System.out.println("Bing = Satrio Binusa, CTPS = Vivi Nur Wijayaningrum, Matdas = Yuri Ariyanto");
                    break;
                case 2:
                    System.out.println("=======JADWAL KULIAH SELASA=======");
                    System.out.println("Matdas = Yuri Ariyanto, Pancasila = Widaningsih Condrowardhani");
                    break;
                case 3:
                    System.out.println("=======JADWAL KULIAH RABU=======");
                    System.out.println("K3 = Budi Harijanto");
                    break;
                case 4:
                    System.out.println("=======JADWAL KULIAH KAMIS=======");
                    System.out.println("Daspro = Mamluatul Hani'ah)");
                    break;
                case 5:
                    System.out.println("=======JADWAL KULIAH JUMAT=======");
                    System.out.println("KTI = Ariadi Retno Ririd, Prak Daspro = Mamluatul Hani'ah");
                    break;
                default:
                    System.out.println("Silahkan Pilih 1,2,3,4");

            }

            System.out.print("Apakah memilih hari jadwal perkuliahan lagi ");
            Pilih = Masuk.next();
            switch (Pilih) {
                case "ya":
                    num = 0;
                    break;
                default:
                    num = 3;
                    break;
            }

            num++;
        }
    }
}
