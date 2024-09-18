package com.turkcell.pair3.invoiceservice.clients;

import com.turkcell.pair3.core.configuration.feign.FeignClientConfiguration;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "productservice", configuration = FeignClientConfiguration.class)
@Retry(name = "feignclient")
public interface ProductServiceClient {
    @GetMapping("/api/products/hasProduct")
    boolean hasAccountProduct(@RequestParam("billAccountId") int accountId);
}
