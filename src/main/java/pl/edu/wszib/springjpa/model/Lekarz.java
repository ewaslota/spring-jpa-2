package pl.edu.wszib.springjpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Lekarz {

  @Id
  @GeneratedValue
  private Integer id;
  private String imie;
  private String nazwisko;
  private String specjalizacja;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getImie() {
    return imie;
  }

  public void setImie(String imie) {
    this.imie = imie;
  }

  public String getNazwisko() {
    return nazwisko;
  }

  public void setNazwisko(String nazwisko) {
    this.nazwisko = nazwisko;
  }

  public String getSpecjalizacja() {
    return specjalizacja;
  }

  public void setSpecjalizacja(String specjalizacja) {
    this.specjalizacja = specjalizacja;
  }
}
