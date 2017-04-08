package com.agrawroh.wbank.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.agrawroh.wbank.dao.IDAOLayer;
import com.agrawroh.wbank.model.InputData;

@Component
@Path("/")
public class Controller {

    @Autowired
    private IDAOLayer dao;

    @GET
    @Path("/getStatus")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getStatus() {
        String result = "Service Available";
        return Response.status(200).entity(result).build();
    }

    @GET
    @Path("/getData/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getData(@PathParam("id") int id) {
        InputData result = dao.getData(id);
        return Response.status(200).entity(result).build();
    }

    @GET
    @Path("/getCityData/{city}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCityData(@PathParam("city") String city) {
        List<InputData> result = dao.getCityData(city);
        return Response.status(200).entity(result).build();
    }

    @GET
    @Path("/getClimateData/{climate}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClimateData(@PathParam("climate") String climate) {
        List<InputData> result = dao.getClimateData(climate);
        return Response.status(200).entity(result).build();
    }

    @GET
    @Path("/getClimateData")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClimateData() {
        List<InputData> result = dao.getClimateData();
        return Response.status(200).entity(result).build();
    }

    @GET
    @Path("/getCountryData/{country}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCountryData(@PathParam("country") String country) {
        List<InputData> result = dao.getCountryData(country);
        return Response.status(200).entity(result).build();
    }

    @GET
    @Path("/getAllData")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllData() {
        List<InputData> result = dao.listRecords();
        return Response.status(200).entity(result).build();
    }

    @GET
    @Path("/getCitiesData")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCitiesData() {
        List<InputData> result = dao.getCitiesData();
        return Response.status(200).entity(result).build();
    }

    @GET
    @Path("/getCountriesData")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCountriesData() {
        List<InputData> result = dao.getCountriesData();
        return Response.status(200).entity(result).build();
    }

    @POST
    @Path("/saveData")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveInputData(InputData data) {
        String result = dao.create(data);
        return Response.status(200).entity(result).build();
    }

}