package com.newsagregator;

public enum NewsSites {

    KORRESPONDENT("korrespondent.properties"), STRANA("strana.properties");

    private String propertiesFile;
    
    NewsSites(String propertiesFile) {
        this.propertiesFile = propertiesFile;
    }

    public String getPropertiesFile() {
        return propertiesFile;
    }
}
