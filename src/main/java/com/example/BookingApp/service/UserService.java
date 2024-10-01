package com.example.BookingApp.service;

import com.example.BookingApp.dtos.UserRequestDTO;
import com.example.BookingApp.entities.Role;
import com.example.BookingApp.entities.RoleType;
import com.example.BookingApp.entities.User;
import com.example.BookingApp.exceptions.ResourceNotFoundException;
import com.example.BookingApp.repository.HotelRepository;
import com.example.BookingApp.repository.RoleRepository;
import com.example.BookingApp.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
        UserRepository userRepository;
        RoleRepository roleRepository;

        HotelRepository hotelRepository;


        @Autowired
        public UserService(UserRepository userRepository, RoleRepository roleRepository, HotelRepository hotelRepository) {
            this.userRepository = userRepository;
            this.roleRepository = roleRepository;
            this.hotelRepository = hotelRepository;


        }

        @Transactional
        public User addNewUser(UserRequestDTO userRequestDTO) {
            // creez un nou user folosindu-ma de DTO
            User newUser = new User(userRequestDTO.getName());

            // salvez in repository userul creat


            RoleType roleType = userRequestDTO.getRoleType();

            //caut acel rol in baza de date si apoi il adaug la user
            Role role = roleRepository.findByRoleType(roleType).orElseThrow(()->new ResourceNotFoundException("role not found"));
            role.getUsers().add(newUser);
            // Updatez lista de roluri a userului
            newUser.getRoles().add(role);
            return userRepository.save(newUser);
        }

        @Transactional
        public Role addRoleToUser(RoleType roleType, Long userId){
            // caut rolul in repository dupa roletype

            User user = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User not found!"));
            Role role = roleRepository.findByRoleType(roleType).orElseThrow(()->new ResourceNotFoundException("role not found"));

            //daca este null il creez de la 0, ii setez roletype si il adaug la userul creat mai sus
//        if(role==null){
//            Role newRole = new Role();
//            newRole.setRoleType(roleType);
//            user.getRoles().add(newRole);
//            return roleRepository.save(newRole);
//        }else {
            // daca rolul exista il adaug la lista de useri si il salvez
            role.getUsers().add(user);
            // Updatez lista de roluri a userului
            user.getRoles().add(role);
            return roleRepository.save(role);
            //}

        }






}