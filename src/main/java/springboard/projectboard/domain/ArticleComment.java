package springboard.projectboard.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "content"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
@EntityListeners(AuditingEntityListener.class)
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ArticleComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter @ManyToOne(optional = false) private Article article;    // 게시글 (ID)
    @Setter @Column(nullable = false, length = 500) private String content; // 내용

    @CreatedDate @Column(nullable = false) private LocalDateTime createdAt;    // 생성일시
    @CreatedBy @Column(nullable = false, length = 100) private String CreatedBy;   // 생성자
    @LastModifiedDate @Column(nullable = false) private LocalDateTime modifiedAt;   // 수정일시
    @LastModifiedBy @Column(nullable = false, length = 100) private String modifiedBy;  // 수정자



    private ArticleComment(Article article, String content) {
        this.article = article;
        this.content = content;
    }

    public static ArticleComment of(Article article, String content){
        return new ArticleComment(article, content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArticleComment that)) return false;
        // 영속화(db에 저장) 되지 않았으면 다 같은 객체로 간주
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
