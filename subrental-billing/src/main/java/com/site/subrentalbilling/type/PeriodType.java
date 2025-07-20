package com.site.subrentalbilling.type;

public enum PeriodType {
    DAY("DAY"),
    WEEK("WEEK"),
    MONTH("MONTH");

    private String value;

    PeriodType(String value) {
        this.value = value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
