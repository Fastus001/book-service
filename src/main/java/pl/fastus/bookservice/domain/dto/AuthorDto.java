package pl.fastus.bookservice.domain.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tom - 29.05.2021
 */
@Data
public class AuthorDto {

    private String name;
    private String sureName;
    private List<Long> bookIds = new ArrayList<>();
}
