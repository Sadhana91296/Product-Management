package com.ecommerce.project.wicket;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.wicket.api.CategoryApiClient;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.util.List;

public class CategoryPage extends WebPage {
    @SpringBean
    private CategoryApiClient apiClient;

    public CategoryPage() {
        List<Category> categories = apiClient.fetchAllCategories();

        ListView<Category> listView = new ListView<>("categoryList", categories) {
            @Override
            protected void populateItem(ListItem<Category> item) {
                Category cat = item.getModelObject();
                item.add(new Label("id", String.valueOf(cat.getCategoryId())));
                item.add(new Label("name", cat.getCategoryName()));
            }
        };
        add(listView);
    }}
