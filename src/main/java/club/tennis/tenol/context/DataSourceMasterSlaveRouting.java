package club.tennis.tenol.context;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DataSourceMasterSlaveRouting extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DatabaseContextHolder.getEnvironment();
    }
}
