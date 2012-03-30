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
Read my [blog post here](http://tomasmuller.com.br/2012/03/29/10-steps-to-run-neo4j-at-redhat-openshift-cloud).


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
  * `git checkout -b template`
  * `git pull -s recursive -X theirs upstream master`
  * `git checkout master`
  * `git merge template`
  * `git branch -D template`

8. You must have to export the following variable into your system (just a path to store Neo4j data):

  * `export OPENSHIFT_DATA_DIR=/some/dir/related/to/your/project/maybe`

9. Start jetty with:

  * `mvn -Plocalhost jetty:run`

10. Commit the changes, and then push, by running:

  * `git commit -a -m "Neo4j template running on OpenShift."`
  * `git push`


And have fun with Neo4j at OpenShift!
