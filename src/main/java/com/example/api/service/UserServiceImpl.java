package com.example.api.service;

import com.example.api.dto.UserDTO;
import com.example.api.entity.User;
import com.example.api.repository.UserRepository;
import com.example.api.utils.UserDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserDTOMapper userDTOMapper;
    private final AwsS3Service awsS3Service;

    @Override
    public List<UserDTO> fetchUsers() {
        return userRepository.findAll()
                .stream()
                .map(userDTOMapper).collect(Collectors.toList());
    }

    @Override
    public UserDTO findUserById(Long userId) {
        Optional<User> userDb = userRepository.findById(userId);
        if (userDb.isEmpty()) {
            //tode throw user not found exception
        }

        return userDb.map(userDTOMapper).get();
    }

    @Override
    public User fetchUserByEmail(String userEmail) {
        return null;
    }

    @Override
    public UserDTO updateUser(User user, MultipartFile file) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> userDb = userRepository.findByEmail(username);
        if (userDb.isEmpty()) {
            //todo  throw an error
        }
        User foundUser = userDb.get();

        if (Objects.nonNull(user) && !"".equals(user.getFirstname())) {
            foundUser.setFirstname(user.getFirstname());
        }
        userRepository.save(foundUser);
        return userDb.map(userDTOMapper).get() ;
    }

    @Override
    public String banUser(Long userId) {
        Optional<User> userDb = userRepository.findById(userId);
        if(userDb.isEmpty()){
            //todo throw user not found error
        }
        if(userDb.get().isBanned()){

            userDb.get().setBanned(false);
            userRepository.save(userDb.get());
            return  userDb.get().getFirstname() + "'s account has been activated";
        }else {
            userDb.get().setBanned(true);
            userRepository.save(userDb.get());
        }

        return  userDb.get().getFirstname() + "'s account has been banned";
    }

//todo user pagination
//    @Override
//    public Page<UserDTO> fetchUsersByPage(int pageNumber, int pageSize) {
//      //  Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("firstname").ascending());
//      ///  Page<UserDTO> page = userRepository.findAll(pageable).stream().map(UserDTOMapper).collect(Collectors.toList());
//      //  return userRepository.findAll(pageable).map(UserDTOMapper) ;
//    }
}
