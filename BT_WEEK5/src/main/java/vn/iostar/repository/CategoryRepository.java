package vn.iostar.repository;

import vn.iostar.entity.Category;
import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends GenericRepository<Category, Long> {
    Optional<Category> findByName(String name);
    List<Category> findByNameContaining(String keyword);
}