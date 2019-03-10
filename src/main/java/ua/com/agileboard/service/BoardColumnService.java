package ua.com.agileboard.service;

import ua.com.agileboard.model.BoardColumn;
import ua.com.agileboard.util.exception.NotFoundException;

import java.util.List;

public interface BoardColumnService {

    BoardColumn create(BoardColumn boardColumn);

    void update(BoardColumn boardColumn) throws NotFoundException;

    void delete(int bcId) throws NotFoundException;

    BoardColumn findById(int bcId) throws NotFoundException;

    List<BoardColumn> findAll();
}
