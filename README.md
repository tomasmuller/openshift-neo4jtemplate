Sources:
http://groups.google.com/group/neo4j/browse_thread/thread/c39029d81a72aafe

--

1. [Create your OpenShift account](https://openshift.redhat.com/app)

2. `gem install rhc`

3. Generate a new ssh key-pair with this name:

  `ssh-keygen -t rsa -f ~/.ssh/libra_id_rsa`

4. Add them to your local ssh-agent:

  `ssh-add ~/.ssh/libra_id_rsa`

5. [Access your OpenShift account](https://openshift.redhat.com/app/account) and add your generated SSH key.

6. Create a new Java app with:

  `rhc-create-app -a <yourappname> -t jbossas-7 -l <your rhc login>`

  Note somewhere this important output information:
  
    * neo4jtemplate published:  http://neo4jtemplate-codenroll.rhcloud.com/
    * git url: full address to your git repository

7. Update your recently created app repository with:

  `cd <yourappname>`
  `git remote add upstream -m master git://github.com/tomasmuller/openshift-neo4jtemplate.git`
  `git pull -s recursive -X theirs upstream master`

8. If you are new to OpenShift, read the default [README](https://github.com/tomasmuller/openshift-neo4jtemplate/blob/master/docs/OPENSHIFT_README) file. It will help you a lot.
For example: in Repo layout explanation, we have this line:

  ../data - For persistent data (also in env var OPENSHIFT_DATA_DIR)

Hmmm that's interesting! Heroku doesn't have a place for persistent data across Heroku's dynos.
(they are ephemeral, [as said by James Ward here](http://stackoverflow.com/questions/7952324/heroku-worker-dyno-produces-file-how-to-read-it-from-web-dyno).)

9. You must have to export the following variable into your system (just a path to store Neo4j data):

  export OPENSHIFT_DATA_DIR=/some/dir/related/to/your/project/maybe

10. Start jetty with:

  `mvn -P localhost jetty:run`

11. Commit the changes, and then push, by running:

  `git commit -a -m "Neo4j template running on OpenShift."`
  `git push`


And have fun with Neo4j in OpenShift!

