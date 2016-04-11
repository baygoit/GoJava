<h1> Installation </h1>

<h2>Ubuntu</h2>
<ol>
<li>Сopy context.xml and tomcat-users.xml from resources into Tomcat7.</li>
<li>Installing a CA (if using ssh)
Copy your certificate in PEM format rds-combined-ca-bundle.pem (the format that has ----BEGIN CERTIFICATE---- in it) into /usr/local/share/ca-certificates and name it with a .crt file extension.
Then run sudo update-ca-certificates.</li>
<li> Add Inbound rule for Tomcat7 server IP on Amazon AWS if problem happend. Now all inbound is accept without limitation</li>
</ol>
