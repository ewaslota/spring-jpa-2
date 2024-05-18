package pl.edu.wszib.springjpa.model;

import jakarta.persistence.*;

@Entity
public class Organizacja {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private DetaleOrganizacji detaleOrganizacji;

    public DetaleOrganizacji getDetaleOrganizacji() {
        return detaleOrganizacji;
    }

    public void setDetaleOrganizacji(DetaleOrganizacji detaleOrganizacji) {
        this.detaleOrganizacji = detaleOrganizacji;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
