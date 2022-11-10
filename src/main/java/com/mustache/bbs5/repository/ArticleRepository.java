package com.mustache.bbs5.repository;

import com.mustache.bbs5.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {
}
