package com.riwi.Filtro_Spring_Boot.infrastructure.services;

import com.riwi.Filtro_Spring_Boot.api.dto.request.UserRequest;
import com.riwi.Filtro_Spring_Boot.api.dto.response.UserResponse;
import com.riwi.Filtro_Spring_Boot.domain.entities.User;
import com.riwi.Filtro_Spring_Boot.domain.repositories.UserRepository;
import com.riwi.Filtro_Spring_Boot.infrastructure.abstract_services.IUserService;
import com.riwi.Filtro_Spring_Boot.util.enums.SortType;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements IUserService {
    @Autowired
    private final UserRepository userRepository;
    @Override
    public Page<UserResponse> getAll(int page, int size, SortType sortType) {
        if(page < 0) {
            page = 0;
        }
        PageRequest pagination = PageRequest.of(page,size);
        return this.userRepository.findAll(pagination).map(this::entityToResponse);
    }

    @Override
    public UserResponse getById(Long id) {
        return this.entityToResponse(this.find(id));
    }

    @Override
    public UserResponse create(UserRequest userRequest) {
        User user = this.requestToEntity(userRequest);
        return this.entityToResponse(this.userRepository.save(user));
    }

    @Override
    public UserResponse update(UserRequest userRequest, Long id) {
        User user = this.find(id);
        user = this.requestToEntity(userRequest);
        return this.entityToResponse(this.userRepository.save(user));
    }

    @Override
    public void delete(Long aLong) {
    }

    private User find(Long id) {
        return this.userRepository.findById(id).orElseThrow(() -> new RuntimeException("no usar con este id"));
    }

    private UserResponse entityToResponse(User user) {
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(user, userResponse);
        return userResponse;
    }

    private User requestToEntity(UserRequest request) {
        User user = new User();
        BeanUtils.copyProperties(request, user);
        return user;
    }
}
