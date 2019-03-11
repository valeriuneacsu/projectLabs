

public class CarsGame {

    public static void main(String[] args){

        String car1 = "Ford";
        String car2 = "BMW";
        String car3 = "Mercedes";

        String[] myCars = new String[3];
        myCars[0] = car1;
        myCars[1] = car2;
        myCars[2] = car3;

        for (int i = 0; i<3; i++){
            System.out.println(myCars[i]);
        }

        for (String masina: myCars){
            System.out.println(masina);
        }

        int i = 0;
        while (i<myCars.length && !(myCars[i].charAt(0) == "B".charAt(0) || myCars[i].charAt(0) == "b".charAt(0))){
            System.out.println(myCars[i]);
            i++;
        }

        int j = 0;
        do {
            System.out.println(myCars[j]);
            j++;
        } while (j<myCars.length && !(myCars[j].charAt(0) == "B".charAt(0) || myCars[j].charAt(0) == "b".charAt(0)));

    }

}
