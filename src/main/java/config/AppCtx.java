package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class AppCtx {

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        // 데이터 베이스 연결 설정 Start
        DataSource ds = new DataSource();
        ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        ds.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
        ds.setUsername("spring6");
        ds.setPassword("_aA123456");
        // 데이터 베이스 연결 설정 End

        // 커넥션 풀 설정 Start
        ds.setInitialSize(2); // 데이터 소스 초기 크기를 2로 설정
        ds.setMaxActive(10); // 데이터 소스에서 최대 활성 연결 수를 10으로 설정
        ds.setTestWhileIdle(true); // 비활성 상태의 연결이 풀에 있는 동안 유효성 검사를 실행하도록 설정
        ds.setTimeBetweenEvictionRunsMillis(3000); // 연결 풀에서 비활성 상태의 연결을 정리하는 주기를 3,000 밀리초 (3초)로 설정
        ds.setMinEvictableIdleTimeMillis(30 * 1000); // 비활성 상태의 연결을 풀에서 정리하기 전에 허용된 최소 대기 시간을 30,000 밀리초 (30초)로 설정
        // 커넥션 풀 설정 End
        return ds;
    }

    @Bean // 쿼리 수행할 메소드
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
}
