package com.demo.moataz.photozdemo.service;

import com.demo.moataz.photozdemo.model.Photo;
import com.demo.moataz.photozdemo.repository.PhotozRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PhotoService {
    private final PhotozRepository photozRepository;

    public PhotoService(PhotozRepository photozRepository) {
        this.photozRepository = photozRepository;
    }

    public Iterable<Photo> get(){
        return  photozRepository.findAll();
    }

    public Photo get(Integer id){
        return  photozRepository.findById(id).orElse(null);
    }

    public void remove(Integer id){
        photozRepository.deleteById(id);
    }

    public Photo save(String fileName, String contentType, byte[] data){
        Photo photo = new Photo();
        photo.setFileName(fileName);
        photo.setContentType(contentType);
        photo.setData(data);
        photozRepository.save(photo);
        return photo;
    }
}
