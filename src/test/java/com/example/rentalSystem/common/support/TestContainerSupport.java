package com.example.rentalSystem.common.support;

import static lombok.AccessLevel.PROTECTED;

import lombok.NoArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.JdbcDatabaseContainer;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.utility.DockerImageName;

@NoArgsConstructor(access = PROTECTED)
@ActiveProfiles("test")
public abstract class TestContainerSupport {

  private static final String MYSQL_IMAGE = "mysql:8";
  private static final String REDIS_IMAGE = "redis:latest";
  private static final int MYSQL_PORT = 3306;
  private static final int REDIS_PORT = 6379;
  private static final JdbcDatabaseContainer<?> MYSQL;
  private static final GenericContainer<?> REDIS;

  @Autowired
  private DataInitializer dataInitializer;

  // 싱글톤
  static {
    MYSQL = new MySQLContainer<>(MYSQL_IMAGE)
        .withExposedPorts(MYSQL_PORT)
        .withReuse(true);

    REDIS = new GenericContainer<>(DockerImageName.parse(REDIS_IMAGE))
        .withExposedPorts(REDIS_PORT)
        .withReuse(true);

    MYSQL.start();
    REDIS.start();
  }

  // 동적으로 DB 속성 할당
  @DynamicPropertySource
  public static void setUp(DynamicPropertyRegistry registry) {
    registry.add("spring.data.redis.host", REDIS::getHost);
    registry.add("spring.data.redis.port", ()
        -> String.valueOf(REDIS.getMappedPort(REDIS_PORT)));

    registry.add("spring.datasource.driver-class-name", MYSQL::getDriverClassName);
    registry.add("spring.datasource.url", MYSQL::getJdbcUrl);
    registry.add("spring.datasource.username", MYSQL::getUsername);
    registry.add("spring.datasource.password", MYSQL::getPassword);
  }

  @BeforeEach
  void delete() {
    dataInitializer.deleteAll();
  }
}
