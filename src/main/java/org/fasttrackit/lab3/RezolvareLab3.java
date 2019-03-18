package org.fasttrackit.lab3;

import java.util.Scanner;

public class RezolvareLab3 {
    static int nr1;
    static int nr2;
    static double med;
    static int n;
    static int m;
    static double res = 0;
    static int[] tablou;

    //Problema 1

    public static void printMeniu() {
        System.out.println("1. Media aritmetica a doua numere");
        System.out.println("2. Media aritmetica a n numere");
        System.out.println("3. Maximul a n numere");
        System.out.println("4. Tabla inmultirii cu n numere");
        System.out.println("5. Tabla inmultirii cu n,m numere");
        System.out.println("6a. Suma si produsul cifrelor numarului n");
        System.out.println("6b. Numarul cifrelor numarului n");
        System.out.println("6c. Cifra minima si maxima a numarului n");
        System.out.println("6d. Cifra control a numarului n");
        System.out.println("x. Iesire");
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (true) {
            printMeniu();
            String optiune = in.next();
            if (optiune.equals("1")) {
                do {
                    System.out.println("Dati numarul 1: ");
                    nr1 = in.nextInt();
                    System.out.println("Dati numarul 2: ");
                    nr2 = in.nextInt();
                } while (nr1 < 0 || nr2 < 0);
                med = mediaAritmetica(nr1, nr2);
                System.out.println("Media aritmetica este: " + med);

            } else if (optiune.equals("2")) {
                do {
                    System.out.println("La cate numere vrei sa afli media? ");

                    n = in.nextInt();
                    System.out.println("introdu   " + n + "  numere");
                } while (n < 0);
                res = medieNNumere(n);
                System.out.println("Media numerelor=" + res / n);

            } else if (optiune.equals("3")) {
                System.out.println("Dati numarul de elemente:");
                n = in.nextInt();

                tablou = new int[n];
                for (int i = 0; i < n; ++i) {
                    System.out.println("Dati elementul cu nr. " + (i + 1));
                    tablou[i] = in.nextInt();
                }
                System.out.println("Maximul este: " + getMax(tablou));

            }  else if (optiune.equals("4")) {
                System.out.println("Dati numarul de elemente:");
                n = in.nextInt();
                tablaInmultirii(n);

            } else if (optiune.equals("5")) {
                do{
                System.out.println("Dati numarul n:");
                n = in.nextInt();
                System.out.println("Dati numarul m:");
                m = in.nextInt(); } while (n>m);
                tablaInmultiriiNM(n,m);

            } else if (optiune.equals("6a")) {
                System.out.println("Dati numarul nr:");
                n = in.nextInt();
                System.out.println("Suma cifrelor numarului " + n + " este: " + sumaCifre(n));
                System.out.println("Produsul cifrelor numarului " + n + " este: " + produsCifre(n));

            } else if (optiune.equals("6b")) {
                System.out.println("Dati numarul nr:");
                n = in.nextInt();
                System.out.println("Nuamrul cifrelor numarului " + n + " este: " + numarCifre(n));

            } else if (optiune.equals("6c")) {
                System.out.println("Dati numarul nr:");
                n = in.nextInt();
                System.out.println("Cifra minima a numarului " + n + " este: " + getMin(cifreNumar(n)));
                System.out.println("Cifra maxima a numarului " + n + " este: " + getMax(cifreNumar(n)));

            } else if (optiune.equals("6d")) {
                System.out.println("Dati numarul nr:");
                n = in.nextInt();
                System.out.println("Cifra control a numarului " + n + " este: " + cifraControl(n));
            }


            else if (optiune.equals("x")) {
                break;
            } else {
                System.out.println("Comanda invalida!");
            }

        }

    }

    private  static  int getMax(int[] array) {
        int max = array [0];
        for (int i=1; i<array.length; ++i){
            if (array [i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    private  static  int getMin(int[] array) {
        int min = array [0];
        for (int i=1; i<array.length; ++i){
            if (array [i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    private static double mediaAritmetica(int nr1, int nr2) {
        double media = (double) (nr1 + nr2) / 2;
        return media;
    }

    private static double medieNNumere(int n) {
        Scanner in = new Scanner(System.in);
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            do {
                System.out.println("introduceti numarul " + (i + 1) + " : ");
                a[i] = in.nextInt();
            } while (a[i]<0);

        for (int i = 0; i < n; i++)
            res = res + a[i];

        return res;
    }

    public static void tablaInmultirii(int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.println(i + " x " + j + " = " + i * j);
            }
        }
    }

    public static void tablaInmultiriiNM(int n, int m) {
        for (int i = n; i <= m; i++) {
            for (int j = 0; j <= m; j++) {
                System.out.println(i + " x " + j + " = " + i * j);
            }
        }
    }

    public static int sumaCifre(int nr) {
        int Suma = 0;
        while (nr > 0) {
            Suma += nr % 10;
            nr = nr / 10;
        }
        return Suma;
    }


    public static int produsCifre(int nr) {
        int produs = 1;
        while (nr > 0) {
            produs = produs*( nr % 10);
            nr = nr / 10;
        }
        return produs;
    }

    public static int numarCifre(int nr) {
        int numarC = 0;
        while (nr > 0) {
            numarC += 1;
            nr = nr / 10;
        }
        return numarC;
    }

    public static int[] cifreNumar(int nr) {
        int a[] = new int[numarCifre(nr)];
        int i = 0;
        while (nr > 0) {
            a[i] = nr % 10;
            nr = nr / 10;
            i++;
        }
        return a;
    }

    public static int cifraControl(int nr) {
        int Suma;
        do {
            Suma = 0;
            while (nr > 0) {
                Suma += nr % 10;
                nr = nr / 10;
            }
            nr = Suma;
        } while (nr>9);
        return Suma;
    }

}

