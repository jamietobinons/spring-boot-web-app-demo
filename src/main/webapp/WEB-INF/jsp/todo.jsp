<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
    <title>Add ToDo</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet">
</head>
<body>

    <div class="container">
        Add a todo for ${name}
        <form:form method="post" commandName="todo">
            <fieldset class="form-group">
                <form:label path="desc">Description</form:label>
                <form:input path="desc" type="text"
                            class="form-control" required="required"/>
                <button type="submit" class="btn-success">Add</button>
                <button type="reset" class="btn-danger">Cancel</button>
            </fieldset>
        </form:form>


        <a href="/list-todos">Cancel</a>
        <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
        <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </div>
</body>
</html>