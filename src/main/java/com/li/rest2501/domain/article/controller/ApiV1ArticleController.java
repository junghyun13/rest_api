package com.li.rest2501.domain.article.controller;

import com.li.rest2501.domain.article.dto.ArticleDTO;
import com.li.rest2501.domain.article.dto.request.ArticleCreateRequest;
import com.li.rest2501.domain.article.dto.request.ArticleModifyRequest;
import com.li.rest2501.domain.article.dto.response.ArticleCreateResponse;
import com.li.rest2501.domain.article.dto.response.ArticleModifyResponse;
import com.li.rest2501.domain.article.dto.response.ArticleResponse;
import com.li.rest2501.domain.article.entity.Article;
import com.li.rest2501.domain.article.service.ArticleService;
import com.li.rest2501.global.RsData.RsData;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/articles", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Tag(name = "ApiV1ArticleController", description = "게시글 CRUD API")
public class ApiV1ArticleController {
    private final ArticleService articleService;

    @AllArgsConstructor
    @Getter
    public static class ArticlesResponse {
        private final List<ArticleDTO> articleList;
    }

    @GetMapping("")
    @Operation(summary = "게시글 다건 조회")
    public RsData<ArticlesResponse> list() {
        List<ArticleDTO> articleList = this.articleService.getList();
        return RsData.of("200", "게시글 다건 조회 성공", new ArticlesResponse(articleList));
    }
    @GetMapping("/{id}")
    @Operation(summary = "게시글 단건 조회")
    public RsData<ArticleResponse> getArticle(@PathVariable("id") Long id) {
        Article  article = this.articleService.getArticle(id);
        ArticleDTO articleDTO = new ArticleDTO(article);
        return RsData.of("200", "게시글 단건 조회 성공", new ArticleResponse(articleDTO));
    }

    @Data
    public static class ArticleRequest {
        @NotBlank
        private String subject;
        @NotBlank
        private String content;
    }

    @PostMapping("")
    @Operation(summary = "게시글 등록")
    public RsData<ArticleCreateResponse> create(@Valid @RequestBody ArticleCreateRequest articleCreateRequest) {
        Article article = this.articleService.write(articleCreateRequest.getSubject(), articleCreateRequest.getContent());

        return RsData.of("200", "등록성공", new ArticleCreateResponse(article));
    }

    @PatchMapping("/{id}")
    @Operation(summary = "게시글 수정")
    public RsData<ArticleModifyResponse> modify(@PathVariable("id") Long id, @Valid @RequestBody ArticleModifyRequest articleModifyRequest) {
        Article article = this.articleService.getArticle(id);

        if (article == null) return RsData.of(
                "500",
                "%d 번 게시물은 존재하지 않습니다.".formatted(id),
                null
        );
        article = this.articleService.update(article, articleModifyRequest.getSubject(), articleModifyRequest.getContent());
        return RsData.of("200", "수정성공", new ArticleModifyResponse(article));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "게시글 삭제")
    public RsData<ArticleResponse> delete(@PathVariable("id") Long id) {
        Article article = this.articleService.getArticle(id);
        if (article == null) return RsData.of(
                "500",
                "%d 번 게시물은 존재하지 않습니다.".formatted(id),
                null
        );
        this.articleService.delete(article);
        ArticleDTO articleDTO = new ArticleDTO(article);

        return RsData.of("200", "삭제성공",  new ArticleResponse(articleDTO));
    }
}
