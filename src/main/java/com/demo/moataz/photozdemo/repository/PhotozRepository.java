package com.demo.moataz.photozdemo.repository;

import com.demo.moataz.photozdemo.model.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotozRepository extends CrudRepository<Photo, Integer> {
}
