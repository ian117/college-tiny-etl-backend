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
    basePackages = "datawarehouse.wareouse.repo.db3",
    entityManagerFactoryRef = "emf3",
    transactionManagerRef = "tm3"
)
public class Db3Config {

    @Bean
    @ConfigurationProperties("spring.datasource.db3")
    public DataSource ds3() {
        // return DataSourceBuilder.create().build();
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/zapateria3");
        dataSource.setUsername("postgres");
        dataSource.setPassword("sisas3232");
        dataSource.setDriverClassName("org.postgresql.Driver");
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean emf3(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(ds3())
                .packages("datawarehouse.wareouse.entity")
                .persistenceUnit("db3")
                .build();
    }

    @Bean
    public PlatformTransactionManager tm3(EntityManagerFactory emf3) {
        return new JpaTransactionManager(emf3);
    }
}