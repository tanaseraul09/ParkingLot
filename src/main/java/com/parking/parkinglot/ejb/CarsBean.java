package com.parking.parkinglot.ejb;

import com.parking.parkinglot.common.CarDto;
import com.parking.parkinglot.entities.car;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class CarsBean {
    private static final Logger LOG = Logger.getLogger(CarsBean.class.getName());
    @PersistenceContext
    EntityManager entityManager;

    public List<CarDto> findAllCars(){
        LOG.info("FindAllCars");
        try{
            TypedQuery<car> typedQuery=entityManager.createQuery("SELECT c FROM car c",car.class);
            List<car> cars=typedQuery.getResultList();
            return copyCarsToDto(cars);
        }catch(Exception ex){
            throw new EJBException(ex);
        }
    }

    public List<CarDto> copyCarsToDto(List<car> cars) {
        List<CarDto> carDtoList = new ArrayList<>();

        for (car car : cars) {
            CarDto carDto = new CarDto(
                    car.getId(),
                    car.getLicensePlate(),
                    car.getParkingSpot(),
                    car.getOwner().getUsername()
            );

            carDtoList.add(carDto);
        }

        return carDtoList;
    }
}
