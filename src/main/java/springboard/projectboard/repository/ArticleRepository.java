package springboard.projectboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboard.projectboard.domain.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}