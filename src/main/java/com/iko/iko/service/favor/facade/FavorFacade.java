package com.iko.iko.service.favor.facade;

import com.iko.iko.controller.favor.dto.request.AddFavorRequestDto;
import com.iko.iko.service.favor.AddFavorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FavorFacade {

    private final AddFavorService addFavorService;

    @Transactional
    public Long addFavor(AddFavorRequestDto requestDto){
        return addFavorService.addFavor(requestDto);
    }
}
