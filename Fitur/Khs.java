package Fitur;
import java.util.Scanner;
public class Khs {
    public static void main(String[] args) {
        String nama, matkul1, matkul2,matkul3,matkul4,matkul5,predikat = "";
        long nim;
        int bobotMatkul1,bobotMatkul2,bobotMatkul3,bobotMatkul4,bobotMatkul5, sks1,sks2,sks3,sks4,sks5,totSKS;
        double ips;
        Scanner input28 = new Scanner(System.in);

        System.out.print("Masukan nama      : ");
        nama = input28.nextLine();
        System.out.print("Masukan nim       : ");
        nim = input28.nextLong();
        input28.nextLine();
        System.out.print("Masukan matkul 1 ");
        matkul1 = input28.nextLine();
        System.out.print("Masukan jumlah sks matkul 1: ");
        sks1 = input28.nextInt();
        System.out.print("Masukan jumlah bobot matkul 1: ");
        bobotMatkul1 = input28.nextInt();
        input28.nextLine();
        System.out.print("Masukan matkul2       : ");
        matkul2 = input28.nextLine();
        System.out.print("Masukan jumlah sks matkul 2: ");
        sks2 = input28.nextInt();
        System.out.print("Masukan jumlah bobot matkul 2: ");
        bobotMatkul2 = input28.nextInt();
        input28.nextLine();
        System.out.print("Masukan matkul3       : ");
        matkul3 = input28.nextLine();
        System.out.print("Masukan jumlah sks matkul 3: ");
        sks3 = input28.nextInt();
        System.out.print("Masukan jumlah bobot matkul 3: ");
        bobotMatkul3 = input28.nextInt();
        input28.nextLine();
        System.out.print("Masukan matkul4       : ");
        matkul4 = input28.nextLine();
        System.out.print("Masukan jumlah sks matkul 4: ");
        sks4 = input28.nextInt();
        System.out.print("Masukan jumlah bobot matkul 4: ");
        bobotMatkul4 = input28.nextInt();
        input28.nextLine();
        System.out.print("Masukan matkul5       : ");
        matkul5 = input28.nextLine();
        System.out.print("Masukan jumlah sks matkul 5: ");
        sks5 = input28.nextInt();
        System.out.print("Masukan jumlah bobot matkul 5: ");
        bobotMatkul5 = input28.nextInt();
        totSKS = sks1 + sks2 + sks3 + sks4 + sks5;
        ips = ((sks1 * bobotMatkul1) + (sks2 * bobotMatkul2) + (sks3 * bobotMatkul3) + (sks4 * bobotMatkul4) + (sks5 * bobotMatkul5)) / totSKS;
        if(ips < 4){
            if(ips < 4 && ips > 2){
                predikat = "anda lulus semester";
            }else{
                predikat = "anda tidak lulus semester";
            }
        }else{
            System.out.println("nilai ips tidak terdefinisi");
        }

        System.out.println("-------------------");
        System.out.println(" KARTU HASIL STUDI  ");
        System.out.println("-------------------");
        System.out.println("| Nama          : " + nama);
        System.out.println("| NIM           : " + nim);
        System.out.println("| Mata Kuliah 1 : " + matkul1 + " dengan sks " + sks1 + " dengan bobot nilai " + bobotMatkul1);
        System.out.println("| Mata Kuliah 2 : " + matkul2 + " dengan sks " + sks2 + " dengan bobot nilai " + bobotMatkul2);
        System.out.println("| Mata Kuliah 3 : " + matkul3 + " dengan sks " + sks3 + " dengan bobot nilai " + bobotMatkul3);
        System.out.println("| Mata Kuliah 4 : " + matkul4 + " dengan sks " + sks4 + " dengan bobot nilai " + bobotMatkul4);
        System.out.println("| Mata Kuliah 5 : " + matkul5 + " dengan sks " + sks5 + " dengan bobot nilai " + bobotMatkul5);
        System.out.println("| ips           : " + ips);
        System.out.println("status anda adalah " + predikat);






    }
}
