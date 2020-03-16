package com.user.profile.profile.service;

import com.user.profile.profile.model.Profile;

import java.util.*;
import java.util.stream.Collectors;

public class ProfileProductFilterService {

    private static final Map<String, List<String>> PRODUCT_FILTER_MAP;

    static {
        Map<String, List<String>> productFilterMap = new HashMap<>();
        productFilterMap.put("AR", Arrays.asList("product1", "product2", "product3"));
        productFilterMap.put("US", Arrays.asList("product1"));
        productFilterMap.put("UY", Arrays.asList("product1", "product2"));
        PRODUCT_FILTER_MAP = Collections.unmodifiableMap(productFilterMap);
    }

    public static List<String> filterProducts(Profile profile) {
        String country = profile.getCountry();
        List<String> products = profile.getProducts();
        List<String> filteredProducts = PRODUCT_FILTER_MAP.get(country);
        List<String> availableProducts = products.stream()
                                            .filter(product -> !filteredProducts.contains(product))
                                            .collect(Collectors.toList());
        return availableProducts;
    }
}
