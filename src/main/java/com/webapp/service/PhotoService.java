package com.webapp.service;

import com.webapp.model.PhotoDTO;
import com.webapp.model.entity.Photo;

import java.util.List;

public interface PhotoService {
    Photo addNewPhoto(PhotoDTO photoDTO, long productId, String rootDirectory);
    List<Photo> getPhotosByProductId(long productId);
    void deletePhoto(long photoId, String rootDirectory);
}
