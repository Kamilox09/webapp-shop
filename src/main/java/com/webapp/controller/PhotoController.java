package com.webapp.controller;


import com.webapp.model.PhotoDTO;
import com.webapp.model.entity.Photo;
import com.webapp.service.PhotoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class PhotoController {

    private final PhotoService photoService;

    public PhotoController(PhotoService photoService){
        this.photoService=photoService;
    }

    @RequestMapping("/admin/photo/{id}")
    public String getPhotoPage(@PathVariable("id") long productId){
        return "/admin/photo/photoManagment";
    }

    @RequestMapping(value = "/admin/photo/{id}", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    public @ResponseBody
    Photo addPhoto(@RequestBody MultipartFile file, @PathVariable("id") long productId, HttpServletRequest request,
                   HttpServletResponse response){
        PhotoDTO photoDTO = new PhotoDTO();
        photoDTO.setPhoto(file);
        Photo photo = photoService.addNewPhoto(photoDTO,productId,request.getSession().getServletContext().getRealPath("/"));
        if(photo==null)
            response.setStatus(507);
        return photo;
    }

    @RequestMapping(value = "/admin/photos/{id}")
    public @ResponseBody
    List<Photo> getPhotosByProductId(@PathVariable("id") long productId){
        return photoService.getPhotosByProductId(productId);
    }

    @RequestMapping(value = "/admin/photo", method = RequestMethod.DELETE)
    public ResponseEntity deletePhoto(@RequestParam("id") long photoId, HttpServletRequest request){
        photoService.deletePhoto(photoId,request.getSession().getServletContext().getRealPath("/"));
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }
}
