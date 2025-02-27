package com.li.rest2501.domain.article.dto.response;

import com.li.rest2501.domain.article.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ArticleCreateResponse {
    private final Article article;
}
