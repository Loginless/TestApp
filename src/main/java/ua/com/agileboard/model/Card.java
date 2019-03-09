package ua.com.agileboard.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cards", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"}, name = "columns_unique_name_idx")})
public class Card extends AbstractNamedEntity {

    @Column(name = "description")
    @Size(max = 255)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "column_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
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






