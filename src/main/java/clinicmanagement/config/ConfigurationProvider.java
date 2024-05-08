package clinicmanagement.config;

import clinicmanagement.constant.ConfigConstant;
import com.google.inject.Singleton;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Singleton
public class ConfigurationProvider {
    private final Properties properties;
    public ConfigurationProvider() throws IOException {
        this.properties = this.loadProperties();
    }

    private Properties loadProperties() throws IOException {
        String configFile = this.getConfigFilePath();
        InputStream input = new FileInputStream(configFile);
        Properties prop = new Properties();

        prop.load(input);
        return prop;
    }

    private String getConfigFilePath() {
        String defaultConfigFile = ConfigConstant.CONFIG_FILE;
        String envConfigFile = System.getenv(ConfigConstant.CONFIG_FILE_ENV_KEY);
        return envConfigFile != null ? envConfigFile : defaultConfigFile;
    }

    public String get(String key) {
        return this.properties.getProperty(key);
    }
}
