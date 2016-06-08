import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

import java.lang.management.ManagementFactory;

/**
 * Created by b3605 on 02/03/16.
 *
 * @author Xavier MARIN (b3605)
 */
public class HaVerticle extends AbstractVerticle {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Vertx.clusteredVertx(new VertxOptions().setHAEnabled(true), vertx ->
                vertx.result().deployVerticle(HaVerticle.class.getName(), new DeploymentOptions().setHa(true))
        );
    }


    @Override
    public void start() throws Exception {
        vertx.createHttpServer().requestHandler(req ->
                req.response().end("Request served by " + ManagementFactory.getRuntimeMXBean().getName() + "\n")
        ).listen(8080);
    }
}
