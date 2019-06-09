package com.lemzki.hobby.language.translation;

import com.lemzki.hobby.language.Language;
import com.lemzki.hobby.language.phrase.Phrase;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TRANSLATION")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Translation {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    @JoinColumn(name = "language_id")
    private Language language;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "phrase_id")
    private Phrase phrase;
    private String translation;
}
