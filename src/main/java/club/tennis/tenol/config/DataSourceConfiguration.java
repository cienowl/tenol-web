package club.tennis.tenol.config;

import club.tennis.tenol.context.DataSourceMasterSlaveRouting;
import club.tennis.tenol.context.DatabaseEnvironment;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public HikariConfig masterHikariConfig() {
        return new HikariConfig();
    }

    public DataSource masterDataSource() {
        return new HikariDataSource(masterHikariConfig());
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    public HikariConfig slaveHikariConfig() {
        return new HikariConfig();
    }

    public DataSource slaveDataSource() {
        return new HikariDataSource(slaveHikariConfig());
    }

    @Bean
    public DataSource dataSource() {
        DataSourceMasterSlaveRouting dataSourceMasterSlaveRouting = new DataSourceMasterSlaveRouting();
        Map<Object, Object> targetDataSource = new HashMap<>();
        targetDataSource.put(DatabaseEnvironment.WRITER, masterDataSource());
        targetDataSource.put(DatabaseEnvironment.READONLY, slaveDataSource());
        dataSourceMasterSlaveRouting.setTargetDataSources(targetDataSource);
        dataSourceMasterSlaveRouting.setDefaultTargetDataSource(masterDataSource());
        return dataSourceMasterSlaveRouting;
    }
}
