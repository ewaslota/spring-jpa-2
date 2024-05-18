package pl.edu.wszib.springjpa.model;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
public class Wizyta {

  @Id
  @GeneratedValue
  private Integer id;

  @ManyToOne
  @JoinColumn
  private Gabinet gabinet;

  @ManyToOne
  @JoinColumn
  private Pacjent pacjent;
  private Instant data;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Gabinet getGabinet() {
    return gabinet;
  }

  public void setGabinet(Gabinet gabinet) {
    this.gabinet = gabinet;
  }

  public Pacjent getPacjent() {
    return pacjent;
  }

  public void setPacjent(Pacjent pacjent) {
    this.pacjent = pacjent;
  }

  public Instant getData() {
    return data;
  }

  public void setData(Instant data) {
    this.data = data;
  }
}
