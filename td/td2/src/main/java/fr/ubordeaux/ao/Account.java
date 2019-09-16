package fr.ubordeaux.ao;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.*;

public class Account {
    private double balance;
    private String id;
    private String name;
    private Set<Transaction> transactions;

    public Account(String id, String name) {
        this.balance = 0;
        transactions = new HashSet<Transaction>();
    }

    public double getBalance() {
        return balance;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        this.balance+=transaction.getAmount();
    }
    
    public Set<Transaction> getTransactionSince(Date date) {
        Set<Transaction> provisoire = new HashSet<>();
        Iterator<Transaction> iterator = this.transactions.iterator();
        while(iterator.hasNext()){
            Transaction t = iterator.next();
            if(!t.getDate().before(date)){
                provisoire.add(t);
            }
        }
        return new HashSet<>(provisoire);
    }

    public void supprTransaction(Date date, String titre, int montant) {
        Iterator<Transaction> iterator = this.transactions.iterator();
        while(iterator.hasNext()){
            Transaction t = iterator.next();
            if(t.getDate().equals(date) && t.getAmount()==montant && t.getTitle().equals(titre)){
                iterator.remove();
                break;
            }
        }
    }


    @Override
    public boolean equals(Object other) {
        if (other instanceof Account) {
            Account otherAccount = (Account) other;
            return this.id.compareTo(otherAccount.id) == 0;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.id);
    }

    @Override
    public String toString() {
        return "Account "+this.name+" (id="+this.id+"), balance = "+this.balance;
    }
    
}