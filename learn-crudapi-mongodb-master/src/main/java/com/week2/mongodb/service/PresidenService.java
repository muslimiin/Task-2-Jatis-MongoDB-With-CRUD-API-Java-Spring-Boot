package com.week2.mongodb.service;

import com.week2.mongodb.model.Presiden;

import java.util.List;

public interface PresidenService {

    Presiden createPresiden(Presiden presiden);

    Presiden updatePresiden(Presiden presiden);

    List<Presiden> getAllPresiden();

    Presiden getPresidenById(Long presidenId);

    Presiden deletePresiden(Long id);
}
