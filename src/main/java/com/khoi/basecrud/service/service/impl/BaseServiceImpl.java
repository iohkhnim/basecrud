package com.khoi.basecrud.service.service.impl;

import com.khoi.basecrud.dao.IBaseDAO;
import com.khoi.basecrud.dao.dao.impl.BaseDAOImpl;
import com.khoi.basecrud.dto.baseDTO;
import com.khoi.basecrud.service.IBaseService;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseServiceImpl<T extends baseDTO, PK extends Serializable> implements IBaseService<T, PK> {

  @Autowired
  private IBaseDAO<T, PK> baseDAO;
  /*@Autowired
  private BaseDAOImpl<T, PK> baseDAO;*/

  public List<T> findAll() {
    return baseDAO.findAll();
  }

  public T findByid(PK id) {
    return baseDAO.findByid(id);
  }

  public int create(T t) {
    //t.setCreatedTime(Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTime());
    //t.setUpdatedTime(Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTime());
    int id = baseDAO.create(t);
    if (id != 0) {
      return id;
    } else {
      return 0;
    }
  }

  public Boolean update(T t) {
    //t.setUpdatedTime(Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTime());
    Boolean flag = baseDAO.update(t);
    if (flag) {
      return true;
    } else {
      return false;
    }
  }

  public Boolean delete(PK id) {
    Boolean flag = baseDAO.delete(id);
    if (flag) {
      return true;
    } else {
      return false;
    }
  }
}
