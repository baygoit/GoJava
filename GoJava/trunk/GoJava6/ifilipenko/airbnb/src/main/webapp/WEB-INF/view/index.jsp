 <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>
    <body>
        <form method="POST" action="index?action=signup" class="form">
            <center>
            <h1><font color="#FF1493">THIS IS A BRAND NEW AWESOME AIRBNB!</font></h1>
            <table border="1" width="30%" cellpadding="5">
                <thead>
                    <tr>
                        <th colspan="2">Enter Information Here</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>First Name</td>
                        <td><input type="text" name="fname" value="" required/></td>
                   </tr>
                    <tr>
                        <td>Last Name</td>
                        <td><input type="text" name="lname" value="" required/></td>
                    </tr>
                    <tr>
                        <td>Gender</td>
                        <td><input type="text" name="gender" value="" required/></td>
                    </tr>
                       <tr>
                        <td>Birth Date</td>
                        <td><input type="text" name="bdate" value="" required/></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="email" value="" required/></td>
                    </tr>
                    <tr>
                        <td>City</td>
                        <td><input type="text" name="city" value="" required/></td>
                    </tr>
                    <tr>
                        <td>User Name</td>
                        <td><input type="text" name="uname" value="" /></td>¡
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="pass" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Submit" /></td>
                        <td><input type="reset" value="Reset" /></td>
                    </tr>
                    <tr>
                        <td colspan="2">Already registered!!! <a href="/login?action=login">Login Here</a></td>
                    </tr>
                </tbody>
            </table>
            </center>
        </form>
    </body>