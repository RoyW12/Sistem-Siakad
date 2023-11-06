import java.util.Scanner;

public class CobaMatkul {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Program Input Mata Kuliah ===");
        
        boolean lanjut = true;
        while (lanjut) {
            // Input data mata kuliah
            System.out.print("Masukkan nama mata kuliah: ");
            String namaMatkul = scanner.nextLine();
            
            System.out.print("Masukkan jurusan perkuliahan: ");
            String jurusan = scanner.nextLine();
            
            int sks = -1;
            while (sks < 0) {
                System.out.print("Masukkan jumlah sks (harus bilangan bulat positif): ");
                try {
                    sks = Integer.parseInt(scanner.nextLine());
                    if (sks < 0) {
                        System.out.println("Jumlah SKS harus positif!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Masukkan angka yang valid!");
                }
            }
            
            // Menampilkan data mata kuliah yang diinput
            System.out.println("Data Mata Kuliah:");
            System.out.println("Nama Matkul: " + namaMatkul);
            System.out.println("Jurusan: " + jurusan);
            System.out.println("Jumlah SKS: " + sks);
            
            System.out.print("Ingin input data mata kuliah lagi? (y/n): ");
            String opsi = scanner.nextLine();
            if (!opsi.equalsIgnoreCase("y")) {
                lanjut = false;
            }
        }
        
        scanner.close();
    }
}
