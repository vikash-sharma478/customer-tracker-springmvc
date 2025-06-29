<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Customer</title>
    
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    
    <!-- Custom Stylesheet -->
    <link href="${pageContext.request.contextPath}/assets/stylesheet/styles.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/assets/images/favicon.png" rel="icon">
</head>
<body>

<div id="addForm">
    <div class="bg-secondary bg-gradient text-center">
        <h1 class="pt-3 pb-3 text-white">Add Customer</h1>
    </div>

    <form:form class="form-container p-4" action="${pageContext.request.contextPath}/customer/save"
               method="POST" modelAttribute="customer">

        <div class="input-group mb-3">
            <span class="input-group-text">First Name</span>
            <form:input path="firstName" cssClass="form-control" />
            <form:errors path="firstName" cssClass="error ps-5 text-danger" />
        </div>

        <div class="input-group mb-3">
            <span class="input-group-text">Last Name</span>
            <form:input path="lastName" cssClass="form-control" />
            <form:errors path="lastName" cssClass="error ps-5 text-danger" />
        </div>

        <div class="input-group mb-3">
            <span class="input-group-text">Email</span>
            <form:input path="email" cssClass="form-control" />
            <form:errors path="email" cssClass="error ps-5 text-danger" />
        </div>

        <input type="submit" class="btn btn-primary" value="Submit" />
    </form:form>
</div>

</body>
</html>
