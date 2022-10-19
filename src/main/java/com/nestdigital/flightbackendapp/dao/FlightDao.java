package com.nestdigital.flightbackendapp.dao;

import com.nestdigital.flightbackendapp.model.FlightModel;
import org.springframework.data.repository.CrudRepository;

public interface FlightDao extends CrudRepository<FlightModel,Integer> {
}
