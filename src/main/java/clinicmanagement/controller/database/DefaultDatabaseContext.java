package clinicmanagement.controller.database;

import clinicmanagement.config.DatabaseConfig;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.sql.Connection;
import java.sql.SQLException;

@Singleton
public class DefaultDatabaseContext implements DatabaseContext {
    @Inject
    private DatabaseConfig databaseConfig;

    @Override
    public Connection getConnection() {
        try {
            return this.prepareConnection();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection prepareConnection() throws SQLException, ClassNotFoundException {
        Class.forName(this.databaseConfig.getDriver());
        return java.sql.DriverManager.getConnection(this.databaseConfig.getUrl(), this.databaseConfig.getUsername(), this.databaseConfig.getPassword());
    }
}
