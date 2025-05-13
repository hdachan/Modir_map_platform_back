package com.example.modir;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class ModirApplication {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(ModirApplication.class, args);
	}

	@PostConstruct
	public void testDbConnection() {
		try {
			jdbcTemplate.queryForObject("SELECT 1", Integer.class);
			System.out.println("✅✅ MariaDB 연결 성공 ✅✅");
		} catch (Exception e) {
			System.out.println("❌❌ MariaDB 연결 실패 ❌❌");
			e.printStackTrace();
		}
	}
}
