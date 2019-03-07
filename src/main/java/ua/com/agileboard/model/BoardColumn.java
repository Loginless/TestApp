package ua.com.agileboard.model;


import java.util.Set;

public class BoardColumn extends AbstractNamedEntity {


    private String description;

    private Set<Card> cards;

    public BoardColumn() {
    }

    public BoardColumn(BoardColumn boardColumn) {
        this(boardColumn.getId(), boardColumn.getName(), boardColumn.getDescription());
    }

    public BoardColumn(Integer id, String name, String description) {
        super(id, name);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Card> getCards() {
        return cards;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "BoardColumn{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                '}';
    }
}
