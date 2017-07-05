package com.creditcrest.ccs.common.pojo;

import com.creditcrest.ccs.common.util.IPUtil;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 封装Request参数
 * Created by 柏世民 on 2017/7/3.
 */
public class ParamData extends HashMap implements Map{

    private final static long serialVersionUID = 1L;
    //参数封装
    Map<Object,Object> map = null;
    //Request
    HttpServletRequest request;

    public ParamData(Map<Object, Object> map) {
        this.map = map;
    }

    public ParamData() {
        //拿来封装要装载的值
        Map<Object,Object> returnMap = new HashMap<Object, Object>(5);
        //获取Request对象
        this.request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //request请求里的所有参数
        Map<String,String[]> properties = request.getParameterMap();
        //迭代Map中entry
        Iterator entries = properties.entrySet().iterator();
        Map.Entry entry;
        String name = "";
        String value = "";
        while(entries.hasNext()){
            entry = (Map.Entry)entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if(null == valueObj){
                value = "";
            }else if(valueObj instanceof String[]) {
                String[] values = (String[]) valueObj;
                for (int i = 0; i < values.length; i++) {
                    value = values[i] + ",";
                }
                value = value.substring(0, value.length() - 1);
            }else{
                value = valueObj.toString();
            }
            returnMap.put(name,value);
        }
        //记录请求者:IP地址
        returnMap.put("loginIP", IPUtil.getIpAdd());
        map = returnMap;
    }
    @Override
    public Object get(Object key) {
        return map.get(key);
    }

    public String getString(Object key){
        Object value = get(key);
        String str = null ;
        if(null != value){
            str = String.valueOf(value);
        }
        return str;
    }

    public int getInt(Object key){
        int num = 0;
        String str = getString(key);
        if(null != str){
            num = Integer.parseInt(str);
        }
        return num;
    }

    public double getDouble(Object key){
        double num = 0;
        String str = getString(key);
        if(null != str){
            num = Double.parseDouble(str);
        }
        return num;
    }
    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public Object put(Object key, Object value) {
        return map.put(key, value);
    }

    @Override
    public Object remove(Object key) {
        return map.remove(key);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    @Override
    public Set keySet() {
        return map.keySet();
    }

    @Override
    public Collection values() {
        return map.values();
    }

    @Override
    public Set entrySet() {
        return map.entrySet();
    }

}
