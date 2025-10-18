package ru.practicum.category.service;

import java.util.List;
import org.springframework.data.domain.Pageable;
import ru.practicum.category.dto.CategoryDto;
import ru.practicum.category.dto.NewCategoryDto;
import ru.practicum.category.model.Category;

public interface CategoryService {

    CategoryDto createCategory(NewCategoryDto newCategoryDto);

    void deleteCategory(Long categoryId);

    CategoryDto updateCategory(Long categoryId, NewCategoryDto newCategoryDto);

    List<CategoryDto> getCategories(Pageable pageable);

    CategoryDto getCategoryById(Long categoryId);

    Category getCategoryByIdOrThrow(Long categoryId);
}