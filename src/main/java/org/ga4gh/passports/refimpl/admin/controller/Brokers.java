package org.ga4gh.passports.refimpl.admin.controller;

import java.util.List;
import org.ga4gh.passports.refimpl.admin.model.Broker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/brokers")
public class Brokers {

    @GetMapping
    // public List<Broker> getBrokers() {
    public String getBrokers() {
        return "Hello world";
    }

    @GetMapping(path = "/{brokerId:.+}")
    public Broker getBrokerById(@PathVariable(name = "brokerId") String brokerId) {
        return null;
    }

    @PostMapping
    public Broker createBroker(@RequestBody Broker broker) {
        System.out.println("you reached the create broker endpoint");
        System.out.println("your broker");
        System.out.println(broker);
        return broker;
    }

    @PutMapping(path = "/{brokerId:.+}")
    public Broker updateBroker() {
        return null;
    }
}
