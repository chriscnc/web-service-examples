# hit-counter

A simple service that keeps track of hits.

## Run in Development
```bash
> lein ring server
```

## Run in Production
Download and install the [Jetty Server](http://eclipse.org/downloads/download.php?file=/jetty/stable-9/dist/jetty-distribution-9.3.6.v20151106.tar.gz&r=1)

Build the war
```bash
> lein ring uberwar
```

Copy the war file into <jetty-home>/webapps
```bash
> cp <project-dir>/target/hit-counter-0.1.0-SNAPSHOT-standalone.war <jetty-home>/webapps/hit-counter.war
```

Start Jetty
```bash
> <jetty-home>/bin/jetty.sh start
```

Browse to `http://localhost:8080/hit-counter` or for fun seige it...
```bash
> seige -c 100 http://localhost:8080/hit-counter
```


## License

Copyright © 2015 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
