package org.ga4gh.passports.refimpl.admin.controller;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.ga4gh.passports.refimpl.admin.model.Broker;
import org.ga4gh.passports.refimpl.admin.model.UserPool;
import org.ga4gh.passports.refimpl.admin.utils.filesystem.DirUtils;
import org.ga4gh.passports.refimpl.admin.utils.filesystem.ModelReader;
import org.ga4gh.passports.refimpl.admin.utils.filesystem.PathUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    PathUtils pathUtils;

    @Autowired
    DirUtils dirUtils;

    @Autowired
    ModelReader modelReader;

    @GetMapping
    public List<Broker> getBrokers() {
        List<Broker> brokers = new ArrayList<>();
        String[] brokerNames = pathUtils.getBrokersDir().toFile().list();
        for (String brokerName : brokerNames) {
            Broker broker = modelReader.readBroker(brokerName);
            brokers.add(broker);
        }
        return brokers;
    }

    @GetMapping(path = "/{brokerId:.+}")
    public Broker getBrokerById(@PathVariable(name = "brokerId") String brokerId) {
        return modelReader.readBroker(brokerId);
    }

    @PostMapping
    public Broker createBroker(@RequestBody Broker broker) {
        String brokerName = broker.getName();
        Path dirPath = pathUtils.getBrokerDir(brokerName);
        dirUtils.raiseIfDirExists(dirPath);
        dirUtils.createDirIfNeeded(dirPath);
        dirUtils.writeObjectToFile(pathUtils.getBrokerDetailsFile(brokerName), broker);
        dirUtils.writeObjectToFile(pathUtils.getUserPoolFile(brokerName), new UserPool());
        return broker;
    }

    @PutMapping(path = "/{brokerId:.+}")
    public Broker updateBroker() {
        return null;
    }
}
