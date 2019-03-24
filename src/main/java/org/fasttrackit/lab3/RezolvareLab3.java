package org.fasttrackit.lab3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class RezolvareLab3 {
    static int nr1;
    static int nr2;
    static double med;
    static int n;
    static int m;
    static int a;
    static int rest;
    static double res = 0;
    static int[] tablou;
    static int[] newSir;


    //Problema 1

    public static void printMeniu() {
        System.out.println();
        System.out.println("1. Media aritmetica a doua numere");
        System.out.println("2. Media aritmetica a n numere");
        System.out.println("3. Maximul a n numere");
        System.out.println("4. Tabla inmultirii cu n numere");
        System.out.println("5. Tabla inmultirii cu n,m numere");
        System.out.println("6a. Suma si produsul cifrelor numarului n");
        System.out.println("6b. Numarul cifrelor numarului n");
        System.out.println("6c. Cifra minima si maxima a numarului n");
        System.out.println("6d. Cifra control a numarului n");
        System.out.println("7. Inversul numarului n");
        System.out.println("8. Palindrom sau nu");
        System.out.println("9. Numar format din cifrele impare ale altui numar si patratul celor pare");
        System.out.println("10. Gasire numar intr-un sir de numere");
        System.out.println("11. Suma primelor n numere naturale");
        System.out.println("12. Cea mai mare valoare din sir, cu suma de control sub 3");
        System.out.println("13. True/False daca nr este in intervalul [9,24]");
        System.out.println("14. Numarul a la puterea n");
        System.out.println("15. Factorialul unui numar");
        System.out.println("16. Perechi de numere cu primul numar mai mare decat al doilea");

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

            } else if (optiune.equals("7")) {
                System.out.println("Dati numarul nr:");
                n = in.nextInt();
                System.out.println("Inversul numarului " + n + " este: " + inversulNr(n));

            } else if (optiune.equals("8")) {
                System.out.println("Dati numarul nr:");
                n = in.nextInt();
                numarulFormat(n);

            }else if (optiune.equals("9")) {
                System.out.println("Numarul: ");
                n = in.nextInt();
                System.out.println("Numarul format din cifre impare: " + numarCifreImpare(n));
                System.out.println("Numarul format din patratul cifrelor pare: " + numarPatratCifrePare(n));

            } else if (optiune.equals("10")) {
                int[] arr = {1, 2, 4, 5, 7, 9, 34, 66, 77, 79};
                System.out.println("Introduceti nr pe care doriti sa il cautati: ");
                n = in.nextInt();

                int index = search(arr, n);
                if (index == -1) {
                    System.out.println("-1");
                } else
                    System.out.println(" Gasit la indexul: " + index);

            } else if (optiune.equals("11")) {
                System.out.println("Dati numarul: ");
                n = in.nextInt();
                System.out.println("Suma primelor " + n + " numere este: " + sumOfNumbers(n));

            } else if (optiune.equals("12")) {
                System.out.println("Dati numarul de elemente al sirului: ");
                n = in.nextInt();
                tablou = new int[n];
                for (int i=0;i<n;i++){
                    do {
                        System.out.println("dati elementul cu nr: " + (i + 1));
                        tablou[i] = in.nextInt();
                    } while (tablou[i]<10);
                }
                System.out.println(" Sirul de numere este: " + Arrays.toString(tablou));
                newSir = new int[n];
                for (int i = 0; i < n; i++) {
                    if(cifraControl(tablou[i]) < 3){
                        newSir[i] = tablou[i];
                    }else newSir[i] = 0;
                }
                System.out.println("Cea mai mare valoare din sir cu suma de control < 3 este: " + getMax(newSir));


            } else if (optiune.equals("13")) {
                int arr[] = IntStream.rangeClosed(9,24).toArray();
                System.out.println("Dati numarul: ");
                n = in.nextInt();
                int result = search(arr,n);
                if(result == -1) {
                    System.out.println("False");
                }else System.out.println("True");


            } else if (optiune.equals("14")) {
                System.out.println("Dati numarul a: ");
                a = in.nextInt();
                System.out.println("Dati numarul n(puterea): ");
                n = in.nextInt();
                System.out.println("Numarul " + a + " la puterea " + n + " este = " + putere(n,a));

            } else if (optiune.equals("15")) {
                System.out.println("Dati numarul: ");
                n = in.nextInt();
                System.out.println("Factorialul numarului " + n + " este = " + factorialNumber(n));

            }else if (optiune.equals("16")) {
                System.out.println("Dati numarul de elemente:");
                n = in.nextInt();

                int[] arr = new int[n];
                for (int i = 0; i < n; ++i) {
                    System.out.println("Dati elementul cu nr. " + (i + 1));
                    arr[i] = in.nextInt();
                }
//                int[] arr = {31, 2, 24, 5, 7, 19, 34, 66, 77, 79}; //in ideea in care sirul trb sa fie dat implicit
                System.out.println(Arrays.toString(arr));
                perechiNumere(arr);

            }else if (optiune.equals("x")) {
                break;
            } else {
                System.out.println("Comanda invalida!");
            }

        }

    }
    private static void perechiNumere(int[] arr) {
        Map<Integer,Integer> perechi = new HashMap<>();

        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] < arr[i - 1]) {
                perechi.put(arr[i - 1],arr[i]);
            }
        }
        for (Integer i : perechi.keySet()) {
            System.out.print( i +" "+ perechi.get(i)+" , ");
        }
    }
    private static int putere(int n, int a ){
        int p = n;
        for (int i=1; i<a; i++){
            p *= n;
        }
        return p;
    }
    private static int factorialNumber(int n) {
        int factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial = factorial * i;     //fact pt 3 = 1*2*3
        }
        return factorial;
    }
    private static int search(int arr[], int n) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (arr[middle] == n)  // verific daca nr e la mijloc
                return middle;
            if (arr[middle] < n)    // daca nr e mai mare ignor partea stanga
                left = middle + 1;
            else              // daca nr e mai mic ignor partea dreapta
                right = middle - 1;
        }
        return -1; //-1 daca nr nu este in sir
    }

    private static int sumOfNumbers(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum = sum + i;
        }
        return sum; //sau return n*(n+1)/2
    }
    private static int numarCifreImpare(int n) {
        int nrnou = 0;
        int p = 1;
        do {
            rest = n % 10;
            if (rest % 2 != 0) {
                nrnou = nrnou + p * rest;
                p = p * 10;
            }
            n = n / 10;
        } while (n > 0);
        return nrnou;
    }

    private static int numarPatratCifrePare(int n) {
        int nrnou = 0;
        int p = 1;
        do {
            rest = n % 10;
            if (rest % 2 == 0) {
                nrnou = nrnou + p * rest;
                p = p * 10;
            }
            n = n / 10;
        } while (n > 0);
        return nrnou * nrnou;
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

    private static int inversulNr(int nr) {
        int invers = 0;
        while (nr > 0 ){
            invers = invers* 10 + nr % 10;
            nr = nr/10;
        }
        return invers;
    }
    public static void numarulFormat(int nr) {
        int rest, suma=0, copie;
        copie=nr;
        while(nr>0){
            rest= nr%10;
            suma= (suma*10)+rest;
            nr=nr/10;
        }

        if(copie==suma)
            System.out.println("Numarul " + copie + " este palindrom");
        else System.out.println("Numarul " + copie + " nu e palindrom");
    }


}

