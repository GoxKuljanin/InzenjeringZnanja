package com.klinika.pregled.dto;

import java.util.List;
//
public class CBRResponseDijagnozaDTO {

    private Long id;
    private List<String> testovi;  // testovi ili pregledi?
    private String dijagnoza;
    //private String simptom;

    @Override
    public String toString() {
        return "CBRResponseDTO [id=" + id + ", testovi=" + testovi + ", dijagnoza=" + dijagnoza + "]";
    }
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
    public String getDijagnoza() {
        return dijagnoza;
    }
    public void setDijagnoza(String dijagnoza) {
        this.dijagnoza = dijagnoza;
    }
}
