package cn.windy.redis;

/**
 * 计数器
 */
public class Counter {

    private static void set(Long counter){
        JedisUtil.set("counter","counter"+counter);
    }

    public static Long get(){
        String counter_ = JedisUtil.get("counter");
        if(counter_ == null || counter_.equals("0") )counter_ = "0";
        counter_ = counter_.replace("counter","");

        Long counter = Long.parseLong(counter_);
        synchronized (counter){
            counter++;
            set(counter);
        }
        return counter;
    }

}
