package pl.edu.wszib.springjpa.model;

import jakarta.persistence.*;

import java.util.List;

public class Zajęcia {

  @Id
  @GeneratedValue
  private Integer id;
  private String nazwa;
  @ManyToMany
  @JoinTable
  private List<Student> student;

  @ManyToOne
  @JoinColumn
  private Prowadzacy prowadzacy;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNazwa() {
    return nazwa;
  }

  public void setNazwa(String nazwa) {
    this.nazwa = nazwa;
  }

  public List<Student> getStudent() {
    return student;
  }

  public void setStudent(List<Student> student) {
    this.student = student;
  }

  public Prowadzacy getProwadzacy() {
    return prowadzacy;
  }

  public void setProwadzacy(Prowadzacy prowadzacy) {
    this.prowadzacy = prowadzacy;
  }
}
