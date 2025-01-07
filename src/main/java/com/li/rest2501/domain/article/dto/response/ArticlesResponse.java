package com.li.rest2501.domain.article.dto.response;

import com.li.rest2501.domain.article.dto.ArticleDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class ArticlesResponse {
    private final List<ArticleDTO> articleList;
}
