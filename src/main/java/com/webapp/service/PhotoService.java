package com.webapp.service;

import com.webapp.model.PhotoDTO;
import com.webapp.model.entity.Photo;

public interface PhotoService {
    Photo addNewPhoto(PhotoDTO photoDTO, long productId, String rootDirectory);
}
