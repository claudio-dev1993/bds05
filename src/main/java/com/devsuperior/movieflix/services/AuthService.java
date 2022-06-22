package com.devsuperior.movieflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.UserDTO;
import com.devsuperior.movieflix.repositories.UserRepository;
import com.devsuperior.movieflix.services.exceptions.ForbiddenAccessException;
import com.devsuperior.movieflix.services.exceptions.UnauthorizedAccessException;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public UserDTO authenticated(){
        try {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
             return new UserDTO(userRepository.findByEmail(username));
        } catch (Exception e) {
            throw new UnauthorizedAccessException("User is not logged in!");
        }
    }

    public void validateSelfOrAdmin(Long userId){
        UserDTO user = authenticated();
        if(!user.getId().equals(userId) && !user.hasRole("ROLE_MEMBER")){
            throw new ForbiddenAccessException("Access denied!");
        }
    }
}
