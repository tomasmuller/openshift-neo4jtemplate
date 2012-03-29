Sources:
http://groups.google.com/group/neo4j/browse_thread/thread/c39029d81a72aafe

--

1. register at: https://openshift.redhat.com/app

2. gem install rhc

3. you HAVE to generate a new keypair with this name

  ssh-keygen -t rsa -f ~/.ssh/libra_id_rsa

4. add them to the ssh-agent:

  ssh-add ~/.ssh/libra_id_rsa

5. Go to https://openshift.redhat.com/app/account and add your generated SSH key.

6. Create a java app with type, via

  rhc-create-app -a neo4jtemplate -t jbossas-7 -l <your rhc login>

  neo4jtemplate published:  http://neo4jtemplate-codenroll.rhcloud.com/

  git url:  ssh://1f60cd3245ba4377b8e4617a3a4bd59a@neo4jtemplate-codenroll.rhcloud.com/~/git/neo4jtemplate.git/

7. Clone your recently created app.

8. If you are new to OpenShift, read the default README file. It will help you a lot.
For example: in Repo layout explanation, we have this line:

  ../data - For persistent data (also in env var OPENSHIFT_DATA_DIR)

Hmmm that's interesting! Heroku doesn't have a place for persistent data across Heroku's dynos.
(as said by James Ward here: http://stackoverflow.com/questions/7952324/heroku-worker-dyno-produces-file-how-to-read-it-from-web-dyno)

9. To test the app with `mvn -P localhost jetty:run`, you must have to export the following variable into your system:

  export OPENSHIFT_DATA_DIR=/some/dir/related/to/your/project/maybe

10. 