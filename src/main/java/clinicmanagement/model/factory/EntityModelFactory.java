package clinicmanagement.model.factory;

import clinicmanagement.constant.EntityName;
import clinicmanagement.model.entity.Employee;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import java.util.ArrayList;

public class EntityModelFactory extends AbstractModule {
    @Provides
    @Singleton
    @Named(EntityName.EMPLOYEE_MODEL)
    public static ArrayList<Employee> ProvideEmployee() {
        return new ArrayList<Employee>();
    }
}
