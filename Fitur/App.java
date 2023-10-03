package Fitur;

import java.util.Scanner;

public class App{
    static String[] mahasiswa = {"mahasiswa","mahasiswa123"};
    static String[] admin = {"admin","admin123"};
    static boolean login = true;

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        int fitur = 0;
        login();

        while(login){
            fitur();

            renderString("Pilih Fitur: ");
            try {
                fitur = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Inputan salah");
                sc.nextLine();
                continue;
            }
            if(fitur == 1){
                edit();
            }else if(fitur == 2){
            }
            else if(fitur == 3){
            }
            else if(fitur == 4){
            }
            else if(fitur == 5){
            }
            else if(fitur == 6){
            }
            else if(fitur == 7){
                login = false;
                System.out.println("Terimakasih sudah menggunakan program ini");
            }
            else{
                System.out.println("fitur tidak tersedia,masukkan angka 1-5 ");
            };
        }
    }

    static void renderString(String string){
        System.out.println(string);
    }

    static void login(){
        System.out.print("username:");
            String username = sc.nextLine().trim(); //trim menghapus spasi di awal dan akhir string
            System.out.print("password:");
            String password = sc.nextLine().trim(); //trim menghapus spasi di awal dan akhir string
                while(login){
                    if(username.equals(admin[0]) && password.equals(admin[1])){
                    renderString("welcome back " + username);
                    break;
                    }else if(username.equals(mahasiswa[0] ) && password.equals(mahasiswa[1])){
                    renderString("welcome back " + username);
                    break;
                    }else{
                        System.out.println("incorrect username");
                        login =false;
                        break;
                    }                    
        }
    }
    static void fitur(){
        renderString(" \n Fitur Utama :");
        renderString("1. Edit Biodata");
        renderString("2. Pembayaran UKT");
        renderString("3. Cetak KRS");
        renderString("4. Peminjaman Buku");
        renderString("5. Cetak KHS");
        renderString("6. Cek Jadwal Perkuliahan");
        renderString("7. Keluar");
}
    static void edit(){

    }
    // static void ukt(){
    //      Long nim;
    //             int jumlahTagihanUKT = 10000000,sisaTagihan,nominalPembayaran;
    //             String nama;  

    //             System.out.println("Pembayaran UKT");
    //             System.out.print("Nama Mahasiswa : ");
    //             nama = sc.nextLine();
    //             System.out.println("===============");
    //             System.out.println("===============");
    //             System.out.print("Nomor Induk Mahasiswa : ");
    //             nim = sc.nextLong();
    //             System.out.println("===============");
    //             System.out.println("===============");
    //             System.out.println( "jumlah tagihan UKT = " + jumlahTagihanUKT);
    //             System.out.print("masukkan jumlah UKT yang dibayar ");
    //             nominalPembayaran = sc.nextInt();

    //             System.out.println("=======BUKTI PEMBAYARAN=======");
    //             sisaTagihan = jumlahTagihanUKT - nominalPembayaran;
    //             System.out.println("Sisa tagihan = " + sisaTagihan);

    //             System.out.println("Nama : " + nama + "\n" + "Nim : " + nim + "\n" + "Nominal Pembayaran : " + nominalPembayaran + "\n" + "Sisa Tagihan : " + sisaTagihan);
    // }
}
