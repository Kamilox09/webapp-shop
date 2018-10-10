package com.webapp.service.impl;

import com.webapp.dao.PhotoDao;
import com.webapp.model.PhotoDTO;
import com.webapp.model.entity.Photo;
import com.webapp.model.entity.Product;
import com.webapp.service.PhotoService;
import com.webapp.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;

@Service("photoService")
@Transactional
public class PhotoServiceImpl implements PhotoService {

    private final PhotoDao photoDao;
    private final ProductService productService;

    public PhotoServiceImpl(PhotoDao photoDao, ProductService productService){
        this.photoDao=photoDao;
        this.productService=productService;
    }

    @Override
    public Photo addNewPhoto(PhotoDTO photoDTO, long productId, String rootDirectory) {
        Product product = productService.getById(productId);
        Photo photo = new Photo();
        photo.setAddingDate(new Timestamp(System.currentTimeMillis()));
        photo.setFileName(product.getName());
        photo.setProduct(product);
        photo = photoDao.create(photo);
        if(photo.getPhotoId()==0L)
            return null;
        photo.setFileName(product.getName()+"-"+photo.getPhotoId());
        photo = photoDao.update(photo);
        if(photoDTO.getPhoto()!=null && !photoDTO.getPhoto().isEmpty()){
            try{
                Path path = Paths.get(rootDirectory+"resources//images//"+product.getProductId()+"//"+photo.getFileName()+".png");
                Files.createDirectories(path.getParent());
                photoDTO.getPhoto().transferTo(new File(
                        rootDirectory+"resources//images//"+product.getProductId()+"//"+photo.getFileName()+".png"));
            }catch(Exception e){
                return null;
            }
            return photo;
        }
        photoDao.delete(photo);
        return null;
    }
}
