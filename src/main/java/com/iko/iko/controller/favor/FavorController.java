package com.iko.iko.controller.favor;


import com.iko.iko.controller.favor.dto.request.AddFavorRequestDto;
import com.iko.iko.service.favor.facade.FavorFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/favor")
@RestController
public class FavorController {

    private final FavorFacade favorFacade;

    public FavorController(FavorFacade favorFacade){
        this.favorFacade = favorFacade;
    }

    //  즐겨찾기 추가
    @PostMapping("/add")
    public ResponseEntity addFavor(AddFavorRequestDto requestDto){
        favorFacade.addFavor(requestDto);
        return new ResponseEntity<>("즐겨찾기 추가 완료", HttpStatus.OK);
    }

}
