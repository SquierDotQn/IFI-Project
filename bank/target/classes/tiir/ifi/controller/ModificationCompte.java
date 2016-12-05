package tiir.ifi.controller;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class ModificationCompte {
    private Integer id;
    private String nom;
    @NotEmpty(message="{modification.compte.balance.notempty}")
    @Pattern(regexp="\\d*", message="{modification.compte.balance.numerique}")
    private String balance;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer pId) {
        id = pId;
    }

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