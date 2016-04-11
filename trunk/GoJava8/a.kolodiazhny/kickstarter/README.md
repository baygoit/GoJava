<h1> Installation </h1>

<h2>Ubuntu</h2>
<ol>
<li>Installing a CA
Copy your certificate in PEM format rds-combined-ca-bundle.pem (the format that has ----BEGIN CERTIFICATE---- in it) into /usr/local/share/ca-certificates and name it with a .crt file extension.
Then run sudo update-ca-certificates.</li>
<li>Сopy context.xml from resources into Tomcat7.</li>
<li> Add Inbound rule for Tomcat7 server IP on Amazon AWS</li>
</ol>
