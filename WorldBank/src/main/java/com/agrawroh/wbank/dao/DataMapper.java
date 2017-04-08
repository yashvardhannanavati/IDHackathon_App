package com.agrawroh.wbank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.agrawroh.wbank.model.InputData;

public class DataMapper implements RowMapper<InputData> {
    public InputData mapRow(ResultSet rs, int rowNum) throws SQLException {
        InputData input = new InputData();

        input.setIdRecord_ID(rs.getInt("idRecord_ID"));
        input.setCity(rs.getString("city"));
        input.setCountry(rs.getString("country"));
        input.setBaseline_year(rs.getString("baseline_year"));
        input.setInterim_year_1(rs.getString("interim_year_1"));
        input.setInterim_year_2(rs.getString("interim_year_2"));
        input.setTarget_year(rs.getString("target_year"));
        input.setAnnual_city_precipitation(rs.getDouble("annual_city_precipitation"));
        input.setArea_of_city(rs.getDouble("area_of_city"));
        input.setClimate(rs.getString("climate"));
        input.setPopulation_baseline_year(rs.getInt("population_baseline_year"));
        input.setDaily_commuters_baseline_year(rs.getInt("daily_commuters_baseline_year"));
        input.setAa_pop_growth_baseline_year_1(rs.getDouble("aa_pop_growth_baseline_year_1"));
        input.setAa_pop_growth_year_1_year_2(rs.getDouble("aa_pop_growth_year_1_year_2"));
        input.setAa_pop_growth_year_2_target_year(rs.getDouble("aa_pop_growth_year_2_target_year"));
        input.setAa_com_growth_baseline_year_1(rs.getDouble("aa_com_growth_baseline_year_1"));
        input.setAa_com_growth_year_1_year_2(rs.getDouble("aa_com_growth_year_1_year_2"));
        input.setAa_com_growth_year_2_target_year(rs.getDouble("aa_com_growth_year_2_target_year"));
        input.setAa_gdp_growth_baseline_year_1(rs.getDouble("aa_gdp_growth_baseline_year_1"));
        input.setAa_gdp_growth_year_1_year_2(rs.getDouble("aa_gdp_growth_year_1_year_2"));
        input.setAa_gdp_growth_year_2_target_year(rs.getDouble("aa_gdp_growth_year_2_target_year"));

        return input;
    }
}
