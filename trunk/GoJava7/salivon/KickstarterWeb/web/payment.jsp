<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="WEB-INF/jspf/header.jspf" %>
<section id="category">
    <p>Enter data</p>
    <form action="payment" method="POST">
        <table border="1">
            <tr>
                <td>Enter Name</td>
                <td><input type="text" name="name" value="" /></td>
            </tr>
            <tr>
                <td>Enter number card</td>
                <td><input type="text" name="card" value="" size="25" /></td>
            </tr>
            <tr>
                <td>Make a contribution of 10$</td>
                <td><input type="radio" name="total" value="10" /></td>
            </tr>
            <tr>
                <td>Make a contribution of 50$</td>
                <td><input type="radio" name="total" value="50" /></td>
            </tr>
            <tr>
                <td>Make a contribution of 100$</td>
                <td><input type="radio" name="total" value="100" /></td>
            </tr>
            <tr>
                <td>Make a contribution another amount</td>
                <td><input type="text" name="total" /></td>
            </tr>
            </tbody>
        </table>

        <input type="submit" value="Contribute" />
    </form>
</section>
<%@include file="WEB-INF/jspf/footer.jspf" %>
