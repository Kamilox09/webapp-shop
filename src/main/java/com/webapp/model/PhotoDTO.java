package com.webapp.model;

import org.springframework.web.multipart.MultipartFile;

public class PhotoDTO {

    private MultipartFile photo;

    public MultipartFile getPhoto() {
        return photo;
    }

    public void setPhoto(MultipartFile photo) {
        this.photo = photo;
    }
}
