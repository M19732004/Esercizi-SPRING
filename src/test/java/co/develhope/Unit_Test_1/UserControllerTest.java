package co.develhope.Unit_Test_1;

import co.develhope.Unit_Test_1.controllers.UserController;
import co.develhope.Unit_Test_1.entities.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles(value="test")
@AutoConfigureMockMvc
class UserControllerTest {

	@Autowired
	private UserController userController;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void userControllerLoads() {

		assertThat(userController).isNotNull();
	}

	private User getUserFromId(Long userId) throws Exception{
		MvcResult result = this.mockMvc.perform(get("/user/" + userId))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		try {
			String userJSON = result.getResponse().getContentAsString();
			User user = objectMapper.readValue(userJSON, User.class);

			assertThat(user).isNotNull();
			assertThat(user.getUserId()).isNotNull();

			return user;
		}catch (Exception e){
			return null;
		}
	}


	private User createAUser() throws Exception {
		User user = new User();
		user.setName("Paul");
		user.setSurname("Burns");
		user.setIsActive(true);
		return createAUser(user);
	}

	private User createAUser(User user) throws Exception {
		MvcResult result = createAUserRequest(user);
		User studentFromResponse = objectMapper.readValue(result.getResponse().getContentAsString(), User.class);

		assertThat(studentFromResponse).isNotNull();
		assertThat(studentFromResponse.getUserId()).isNotNull();

		return studentFromResponse;
	}

	private MvcResult createAUserRequest() throws Exception {
		User user = new User();
		user.setName("Paul");
		user.setSurname("Burns");
		user.setIsActive(true);
		return createAUserRequest(user);
	}

	private MvcResult createAUserRequest(User user) throws Exception {
		if(user == null) return null;
		String userJSON = objectMapper.writeValueAsString(user);
		return this.mockMvc.perform(post("/user")
						.contentType(MediaType.APPLICATION_JSON)
						.content(userJSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	void createAUserTest() throws Exception {
		User userFromResponse = createAUser();
	}

	@Test
	void readUsersList() throws Exception {
		createAUserRequest();

		MvcResult result =this.mockMvc.perform(get("/user/"))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		List<User> usersFromResponse = objectMapper.readValue(result.getResponse().getContentAsString(), List.class);
		System.out.println("Users in database are: " + usersFromResponse.size());
		assertThat(usersFromResponse.size()).isNotZero();
	}

	@Test
	void readSingleUser() throws Exception {
		User user = createAUser();
		User userFromResponse = getUserFromId(user.getUserId());
		assertThat(userFromResponse.getUserId()).isEqualTo(user.getUserId());
	}

	@Test
	void updateUser() throws Exception{
		User user = createAUser();

		String newName = "Frank";
		user.setName(newName);

		String userJSON = objectMapper.writeValueAsString(user);

		MvcResult result = this.mockMvc.perform(put("/user/"+user.getUserId())
						.contentType(MediaType.APPLICATION_JSON)
						.content(userJSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
		User userFromResponse = objectMapper.readValue(result.getResponse().getContentAsString(), User.class);

		assertThat(userFromResponse.getUserId()).isEqualTo(user.getUserId());
		assertThat(userFromResponse.getName()).isEqualTo(newName);

		User userFromResponseGet = getUserFromId(user.getUserId());
		assertThat(userFromResponseGet.getUserId()).isEqualTo(user.getUserId());
		assertThat(userFromResponseGet.getName()).isEqualTo(newName);
	}

	@Test
	void deleteUser() throws Exception{
		User user = createAUser();
		assertThat(user.getUserId()).isNotNull();

		this.mockMvc.perform(delete("/user/"+user.getUserId()))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		User userFromResponseGet = getUserFromId(user.getUserId());
		assertThat(userFromResponseGet).isNull();
	}

	@Test
	void activateUser() throws Exception{
		User user = createAUser();
		assertThat(user.getUserId()).isNotNull();

		MvcResult result = this.mockMvc.perform(put("/user/"+user.getUserId()+"/active=true"))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		User userFromResponse = objectMapper.readValue(result.getResponse().getContentAsString(), User.class);
		assertThat(userFromResponse).isNotNull();
		assertThat(userFromResponse.getUserId()).isEqualTo(user.getUserId());
		assertThat(userFromResponse.getIsActive()).isEqualTo(true);

		User userFromResponseGet = getUserFromId(user.getUserId());
		assertThat(userFromResponseGet).isNotNull();
		assertThat(userFromResponseGet.getUserId()).isEqualTo(user.getUserId());
		assertThat(userFromResponseGet.getIsActive()).isEqualTo(true);
	}

}