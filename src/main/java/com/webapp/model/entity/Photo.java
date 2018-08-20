package com.webapp.model.entity;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Entity
@Table(name="PHOTO")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long photoId;

    @Size(min=1,max=64)
    @Column(name = "FILE_NAME",nullable = false)
    private String fileName;

    @Column(name="ADDING_DATE",nullable = false)
    private Timestamp addingDate;

    @ManyToOne
    private Product product;

    public long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(long photoId) {
        this.photoId = photoId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Timestamp getAddingDate() {
        return addingDate;
    }

    public void setAddingDate(Timestamp addingDate) {
        this.addingDate = addingDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
