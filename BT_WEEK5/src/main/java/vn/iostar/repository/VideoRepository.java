package vn.iostar.repository;

import vn.iostar.entity.Video;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("unused")
public interface VideoRepository extends GenericRepository<Video, Long> {
    List<Video> findByTitleContaining(String keyword);
    List<Video> findByCategoryId(Long categoryId);
    List<Video> findByUserId(Long userId);
    List<Video> findByTitleContainingAndCategoryId(String keyword, Long categoryId);
}