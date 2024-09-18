package com.turkcell.pair3.invoiceservice.clients;

import com.turkcell.pair3.core.configuration.feign.FeignClientConfiguration;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name="customerservice", configuration = FeignClientConfiguration.class)
@Retry(name = "feignclient")
public interface CustomerServiceClient {

    @GetMapping("/api/customers/getInfo")
    String testClient();
}


