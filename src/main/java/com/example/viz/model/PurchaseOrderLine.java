package com.example.viz.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Random;

@Getter
@Setter
public class PurchaseOrderLine {

    private Long id;
    private String position;

    private Date inputDate;

    private int quantity;

    public PurchaseOrderLine() {
                Random random = new Random();
        this.id = random.nextLong(1L, 10000L);
        this.position = "P" + this.id;
        inputDate = new Date(random.nextInt(2022, 2025), random.nextInt(1, 13), random.nextInt(1, 31));
        quantity = random.nextInt(1, 30);
    }
}
