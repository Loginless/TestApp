package ua.com.agileboard.service;

import ua.com.agileboard.model.Card;
import ua.com.agileboard.util.exception.NotFoundException;

import java.util.List;

public interface CardService {

    Card create(Card card);

    void update(Card card) throws NotFoundException;

    void delete(int bcId) throws NotFoundException;

    Card findById(int bcId) throws NotFoundException;

    List<Card> findAll();
}
