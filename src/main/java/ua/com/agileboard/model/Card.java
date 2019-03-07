package ua.com.agileboard.model;

public class Card extends AbstractNamedEntity {


    private String description;


    private BoardColumn boardColumn;

    public Card() {
    }

    public Card(Card newCard) {
        this(newCard.getId(), newCard.getName(), newCard.getDescription(), newCard.getBoardColumn());
    }


    public Card(Integer id, String name, String description, BoardColumn boardColumn) {
        super(id, name);
        this.description = description;
        this.boardColumn = boardColumn;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BoardColumn getBoardColumn() {
        return boardColumn;
    }

    public void setBoardColumn(BoardColumn boardColumn) {
        this.boardColumn = boardColumn;
    }

    @Override
    public String toString() {
        return "Card{" +
                "description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}






