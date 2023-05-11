package pl.studentmed.facultative.services.user_info;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.studentmed.facultative.models.user_info.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Validated
class UserInfoController {

    private final UserInfoFacade facade;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public UserInfoResponseDTO createUser(@Valid @RequestBody UserInfoCreateDTO dto) {
        return facade.createUser(dto);
    }

    @PostMapping(
            path = "/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public UserInfoLoginResponseDTO loginUser(@RequestBody UserInfoLoginRequestDTO user) {
        return facade.loginUser(user);
    }

}
