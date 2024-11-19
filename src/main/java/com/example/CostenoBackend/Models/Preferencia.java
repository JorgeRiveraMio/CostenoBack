package com.example.CostenoBackend.Models;

import java.io.Serializable;
import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Preferencia implements Serializable{
    private String name;
    private Integer quantity;
    private Float price;
}
