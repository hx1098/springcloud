package cn.com.hx.lock;

import cn.com.hx.zookeeper.ZkUtils;
import org.apache.zookeeper.ZooKeeper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author hx
 * @createTime 2021/5/12 6:19
 * @option
 * @description 模拟多线程的方式,
 */
public class TestLock {

    ZooKeeper zk;

    @Before
    public void conn(){
        zk = ZkUtils.getZK();
    }
    @After
    public void close(){
        try {
            zk.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1(){
        for (int i = 0; i < 10; i++) {
            new Thread(){
                @Override
                public void run() {


                    WatchCallback callback = new WatchCallback();
                    callback.setZk(zk);
                    String threadName = Thread.currentThread().getName();
                    callback.setThreadName(threadName);

//                    每个线程都去抢锁,

                    callback.tryLock();

//                    抢到以后, 干活
                    System.out.println(threadName +  " :干活.............");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

//                    释放锁
                    callback.unLock();





                }
            }.start();
        }

        while (true) {

        }

    }
}
