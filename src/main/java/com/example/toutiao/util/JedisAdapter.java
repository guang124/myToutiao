package com.example.toutiao.util;

import redis.clients.jedis.Jedis;

public class JedisAdapter {

    public static  void print(int index,Object obj){
        System.out.println(String.format("%d,%s",index,obj.toString()));

    }
    public static  void main(String[] args){
        Jedis jedis=new Jedis();
        jedis.flushAll();

        jedis.set("hello","world");

        print(1,jedis.get("hello"));
    }
}
