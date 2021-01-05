package com.khoi.basecrud.dao;

import com.khoi.basecrud.dto.baseDTO;
import java.io.Serializable;
import java.util.List;

public interface IBaseDAO<T extends baseDTO, PK extends Serializable> {

  List<T> findAll();

  T findByid(PK id);

  Boolean update(T object);

  int create(T object);

  Boolean delete(PK id);
}
