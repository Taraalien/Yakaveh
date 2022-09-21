package com.kurdsoft.yakaveh.user;

import com.kurdsoft.yakaveh.common.exceptions.ConflictException;
import com.kurdsoft.yakaveh.common.exceptions.NotFound;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements IUserService{
    private final UserRep userRep;

    @Override
    public User save(User user) {
        List<User> users= (List<User>) userRep.findAll();
        for(User user1:users){
            if(user1.getPhone()==user1.getPhone()){
                throw new ConflictException("This phone number is already exits.");
            }
        }
        return userRep.save(user);
    }

    @Override
    public User update(User user) {
        User lastItem=getById(user.getId());
        lastItem.setName(user.getName());
        lastItem.setFamily(user.getFamily());
        lastItem.setPhone(user.getPhone());

        return userRep.save(lastItem);
    }

    @Override
    public List<User> getAll() {
        return (List<User>) userRep.findAll();
    }

    @Override
    public void delete(Long id) {
            userRep.deleteById(id);
    }

    @Override
    public User getById(Long id) {
        Optional<User> optionalUser=userRep.findById(id);
        if(!optionalUser.isPresent())
        {
            throw new NotFound("Not found id");
        }
        return optionalUser.get();
    }

    @Override
    public Page<User> paging(Integer page, Integer size) {
        return userRep.findAll(PageRequest.of(page,size, Sort.by("id").descending()));
    }
}
