<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
    <title>Add ToDo</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">

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
            <fieldset class="form-group">
                <form:label path="desc">Target Date</form:label>
                <form:input path="targetDate" type="text"
                            class="form-control" required="required"/>
                <form:errors path="targetDate" cssClass="text-warning"/>
            </fieldset>
            <div class="btn-toolbar btn-group-sm">
                <button type="submit" class="btn btn-success">Add</button>
                <a href="/list-todos" id="cancel" name="cancel"
                   class="btn btn-primary">Cancel</a>
            </div>
        </form:form>

        <script src="webjars/jquery/2.1.4/jquery.min.js"></script>
        <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <script src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
            $('#targetDate').datepicker({
                format : 'dd/mm/yyyy'
            });
        </script>
    </div>
</body>
</html>