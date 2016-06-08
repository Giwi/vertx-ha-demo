Vert.X high availability demo
===============================


## setup

    ./gradlew build
     
## running

Run `HaVerticle` with your IDE
    
you should see : 

    Members [1] {
            Member [172.17.0.1]:5701 this
    }

you can test it with : [http://127.0.0.1:8080/](http://127.0.0.1:8080/), you should see a 
message showing `<pId>@<host name>`.

Run `SecondVerticle` with your IDE
    
you should see in both consoles :

    Members [2] {
            Member [172.17.0.1]:5701
            Member [172.17.0.1]:5702 this
    }

you can now test your second app : [http://127.0.0.1:9090/](http://127.0.0.1:9090/), you should 
see a message showing `Request served by SecondVerticle`.

now kill the `HaVerticle` and go to [http://127.0.0.1:8080/](http://127.0.0.1:8080/), you should 
see another pId.

run again `HaVerticle` and then kill `SecondVerticle`, go to  [http://127.0.0.1:9090/](http://127.0.0.1:9090/), 
you should see a message showing `Request served by SecondVerticle` and go to 
[http://127.0.0.1:8080/](http://127.0.0.1:8080/), you should see another pId.

## Next steps
 
- using Zookeeper Cluster Manager
- serving static content
- using database
 
