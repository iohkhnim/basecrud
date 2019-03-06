package com.khoi.basecrud.dao.dao.impl;

import com.khoi.basecrud.BasecrudApplication;
import com.khoi.basecrud.dao.IBaseDAO;
import com.khoi.basecrud.dto.baseDTO;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public abstract class BaseDAOImpl<T extends baseDTO, PK extends Serializable> implements IBaseDAO<T, PK> {


  @PersistenceContext
  protected EntityManager entityManager;
  protected Class<T> entityClass;

  public BaseDAOImpl() {
    ParameterizedType genericSuperclass = (ParameterizedType) getClass()
        .getGenericSuperclass();
    this.entityClass = (Class<T>) genericSuperclass
        .getActualTypeArguments()[0];
  }

  public static void main(String[] args) {
    System.out.println();
  }
  /*public void setClass(Class<T> classToSet){
    this.entityClass = classToSet
  }*/

  @Override
  public List<T> findAll() {
    String hql = "FROM " + this.entityClass.getName() + " as class ORDER BY class.id";
    return (List<T>) entityManager.createQuery(hql).getResultList();
  }

  @Override
  public T findByid(PK id) {
    return entityManager.find(entityClass, id);
  }

  @Override
  public Boolean create(T t){
    try{
      this.entityManager.persist(t);
      return true;
    } catch (Exception ex){
      return false;
    }
  }

  @Override
  public Boolean update(T t){
    try{
      this.entityManager.merge(t);
      return true;
    } catch (Exception ex){
      return false;
    }
  }

  @Override
  public Boolean delete(PK id){
    try{
      this.entityManager.remove(this.entityManager.find(entityClass, id));
      return true;
    } catch (Exception ex){
      return false;
    }
  }
}
