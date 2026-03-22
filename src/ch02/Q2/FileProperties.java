package ch02.Q2;
// FileProperties 클래스를 구현해 보세요.

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class FileProperties implements FileIO {
    private Properties property;

    public FileProperties() {
        property = new Properties();
    }
    
    @Override
    public void readFromFile(String filename) throws IOException {
        property.load(new FileReader(filename));
    }
    
    @Override
    public void writeToFile(String filename) throws IOException {
        property    .store(new FileWriter(filename), "File Properties");
    }

    @Override
    public void setValue(String key, String value) {
        property.setProperty(key, value);
    }

    @Override
    public String getValue(String key) {
        return property.getProperty(key);
    }

    }