package com.crud_app.spring;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class ExModel {
    String message;

    public ExModel(String message) {
        this.message = message;
    }

}
