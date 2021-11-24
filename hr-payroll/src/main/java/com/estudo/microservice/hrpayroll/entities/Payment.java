package com.estudo.microservice.hrpayroll.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable {
    private static final long serialVersionUID = -2354872573963315870L;

    @JsonProperty("name")
    private String name;
    @JsonProperty("daily_income")
    private Double dailyIncome;
    @JsonProperty("days")
    private Integer days;

    @JsonProperty("total")
    public double getTotal(){
        return days * dailyIncome;
    }
}
