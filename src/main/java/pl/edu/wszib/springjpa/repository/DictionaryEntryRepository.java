package pl.edu.wszib.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.springjpa.model.DictionaryEntry;

import java.util.List;

@Repository
public interface DictionaryEntryRepository extends JpaRepository<DictionaryEntry, Integer> {

    int countByLanguageCode(String code);

    @Query("""
        select e from DictionaryEntry e
        where
            lower(e.word) like concat('%', lower(:text), '%') or
            lower(e.translation) like concat('%', lower(:text), '%') or
            lower(e.description) like concat('%', lower(:text), '%')
    """)
    List<DictionaryEntry> filterByText(String text);

}
