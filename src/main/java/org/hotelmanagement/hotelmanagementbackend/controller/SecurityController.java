package org.hotelmanagement.hotelmanagementbackend.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/articles")
public class SecurityController {
    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<String> getAllArticles() {
        return List.of("Security article 1", "Security article 2", "Security article 3");
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_SUPERUSER')")
    public String deleteArticle(@PathVariable Long id) {
        return "Article deleted with id: " + id;
    }
}
