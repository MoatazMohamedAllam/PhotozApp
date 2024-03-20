package com.demo.moataz.photozdemo.web;

import com.demo.moataz.photozdemo.model.Photo;
import com.demo.moataz.photozdemo.service.PhotoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@RestController
public class PhotozController {

    private final PhotoService photoService;
    public PhotozController(PhotoService photoService){

        this.photoService = photoService;
    }

    @GetMapping("/")
    public String hello(){
        return "Hello From Docker By Java";
    }

    @GetMapping("/photoz")
    public Iterable<Photo> get(){
        return photoService.get();
    }

    @GetMapping("/photoz/{id}")
    public Photo get(@PathVariable Integer id){
        Photo photo = photoService.get(id);
        if(photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    @DeleteMapping("/photoz/{id}")
    public void delete(@PathVariable Integer id){
      photoService.remove(id);
    }

    @PostMapping("/photoz")
    public Photo create(@RequestPart("data")MultipartFile file) throws IOException {
        return photoService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
    }



}
