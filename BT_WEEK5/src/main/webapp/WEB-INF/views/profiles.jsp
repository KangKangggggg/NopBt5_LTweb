<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Profile Update</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"/>
</head>
<body class="bg-light">

<div class="container mt-5">
    <!-- Thông báo -->
    <c:if test="${not empty message}">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            ${message}
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    </c:if>

    <div class="card shadow-lg border-0">
        <div class="card-header bg-primary text-white">
            <h4 class="mb-0">Update Profile</h4>
        </div>
        <div class="card-body">
            <form action="${pageContext.request.contextPath}/profile" 
                  method="post" enctype="multipart/form-data">

                <div class="mb-3">
                    <label class="form-label">Fullname</label>
                    <input type="text" name="fullname" class="form-control"
                           value="${profile.fullname}" required/>
                </div>

                <div class="mb-3">
                    <label class="form-label">Phone</label>
                    <input type="text" name="phone" class="form-control"
                           value="${profile.phone}" required/>
                </div>

                <div class="mb-3">
                    <label class="form-label">Profile Image</label><br>
                    <c:if test="${not empty profile.image}">
                        <img src="${pageContext.request.contextPath}/uploads/${profile.image}" 
                             alt="Profile Image" width="120" class="mb-3 rounded shadow-sm"><br>
                    </c:if>
                    <input type="file" name="image" class="form-control"/>
                </div>

                <button type="submit" class="btn btn-success px-4">💾 Save</button>
                <a href="${pageContext.request.contextPath}/index.jsp" 
                   class="btn btn-secondary ms-2">Cancel</a>
            </form>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
