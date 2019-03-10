package ua.com.agileboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ua.com.agileboard.model.BoardColumn;
import ua.com.agileboard.model.Card;
import ua.com.agileboard.repository.CardRepository;
import ua.com.agileboard.util.exception.NotFoundException;

import java.util.List;

import static ua.com.agileboard.util.ValidationUtil.checkNotFoundWithId;

@Service("cardService")
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    @Autowired
    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public Card create(Card card) {
        Assert.notNull(card, "card must not be null");
        return cardRepository.save(card);
    }

    @Override
    public void update(Card card) throws NotFoundException {
        Assert.notNull(card, "card must not be null");
        checkNotFoundWithId(cardRepository.save(card), card.getId());
    }

    @Override
    public void delete(int cardId) throws NotFoundException {
        checkNotFoundWithId(cardRepository.delete(cardId) != 0, cardId);

    }

    @Override
    public Card findById(int cardId) throws NotFoundException {
        return checkNotFoundWithId(cardRepository.findById(cardId).orElse(null), cardId);
    }

    @Override
    public List<Card> findAll() {
        return cardRepository.findAll();
    }

    public void changeCardColumn(Card card, BoardColumn boardColumn) {
        card.setBoardColumn(boardColumn);
    }
}

