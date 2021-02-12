package org.ga4gh.passports.refimpl.admin.utils.filesystem;

import java.io.IOException;
import java.nio.file.Path;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.ga4gh.passports.refimpl.admin.exception.BadRequestException;
import org.ga4gh.passports.refimpl.admin.model.Broker;
import org.ga4gh.passports.refimpl.admin.model.PassportModel;
import org.springframework.beans.factory.annotation.Autowired;

public class ModelReader {

    @Autowired
    PathUtils pathUtils;

    public ModelReader() {

    }

    private PassportModel readObject(Path filePath, Class<? extends PassportModel> typeClass) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(filePath.toFile(), typeClass);
        } catch (IOException e) {
            throw new BadRequestException(e);
        }
    }

    public Broker readBroker(String brokerName) {
        return (Broker) readObject(pathUtils.getBrokerDetailsFile(brokerName), Broker.class);
    }
}
