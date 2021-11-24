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
public class Worker implements Serializable {
    private static final long serialVersionUID = 236636854513013642L;

    private Long id;
    private String name;
    @JsonProperty("daily_income")
    private Double dailyIncome;

}