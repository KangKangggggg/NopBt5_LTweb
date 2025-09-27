package vn.iostar.repository.impl;

import vn.iostar.entity.User;
import vn.iostar.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl extends GenericRepositoryImpl<User, Long> implements UserRepository {
    
    public UserRepositoryImpl() {
        super(User.class);
    }
    
    @Override
    public Optional<User> findByUsername(String username) {
        TypedQuery<User> query = entityManager.createQuery(
            "SELECT u FROM User u WHERE u.username = :username", User.class);
        query.setParameter("username", username);
        return query.getResultStream().findFirst();
    }
    
    @Override
    public Optional<User> findByEmail(String email) {
        TypedQuery<User> query = entityManager.createQuery(
            "SELECT u FROM User u WHERE u.email = :email", User.class);
        query.setParameter("email", email);
        return query.getResultStream().findFirst();
    }
    
    @Override
    public List<User> findByFullNameContaining(String keyword) {
        TypedQuery<User> query = entityManager.createQuery(
            "SELECT u FROM User u WHERE u.fullName LIKE :keyword", User.class);
        query.setParameter("keyword", "%" + keyword + "%");
        return query.getResultList();
    }
    
    @Override
    public List<User> findByRole(String role) {
        TypedQuery<User> query = entityManager.createQuery(
            "SELECT u FROM User u WHERE u.role = :role", User.class);
        query.setParameter("role", role);
        return query.getResultList();
    }

	public void setEntityManager(EntityManager entityManager) {
		// TODO Auto-generated method stub
		
	}
}