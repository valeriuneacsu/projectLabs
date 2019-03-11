package org.fasttrackit.catel;

public class TamagociGame {

    public static void main(String[] args){

        Catel dog1 = new Catel();
        dog1.setName("Rex");

        Catel dog2 = new Catel();
        dog2.setName("Snowy");

        for (int zi=0; zi<15; zi++) {
            System.out.println("zi " + zi + " varsta " + dog2.getVarsta() + " greutate " + dog2.getGreutate());
            dog2.mananca();
        }

        System.out.println("Catelul " + dog2.getName() + " are varsta " + dog2.getVarsta() + " greutate " + dog2.getGreutate());
    }
}
