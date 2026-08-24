package org.skypro.skyshop.controller;

import org.skypro.skyshop.model.errors.ShopError;
import org.skypro.skyshop.model.product.NoSuchProductException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ShopControllerAdvice {

    @ExceptionHandler(NoSuchProductException.class)
    public ResponseEntity<ShopError> NoProduct(NoSuchProductException e) {
        ShopError shopError = new ShopError("404", e.getMessage());
        return ResponseEntity.status(404).body(shopError);
    }
}
