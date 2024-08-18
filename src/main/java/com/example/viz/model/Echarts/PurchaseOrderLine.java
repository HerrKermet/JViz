package com.example.viz.model.Echarts;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Getter
@Setter
public class PurchaseOrderLine {

    private Long id;
    private String position;

    private Date inputDate;

    private int quantity;
    private String mot;

    public static final List<String> mots = List.of("Truck", "Sea", "Air");

    public PurchaseOrderLine() {
                Random random = new Random();
        this.id = random.nextLong(1L, 10000L);
        this.position = "P" + this.id;
        inputDate = new Date(random.nextInt(2022, 2025), random.nextInt(1, 13), random.nextInt(1, 31));
        quantity = random.nextInt(1, 30);
        mot = mots.get(random.nextInt(0, mots.size()));
    }
}
