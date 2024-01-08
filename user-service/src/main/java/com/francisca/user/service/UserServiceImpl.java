package com.francisca.user.service;

import com.francisca.user.config.JwtService;
import com.francisca.user.dto.LoginRequest;
import com.francisca.user.dto.LoginResponse;
import com.francisca.user.dto.UserRequest;
import com.francisca.user.dto.UserResponse;
import com.francisca.user.exception.UserVerificationException;
import com.francisca.user.model.Users;
import com.francisca.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.KeyPairGenerator;
import java.util.Arrays;

    @Service
    @RequiredArgsConstructor
    public class UserServiceImpl implements UserService {

        private final UserRepository repositoryUser;
        private final PasswordEncoder passwordEncoder;
        private final AuthenticationManager authenticationManager;
        private final JwtService jwtService;


        @Override
        public UserResponse registerUser(UserRequest userRequest) throws Exception {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            Users user = repositoryUser.findByUsername(username)
                    .orElseThrow(() -> new UserVerificationException("Invalid user", null));

            if (repositoryUser.existsByUsername(userRequest.getUsername().toLowerCase()))
                throw new UserVerificationException("Username: " + userRequest.getUsername() + " already exist", null);

            try {
                String secretKey = secretKey();

                Users users = storeUser(userRequest, secretKey);
                Users savedUser = repositoryUser.save(users);


                UserResponse response = new UserResponse();
                response.setUsername(savedUser.getUsername());
                response.setId(savedUser.getId());
                response.setSecretKey(savedUser.getSecretKey());

                return response;
            } catch (Exception ex) {
                throw new Exception(ex);
            }
        }




        @Override
        public LoginResponse loginUser(LoginRequest loginRequest) throws UserVerificationException {
            LoginResponse response = new LoginResponse();

            Users user = repositoryUser.findByUsername(loginRequest.getUsername())
                    .orElseThrow(() -> new UserVerificationException("Invalid user", null));

          //  if (user.getStatus().equals(StatusConstant.INACTIVE) || !user.isEnabled()) throw new UserVerificationException("User is not validated", null);
       if (!user.getPassword().equals(loginRequest.getPassword())) throw new UserVerificationException("Invalid password", null);

            try {
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
                );
                String token = jwtService.generateToken(user);


                response.setSecretKey(user.getSecretKey());
                response.setUsername(user.getUsername());
                response.setEmail(user.getEmail());
                response.setId(user.getId());
                response.setAccessToken(token);
                response.setTokenExpirationDate(jwtService.getExpirationDate(token));

            } catch (BadCredentialsException ex) {
                System.out.println(ex.getMessage());
            }
            return response;
        }

        private boolean validateUser(Users user, LoginRequest loginRequest) {
            if (user != null && loginRequest != null) {
                String encryptedPassword = passwordEncoder.encode(loginRequest.getPassword());
                return user.getUsername().equalsIgnoreCase(loginRequest.getUsername()) && user.getPassword().equals(encryptedPassword);
            }
            return false;
        }





        private Users storeUser(UserRequest userRequest, String secretKey) {
            return Users.builder()
                    .username(userRequest.getUsername())
                    .secretKey(secretKey)
                    .build();
        }


        private String secretKey() {
            String key = null;
            try {
                KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
                keyGen.initialize(512);
                byte[] publicKey = keyGen.genKeyPair().getPublic().getEncoded();
                key = Arrays.toString(publicKey);
                key = passwordEncoder.encode(key);
                key = key.replaceAll("[/]", "v");
            } catch (Exception e) {
                System.out.printf(e.getMessage());
            }
            return key;
        }

    }


