package pl.edu.wszib.springjpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class DetaleOrganizacji {
    @Id
    @GeneratedValue
    private Long id;
    private String adres;
    private String kodPoczowy;
    private String miasto;
    private String kraj;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getKodPoczowy() {
        return kodPoczowy;
    }

    public void setKodPoczowy(String kodPoczowy) {
        this.kodPoczowy = kodPoczowy;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getKraj() {
        return kraj;
    }

    public void setKraj(String kraj) {
        this.kraj = kraj;
    }
}
