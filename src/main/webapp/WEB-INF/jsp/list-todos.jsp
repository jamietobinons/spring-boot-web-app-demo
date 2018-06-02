<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Todo's for ${name}</title>
</head>
<body>
    <h1>Your todos</h1>
    <table>
        <caption>Your Todos</caption>
        <thead>
            <tr>
                <th>Description</th>
                <th>Target Date</th>
                <th>Completed?</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${toDos}" var="todo">
                <tr>
                    <td>${todo.desc}</td>
                    <td>${todo.targetDate}</td>
                    <td>${todo.done}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="/add-todo">Add a ToDo</a>
</body>
</html>