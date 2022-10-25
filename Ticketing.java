package StudiKasus;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Ticketing {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String Nama,Alamat,Tanggal,Sasal,Stujuan,Nomor,NIK;
        int nominal,kembalian,harga=0,jumlah,jarak=0,kelas_ekonomi,kelas_bisnis, kelas_first,kelas,kondisi = 1;

        tanda();
        System.out.printf("\n%12s%s "," ","FILKOM RAIL EXPRESS");
        System.out.printf("\n%7s%s\n"," ","PROGAM PEMESANAN TIKET KERETA");
        tanda();
        System.out.printf("\n%-24s%c ","Nama",':');
        Nama = scan.nextLine();
        System.out.printf("%-24s%c ","NIK",':');
        NIK = scan.nextLine();
        System.out.printf("%-24s%c ","Alamat",':');
        Alamat = scan.nextLine();
        System.out.printf("%-24s%c ","Nomor Telepon",':');
        Nomor = scan.nextLine();

        tanda();
        System.out.println("\nSilahkan pilih tiket anda");
        tanda();
        System.out.println("\nList stasiun tersedia :");
        System.out.printf("%-17s%s%14s","1.Malang","4.Semarang","7.Serang");
        System.out.printf("\n%-17s%s","2.Surabaya","5.Bandung");
        System.out.printf("\n%-17s%s","3.Yogyakarta","6.Jakata");

        System.out.println("\n\nJenis Tiket :");
        System.out.println("1. Economy Class");
        System.out.println("2. Business Class");
        System.out.println("3. First Class");

        System.out.printf("%-24s%c ","Tanggal Keberangkatan",':');
        Tanggal = scan.nextLine();
        System.out.printf("%-24s%c ","Stasiun Asal",':');
        Sasal = scan.nextLine();
        System.out.printf("%-24s%c ","Stasiun Tujuan",':');
        Stujuan = scan.nextLine();
        System.out.printf("%-24s%c ","Jumlah Tiket",':');
        jumlah = scan.nextInt();
        System.out.printf("%-24s%c ","Jenis Tiket",':');
        kelas = scan.nextInt();
        System.out.printf("%-24s%c ","Nominal Pembayaran",':');
        nominal = scan.nextInt();
        System.out.println();

        kelas_ekonomi = 400;
        kelas_bisnis = 700;
        kelas_first = 1000;

        if (Sasal.equals("Malang") || Sasal.equals("Surabaya") || Sasal.equals("Yogyakarta")) {
            if (Sasal.equals("Malang")) {
                switch (Stujuan) {
                    case "Surabaya" -> jarak = 100;
                    case "Yogyakarta" -> jarak = 400;
                    case "Serang" -> jarak = 1000;
                    default -> kondisi = 0;
                }
            }

            if (Sasal.equals("Surabaya")) {
                switch (Stujuan) {
                    case "Semarang" -> jarak = 350;
                    case "Bandung" -> jarak = 700;
                    default -> kondisi = 0;
                }
            }

            if (Sasal.equals("Yogyakarta")) {
                if ("Jakarta".equals(Stujuan)) {
                    jarak = 500;
                } else {
                    kondisi = 0;
                }
            }
        } else {
            kondisi = 0;
        }

        if (kelas == 1){
            harga = jarak*kelas_ekonomi*jumlah;
        } else if (kelas == 2) {
            harga = jarak*kelas_bisnis*jumlah;
        }else if(kelas == 3){
            harga = jarak*kelas_first*jumlah;
        }else {kondisi = 0;}

        kembalian = nominal - harga;
        NumberFormat separator = NumberFormat.getNumberInstance(Locale.GERMANY);
        String hargas = separator.format(harga);
        String nominals = separator.format(nominal);
        String kembalians = separator.format(kembalian);

        if (kondisi == 1){
            tanda();
            if (kembalian >= 0){
                System.out.printf("\n%9s%s \n"," ","Pemesanan Tiket Berhasil");
                tanda();
                System.out.printf("\n%13s%s \n"," ","DETAIL PEMESANAN");
                tanda();
                System.out.printf("\n%-24s%c %s","Nama",':',Nama);
                System.out.printf("\n%-24s%c %s","NIK",':',NIK);
                System.out.printf("\n%-24s%c %s","Alamat",':',Alamat);
                System.out.printf("\n%-24s%c %s","Nomor Telepon",':',Nomor);
                System.out.printf("\n%-24s%c %s","Tanggal Keberangkatan",':',Tanggal);
                System.out.printf("\n%-24s%c %s - %s (%d km)","Rute",':',Sasal,Stujuan,jarak);
                System.out.printf("\n%-24s%c %d","Jumlah Tiket",':',jumlah);
                System.out.printf("\n\n%-24s%c %s %s,-","Total Harga",':',"Rp",hargas);
                System.out.printf("\n%-24s%c %s %s,-","Nominal Pembayaran",':',"Rp",nominals);
                System.out.printf("\n%-24s%c %s %s,-\n","Kembalian",':',"Rp",kembalians);
            }else {
                System.out.printf("\n%6sMaaf, uang anda tidak mencukupi\n","");
            }
            tanda();
        }else {
            tanda();
            System.out.printf("\n%8sMaaf, rute tidak ditemukan\n","");
            tanda();
        }
    }
    private static void tanda (){
        int a=42;
        for(int i = 1;i<=a;i++){
            System.out.print("=");
        }
    }
}
