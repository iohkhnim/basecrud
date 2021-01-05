package com.khoi.basecrud.service;

import com.khoi.basecrud.dto.baseDTO;
import java.io.Serializable;
import java.util.List;

public interface IBaseService<T extends baseDTO, PK extends Serializable> {

  List<T> findAll();

  T findByid(PK id);

  Boolean update(T object);

  int create(T object);

  Boolean delete(PK id);
}
