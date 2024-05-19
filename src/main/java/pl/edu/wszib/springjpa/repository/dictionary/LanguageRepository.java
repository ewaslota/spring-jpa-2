package pl.edu.wszib.springjpa.repository.dictionary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.springjpa.model.dictionary.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {
}
