package com.williammiranda.workshop.mongodb.resources.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class StandarError implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long timeStamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
