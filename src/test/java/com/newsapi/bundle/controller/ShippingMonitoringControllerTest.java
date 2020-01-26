package com.newsapi.bundle.controller;

import com.newsapi.bundle.model.dto.DeliverStatus;
import com.newsapi.bundle.model.dto.ProductDTO;
import com.newsapi.bundle.model.dto.SaleDTO;
import com.newsapi.bundle.model.dto.ShippingMonitoringDTO;
import com.newsapi.bundle.model.request.Product;
import com.newsapi.bundle.model.request.Sale;
import com.newsapi.bundle.model.request.Shipping;
import com.newsapi.bundle.service.ShippingMonitoringProxy;
import com.newsapi.bundle.service.ShippingMonitoringService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest({ShippingMonitoringController.class, ShippingMonitoringService.class})
public class ShippingMonitoringControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ShippingMonitoringProxy shippingMonitoringProxy;

    private ShippingMonitoringDTO shippingMonitoringDTO;

    @BeforeEach
    void setup(){
        shippingMonitoringDTO = ShippingMonitoringDTO.builder()
                .sale(SaleDTO.builder().id(1L).build())
                .product(new ProductDTO())
                .status(DeliverStatus.COMPLETED.value())
                .build();
    }

    @Test
    void givenCompeletedShipping_whenFetchACompletedSale_thenSucsess() throws Exception {
        Mockito.when (shippingMonitoringProxy.getShippingMonitoring(123L)).thenReturn (shippingMonitoringDTO);

        MvcResult mvcResult = mockMvc.perform (MockMvcRequestBuilders.get ("/sale/123/shipping"))
                .andExpect (MockMvcResultMatchers.request ().asyncStarted ())
                .andReturn ();

        mockMvc.perform (MockMvcRequestBuilders.asyncDispatch (mvcResult))
                .andExpect (MockMvcResultMatchers.status ().isOk ())
                .andExpect (MockMvcResultMatchers.jsonPath ("$.status").value (DeliverStatus.COMPLETED.value()));
    }

    //    @Test
//    void givenCompeletedShipping_whenFetchAWithWrongId_thenReturnNotFound() throws Exception {
//        Mockito.when (shippingMonitoringProxy.getShippingMonitoring(123L)).thenReturn (shippingMonitoringDTO);
//        mockMvc.perform (MockMvcRequestBuilders.get ("/sale/112316584/shipping"))
//                .andExpect (MockMvcResultMatchers.status().is4xxClientError ());
//    }

}
