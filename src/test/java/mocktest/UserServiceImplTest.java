package mocktest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * UserServiceImplTest
 *
 * @author AnhDT118
 * @since 1.0
 */
@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    // Create a mock object
    @Mock
    private UserDao userDao;

    private UserService userService;

    @BeforeEach
    public void setUp() {
        userService = new UserServiceImpl(userDao);
    }

    @Test
    public void createUser_WhenEmailExisted_ReturnFailed() {
        // Define return value for method createUser()
        Mockito.when(userDao.createUser("existed@gpcoder.com")).thenReturn(false);

        // Use mock in test
        assertEquals("FAILED", userService.createUser("existed@gpcoder.com"));
    }

    @Test
    public void createUser_WhenEmailNotExisted_ReturnSuccess() {
        // Define return value for method createUser()
        Mockito.when(userDao.createUser("not_existed@gpcoder.com")).thenReturn(true);

        // Use mock in test
        assertEquals("SUCCESS", userService.createUser("not_existed@gpcoder.com"));
    }
}