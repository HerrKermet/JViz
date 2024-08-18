package com.example.viz.model.Echarts;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Getter
@Setter
public class PurchaseOrder {

    private Long id;
    private String purchaseOrderNumber;
    private List<PurchaseOrderLine> purchaseOrderLines;

    private Date inputDate;

    public PurchaseOrder() {
        Random random = new Random();
        this.id = random.nextLong(1L, 10000L);
        this.purchaseOrderNumber = "PO" + this.id;
        int polCount = random.nextInt(1,30);
        purchaseOrderLines = new ArrayList<>();
        for (int i = 0; i < polCount; i++) {
            purchaseOrderLines.add(new PurchaseOrderLine());
        }
        inputDate = new Date(random.nextInt(2022, 2025), random.nextInt(1, 13), random.nextInt(1, 31));
    }
}
