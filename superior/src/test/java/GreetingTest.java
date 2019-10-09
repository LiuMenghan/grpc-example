import cn.lmh.examples.grpc.client.GreetingClient;
import cn.lmh.examples.grpc.server.GreetingServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GreetingTest {
    List<GreetingServer> servers = new ArrayList<>();
    GreetingClient client;
    String registryPath = "/service/grpc/example/superior";
    @Before
    public void init() throws Exception {
        for(int port = 8081; port <= 8082; port++){
            GreetingServer server = new GreetingServer(port, registryPath);
            server.start();
        }
        client = new GreetingClient("172.16.17.101",2181, registryPath);
    }

    @After
    public void destroy() throws InterruptedException {
        client.shutdown();
        for(GreetingServer server : servers) {
            server.stop();
        }
    }

    @Test
    public void greeting() throws Throwable {
        for(int i = 1; i < 100; i++){
            String name = "Student" + i;
            String message = client.sayHello(name);
            System.out.println(message);
        }
    }
}
