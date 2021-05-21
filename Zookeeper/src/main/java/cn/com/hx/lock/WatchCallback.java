package cn.com.hx.lock;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author hx
 * @createTime 2021/5/12 6:29
 * @option
 * @description
 */
public class WatchCallback implements Watcher, AsyncCallback.StringCallback, AsyncCallback.Children2Callback, AsyncCallback.StatCallback {

    ZooKeeper zk;
    String ThreadName;
    CountDownLatch cc = new CountDownLatch(1);
    String pathName;

    public String getPathName() {
        return pathName;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }

    public String getThreadName() {
        return ThreadName;
    }

    public void setThreadName(String ThreadName) {
        this.ThreadName = ThreadName;
    }

    public ZooKeeper getZk() {
        return zk;
    }

    public void setZk(ZooKeeper zk) {
        this.zk = zk;
    }

    public void tryLock() {
        try {
            System.out.println(ThreadName + "create .... ");
            zk.create("/lock", ThreadName.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL, this, "123");


            cc.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void unLock() {
        try {
            zk.delete(pathName,-1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void process(WatchedEvent event) {
        switch (event.getType()) {
            case None:
                break;
            case NodeCreated:
                break;
            case NodeDeleted:
                zk.getChildren("/", false, this, "sas");
                break;
            case NodeDataChanged:
                break;
            case NodeChildrenChanged:
                break;
            case DataWatchRemoved:
                break;
            case ChildWatchRemoved:
                break;
            case PersistentWatchRemoved:
                break;
        }
    }

    @Override
    public void processResult(int rc, String path, Object ctx, String name) {

//        r如果nama不为空, 则一定是创建成功了
        if (name != null) {
            System.out.println(ThreadName + " createNode : " + name);
            pathName = name;
            zk.getChildren("/", false, this, "sas");
        }
    }

    /**
     * get children 的回调
     *
     * @param rc
     * @param path
     * @param ctx
     * @param children
     * @param stat
     */
    @Override
    public void processResult(int rc, String path, Object ctx, List<String> children, Stat stat) {
//       进到这个方法, 说明十个线程已经拿到了目录, 节点已经创建完啦,且看到了自己和自己前面的节点
       /* System.out.println(ThreadName + "look locks ....");
        for (String child : children) {
            System.out.println(child);
        }*/
        Collections.sort(children);
        int i = children.indexOf(pathName.substring(1));


//        是不是第一个,
        if (i == 0) {
//        yes
            System.out.println(ThreadName + "i am first.........");
            cc.countDown();
        } else {
//        no
            zk.exists("/" + children.get(i - 1), this, this, "sdg");

        }

    }

    @Override
    public void processResult(int rc, String path, Object ctx, Stat stat) {

    }
}
