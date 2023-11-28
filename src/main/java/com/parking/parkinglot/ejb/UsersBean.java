package com.parking.parkinglot.ejb;

import com.parking.parkinglot.entities.User;
import com.parking.parkinglot.common.UserDto;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class UsersBean {
    private static final Logger LOG = Logger.getLogger(CarsBean.class.getName());
    @PersistenceContext
    EntityManager entityManager;

    public List<UserDto> findAllUsers(){
        LOG.info("FindAllUsers");
        try{
            TypedQuery<User> typedQuery=entityManager.createQuery("SELECT c FROM User c",User.class);
            List<User> Users=typedQuery.getResultList();
            return copyUsersToDto(Users);
        }catch(Exception ex){
            throw new EJBException(ex);
        }
    }

    public List<UserDto> copyUsersToDto(List<User> Users) {
        List<UserDto> UserDtoList = new ArrayList<>();

        for (User User : Users) {
            UserDto UserDto = new UserDto(
                    User.getId(),
                    User.getUsername(),
                    User.getEmail()
            );

            UserDtoList.add(UserDto);
        }

        return UserDtoList;
    }
}
