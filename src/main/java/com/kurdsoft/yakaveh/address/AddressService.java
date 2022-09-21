package com.kurdsoft.yakaveh.address;


import com.kurdsoft.yakaveh.User.IUserService;
import com.kurdsoft.yakaveh.User.User;
import com.kurdsoft.yakaveh.common.exceptions.NotFound;
import com.kurdsoft.yakaveh.items.Items;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AddressService implements IAddressService{
    private final AddressRep rep;
    private IUserService service;
    @Override
    public Address save(Address address) {
        Long userId=address.getUser().getId();
        User  user=service.getById(userId);
        address.setUser(user);
        return rep.save(address);
    }

    @Override
    public Address update(Address address) {
        Address lastItem=getById(address.getId());
        lastItem.setLocation(address.getLocation());
        lastItem.setNo(address.getNo());
        lastItem.setUnit(address.getUnit());
        Long userId=address.getUser().getId();
        User  user=service.getById(userId);
        lastItem.setUser(user);
        return rep.save(lastItem);
    }

    @Override
    public List<Address> getAll() {

        return (List<Address>) rep.findAll();
    }

    @Override
    public void delete(Long id) {
        rep.deleteById(id);
    }

    @Override
    public Address getById(Long id) {
        Optional<Address> optionalAddress=rep.findById(id);
        if(!optionalAddress.isPresent()){
            throw  new NotFound("Not found Id.");
        }
        return optionalAddress.get();
    }

    @Override
    public Page<Address> paging(Integer page, Integer size) {

        return rep.findAll(PageRequest.of(page,size, Sort.by("id").descending()));
    }

    @Override
    public List<Address> getByUserId(Long id) {
        User user=service.getById(id);
        Long userId=user.getId();
        List<Address> addresses=rep.findAllByUser_Id(userId);
        return addresses;
    }
}
