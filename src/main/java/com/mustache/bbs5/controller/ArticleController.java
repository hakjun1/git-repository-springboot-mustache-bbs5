package com.mustache.bbs5.controller;

import com.mustache.bbs5.domain.Article;
import com.mustache.bbs5.domain.dto.ArticleDto;
import com.mustache.bbs5.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/articles")
@Slf4j
public class ArticleController {

    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }
    @GetMapping("/new")
    public String createPage() {
        return "new";
    }

    @PostMapping("")
    public String add(ArticleDto articleDto) {
        log.info(articleDto.getTitle()); //log에만 표시
        Article savedArticle = articleRepository.save(articleDto.toEntity());
        log.info("generated:{}",savedArticle.getId(),savedArticle.getTitle(),savedArticle.getContent());
        return String.format("redirect:/articles/%d",savedArticle.getId());
    }
}
