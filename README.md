Neo4j Template for OpenShift
----------------------------
This is a blank application whose intent is to serve as a template
to build another web applications with the following base stack:

  * Neo4j Graph Database
  * Spring Framework
  * Spring Web MVC
  * Spring Data Neo4j


How it works
------------
It's very easy to get Neo4j running on RedHat's OpenShift Cloud Platform.
Note that at the time of writing this, there is no Neo4j cartridge available at OpenShift.

If you are familiar with Heroku, think that a cartridge is like a Heroku Add-on.
It plugs functionality into the PaaS environment.

So, how we can use Neo4j at OpenShift?
First, remember to always read a README file, if there's one.

When you create a project at OpenShift, a README file can be located at the root directory of your app.
Among other things, we have this line:

  ../data - For persistent data (also in env var OPENSHIFT_DATA_DIR)

Hmmm *that's* interesting! Heroku doesn't have a place for persistent data across Heroku's dynos.
They are ephemeral, [as said by James Ward, here](http://stackoverflow.com/questions/7952324/heroku-worker-dyno-produces-file-how-to-read-it-from-web-dyno).

From now on, you can guess what to do, right?

The answer is inside of Spring `applicationContext.xml` file:

  `<neo4j:config storeDirectory="${OPENSHIFT_DATA_DIR}/graph.db"/>`


How to get started
------------------
1. [Create your OpenShift account](https://openshift.redhat.com/app)

2. `gem install rhc`

3. Generate a new ssh key-pair with this name:

  * `ssh-keygen -t rsa -f ~/.ssh/libra_id_rsa`

4. Add them to your local ssh-agent:

  * `ssh-add ~/.ssh/libra_id_rsa`

5. [Access your OpenShift account](https://openshift.redhat.com/app/account) and add your generated SSH key.

6. Create a new Java app with:

  * `rhc-create-app -a <yourappname> -t jbossas-7 -l <your rhc login>`

7. Update your recently created app repository with:

  * `cd <yourappname>`
  * `git remote add upstream -m master git://github.com/tomasmuller/openshift-neo4jtemplate.git`
  * `git pull -s recursive -X theirs upstream master`

8. You must have to export the following variable into your system (just a path to store Neo4j data):

  * export OPENSHIFT_DATA_DIR=/some/dir/related/to/your/project/maybe

9. Start jetty with:

  * `mvn -Plocalhost jetty:run`

10. Commit the changes, and then push, by running:

  * `git commit -a -m "Neo4j template running on OpenShift."`
  * `git push`


And have fun with Neo4j in OpenShift!
