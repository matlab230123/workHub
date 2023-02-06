//package com.demo.configuration;
//
//import org.eclipse.persistence.config.PersistenceUnitProperties;
//import org.springframework.beans.factory.ObjectProvider;
//import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
//import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
//import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
//import org.springframework.transaction.jta.JtaTransactionManager;
//
//import javax.sql.DataSource;
//import java.util.HashMap;
//import java.util.Map;
////Auto-wiring...
//@Configuration
//public class EclipseLinkJpaConfiguration extends JpaBaseConfiguration {
////EXPLORATION.......
//    protected EclipseLinkJpaConfiguration(DataSource dataSource, JpaProperties properties, ObjectProvider<JtaTransactionManager> jtaTransactionManager) {
//        super(dataSource, properties, jtaTransactionManager);
//    }
//
//    @Override
//    protected AbstractJpaVendorAdapter createJpaVendorAdapter() {
//        return new EclipseLinkJpaVendorAdapter();
//    }
//
//    @Override
//    protected Map<String, Object> getVendorProperties() {
//        HashMap<String,Object> map = new HashMap<>();
//        map.put(PersistenceUnitProperties.WEAVING, true);
//        map.put(PersistenceUnitProperties.DDL_GENERATION,"drop-and-create-tables");
//        return map;
//    }
//
//}
