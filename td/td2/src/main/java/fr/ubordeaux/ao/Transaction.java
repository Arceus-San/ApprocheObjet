package fr.ubordeaux.ao;

import java.util.Date;

public class Transaction {
    private Date date;
    private String title;
    private int amount;

    public Transaction(String title, int amount) throws IllegalArgumentException{
        this.date = new Date();
        this.title = title;
        if(amount <= 0)
            throw new IllegalArgumentException("Le montant doit être supérieur à zéro");
        this.amount=amount;
    }

    public Date getDate() {
        return this.date;
    }

    public String getTitle() {
        return this.title;
    }

    public double getAmount() {
        return this.amount;
    }
}