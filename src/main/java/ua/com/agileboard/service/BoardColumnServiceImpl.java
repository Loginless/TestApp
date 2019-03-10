package ua.com.agileboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ua.com.agileboard.model.BoardColumn;
import ua.com.agileboard.repository.BoardColumnRepository;
import ua.com.agileboard.util.exception.NotFoundException;

import java.util.List;

import static ua.com.agileboard.util.ValidationUtil.checkNotFoundWithId;

@Service("boardColumnService")
public class BoardColumnServiceImpl implements BoardColumnService {

    private final BoardColumnRepository boardColumnRepository;

    @Autowired
    public BoardColumnServiceImpl(BoardColumnRepository boardColumnRepository) {
        this.boardColumnRepository = boardColumnRepository;
    }

    @Override
    public BoardColumn create(BoardColumn boardColumn) {
        Assert.notNull(boardColumn, "BoardColumn must not be null");
        return boardColumnRepository.save(boardColumn);
    }

    @Override
    public void update(BoardColumn boardColumn) throws NotFoundException {
        Assert.notNull(boardColumn, "BoardColumn must not be null");
        checkNotFoundWithId(boardColumnRepository.save(boardColumn), boardColumn.getId());
    }

    @Override
    public void delete(int bcId) throws NotFoundException {
        checkNotFoundWithId(boardColumnRepository.delete(bcId) != 0, bcId);
    }

    @Override
    public BoardColumn findById(int bcId) throws NotFoundException {
        return checkNotFoundWithId(boardColumnRepository.findById(bcId).orElse(null), bcId);
    }

    @Override
    public List<BoardColumn> findAll() {
        return boardColumnRepository.findAll();
    }

}
