# spring boot solr

```bash

$ docker pull solr

# run a single Solr server
$ docker run --name solr-demo -d -p 8983:8983 -t solr

# create a "core", an index for your data
$ docker exec -it solr-demo solr create_core -c gettingstarted

# load some of the example data that is included in the container
$ docker exec -it solr-demo post -c gettingstarted example/exampledocs/manufacturers.xml
```