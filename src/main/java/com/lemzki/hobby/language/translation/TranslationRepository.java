package com.lemzki.hobby.language.translation;

import com.lemzki.hobby.language.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TranslationRepository extends JpaRepository<Translation, Long> {
}
