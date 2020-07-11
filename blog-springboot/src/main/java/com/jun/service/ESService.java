package com.jun.service;

import io.swagger.models.auth.In;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ESService {
    Boolean findALLToES() throws Exception;

    List<Map<String, Object>> searchPageHighlightBuilder(String keyword, Integer currentPage, Integer pageSize) throws Exception;

}
