package com.klinika.pregled.dto;

import java.util.List;

public class CBRListaTestovaDTO {

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
    public void setSimptomi(List<String> testovi) {
        this.testovi = testovi;
    }
}
