package com.lemzki.hobby.language.phrase;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
class PhraseControllerImpl implements PhraseController {

    @Autowired
    PhraseService service;


}
