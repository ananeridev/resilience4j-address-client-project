package com.anabneri.microsservices.address.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ZipCodeDTO {

    @JsonProperty("cep")
    private String zipCode;

    @JsonProperty("logradouro")
    private String street;

    @JsonProperty("complemento")
    private String complement;

    @JsonProperty("bairro")
    private String district;

    @JsonProperty("localidade")
    private String city;

    @JsonProperty("uf")
    private String state;

    private String ibge;

    private String gia;

    private String ddd;

    private String siafi;
}
