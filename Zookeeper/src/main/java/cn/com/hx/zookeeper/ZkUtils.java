package cn.com.hx.zookeeper;

import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author hx
 * @createTime 2021/5/11 21:00
 * @option
 * @description
 */
public class ZkUtils {
    private static ZooKeeper zooKeeper;

//    private static String address = "192.168.190.66:2181,192.168.190.67:2181,192.168.190.68:2181,192.168.190.69:2181/testConf";
    private static String address = "192.168.190.66:2181,192.168.190.67:2181,192.168.190.68:2181,192.168.190.69:2181/testLock";

    private  static ZooKeeper zk;


    private static DefaultWatch watch = new DefaultWatch();

    private static CountDownLatch init  =  new CountDownLatch(1);
    public static ZooKeeper  getZK(){

        try {
            zk = new ZooKeeper(address,1000,watch);
            watch.setCc(init);
            init.await();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return zk;
    }


}
