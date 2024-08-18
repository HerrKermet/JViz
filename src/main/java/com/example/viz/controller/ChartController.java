package com.example.viz.controller;

import com.example.viz.Echarts;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChartController {
    private Echarts echarts = new Echarts();

    @GetMapping("/test-chart")
    public ResponseEntity<String> testChart() {
        return ResponseEntity.ok(echarts.createSampleChart2());
    }

    @GetMapping("/group-mot")
    public ResponseEntity<String> groupMot() {
        return ResponseEntity.ok(echarts.getGroupedPerMot());
    }

    @GetMapping("/purchase-order-tree")
    public ResponseEntity<String> purchaseOrderTree() {
        return ResponseEntity.ok(echarts.getPurchaseOrderTreeChart());
    }

}
