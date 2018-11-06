package com.example.demo;

public enum PersonEnum {
    RED(1, "red"),
    YELLOW(2, "yellow"),
    BLANK(3, "blank");

    private final Integer id;

    private final String value;

    private PersonEnum(Integer id, String value) {
        this.id = id;
        this.value = value;
    }

    public static PersonEnum getEnumById(Integer id) {
        for (PersonEnum p : PersonEnum.values()) {
            if (p.id.intValue() == id.intValue()) {
                return p;
            }
        }
        return null;
    }

    public Integer getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

}
