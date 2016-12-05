package tiir.ifi.controller;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class CreationForm {

    @NotEmpty
    private String nom;
    @NotEmpty
    @Pattern(regexp="\\d*")
    private String balance;

    public String getNom() {
        return nom;
    }

    public void setNom(final String pNom) {
        nom = pNom;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(final String pBalance) {
        balance = pBalance;
    }
}