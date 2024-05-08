package clinicmanagement.config;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class DatabaseConfig {
    @Inject
    private ConfigurationProvider config;

    public String getUrl() {
        return this.config.get("db.url");
    }

    public String getDriver() {
        return this.config.get("db.driver");
    }

    public String getUsername() {
        return this.config.get("db.username");
    }

    public String getPassword() {
        return this.config.get("db.password");
    }
}
