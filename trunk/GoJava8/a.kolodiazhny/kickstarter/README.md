<h1> Installation </h1>

<h2>Ubuntu</h2>
<ol>
  <li> Download source files</li>
  <li>Build with maven3. Use command:</li> 
</ol>
  ``` bash
  mvn -Dtomcat.deploy.username=<your tomcat user> -D tomcat.deploy.password=<your tomcat password> clean tomcat7:deploy 
  ```


If somethings went wrong:
<ol>
<li>Installing a CA
Copy your certificate in PEM format rds-combined-ca-bundle.pem (the format that has ----BEGIN CERTIFICATE---- in it) into /usr/local/share/ca-certificates and name it with a .crt file extension.
Then run sudo update-ca-certificates.</li>
<li>Сopy context.xml from resources into Tomcat7.</li>
<li> Add Inbound rule for Tomcat7 server IP on Amazon AWS. Now all inbound 0.0.0.0/0 is listening</li>
</ol>
