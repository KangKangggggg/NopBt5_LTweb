package vn.iostar.repository;

import vn.iostar.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends GenericRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    List<User> findByFullNameContaining(String keyword);
    List<User> findByRole(String role);
}