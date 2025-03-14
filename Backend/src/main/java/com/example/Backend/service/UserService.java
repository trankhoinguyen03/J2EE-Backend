package com.example.Backend.service;

import com.example.Backend.dto.UserDTO;
import com.example.Backend.mapper.UserMapper;
import com.example.Backend.model.User;
import com.example.Backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(Integer id) {
        return userRepository.findById(id)
                .map(UserMapper.INSTANCE::toDto)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public UserDTO createUser(UserDTO userDTO) {
        User user = UserMapper.INSTANCE.toEntity(userDTO);
        user = userRepository.save(user);
        return UserMapper.INSTANCE.toDto(user);
    }

    public UserDTO updateUser(Integer id, UserDTO userDTO) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        User updatedUser = UserMapper.INSTANCE.toEntity(userDTO);
        updatedUser.setId(existingUser.getId());
        updatedUser = userRepository.save(updatedUser);
        return UserMapper.INSTANCE.toDto(updatedUser);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}