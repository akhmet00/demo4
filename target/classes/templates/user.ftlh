<!Doctype html>
<html>
<head>
    <title>MyBatis</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <style>
        .container{
            margin-top: 10px;
            max-width: 750px;
            margin-right: 350px;
        }
        .container1 {
            margin-top: 10px;
            max-width:750px;
        }
    </style>

</head>
<body>

<div class="container">

    <h5>User list</h5>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Company name</th>
        </tr>
        </thead>
        <tbody>
        <#list users as us>
            <tr>
                <td>${us.id}</td>
                <td>${us.userName}</td>
                <td>${us.companyname}</td>
                <td>
                    <form action="/admin/users/delete/${us.userName}" method="post">
                        <button class="btn btn-danger btn-sm" type="submit">Delete</button>
                    </form>

                </td>
            </tr>
        </#list>
        </tbody>
    </table>
    <div class="container1">
        <div id ="insertuser">
            <h5>Add New User</h5>
            <form action="/admin/users/insert" method="post"  id="insert_form">
                Username:<br/>
                <input type="text" class="form-control" name="userName" required/>
                <br/>
                Password:<br/>
                <input type="text" class="form-control" name="password" required/>
                <br/>
                Company Name:<br/>
                <input type="text" class="form-control" name="companyname" required/>
                <br/>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form><br>
            <form action="/logout">
                <button type="submit" class="btn btn-primary">Log out</button>
            </form>
        </div>
    </div>
</div>
<div class="col-sm-7" id="postResultDiv">
</div>

</body>
</html>