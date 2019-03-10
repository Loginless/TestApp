package ua.com.agileboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ua.com.agileboard.model.BoardColumn;

import java.util.Optional;

@Transactional(readOnly = true)
public interface BoardColumnRepository extends JpaRepository<BoardColumn, Integer> {

    @Override
    @Transactional
    BoardColumn save(BoardColumn entity);

    @Override
    Optional<BoardColumn> findById(Integer integer);

    @Transactional
    @Modifying
    @Query("DELETE FROM BoardColumn bc WHERE bc.id=:id")
    int delete(@Param("id") int id);
}
