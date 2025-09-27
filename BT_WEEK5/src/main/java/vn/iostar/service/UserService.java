package vn.iostar.service;

import vn.iostar.entity.User;
import vn.iostar.repository.UserRepository;
import vn.iostar.repository.impl.UserRepositoryImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import java.util.Optional;

public class UserService {
    
    private final UserRepository userRepository;
    private final EntityManager entityManager;
    
    public UserService() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        this.entityManager = emf.createEntityManager();
        this.userRepository = new UserRepositoryImpl();
        // Set entity manager for repository
        ((UserRepositoryImpl) userRepository).setEntityManager(entityManager);
    }
    
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
    
    public List<User> findAll() {
        return userRepository.findAll();
    }
    
    public User save(User user) {
        entityManager.getTransaction().begin();
        User savedUser = userRepository.save(user);
        entityManager.getTransaction().commit();
        return savedUser;
    }
    
    public void deleteById(Long id) {
        entityManager.getTransaction().begin();
        userRepository.deleteById(id);
        entityManager.getTransaction().commit();
    }
    
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    public List<User> searchByFullName(String keyword) {
        return userRepository.findByFullNameContaining(keyword);
    }
    
    public List<User> findByRole(String role) {
        return userRepository.findByRole(role);
    }
    
    public void close() {
        entityManager.close();
    }
}