package com.AddressBookApp.Interceptor;

import com.AddressBookApp.Model.AuthUser;
import com.AddressBookApp.Repository.AuthenticationRepository;
import com.AddressBookApp.Util.jwttoken;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class Interceptor1 implements HandlerInterceptor {

    @Autowired
    jwttoken jwtTokenService;

    @Autowired
    AuthenticationRepository userRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        try {
            // Get token from cookies
            String token = null;

            String auth = request.getHeader("Authorization");

            if (auth == null) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return false;
            }

            token = auth.substring(9);

            // If no token, reject request
            if (token == null) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return false;
            }

            System.out.println(token);

            // Decode token to get user ID
            Long userId = jwtTokenService.decodeToken(token);

            // Check for user in database with given id

            AuthUser foundUser = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

            // Token is valid → Allow request
            return true;
        } catch (RuntimeException e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
    }
}