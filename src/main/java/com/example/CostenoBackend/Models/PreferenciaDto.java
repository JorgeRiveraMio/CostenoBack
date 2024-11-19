package com.example.CostenoBackend.Models;

import java.io.Serializable;
import java.util.List;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PreferenciaDto implements Serializable{
    private String accessToken;
    private List<Preferencia> items;
}
