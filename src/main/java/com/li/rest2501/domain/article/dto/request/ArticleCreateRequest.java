package com.li.rest2501.domain.article.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ArticleCreateRequest {
    @NotBlank
    private String subject;
    @NotBlank
    private String content;
}
