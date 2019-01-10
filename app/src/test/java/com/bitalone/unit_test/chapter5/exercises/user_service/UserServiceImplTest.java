package com.bitalone.unit_test.chapter5.exercises.user_service;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserServiceImplTest {

    private static final String USER_PASSWORD = "password";
    private static final String MD5_PASSWORD = "md5password";

    @Test
    public void assignPassword() throws Exception {
        UserDAO userDAO = mock(UserDAO.class);
        SecurityService securityService = mock(SecurityService.class);
        User user = mock(User.class);

        //user and securityService are test stub, their return value is used in SUT
        when(user.getPassword()).thenReturn(USER_PASSWORD);
        when(securityService.md5(USER_PASSWORD)).thenReturn(MD5_PASSWORD);

        UserServiceImpl sut = new UserServiceImpl(userDAO, securityService);
        sut.assignPassword(user);

        //user is a test spy
        verify(user).setPassword(MD5_PASSWORD);
        //userDao is a test spy
        verify(userDAO).updateUser(user);
    }
}