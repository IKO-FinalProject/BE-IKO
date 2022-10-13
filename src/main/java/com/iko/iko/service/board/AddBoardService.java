package com.iko.iko.service.board;

import com.iko.iko.domain.repository.board.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AddBoardService {
    private final BoardRepository boardRepository;
}
