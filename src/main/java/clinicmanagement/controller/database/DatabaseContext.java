package clinicmanagement.controller.database;

import com.google.inject.ImplementedBy;

import java.sql.Connection;

@ImplementedBy(DefaultDatabaseContext.class)
public interface DatabaseContext {
    Connection getConnection();
}
