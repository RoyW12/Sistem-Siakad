package FiturUKT;

import java.util.Scanner;

public class App{
    public static void main(String[] args) {
        
                Scanner sc = new Scanner(System.in);
                Long nim;
                int jumlahTagihanUKT = 10000000,sisaTagihan,nominalPembayaran;
                String nama;  

                System.out.println("Pembayaran UKT");
                System.out.print("Nama Mahasiswa : ");
                nama = sc.nextLine();
                System.out.println("===============");
                System.out.println("===============");
                System.out.print("Nomor Induk Mahasiswa : ");
                nim = sc.nextLong();
                System.out.println("===============");
                System.out.println("===============");
                System.out.println( "jumlah tagihan UKT = " + jumlahTagihanUKT);
                System.out.print("masukkan jumlah UKT yang dibayar ");
                nominalPembayaran = sc.nextInt();

                System.out.println("=======BUKTI PEMBAYARAN=======");
                sisaTagihan = jumlahTagihanUKT - nominalPembayaran;
                System.out.println("Sisa tagihan = " + sisaTagihan);

                System.out.println("Nama : " + nama + "\n" + "Nim : " + nim + "\n" + "Nominal Pembayaran : " + nominalPembayaran + "\n" + "Sisa Tagihan : " + sisaTagihan);

    }
}
