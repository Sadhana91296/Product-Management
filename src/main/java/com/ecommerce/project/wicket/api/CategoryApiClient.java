package com.ecommerce.project.wicket.api;

import com.ecommerce.project.model.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
@Component
public class CategoryApiClient {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String BASE_URL = "http://localhost:8080/api/categories";

    public List<Category> fetchAllCategories() {
        ResponseEntity<Category[]> response = restTemplate.getForEntity(BASE_URL, Category[].class);
        return Arrays.asList(response.getBody());
    }
}
