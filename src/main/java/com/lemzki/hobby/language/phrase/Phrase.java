package com.lemzki.hobby.language.phrase;

import com.lemzki.hobby.language.translation.Translation;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Common phrases and their corresponding translations
 */
@Entity
@Table(name = "Phrase")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Phrase {
    @Id
    @GeneratedValue
    private Long id;
    private String phrase;
    @OneToMany(
            mappedBy = "phrase",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Translation> translations = new HashSet<>();

    public void addTranslation(Translation translation){
        this.translations.add(translation);
        translation.setPhrase(this);
    }

    public void removeTranslation(Translation translation){
        this.translations.remove(translation);
        translation.setPhrase(null);
    }
}
