package com.site.subrentalbilling.type;

public enum PaymentType {
    KAKAOPAY("KAKAOPAY"),
    NICE("NICE")
    ;

    private String value;

    PaymentType(String value) {
        this.value = value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return  this.value;
    }
}
