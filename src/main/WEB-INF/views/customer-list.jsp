<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.saransh.utils.SortUtils" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer List</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    
    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/assets/stylesheet/styles.css" rel="stylesheet">
    <link rel="icon" href="${pageContext.request.contextPath}/assets/images/favicon.png">
</head>
<body>

<div class="bg-secondary bg-gradient text-white">
    <div class="text-center">
        <h1 class="pt-3">CRM - Customers List</h1>
    </div>
    <div class="container p-3">
        <a class="btn btn-lg btn-dark" href="${pageContext.request.contextPath}/customer/add">Add Customer</a>
    </div>
</div>

<div class="container mt-5">

    <c:choose>
        <c:when test="${customers.size() > 0}">
            <form class="form-container d-flex mb-4" action="${pageContext.request.contextPath}/customer/search" method="GET">
                <input type="text" class="form-control" name="search" placeholder="Search" value="${search}" required>
                <input type="submit" class="btn btn-primary ms-3" value="Search">
            </form>

            <table class="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">
                            <a href="${pageContext.request.contextPath}/customer/list?sortBy=${SortUtils.SortByFirstName.value}">First Name</a>
                        </th>
                        <th scope="col">
                            <a href="${pageContext.request.contextPath}/customer/list?sortBy=${SortUtils.SortByLastName.value}">Last Name</a>
                        </th>
                        <th scope="col">
                            <a href="${pageContext.request.contextPath}/customer/list?sortBy=${SortUtils.SortByEmail.value}">Email</a>
                        </th>
                        <th scope="col">Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="customer" items="${customers}">
                        <tr>
                            <td>${customer.firstName}</td>
                            <td>${customer.lastName}</td>
                            <td>${customer.email}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/customer/update?id=${customer.id}">Update</a> |
                                <a class="delete" href="${pageContext.request.contextPath}/customer/delete?id=${customer.id}"
                                   onclick="return confirm('Do you really want to delete this customer?')">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:when>

        <c:otherwise>
            <h3 class="text-center text-muted">No customer records found.</h3>
        </c:otherwise>
    </c:choose>
</div>

</body>
</html>
