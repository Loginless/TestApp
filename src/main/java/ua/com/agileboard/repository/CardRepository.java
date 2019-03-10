package ua.com.agileboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ua.com.agileboard.model.Card;

import java.util.Optional;

@Transactional(readOnly = true)
public interface CardRepository extends JpaRepository<Card, Integer> {

    @Override
    @Transactional
    Card save(Card entity);

    @Override
    Optional<Card> findById(Integer integer);

    @Transactional
    @Modifying
    @Query("DELETE FROM Card c WHERE c.id=:id")
    int delete(@Param("id") int id);

}
