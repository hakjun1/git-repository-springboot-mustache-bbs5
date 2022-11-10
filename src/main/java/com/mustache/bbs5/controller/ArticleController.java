package com.mustache.bbs5.controller;

import com.mustache.bbs5.domain.Article;
import com.mustache.bbs5.domain.dto.ArticleDto;
import com.mustache.bbs5.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("")
    public String index() {
        return "redirect:/articles/list";
    }

    @PostMapping("")
    public String add(ArticleDto articleDto) {
        log.info(articleDto.getTitle()); //log에만 표시
        log.info(articleDto.getContent()); //log에만 표시
        Article savedArticle = articleRepository.save(articleDto.toEntity());
        log.info("generated:{}",savedArticle.getId());
        return "redirect:/articles";
    }
    @GetMapping("/{id}")
    public String findbyId(@PathVariable Long id, Model model) {
        Optional<Article> article = articleRepository.findById(id);
        if (!article.isEmpty()) {
            model.addAttribute("article", article.get());
            return "show";
        } else {
            return"error";
        }
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Article> savedArticle = articleRepository.findAll();
        model.addAttribute("articles", savedArticle);
        return "list";
    }



}
