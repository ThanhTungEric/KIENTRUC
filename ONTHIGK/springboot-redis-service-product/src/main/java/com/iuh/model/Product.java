package com.iuh.model;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Getter
@Setter
public class Product implements Serializable {
    private String productId;
    private String productName;
    private int quantity;
}
