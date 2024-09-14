package com.turkcell.pair3.invoiceservice.clients;

import com.turkcell.pair3.core.configuration.feign.FeignClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name="customerservice", configuration = FeignClientConfiguration.class)
public interface CustomerServiceClient {

    @GetMapping("/api/customers/getInfo")
    String testClient();
}


