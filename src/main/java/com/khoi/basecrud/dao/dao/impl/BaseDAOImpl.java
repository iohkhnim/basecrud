package com.khoi.basecrud.dao.dao.impl;

import com.khoi.basecrud.dao.IBaseDAO;
import com.khoi.basecrud.dto.baseDTO;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
@SuppressWarnings("unchecked")
public abstract class BaseDAOImpl<T extends baseDTO, PK extends Serializable>
    implements IBaseDAO<T, PK> {

  @PersistenceContext
  protected EntityManager entityManager;
  protected Class<T> entityClass;

  public BaseDAOImpl() {
    ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
    this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
  }

  public static void main(String[] args) {
    System.out.println();
  }

  @Override
  public List<T> findAll() {
    String hql = "FROM " + this.entityClass.getTypeName() + " as obj ORDER BY obj.id";
    return (List<T>) entityManager.createQuery(hql).getResultList();
  }

  @Override
  public T findByid(PK id) {
    return entityManager.find(entityClass, id);
  }

  @Override
  public int create(T t) {
    try {
      t.setCreatedTime(Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTime());
      t.setUpdatedTime(Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTime());
      this.entityManager.persist(t);
      return t.getId();
    } catch (Exception ex) {
      return 0;
    }
  }

  @Override
  public Boolean update(T t) {
    try {
      if (entityManager.find(entityClass, t.getId()) != null) {
        t.setUpdatedTime(Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTime());
        this.entityManager.merge(t);
        return true;
      } else {
        return false;
      }
    } catch (Exception ex) {
      return false;
    }
  }

  @Override
  public Boolean delete(PK id) {
    try {
      this.entityManager.remove(this.entityManager.find(entityClass, id));
      return true;
    } catch (Exception ex) {
      return false;
    }
  }
}
