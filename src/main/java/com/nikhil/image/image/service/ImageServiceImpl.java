package com.nikhil.image.image.service;


import com.nikhil.image.image.model.Image;
import com.nikhil.image.image.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public Image uploadImage(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public Image getImageById(Long imageId) {
        return imageRepository.findById(imageId).orElse(null);
    }

    @Override
    public List<Image> getUserUploadedImages(Long userId) {
        return imageRepository.findAllById(Collections.singleton(userId));
    }

    @Override
    public void likeImage(Long imageId) {
        Image image = imageRepository.findById(imageId).orElse(null);
        if (image != null) {
            image.setLikes(image.getLikes() + 1);
            imageRepository.save(image);
        }
    }

    @Override
    public int getImageLikes(Long imageId) {
        Image image = imageRepository.findById(imageId).orElse(null);
        return (image != null) ? image.getLikes() : 0;
    }

    @Override
    public void addCommentToImage(Long imageId, String comment) {
        Image image = imageRepository.findById(imageId).orElse(null);
        if (image != null) {
            // Add comment to image (implementation depends on your requirements)
        }
    }

    @Override
    public List<String> getImageComments(Long imageId) {
        // Retrieve comments for the image (implementation depends on your requirements)
        return null;
    }
}
