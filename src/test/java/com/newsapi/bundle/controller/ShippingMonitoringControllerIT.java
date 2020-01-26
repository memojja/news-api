package com.newsapi.bundle.controller;

import com.newsapi.bundle.cache.ShippingMonitorCache;
import com.newsapi.bundle.model.dto.DeliverStatus;
import com.newsapi.bundle.service.ShippingMonitoringProxy;
import com.newsapi.bundle.service.ShippingMonitoringService;
import javafx.beans.value.ObservableBooleanValue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.netflix.ribbon.RibbonAutoConfiguration;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.cloud.openfeign.ribbon.FeignRibbonClientAutoConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest({ShippingMonitoringController.class, ShippingMonitoringService.class, ShippingMonitoringProxy.class, ShippingMonitorCache.class})
@ImportAutoConfiguration({FeignRibbonClientAutoConfiguration.class, FeignAutoConfiguration.class, RibbonAutoConfiguration.class})
public class ShippingMonitoringControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void givenNotCompeletedShipping_whenFetchNotCompletedSale_thenSucsess() throws Exception {
        MvcResult mvcResult = mockMvc.perform (MockMvcRequestBuilders.get ("/sale/10/shipping"))
                .andExpect (MockMvcResultMatchers.request ().asyncStarted ())
                .andReturn ();

        mockMvc.perform (MockMvcRequestBuilders.asyncDispatch (mvcResult))
                .andExpect (MockMvcResultMatchers.status ().isOk ())
                .andExpect (MockMvcResultMatchers.jsonPath ("$.status").value (DeliverStatus.NOT_COMPLETED.value()))
                .andExpect (MockMvcResultMatchers.jsonPath ("$.product.name").value ("Handmade Plastic Fish"))
                .andExpect (MockMvcResultMatchers.jsonPath ("$.sale.code").value ("8b38af55-0075-4111-925f-3046b3c13b77"));
    }

//    @Test
//    void givenCompeletedShipping_whenFetchAWithWrongId_thenReturnNotFound() throws Exception {
//        mockMvc.perform (MockMvcRequestBuilders.get ("/sale/123/shipping"))
//                .andExpect (MockMvcResultMatchers.status().is4xxClientError ());
//    }

}
