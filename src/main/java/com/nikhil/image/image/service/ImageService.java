package com.nikhil.image.image.service;
import com.nikhil.image.image.model.Image;

import java.util.List;

public interface ImageService {
    Image uploadImage(Image image);

    Image getImageById(Long imageId);

    List<Image> getUserUploadedImages(Long userId);

    void likeImage(Long imageId);

    int getImageLikes(Long imageId);

    void addCommentToImage(Long imageId, String comment);

    List<String> getImageComments(Long imageId);
}
