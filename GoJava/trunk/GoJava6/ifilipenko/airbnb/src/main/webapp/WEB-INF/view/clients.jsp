    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>
        <body>
            <form method="GET" action="/clients">
                <c:forEach var="client" items="${clients}" varStatus="iter">

                <table border="1" width="30%" cellpadding="5">
                    <tr>
                        <td>${clients[iter.index]}</td>
                    </tr>
                 </table>

                </c:forEach>

            </form>
         </body>