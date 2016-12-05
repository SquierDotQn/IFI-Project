package tiir.ifi.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COMPTES")
public class Course {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="IDCOMPTE")
    private Integer id;
    private String nom;
    private Integer balance;

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

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(final Integer pBalance) {
        balance = pBalance;
    }
}