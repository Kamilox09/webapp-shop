package com.webapp.dao.impl;

import com.webapp.dao.PhotoDao;
import com.webapp.model.entity.Photo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("photoDao")
@Transactional
public class PhotoDaoImpl extends AbstractDao<Photo> implements PhotoDao {
}
