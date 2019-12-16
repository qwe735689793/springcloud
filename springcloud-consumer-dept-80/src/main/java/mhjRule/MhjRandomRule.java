//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package mhjRule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MhjRandomRule extends AbstractLoadBalancerRule {
    public MhjRandomRule() {
    }
    private int total =0;
    private int currentIndex = 0;
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        } else {
            Server server = null;

            while(server == null) {
                if (Thread.interrupted()) {
                    return null;
                }

                List<Server> upList = lb.getReachableServers(); //获取或者的服务
                List<Server> allList = lb.getAllServers(); //获取全部服务
                int serverCount = allList.size();
                if (serverCount == 0) {
                    return null;
                }

//                int index = this.chooseRandomInt(serverCount);  //生产区间随机数
//                server = (Server)upList.get(index); //获取当前随机对应的服务


                //=========================
                if(total<5){
                    total++;
                    server = (Server)upList.get(currentIndex);
                } else {
                    currentIndex++;
                    total = 0;
                    if(currentIndex>upList.size()){
                        currentIndex=0;
                    }
                    server = (Server)upList.get(currentIndex);  //从活着的服务中获取
                }
                if (server == null) {
                    Thread.yield();
                } else {
                    if (server.isAlive()) {
                        return server;
                    }

                    server = null;
                    Thread.yield();
                }
            }

            return server;
        }
    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    @Override
    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
}
