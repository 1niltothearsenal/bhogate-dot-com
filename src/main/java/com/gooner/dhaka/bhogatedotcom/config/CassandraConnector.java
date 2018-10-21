package com.gooner.dhaka.bhogatedotcom.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.CassandraEntityClassScanner;
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.convert.CassandraConverter;
import org.springframework.data.cassandra.core.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.util.Objects;
import java.util.Set;

@Configuration
@PropertySource(value = {"classpath:cassandra.properties"})
@EnableCassandraRepositories(basePackages = {"com.gooner.dhaka.bhogatedotcom"})
public class CassandraConnector {

    private static final String KEYSPACE = "cassandra.keyspace";

    private static final String CONTACT_POINTS = "cassandra.contactpoints";

    private static final String PORT = "cassandra.port";

    @Autowired
    private Environment environment;


    public CassandraConnector(){
        System.out.println("CassandraConnector");
    }

    private String getKeyspaceName() {
        return environment.getProperty(KEYSPACE);
    }

    private String getContactPoints() {
        return environment
                .getProperty(CONTACT_POINTS);
    }

    private int getPortNumber() {
        return Integer.parseInt(environment
                .getProperty(PORT));
    }

    @Bean
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
        cluster.setContactPoints(getContactPoints());
        cluster.setPort(getPortNumber());
        return cluster;
    }

    @Bean
    public CassandraMappingContext mappingContext() throws ClassNotFoundException {

        CassandraMappingContext cassandraMappingContext = new CassandraMappingContext();
        cassandraMappingContext.setInitialEntitySet(getInitialEntitySet());
        return cassandraMappingContext;
    }

    @Bean
    public CassandraConverter converter() throws ClassNotFoundException {
        return new MappingCassandraConverter(mappingContext());
    }

    @Bean
    public CassandraSessionFactoryBean session() throws ClassNotFoundException {
        CassandraSessionFactoryBean cassandraSessionFactoryBean = new CassandraSessionFactoryBean();
        cassandraSessionFactoryBean.setCluster(Objects.requireNonNull(cluster().getObject()));
        cassandraSessionFactoryBean.setKeyspaceName(getKeyspaceName());
        cassandraSessionFactoryBean.setConverter(converter());
        cassandraSessionFactoryBean.setSchemaAction(SchemaAction.CREATE_IF_NOT_EXISTS);
        return cassandraSessionFactoryBean;
    }

    @Bean
    public CassandraOperations cassandraTemplate() throws Exception {
        return new CassandraTemplate(session().getObject());
    }

    public String[] getEntityBasePackages() {
        return new String[]{"com.gooner.dhaka.bhogatedotcom"};
    }

    protected Set<Class<?>> getInitialEntitySet() throws ClassNotFoundException {
        return CassandraEntityClassScanner.scan(getEntityBasePackages());
    }


}
