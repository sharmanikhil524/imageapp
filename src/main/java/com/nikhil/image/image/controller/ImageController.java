package com.nikhil.image.image.controller;



import com.nikhil.image.image.model.Image;
import com.nikhil.image.image.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/upload")
    public Image uploadImage(@RequestBody Image image) {
        return imageService.uploadImage(image);
    }

    @GetMapping("/{imageId}")
    public Image getImageById(@PathVariable Long imageId) {
        return imageService.getImageById(imageId);
    }

    @GetMapping("/user/{userId}")
    public List<Image> getUserUploadedImages(@PathVariable Long userId) {
        return imageService.getUserUploadedImages(userId);
    }

    @PostMapping("/{imageId}/like")
    public void likeImage(@PathVariable Long imageId) {
        imageService.likeImage(imageId);
    }

    @GetMapping("/{imageId}/likes")
    public int getImageLikes(@PathVariable Long imageId) {
        return imageService.getImageLikes(imageId);
    }

    @PostMapping("/{imageId}/comments")
    public void addCommentToImage(@PathVariable Long imageId, @RequestBody String comment) {
        imageService.addCommentToImage(imageId, comment);
    }

    @GetMapping("/{imageId}/comments")
    public List<String> getImageComments(@PathVariable Long imageId) {
        
        return imageService.getImageComments(imageId);
    }
}
