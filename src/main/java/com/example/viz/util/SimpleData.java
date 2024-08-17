package com.example.viz.util;

import lombok.Getter;

import java.util.*;


public class SimpleData {
    @Getter
    private List<Map<String, Object>> data = new ArrayList<>();


    public SimpleData addEntry(String key, Object value) {
        var entry = new HashMap<String, Object>();
        entry.put("name", key);
        entry.put("value", value);
        data.add(entry);
        return this;
    }

    public Integer getRootCount(){
        return data == null ? null : data.size();
    }

    public List<Map<String, Object>> buildData() {
        return List.copyOf(data);
    }

    public void setSubDataForEntry(String identifier, String key, SimpleData subData){
        for(var entry : data){
            if(entry.get("name").equals(identifier)){
                entry.put(key, subData.buildData());
                return;
            }
        }
        throw new NoSuchElementException("Could not find identifier: [" + identifier + "] in data");
    }
}
