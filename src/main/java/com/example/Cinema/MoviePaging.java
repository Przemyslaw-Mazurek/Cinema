package com.example.Cinema;

import lombok.Getter;
import org.springframework.data.domain.Sort;

@Getter
public class MoviePaging {

    private int pageSize = 5;
    private int pageNumberSize = 0;
    private Sort.Direction sortDirection = Sort.Direction.ASC;
    private String sortBy = "title";
}
