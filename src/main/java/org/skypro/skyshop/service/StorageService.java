package org.skypro.skyshop.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPrice;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StorageService {
    private final Map<UUID, Product> availableProduct;
    private final Map<UUID, Article> availableArticle;

    public StorageService(Map<UUID, Product> availableProduct, Map<UUID, Article> availableArticle) {
        this.availableProduct = new HashMap<>();
        this.availableArticle = new HashMap<>();
        this.createTestData();
    }

    public Collection<Product> getAllProducts() {
        return availableProduct.values();
    }

    public Optional<Product> getProductById(UUID id) {
        return Optional.ofNullable(availableProduct.get(id));
    }

    public Collection<Article> getAllArticles() {
        return availableArticle.values();
    }

    public Collection<Searchable> getSearchableItems() {
        List<Searchable> searchableItems = new ArrayList<>();
        searchableItems.addAll(this.availableProduct.values());
        searchableItems.addAll(this.availableArticle.values());
        return searchableItems;
    }

    private void createTestData() {
        Product p5 = new SimpleProduct(UUID.randomUUID(),"Хлеб", 50);
        Product p6 = new FixPrice(UUID.randomUUID(),"Кефир");
        Product p7 = new SimpleProduct(UUID.randomUUID(),"Мясо", 350);
        Product p8 = new FixPrice(UUID.randomUUID(),"Сыр");
        Product p9 = new DiscountedProduct(UUID.randomUUID(),"Яблоки", 105, 20);
        Article p1Article = new Article(UUID.randomUUID(),
                "Хлеб всему голова",
                "Хлеб - это пищевой продукт, выпекаемый из муки. Также словом «хлеб» часто " +
                        "называют сельскохозяйственные культуры, а также зерно этих культур и муку, " +
                        "используемую для выпечки. \n");
        Article p2Article = new Article(UUID.randomUUID(),
                "Кефир",
                "Внук у бабушки спросил: — Хорошо ли пить кефир? Бабушка сказала честно: — Пить кефир — весьма полезно!\n" +
                        "Чем полезен сей продукт, Почему кефир нам друг? Собираясь в магазин, — Не забудьте про кефир!\n" +
                        "Кефир — жажду утоляет, Калий, кальций восполняет. Витаминов — в нём не счесть, Он содержит даже медь!\n" +
                        "Фосфор, серу, натрий, хром — Минералов в нём набор.\n" +
                        "Так что, взрослые и дети, Вы кефир — на радость, пейте!"
        );
        this.availableProduct.put(p5.getId(), p5);
        this.availableProduct.put(p6.getId(), p6);
        this.availableProduct.put(p7.getId(), p7);
        this.availableProduct.put(p8.getId(), p8);
        this.availableProduct.put(p9.getId(), p9);
        this.availableArticle.put(p1Article.getId(), p1Article);
        this.availableArticle.put(p2Article.getId(), p2Article);
    }
}
