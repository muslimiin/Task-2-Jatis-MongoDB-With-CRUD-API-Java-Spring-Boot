package com.week2.mongodb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "jvsjatis")
@NoArgsConstructor
@AllArgsConstructor

public class Presiden {

    private Map<String, String> presidenMap = new HashMap<String, String>();

    public Map<String, String> getPresidenMap() {
        return presidenMap;
    }

    public void setPresidenMap(Map<String, String> presidenMap) {
        this.presidenMap = presidenMap;
    }

    @Id
    // @Field("_id")
    private Long id;

    private String nama;

    private Integer umur;

    private Integer berat_badan;

    private Integer tinggi_badan;

    private String sebelum_jadipresiden;
}
