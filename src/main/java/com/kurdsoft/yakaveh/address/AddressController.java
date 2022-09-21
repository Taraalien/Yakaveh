package com.kurdsoft.yakaveh.address;

import com.kurdsoft.yakaveh.common.PagingData;
import com.kurdsoft.yakaveh.items.Items;
import com.kurdsoft.yakaveh.items.ItemsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Data
@RequestMapping("/address/")
public class AddressController {
    private final IAddressService service;
    private AddressMapper mapper;

    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody AddressDTO dto){
        Address address=mapper.toAddress(dto);
        service.save(address);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody AddressDTO dto){
        Address address=mapper.toAddress(dto);
        service.update(address);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/v1/{id}")
    public ResponseEntity<AddressDTO> getById(@PathVariable Long id) {
        Address address= service.getById(id);
        AddressDTO dto = mapper.toAddressDto(address);
        return ResponseEntity.ok(dto);
    }


    @GetMapping("/v1")
    public ResponseEntity<List<AddressDTO>> getAll(){
        List<Address>addresses=service.getAll();
        List<AddressDTO>addressDTOS=mapper.toAddressDtos(addresses);
        return ResponseEntity.ok(addressDTOS);

    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/paging/{page}/{size}")
    public ResponseEntity<PagingData<AddressDTO>> findAll(@PathVariable Integer page, Integer size){
        Page<Address> addresses=service.paging(page,size);
        int totalPage=addresses.getTotalPages();
        List<Address> data=addresses.getContent();
        List<AddressDTO> addressDTOS=mapper.toAddressDtos(data);
        PagingData<AddressDTO> pagingData=new PagingData<>(totalPage,page,addressDTOS);
        return ResponseEntity.ok(pagingData);
    }


    @GetMapping("/v1/get-all-by-user-id/{user_id}")
    public ResponseEntity<List<AddressDTO>> getAllByUserId(@PathVariable Long id){
        List<Address>addresses=service.getByUserId(id);
        List<AddressDTO> addressDTOS=mapper.toAddressDtos(addresses);
        return ResponseEntity.ok(addressDTOS);
    }
}
