package org.ga4gh.passports.refimpl.admin.utils.filesystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.ga4gh.passports.refimpl.admin.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;

public class DirUtils {

    private static final String SECURE_DIR_PERMISSIONS = "rwx------" ;
    private static final String SECURE_FILE_PERMISSIONS = "rw-------";
    
    public DirUtils() {

    }

    public void createSecureDir(Path dirPath) {
        try {
            Set<PosixFilePermission> ownerWritable = PosixFilePermissions.fromString(SECURE_DIR_PERMISSIONS);
            FileAttribute<?> permissions = PosixFilePermissions.asFileAttribute(ownerWritable);
            Files.createDirectories(dirPath, permissions);
        } catch (IOException e) {
            throw new BadRequestException();
        }
    }

    private void createSecureFile(Path filePath) {
        try {
            Set<PosixFilePermission> ownerWritable = PosixFilePermissions.fromString(SECURE_FILE_PERMISSIONS);
            FileAttribute<?> permissions = PosixFilePermissions.asFileAttribute(ownerWritable);
            Files.createFile(filePath, permissions);
        } catch (IOException e) {
            throw new BadRequestException();
        }
    }

    public void writeObjectToFile(Path filePath, Object value) {
        try {
            // write the object to the file
            ObjectMapper objectMapper = new ObjectMapper();
            String output = objectMapper.writeValueAsString(value);
            BufferedWriter writer = Files.newBufferedWriter(filePath, Charset.forName("UTF-8"));
            writer.write(output);
            writer.close();

            // set permissions to secure file
            Set<PosixFilePermission> ownerWritable = PosixFilePermissions.fromString(SECURE_DIR_PERMISSIONS);
            Files.setPosixFilePermissions(filePath, ownerWritable);
        } catch (IOException e) {
            throw new BadRequestException(e.toString());
        }
    }

    public void createDirIfNeeded(Path dirPath) {
        if (!dirPath.toFile().exists()) {
            createSecureDir(dirPath);
        }
    }

    public void raiseIfDirExists(Path dirPath) {
        if (dirPath.toFile().exists()) {
            throw new BadRequestException("Cannot create directory: " + dirPath);
        }
    }
}
