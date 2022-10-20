package com.nestdigital.flightbackendapp.controller;

import com.nestdigital.flightbackendapp.dao.FlightDao;
import com.nestdigital.flightbackendapp.model.FlightModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlightController {
    @Autowired
    private FlightDao dao;
    @CrossOrigin(origins = "*")
    @PostMapping(path="/addflight",consumes = "application/json",produces = "application/json")
    public String Flight(@RequestBody FlightModel flight){
        dao.save(flight);
        return "{status:'success'}";
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/viewflight")
    public List<FlightModel> viewflight(){
        return (List<FlightModel>) dao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/deleteflight")
    public String deleteflight(@RequestBody FlightModel flight)
    {
        dao.deleteById(flight.getId());
        return "{status:'success'}";
    }
 @CrossOrigin(origins = "*")
    @PostMapping("/serachflight")
    public List<FlightModel> searchflight(@RequestBody FlightModel flight){
        return (List<FlightModel>) dao.searchFlight(flight.getCapacity());
 }

}
