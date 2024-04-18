package org.store.book;

import com.netflix.discovery.EurekaClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/service-instances")
public class BookStoreDiscoveryClient {
  @Resource
  private DiscoveryClient discoveryClient;

  @Autowired
  @Lazy
  private EurekaClient eurekaClient;

  @Value("${spring.application.name}")
  private String appName;

  @RequestMapping("/{applicationName}")
  public List<ServiceInstance> serviceInstancesByApplicationName(@PathVariable String applicationName) {
    return this.discoveryClient.getInstances(applicationName);
  }

  @RequestMapping("/greeting")
  public String greeting() {
    return String.format(
        "Hello from '%s'!", eurekaClient.getApplication(appName).getName());
  }
}
