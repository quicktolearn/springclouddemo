package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther zzyy
 * @create 2020-02-21 11:42
 */
@Configuration
public class GateWayConfig
{

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){

        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        RouteLocator path_route_guoji = routes.route("path_route_guoji", r -> r.path("/guoji")
                .uri("https://news.baidu.com/guoji")).build();
        return path_route_guoji;

    }

    @Bean
    public RouteLocator customRouteLocator2(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        RouteLocator path_route_guonei = routes.route("path_route_guonei", r -> r.path("/guonei")
                .uri("https://news.baidu.com/guonei")).build();
        return path_route_guonei;
    }
//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder)
//    {
//        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
//
//        routes.route("path_route_atguigu",
//                r -> r.path("/guonei")
//                        .uri("http://news.baidu.com/guonei")).build();
//
//        return routes.build();
//    }
}
