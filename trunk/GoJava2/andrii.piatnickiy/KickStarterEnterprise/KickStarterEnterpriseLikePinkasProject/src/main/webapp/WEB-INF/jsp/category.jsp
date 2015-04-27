<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp" %>

<h1>${category.name}</h1>


<table class="table table-bordered table-striped table-hover">
    <thead>
        <tr>
            <th>Projects</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${category.projects}" var="project">
            <tr>
                <td>
                    ${project.name}
                </td>

            </tr>
        </c:forEach>
    </tbody>
</table>