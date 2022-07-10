package com.niu.datasource.enums;

import lombok.Getter;

@Getter
public enum DynamicDataSource {

    MASTER("master"),
    SLAVE("slave");

    private final String name;

    DynamicDataSource(String name) {
        this.name = name;
    }
}
