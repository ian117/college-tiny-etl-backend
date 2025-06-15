package datawarehouse.wareouse.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
    basePackages = "datawarehouse.wareouse.repo.db2",
    entityManagerFactoryRef = "emf2",
    transactionManagerRef = "tm2"
)
public class Db2Config {

    @Bean
    @ConfigurationProperties("spring.datasource.db2")
    public DataSource ds2() {
        // return DataSourceBuilder.create().build();
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/zapateria2");
        dataSource.setUsername("postgres");
        dataSource.setPassword("sisas3232");
        dataSource.setDriverClassName("org.postgresql.Driver");
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean emf2(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(ds2())
                .packages("datawarehouse.wareouse.entity") // paquete donde está Shoes.java
                .persistenceUnit("db2")
                .build();
    }

    @Bean
    public PlatformTransactionManager tm2(EntityManagerFactory emf2) {
        return new JpaTransactionManager(emf2);
    }
}