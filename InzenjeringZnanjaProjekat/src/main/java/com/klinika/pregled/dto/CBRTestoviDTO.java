package com.klinika.pregled.dto;

import java.util.List;

public class CBRTestoviDTO {

    private Long id;
    private List<String> testovi;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public List<String> getTestovi() {
        return testovi;
    }
    public void setTestovi(List<String> testovi) {
        this.testovi = testovi;
    }

}
