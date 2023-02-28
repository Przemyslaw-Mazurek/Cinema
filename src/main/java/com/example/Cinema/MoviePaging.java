package com.example.Cinema;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;

@Getter
@Setter
@AllArgsConstructor
public class MoviePaging {

    private int pageSize;
    private int pageNumber;
    private Sort.Direction sortDirection;
    private String sortBy;


}
