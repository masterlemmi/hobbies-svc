package com.lemzki.hobby.language;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "LANGUAGE")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Language {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String name;

}
