package com.agrawroh.wbank.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "idRecord_ID", "city", "country", "baseline_year",
        "interim_year_1", "interim_year_2", "target_year",
        "annual_city_precipitation", "area_of_city", "climate",
        "population_baseline_year", "daily_commuters_baseline_year",
        "aa_pop_growth_baseline_year_1", "aa_pop_growth_year_1_year_2",
        "aa_pop_growth_year_2_target_year", "aa_com_growth_baseline_year_1",
        "aa_com_growth_year_1_year_2", "aa_com_growth_year_2_target_year",
        "aa_gdp_growth_baseline_year_1", "aa_gdp_growth_year_1_year_2",
        "aa_gdp_growth_year_2_target_year" })
public class InputData implements Serializable {

    private static final long serialVersionUID = -8527064575585322834L;

    @JsonProperty("idRecord_ID")
    private int idRecord_ID;

    @JsonProperty("city")
    private String city;

    @JsonProperty("country")
    private String country;

    @JsonProperty("baseline_year")
    private String baseline_year;

    @JsonProperty("interim_year_1")
    private String interim_year_1;

    @JsonProperty("interim_year_2")
    private String interim_year_2;

    @JsonProperty("target_year")
    private String target_year;

    @JsonProperty("annual_city_precipitation")
    private double annual_city_precipitation;

    @JsonProperty("area_of_city")
    private double area_of_city;

    @JsonProperty("climate")
    private String climate;

    @JsonProperty("population_baseline_year")
    private int population_baseline_year;

    @JsonProperty("daily_commuters_baseline_year")
    private int daily_commuters_baseline_year;

    @JsonProperty("aa_pop_growth_baseline_year_1")
    private double aa_pop_growth_baseline_year_1;

    @JsonProperty("aa_pop_growth_year_1_year_2")
    private double aa_pop_growth_year_1_year_2;

    @JsonProperty("aa_pop_growth_year_2_target_year")
    private double aa_pop_growth_year_2_target_year;

    @JsonProperty("aa_com_growth_baseline_year_1")
    private double aa_com_growth_baseline_year_1;

    @JsonProperty("aa_com_growth_year_1_year_2")
    private double aa_com_growth_year_1_year_2;

    @JsonProperty("aa_com_growth_year_2_target_year")
    private double aa_com_growth_year_2_target_year;

    @JsonProperty("aa_gdp_growth_baseline_year_1")
    private double aa_gdp_growth_baseline_year_1;

    @JsonProperty("aa_gdp_growth_year_1_year_2")
    private double aa_gdp_growth_year_1_year_2;

    @JsonProperty("aa_gdp_growth_year_2_target_year")
    private double aa_gdp_growth_year_2_target_year;

    public InputData() {

    }

    public int getIdRecord_ID() {
        return idRecord_ID;
    }

    public void setIdRecord_ID(int idRecord_ID) {
        this.idRecord_ID = idRecord_ID;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBaseline_year() {
        return baseline_year;
    }

    public void setBaseline_year(String baseline_year) {
        this.baseline_year = baseline_year;
    }

    public String getInterim_year_1() {
        return interim_year_1;
    }

    public void setInterim_year_1(String interim_year_1) {
        this.interim_year_1 = interim_year_1;
    }

    public String getInterim_year_2() {
        return interim_year_2;
    }

    public void setInterim_year_2(String interim_year_2) {
        this.interim_year_2 = interim_year_2;
    }

    public String getTarget_year() {
        return target_year;
    }

    public void setTarget_year(String target_year) {
        this.target_year = target_year;
    }

    public double getAnnual_city_precipitation() {
        return annual_city_precipitation;
    }

    public void setAnnual_city_precipitation(double annual_city_precipitation) {
        this.annual_city_precipitation = annual_city_precipitation;
    }

    public double getArea_of_city() {
        return area_of_city;
    }

    public void setArea_of_city(double area_of_city) {
        this.area_of_city = area_of_city;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public int getPopulation_baseline_year() {
        return population_baseline_year;
    }

    public void setPopulation_baseline_year(int population_baseline_year) {
        this.population_baseline_year = population_baseline_year;
    }

    public int getDaily_commuters_baseline_year() {
        return daily_commuters_baseline_year;
    }

    public void setDaily_commuters_baseline_year(
            int daily_commuters_baseline_year) {
        this.daily_commuters_baseline_year = daily_commuters_baseline_year;
    }

    public double getAa_pop_growth_baseline_year_1() {
        return aa_pop_growth_baseline_year_1;
    }

    public void setAa_pop_growth_baseline_year_1(
            double aa_pop_growth_baseline_year_1) {
        this.aa_pop_growth_baseline_year_1 = aa_pop_growth_baseline_year_1;
    }

    public double getAa_pop_growth_year_1_year_2() {
        return aa_pop_growth_year_1_year_2;
    }

    public void setAa_pop_growth_year_1_year_2(
            double aa_pop_growth_year_1_year_2) {
        this.aa_pop_growth_year_1_year_2 = aa_pop_growth_year_1_year_2;
    }

    public double getAa_pop_growth_year_2_target_year() {
        return aa_pop_growth_year_2_target_year;
    }

    public void setAa_pop_growth_year_2_target_year(
            double aa_pop_growth_year_2_target_year) {
        this.aa_pop_growth_year_2_target_year = aa_pop_growth_year_2_target_year;
    }

    public double getAa_com_growth_baseline_year_1() {
        return aa_com_growth_baseline_year_1;
    }

    public void setAa_com_growth_baseline_year_1(
            double aa_com_growth_baseline_year_1) {
        this.aa_com_growth_baseline_year_1 = aa_com_growth_baseline_year_1;
    }

    public double getAa_com_growth_year_1_year_2() {
        return aa_com_growth_year_1_year_2;
    }

    public void setAa_com_growth_year_1_year_2(
            double aa_com_growth_year_1_year_2) {
        this.aa_com_growth_year_1_year_2 = aa_com_growth_year_1_year_2;
    }

    public double getAa_com_growth_year_2_target_year() {
        return aa_com_growth_year_2_target_year;
    }

    public void setAa_com_growth_year_2_target_year(
            double aa_com_growth_year_2_target_year) {
        this.aa_com_growth_year_2_target_year = aa_com_growth_year_2_target_year;
    }

    public double getAa_gdp_growth_baseline_year_1() {
        return aa_gdp_growth_baseline_year_1;
    }

    public void setAa_gdp_growth_baseline_year_1(
            double aa_gdp_growth_baseline_year_1) {
        this.aa_gdp_growth_baseline_year_1 = aa_gdp_growth_baseline_year_1;
    }

    public double getAa_gdp_growth_year_1_year_2() {
        return aa_gdp_growth_year_1_year_2;
    }

    public void setAa_gdp_growth_year_1_year_2(
            double aa_gdp_growth_year_1_year_2) {
        this.aa_gdp_growth_year_1_year_2 = aa_gdp_growth_year_1_year_2;
    }

    public double getAa_gdp_growth_year_2_target_year() {
        return aa_gdp_growth_year_2_target_year;
    }

    public void setAa_gdp_growth_year_2_target_year(
            double aa_gdp_growth_year_2_target_year) {
        this.aa_gdp_growth_year_2_target_year = aa_gdp_growth_year_2_target_year;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("City: ").append(city).append(" | ");
        builder.append("Country: ").append(country).append(" ");
        return builder.toString();
    }
}
