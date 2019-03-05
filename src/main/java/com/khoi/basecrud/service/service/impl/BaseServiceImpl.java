package com.khoi.basecrud.service.service.impl;

import com.khoi.basecrud.dao.IBaseDAO;
import com.khoi.basecrud.dto.baseDTO;
import com.khoi.basecrud.service.IBaseService;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class BaseServiceImpl<T extends baseDTO, PK extends Serializable> implements IBaseService<T, PK> {

  private IBaseDAO<T, PK> baseDAO;

  public List<T> findAll() {
    return baseDAO.findAll();
  }

  public T findByid(PK id) {
    return baseDAO.findByid(id);
  }

  public Boolean create(T t) {
    t.setCreatedTime(Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTime());
    t.setUpdatedTime(Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTime());
    Boolean flag = baseDAO.create(t);
    if (flag) {
      return true;
    } else {
      return false;
    }
  }

  public Boolean update(T t) {
    t.setUpdatedTime(Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTime());
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
