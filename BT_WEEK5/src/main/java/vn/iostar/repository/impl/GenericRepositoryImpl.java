package vn.iostar.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import vn.iostar.repository.GenericRepository;
import java.util.List;
import java.util.Optional;

public abstract class GenericRepositoryImpl<T, ID> implements GenericRepository<T, ID> {
    
    @PersistenceContext
    protected EntityManager entityManager;
    
    private final Class<T> entityClass;
    
    protected GenericRepositoryImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(entityManager.find(entityClass, id));
    }
    
    @Override
    public List<T> findAll() {
        return entityManager.createQuery("FROM " + entityClass.getSimpleName(), entityClass)
                .getResultList();
    }
    
    @Override
    public T save(T entity) {
        if (entityManager.contains(entity)) {
            return entityManager.merge(entity);
        } else {
            entityManager.persist(entity);
            return entity;
        }
    }
    
    @Override
    public void deleteById(ID id) {
        findById(id).ifPresent(entityManager::remove);
    }
    
    @Override
    public long count() {
        return entityManager.createQuery("SELECT COUNT(e) FROM " + entityClass.getSimpleName() + " e", Long.class)
                .getSingleResult();
    }
}