package com.iko.iko.service.image.facade;

import com.iko.iko.service.image.AddBannerImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ImageFacade {
    private final AddBannerImageService addBannerImageService;

    @Transactional
    public String addBannerImage(String imageUrl){
        return addBannerImageService.addBannerImage(imageUrl);
    }

}
