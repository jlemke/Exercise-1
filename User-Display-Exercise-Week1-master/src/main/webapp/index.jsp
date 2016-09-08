<%@include file="head.jsp"%>
<html>
<body>
<h2>User Display Exercise - Week 1</h2>
<form action="${pageContext.request.contextPath}/searchUser" method="get">
    <div class=".col-md-offset-1">
        <div class="form-group row">
            <label for="id-input" class="col-xs-2 col-form-label">User Id</label>
            <div class="col-xs-10">
                <input class="form-control" name="userid" type="text"id="id-input">
            </div>
        </div>
        <div class="form-group row">
            <label for="first-name-input" class="col-xs-2 col-form-label">First Name</label>
            <div class="col-xs-10">
                <input class="form-control" name="firstName" type="text"id="first-name-input">
            </div>
        </div>
        <div class="form-group row">
            <label for="last-name-input" class="col-xs-2 col-form-label">Last Name</label>
            <div class="col-xs-10">
                <input class="form-control" name="lastName" type="text"id="last-name-input">
            </div>
        </div>
        <div class="form-group row">
            <label for="age-input" class="col-xs-2 col-form-label">Age</label>
            <div class="col-xs-10">
                <input class="form-control" name="age" type="text"id="age-input">
            </div>
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</body>
</html>
