//package uk.cf.ac.nccteam11;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//import uk.cf.ac.nccteam11.account.service.UserDTO;
//import uk.cf.ac.nccteam11.account.service.UserService;
//import uk.cf.ac.nccteam11.account.service.message.SaveUserRequest;
//import uk.cf.ac.nccteam11.account.service.message.SaveUserResponse;
//import uk.cf.ac.nccteam11.account.web.UserController;
//
//import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(controllers = UserController.class)
//@AutoConfigureMockMvc
//public class UserWebMvcTests {
//    @Autowired
//    MockMvc mvc;
//    @MockBean
//    UserService userService;
//
//    @Test
//    public void shouldBeAbleToCreateANewAccount() throws Exception{
//        //GIVEN
//        UserDTO newUser = new UserDTO(1, "Fei", "Liu", "email123@gmail.com","0123456789", "P@55w0rd", "Tyndall Street",  "Cardiff", "CF10 4BZ");
//
//        //WHEN
//        SaveUserRequest saveUserRequest = SaveUserRequest.of().userDTO(newUser).build();
//        SaveUserResponse saveUserResponse = SaveUserResponse.of().saveUserRequest(saveUserRequest).build();
//        given(userService.addNewUser(saveUserRequest)).willReturn(saveUserResponse);
//
//        //THEN
//        mvc.perform(post("/user/sign-up/add")).andExpect(status().is2xxSuccessful());
//    }
//}
