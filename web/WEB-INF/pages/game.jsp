<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.game.GameField" %>
<%@ page import="com.game.Direction" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% GameField gameField = (GameField) request.getAttribute("gameField"); %>
<html>
<head>
    <title></title>
</head>
<body>
    <h1>game.jsp</h1>
    <h1>${hello}</h1>

    <div>
        <%for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {%>
                <%=gameField.getCell(i, j).getValue() + " "%>
            <%}%>
            </br>
        <%}%>
    </div>

    <form id="key" action="1" method="POST">
        <input type="hidden" name="_method" value="POST">
        <input type="submit" hidden>
    </form>

    <script>

        window.onkeyup = function(e) {
            var key = e.keyCode ? e.keyCode : e.which;
            if ([37, 38, 39, 40].indexOf(key) != -1){
                var formSubmit = document.getElementById("key");
                formSubmit.action = key;
                formSubmit.submit();
            }

            /*var xhr = new XMLHttpRequest();
            xhr.open("GET", "/", true);
            xhr.send(key);

            if (xhr.status == 200){

            }*/

            $(document).ready(function(){
                $("#test").click(function(){
                    $.get("/ajaxtest",function(data,status){
                        alert("Data: " + data + "\nStatus: " + status);
                    });
                });
            });
        }
    </script>

</body>
</html>