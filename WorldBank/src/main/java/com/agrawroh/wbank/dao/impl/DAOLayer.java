package com.agrawroh.wbank.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.agrawroh.wbank.dao.DataMapper;
import com.agrawroh.wbank.dao.IDAOLayer;
import com.agrawroh.wbank.model.InputData;

public class DAOLayer implements IDAOLayer {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(this.dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
                this.jdbcTemplate);
    }

    public String create(final InputData input) {
        String sql = "INSERT INTO world_bank (city,country,baseline_year,interim_year_1,interim_year_2,target_year,annual_city_precipitation,area_of_city,climate,population_baseline_year,daily_commuters_baseline_year,aa_pop_growth_baseline_year_1,aa_pop_growth_year_1_year_2,aa_pop_growth_year_2_target_year,aa_com_growth_baseline_year_1,aa_com_growth_year_1_year_2,aa_com_growth_year_2_target_year,aa_gdp_growth_baseline_year_1,aa_gdp_growth_year_1_year_2,aa_gdp_growth_year_2_target_year) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        //KeyHolder holder = new GeneratedKeyHolder();

        int count = namedParameterJdbcTemplate.update(
                sql,
                new MapSqlParameterSource()
                        .addValue("city", input.getCity())
                        .addValue("country", input.getCountry())
                        .addValue("baseline_year", input.getBaseline_year())
                        .addValue("interim_year_1", input.getInterim_year_1())
                        .addValue("interim_year_2", input.getInterim_year_2())
                        .addValue("target_year", input.getTarget_year())
                        .addValue("annual_city_precipitation",
                                input.getAnnual_city_precipitation())
                        .addValue("area_of_city", input.getArea_of_city())
                        .addValue("climate", input.getClimate())
                        .addValue("population_baseline_year",
                                input.getPopulation_baseline_year())
                        .addValue("daily_commuters_baseline_year",
                                input.getDaily_commuters_baseline_year())
                        .addValue("aa_pop_growth_baseline_year_1",
                                input.getAa_pop_growth_baseline_year_1())
                        .addValue("aa_pop_growth_year_1_year_2",
                                input.getAa_pop_growth_year_1_year_2())
                        .addValue("aa_pop_growth_year_2_target_year",
                                input.getAa_pop_growth_year_2_target_year())
                        .addValue("aa_com_growth_baseline_year_1",
                                input.getAa_com_growth_baseline_year_1())
                        .addValue("aa_com_growth_year_1_year_2",
                                input.getAa_com_growth_year_1_year_2())
                        .addValue("aa_com_growth_year_2_target_year",
                                input.getAa_com_growth_year_2_target_year())
                        .addValue("aa_gdp_growth_baseline_year_1",
                                input.getAa_gdp_growth_baseline_year_1())
                        .addValue("aa_gdp_growth_year_1_year_2",
                                input.getAa_gdp_growth_year_1_year_2())
                        .addValue("aa_gdp_growth_year_2_target_year",
                                input.getAa_gdp_growth_year_2_target_year()));

        return "Created New Record! Count: " + count;
    }

    public InputData getData(Integer id) {
        //System.out.println("Fetching Record With ID: " + id);
        String SQL = "SELECT * FROM world_bank WHERE idRecord_ID = ?";
        InputData record = jdbcTemplate.queryForObject(SQL,
                new Object[] { id }, new DataMapper());
        return record;
    }

    public List<InputData> getClimateData() {
        //System.out.println("Fetching Climate Data...");
        String SQL = "SELECT * FROM world_bank GROUP BY climate ORDER BY climate";
        List<InputData> records = jdbcTemplate.query(SQL, new DataMapper());
        return records;
    }

    public List<InputData> getClimateData(String climate) {
        //System.out.println("Fetching Climate Data! Query: " + climate);
        String SQL = "SELECT * FROM world_bank WHERE climate = ? GROUP BY climate ORDER BY climate";
        List<InputData> records = jdbcTemplate.query(SQL, new DataMapper());
        return records;
    }

    public List<InputData> getCityData(String city) {
        //System.out.println("Fetching City Data! Query: " + city);
        String SQL = "SELECT * FROM world_bank WHERE city = ?";
        List<InputData> records = jdbcTemplate.query(SQL,
                new Object[] { city }, new DataMapper());
        return records;
    }

    public List<InputData> getCitiesData() {
        //System.out.println("Fetching Cities Data...");
        String SQL = "SELECT * FROM world_bank GROUP BY city ORDER BY city";
        List<InputData> records = jdbcTemplate.query(SQL, new DataMapper());
        return records;
    }

    public List<InputData> getCountryData(String country) {
        //System.out.println("Fetching Country Data! Query: " + country);
        String SQL = "SELECT * FROM world_bank WHERE country = ?";
        List<InputData> records = jdbcTemplate.query(SQL,
                new Object[] { country }, new DataMapper());
        return records;
    }

    public List<InputData> getCountriesData() {
        //System.out.println("Fetching Countries Data...");
        String SQL = "SELECT * FROM world_bank GROUP BY country ORDER BY country";
        List<InputData> records = jdbcTemplate.query(SQL, new DataMapper());
        return records;
    }

    public List<InputData> listRecords() {
        String SQL = "SELECT * FROM world_bank";
        List<InputData> records = jdbcTemplate.query(SQL, new DataMapper());
        return records;
    }

    public void delete(Integer id) {
        String SQL = "DELETE FROM world_bank WHERE idRecord_ID = ?";
        jdbcTemplate.update(SQL, id);
        //System.out.println("Deleted Record With ID: " + id);
        return;
    }
}