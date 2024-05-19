package pl.edu.wszib.springjpa.model.dictionary;

import jakarta.persistence.*;

@Entity
public class DictionaryEntry {

   @Id
   @GeneratedValue
    private int id;

    private String word;

    private String translation;

    private String description;

    @ManyToOne
    @JoinColumn
    private Language language;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
