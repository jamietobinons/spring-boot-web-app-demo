<%@include file="../common/header.jspf"%>
<%@include file="../common/navigation.jspf"%>
<div class="container">
    <font color="red">${loginErrorMessage}</font>
    <form method="post">
        Name : <input type="text" name="name" value="test" />
        Password : <input type="password" name="password" value="test"/>
        <input type="submit" />
    </form>
</div>
<%@include file="../common/footer.jspf"%>
