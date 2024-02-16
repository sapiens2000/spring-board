package springboard.projectboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboard.projectboard.domain.ArticleComment;

public interface ArticleCommentRepository extends JpaRepository<ArticleComment, Long> {
}
