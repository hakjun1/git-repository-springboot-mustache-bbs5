package com.mustache.bbs5.service;

import com.mustache.bbs5.domain.Article;
import com.mustache.bbs5.domain.dto.ArticleDto;
import com.mustache.bbs5.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public ArticleDto getArticleById(Long id) {
        Optional<Article> optArticle = articleRepository.findById(id);
        ArticleDto articleDto = Article.of(optArticle.get());
        return articleDto;
    }
}
