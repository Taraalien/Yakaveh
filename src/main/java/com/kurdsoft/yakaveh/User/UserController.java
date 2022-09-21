package com.kurdsoft.yakaveh.User;

import com.kurdsoft.yakaveh.basket.Basket;
import com.kurdsoft.yakaveh.basket.BasketDTO;
import com.kurdsoft.yakaveh.common.PagingData;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Data
@RequestMapping("/user/")
public class UserController {
    private final IUserService service;
    private UserMapper mapper;


    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody UserDTO userDTO){
        User user=mapper.toUser(userDTO);
        service.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody UserDTO userDTO){
        User user=mapper.toUser(userDTO);
        service.update(user);
        return ResponseEntity.ok().build();

    }


    @GetMapping("/v1/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable Long id) {
        User user = service.getById(id);
        UserDTO dto = mapper.toUerDto(user);
        return ResponseEntity.ok(dto);
    }


    @GetMapping("/v1")
    public ResponseEntity<List<UserDTO>> getAll(){
        List<User>users=service.getAll();
        List<UserDTO>userDTOS=mapper.toUserDtos(users);
        return ResponseEntity.ok(userDTOS);

    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/paging/{page}/{size}")
    public ResponseEntity<PagingData<UserDTO>> findAll(@PathVariable Integer page, Integer size){
        Page<User> users=service.paging(page,size);
        int totalPage=users.getTotalPages();
        List<User> data=users.getContent();
        List<UserDTO> userDTOS=mapper.toUserDtos(data);
        PagingData<UserDTO> pagingData=new PagingData<>(totalPage,page,userDTOS);
        return ResponseEntity.ok(pagingData);
    }

}
