package com.nikhil.image.image.repository;




import com.nikhil.image.image.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    // Add custom queries if needed
}
