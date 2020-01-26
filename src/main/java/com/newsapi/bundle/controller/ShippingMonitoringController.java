package com.newsapi.bundle.controller;

import com.newsapi.bundle.model.dto.ShippingMonitoringDTO;
import com.newsapi.bundle.service.ShippingMonitoringService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

@RestController
@Api(value="News Api", description="Monitor e-commerance company shipping ")
public class ShippingMonitoringController {

    private final ShippingMonitoringService shippingMonitoringService;

    @Autowired
    public ShippingMonitoringController(ShippingMonitoringService shippingMonitoringService) {
        this.shippingMonitoringService = shippingMonitoringService;
    }

    @ApiOperation(value = "Get ShippingMonitoringDTO", notes = "Fetch ShippingMonitoringDTO!")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Please check url"),
            @ApiResponse(code = 200, message = "ShippingMonitoringDTO"),
            @ApiResponse(code = 500, message = "Error occurred while fetching ShippingMonitoringDTO")
    })
    @GetMapping("/sale/{saleId}/shipping")
    public Callable<ShippingMonitoringDTO> getShippingMonitoring(@PathVariable Long saleId){
        return () -> shippingMonitoringService.getShippingMonitorBySaleId(saleId);
    }

}
