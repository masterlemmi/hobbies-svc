package com.lemzki.hobby.language;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Long> {
    Language findByName(String cebuano);
}
