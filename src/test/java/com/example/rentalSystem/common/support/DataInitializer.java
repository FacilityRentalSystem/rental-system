package com.example.rentalSystem.common.support;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Profile("test")
@Component
public class DataInitializer {

  private static final String OFF_FOREIGN_CONSTRAINTS = "SET foreign_key_checks = false";
  private static final String ON_FOREIGN_CONSTRAINTS = "SET foreign_key_checks = true";
  private static final String TRUNCATE_SQL_FORMAT = "TRUNCATE %s";

  private static final List<String> truncationDMLs = new ArrayList<>();

  protected DataInitializer() {
  }

  @PersistenceContext
  private EntityManager em;

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void deleteAll() {
    if (truncationDMLs.isEmpty()) {
      init();
    }

    em.createNativeQuery(OFF_FOREIGN_CONSTRAINTS).executeUpdate();
    truncationDMLs.stream()
        .map(em::createNativeQuery)
        .forEach(Query::executeUpdate);
    em.createNativeQuery(ON_FOREIGN_CONSTRAINTS).executeUpdate();
  }

  private void init() {
    final List<String> tableNames = em.createNativeQuery("SHOW TABLES ").getResultList();

    tableNames.stream()
        .map(tableName -> String.format(TRUNCATE_SQL_FORMAT, tableName))
        .forEach(truncationDMLs::add);
  }
}
