package com.example.sfgpetclinicdev.services.map;

import com.example.sfgpetclinicdev.model.BaseEntity;
import com.example.sfgpetclinicdev.services.CrudService;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity,ID extends Long> implements CrudService<T,ID> {
    protected Map<Long,T> map=new HashMap<>();
    @Override
    public T findById(ID id) {
        return map.get(id);
    }
    public T save(T object) {
        if(null!=object){
            if(object.getId()==null){
                object.setId(getNextId());
            }
            map.put(object.getId(),object);
        }else{
            throw new RuntimeException("object can't be null");
        }
        return object;
    }
    @Override
    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    @Override
    public void deleteById(ID id) {
        map.remove(id);
    }

    @Override
    public void delete(T object) {
        map.entrySet().removeIf(idtEntry -> idtEntry.getValue().equals(object));
    }
    private Long getNextId(){
        Long id=null;
        try {
            id = Collections.max(map.keySet())+1;
        }catch (NoSuchElementException e){
            id=1L;
        }

        return id;
    }
}
