package com.webapp.controller;


import com.webapp.model.PhotoDTO;
import com.webapp.model.entity.Photo;
import com.webapp.service.PhotoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

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
    Photo addPhoto(@RequestBody MultipartFile file, @PathVariable("id") long productId, HttpServletRequest request){
        PhotoDTO photoDTO = new PhotoDTO();
        photoDTO.setPhoto(file);
        return photoService.addNewPhoto(photoDTO,productId,request.getSession().getServletContext().getRealPath("/"));
    }
}
