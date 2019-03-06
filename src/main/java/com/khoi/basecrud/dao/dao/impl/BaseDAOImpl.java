package com.khoi.basecrud.dao.dao.impl;

import com.khoi.basecrud.BasecrudApplication;
import com.khoi.basecrud.dao.IBaseDAO;
import com.khoi.basecrud.dto.baseDTO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
<<<<<<< HEAD
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
=======
>>>>>>> 931255144dfff016f2536b4c0a0667a62f7352a0

@Transactional
@Repository
@SuppressWarnings("unchecked")
public abstract class BaseDAOImpl<T extends baseDTO, PK extends Serializable>
    implements IBaseDAO<T, PK> {

<<<<<<< HEAD

  @PersistenceContext
  protected EntityManager entityManager;
=======
  @PersistenceContext protected EntityManager entityManager;
>>>>>>> 931255144dfff016f2536b4c0a0667a62f7352a0
  protected Class<T> entityClass;

  public BaseDAOImpl() {
    ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
    this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
  }

<<<<<<< HEAD
  public static void main(String[] args) {
    System.out.println();
  }
  /*public void setClass(Class<T> classToSet){
    this.entityClass = classToSet
=======
  /*public static String getNeededClassName(String name){
    String[] names = name.split("\\.");
    return names[names.length-1];
>>>>>>> 931255144dfff016f2536b4c0a0667a62f7352a0
  }*/
  @Override
  public List<T> findAll() {
<<<<<<< HEAD
    String hql = "FROM " + this.entityClass.getName() + " as class ORDER BY class.id";
=======
    // String name = getNeededClassName(this.entityClass.getName().toString());
    // String hql = "FROM " + name + " as obj ORDER BY obj.id";
    String hql = "FROM " + this.entityClass.getTypeName() + " as obj ORDER BY obj.id";
>>>>>>> 931255144dfff016f2536b4c0a0667a62f7352a0
    return (List<T>) entityManager.createQuery(hql).getResultList();
  }

  @Override
  public T findByid(PK id) {
    return entityManager.find(entityClass, id);
  }

  @Override
  public Boolean create(T t) {
    try {
      this.entityManager.persist(t);
      return true;
    } catch (Exception ex) {
      return false;
    }
  }

  @Override
  public Boolean update(T t) {
    try {
      this.entityManager.merge(t);
      return true;
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
