package com.example.crud.service;
import com.example.crud.dto.UserRequest;
import com.example.crud.dto.UserResponse;
import com.example.crud.entity.User;
import com.example.crud.entity.UserMapper;
import com.example.crud.exceptions.NoEntityException;
import com.example.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public List<UserResponse> getAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toResponse)
                .collect(Collectors.toList());
    }

    public UserResponse getById(Long id) throws NoEntityException {
        return userRepository.findById(id)
                .map(userMapper::toResponse)
                .orElseThrow(() -> new NoEntityException(User.class, id));
    }

    public UserResponse create(UserRequest request) {
        User entity = userMapper.toEntity(request);
        User savedEntity = userRepository.save(entity);
        return userMapper.toResponse(savedEntity);
    }

    public UserResponse update(Long id, UserRequest request) throws NoEntityException {
        User existingEntity = userRepository.findById(id)
                .orElseThrow(() -> new NoEntityException(User.class, id));

        userMapper.updateEntityFromRequest(request, existingEntity);
        User updatedEntity = userRepository.save(existingEntity);
        return userMapper.toResponse(updatedEntity);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
