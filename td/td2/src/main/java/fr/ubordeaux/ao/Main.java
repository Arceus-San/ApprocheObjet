package fr.ubordeaux.ao;

import fr.ubordeaux.ao.Transaction;

public class Main {
    
    public static void main(String[] args) {
        Transaction t1 = new Transaction("loyer", 545);
        System.out.println(t1.getDate().toString());
    }

}