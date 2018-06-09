<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
    <title>Add ToDo</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet">
</head>
<body>

    <div class="container">
        Add a Todo for ${name}
        <form:form method="post" commandName="todo">
            <form:hidden path="id"/>
            <fieldset class="form-group">
                <form:label path="desc">Description</form:label>
                <form:input path="desc" type="text"
                            class="form-control" required="required"/>
                <form:errors path="desc" cssClass="text-warning"/>
            </fieldset>
            <div class="btn-toolbar btn-group-sm">
                <button type="submit" class="btn btn-success">Add</button>
                <a href="/list-todos" id="cancel" name="cancel"
                   class="btn btn-primary">Cancel</a>
            </div>
        </form:form>

        <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
        <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </div>
</body>
</html>