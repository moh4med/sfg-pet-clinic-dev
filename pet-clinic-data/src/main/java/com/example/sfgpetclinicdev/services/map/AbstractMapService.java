package com.example.sfgpetclinicdev.services.map;

import com.example.sfgpetclinicdev.services.CrudService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<T,ID> implements CrudService<T,ID> {
    protected Map<ID,T> map=new HashMap<>();
    @Override
    public T findById(ID id) {
        return map.get(id);
    }
    public T save(ID id,T object) {
        map.put(id,object);
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
}
