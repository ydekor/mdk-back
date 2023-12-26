package com.ydekor.mdk.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Setter
@Getter
public class PaginatedResult<T> extends Result<List<T>> {

    private long totalPages;
    private long totalElements;

    public PaginatedResult(Page<T> page) {
        super(page.getContent());
        this.totalPages = page.getTotalPages();
        this.totalElements = page.getTotalElements();
    }
}