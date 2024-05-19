package pl.edu.wszib.springjpa.repository.dictionary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.springjpa.model.dictionary.DictionaryEntry;

@Repository
public interface DictionaryEntryRepository extends JpaRepository<DictionaryEntryRepository, Integer> {

    int CountByLanguageCode(String code);

    @Query("""
select e from DictionaryEntry e
where
lower(e.word like cocant('%' lower(:text), '%') or
lower(e.translation like cocant('%' lower(:text), '%') or
lower(e.description like cocant('%' lower(:text), '%')
""")

List<DictionaryEntry> filterByText(String text);
}