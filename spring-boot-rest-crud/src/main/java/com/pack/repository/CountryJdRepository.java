package com.pack.repository;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pack.dto.CountryJDRowMapper;
import com.pack.entity.CountryJD;

@Repository
public class CountryJdRepository {
	static final Logger LOG = LoggerFactory.getLogger(CountryJdRepository.class);
	private final static String PINLESS_DEBIT_NETWORKFEES_QUERY ="select country_id,country_name,country_lang,country_population from country_master";
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public List<CountryJD> getAllCountry() {
		try {
			return this.jdbcTemplate.query(String.format(PINLESS_DEBIT_NETWORKFEES_QUERY), new CountryJDRowMapper());
		}
		catch (Exception ex) {
			LOG.error("Fetching Pinless Debit Network Fees failed for LCR Billing service ,Exception {} ", ex);
			return new ArrayList<>();
		}
	}
	
}
