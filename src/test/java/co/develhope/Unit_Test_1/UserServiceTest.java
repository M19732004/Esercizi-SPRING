package co.develhope.Unit_Test_1;

import co.develhope.Unit_Test_1.entities.User;
import co.develhope.Unit_Test_1.repositories.UserRepository;
import co.develhope.Unit_Test_1.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles(value = "test")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    void checkUserActivation() throws Exception {
        User user = new User();
        user.setName("Maria");
        user.setSurname("Coman");
        user.setIsActive(true);

        User userFromDB = userRepository.save(user);
        assertThat(userFromDB).isNotNull();
        assertThat(userFromDB.getUserId()).isNotNull();

        User userFromService = userService.setUserActivationStatus(user.getUserId(),true);
        assertThat(userFromService).isNotNull();
        assertThat(userFromService.getUserId()).isNotNull();
        assertThat(userFromService.getIsActive()).isTrue();

        User userFromFind = userRepository.findById(userFromDB.getUserId()).get();
        assertThat(userFromFind).isNotNull();
        assertThat(userFromFind.getUserId()).isNotNull();
        assertThat(userFromFind.getUserId()).isEqualTo(userFromDB.getUserId());
        assertThat(userFromFind.getIsActive()).isTrue();
    }
}
