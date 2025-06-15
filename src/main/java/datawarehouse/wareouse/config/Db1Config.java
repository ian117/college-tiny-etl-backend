package datawarehouse.wareouse.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    basePackages = "datawarehouse.wareouse.repo.db1",
    entityManagerFactoryRef = "emf1",
    transactionManagerRef = "tm1"
)
public class Db1Config {

    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource.db1")
    public DataSource ds1() {
        // return DataSourceBuilder.create().build();
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/zapateria1");
        dataSource.setUsername("postgres");
        dataSource.setPassword("sisas3232");
        dataSource.setDriverClassName("org.postgresql.Driver");
        return dataSource;
    }

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean emf1(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(ds1())
                .packages("datawarehouse.wareouse.entity")
                .persistenceUnit("db1")
                .build();
    }

    @Primary
    @Bean
    public PlatformTransactionManager tm1(EntityManagerFactory emf1) {
        return new JpaTransactionManager(emf1);
    }
}