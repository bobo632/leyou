package com.leyou.web;

import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.pojo.Item;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("item")
public class ItemController {
    @PostMapping
    public ResponseEntity<Item> save(Item item){
        if(item.getPrice()==null){
            throw new LyException(ExceptionEnum.ITEM_NOT_PRICE);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }
}
