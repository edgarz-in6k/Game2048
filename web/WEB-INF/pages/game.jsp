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

    <%--<form id="formSubmit" action="/move" method="POST" >
        <input type="hidden" name="key" id="key" value="1"/>
        <input type="submit" value="Submit"/>
    </form>--%>
    <form id="key" action="1" method="POST">
        <input type="hidden" name="_method" value="POST">
        <input type="submit">
    </form>

    <script>

        window.onkeyup = function(e) {
            var key = e.keyCode ? e.keyCode : e.which;
            if ((key == 37) || (key == 38) || (key == 39) || (key == 40)){
                var formSubmit = document.getElementById("key");
                formSubmit.action = key;
                formSubmit.submit();
            }

            /*var xhr = new XMLHttpRequest();
            xhr.open("GET", "/", true);
            xhr.send(key);

            if (xhr.status == 200){

            }*/

            <%--<%Direction direction;%>
            switch (key){
                case 37:
                    <%direction = Direction.LEFT;%>
                    break;
                case 38:
                    <%direction = Direction.UP;%>
                    break;
                case 39:
                    <%direction = Direction.RIGHT;%>
                    break;
                case 40:
                    <%direction = Direction.DOWN;%>
                    break;
            }--%>
        }
    </script>

</body>
</html>