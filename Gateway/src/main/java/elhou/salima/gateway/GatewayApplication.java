package elhou.salima.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    RouteLocator routeLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route("r1",(r)->r.path("/commercant/**").uri("lb://COMMERCANT-SERVICE"))
                .route("r2",(r)->r.path("/agences/**").uri("lb://AGENCE-SERVICE"))
                .route("r3",(r)->r.path("/comptes/**").uri("lb://AGENCE-BANCAIRE-SERVICE"))
                .build();
    }

    //
   // @Bean
    DiscoveryClientRouteDefinitionLocator definitionLocator(ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties properties ){
        return new DiscoveryClientRouteDefinitionLocator(rdc,properties);
    }

}
