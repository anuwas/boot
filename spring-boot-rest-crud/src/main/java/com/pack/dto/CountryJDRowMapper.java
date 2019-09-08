package com.pack.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pack.entity.CountryJD;

public class CountryJDRowMapper implements RowMapper<CountryJD>{

	@Override
	public CountryJD mapRow(ResultSet rs, int rowNum) throws SQLException {
		CountryJD cjd = new CountryJD();
		
		cjd.setCountryId(rs.getInt("country_id"));
		cjd.setCountryName(rs.getString("country_name"));
		cjd.setCountryLang(rs.getString("country_lang"));
		cjd.setCountryPopulation(rs.getInt("country_population"));
		return cjd;
	}

}
