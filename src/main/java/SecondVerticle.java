import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

/**
 * Created by b3605 on 02/03/16.
 *
 * @author Xavier MARIN (b3605)
 */
public class SecondVerticle extends AbstractVerticle {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String... args) {
        Vertx.clusteredVertx(new VertxOptions().setHAEnabled(true), vertx ->
                vertx.result().deployVerticle(SecondVerticle.class.getName(), new DeploymentOptions().setHa(true))
        );
    }


    @Override
    public void start() throws Exception {
        vertx.createHttpServer().requestHandler(req ->
                req.response().end("Request served by " + SecondVerticle.class.getName() + "\n")
        ).listen(9090);
    }
}
