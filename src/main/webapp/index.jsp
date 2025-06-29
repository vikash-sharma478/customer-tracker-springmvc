<%-- 
    Homepage for CRM Application 
    Customized by Vikash Kumar | Based on Spring MVC + Hibernate 
--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CRM Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
          crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/assets/stylesheet/styles.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/assets/images/favicon.png" rel="icon">
</head>
<body>
<div id="main">
    <img id="favicon" src="${pageContext.request.contextPath}/assets/images/favicon.png" alt="CRM Logo"/>
    <h1 class="index-heading">Welcome</h1>
    <h2>Your Smart Customer Management Tool</h2>
    <h2 class="mt-2">CRM - Customer Relationship Management</h2>
    <h3 class="stack mt-3">
        Built with
        <span class="badge bg-secondary">Spring MVC</span> +
        <span class="badge bg-secondary">Hibernate</span>
    </h3>
    <a href="${pageContext.request.contextPath}/customer/list" class="btn btn-primary btn-lg mt-4">
        View Customers
    </a>
</div>
</body>
</html>
