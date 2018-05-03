package cn.windy.redis;

import cn.windy.util.SystemConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Optional;
import java.util.Set;

public class JedisUtil {

    private static Logger logger = LoggerFactory.getLogger(JedisUtil.class);

    private static JedisPool getPool(){
        String ip   = SystemConfig.get("jedis.ip");
        String port = SystemConfig.get("jedis.port");
        JedisPool pool = null;
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(RedisConfig.MAX_TOTAL);
        config.setMaxIdle(RedisConfig.MAX_IDLE);
        config.setMaxWaitMillis(RedisConfig.MAX_WAIT);
        config.setTestOnBorrow(true);
        pool = new JedisPool(config, ip, Integer.parseInt(port), RedisConfig.TIMEOUT, SystemConfig.get("jedis.pass"));
        return pool;
    }

    public static Jedis getJedis() {
        Jedis jedis = null;
        int count = 0;
        do {
            try {
                jedis = getPool().getResource();
            }
            catch (Exception e) {
                logger.error("获取Jedis连接异常：",e);
            }
        }
        while(jedis == null && count<RedisConfig.RETRY_NUM);
        return jedis;
    }


    public static boolean constainsKey(String pattern){
        try(Jedis jedis = JedisUtil.getJedis()){
            Set<String> set = jedis.keys(pattern);
            if(set!= null && set.size()>0) return true;
            else{
                Set<byte[]> set1 = jedis.keys(pattern.getBytes());
                if(set1!= null && set1.size()>0) return true;
            }
        }catch (Exception e){
            logger.error("操作redis异常,{}",e);
        }
        return false;
    }

    public static boolean exists(String key){
        try(Jedis jedis = JedisUtil.getJedis()){
            if(jedis.exists(key)) return true;
            else{
                if(jedis.exists(key.getBytes())) return true;
            }
        }catch (Exception e){
            logger.error("操作redis异常,{}",e);
        }
        return false;
    }

    public static void set(String key,String value){
        Jedis jedis = getJedis();
        try{
            jedis.set(key,value);
        }catch(Exception e){
            logger.error("设置jedis内容异常",e);
        }finally {
            close(jedis);
        }
    }

    public static void expire(String key,int expire){
        Jedis jedis = getJedis();
        try{
            jedis.expire(key,expire);
        }catch(Exception e){
            logger.error("设置jedis过期时间异常",e);
        }finally {
            close(jedis);
        }
    }

    public static void set(String key,String value,int expire){
        Jedis jedis = getJedis();
        try{
            jedis.setex(key,expire,value);
        }catch(Exception e){
            logger.error("设置jedis内容异常",e);
        }finally {
            close(jedis);
        }
    }

    public static String get(String key){
        Jedis jedis = getJedis();
        try{
            return jedis.get(key);
        }catch(Exception e){
            logger.error("获取jedis内容异常",e);
        }finally {
            close(jedis);
        }
        return null;
    }

    public static void close(Jedis jedis){
        if(jedis != null) {
            jedis.close();
        }
    }

    public static byte[] get(byte[] key){
        Jedis jedis = getJedis();
        try{
            return jedis.get(key);
        }catch(Exception e){
            logger.error("获取jedis内容异常",e);
        }finally {
            close(jedis);
        }
        return null;
    }

    public static <T> Optional<T> getObject(String key){
        Optional<T> optional = Optional.empty();
        byte[] bytes = get(key.getBytes());
        if(bytes != null){
            @SuppressWarnings("unchecked")
			T t = (T) SerializeUtil.unserizlize(bytes);
            optional = Optional.of(t);
        }
        return optional;
    }

    public static void set(byte[] key,byte[] value){
        Jedis jedis = getJedis();
        try{
            jedis.set(key,value);
        }catch(Exception e){
            logger.error("设置jedis内容异常",e);
        }finally {
            close(jedis);
        }
    }

    public static void set(String key,Object object){
        set(key.getBytes(),SerializeUtil.serialize(object));
    }

    public static void remove(String key){
        Jedis jedis = getJedis();
        try{
            jedis.del(key);
        }catch(Exception e){
            logger.error("删除jedis-key{}异常",key,e);
        }finally {
            close(jedis);
        }
    }

}
