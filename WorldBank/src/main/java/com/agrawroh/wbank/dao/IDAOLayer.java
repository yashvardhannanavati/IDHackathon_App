package com.agrawroh.wbank.dao;

import java.util.List;

import javax.sql.DataSource;

import com.agrawroh.wbank.model.InputData;

public interface IDAOLayer {

    void setDataSource(DataSource dataSource);

    String create(InputData data);

    InputData getData(Integer id);

    List<InputData> listRecords();

    List<InputData> getClimateData();

    List<InputData> getClimateData(String climate);

    List<InputData> getCountryData(String country);

    List<InputData> getCountriesData();

    List<InputData> getCityData(String city);

    List<InputData> getCitiesData();

    void delete(Integer id);
}