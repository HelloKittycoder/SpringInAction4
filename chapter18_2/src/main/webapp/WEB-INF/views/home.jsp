<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Title</title>
</head>
<body>
Hello, World!
<button id="stop">Stop</button>
<div id="output"></div>
<script type="text/javascript" src="${pageContext.request.contextPath}/webjars/sockjs-client/0.3.4/sockjs.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/webjars/stomp-websocket/2.3.0/stomp.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/webjars/jquery/2.0.3/jquery.js"></script>
<script type="text/javascript">

    (function(win) {
        var getContextPath = function () {
            // 比如：当前的网址是 http://localhost:8080/test/

            // 查找算法：在href中找到host字符串所处的位置，
            // 然后截取从该位置的后一个/（包含）至下一个/（不包含）之间的字符串
            var host = window.location.host; // localhost:8080
            var href= window.location.href; // http://localhost:8080/test/
            var index;
            if ((index = href.indexOf(host)) > -1) {
                index += host.length;
                var lastSlashIndex = href.lastIndexOf("/");
                var tmp = href.substring(index, lastSlashIndex);
                // 去掉右侧结尾的的所有/（参考链接：https://www.jb51.net/article/126580.htm）
                return tmp.replace(/\/*$/g, "");
            } else {
                return "";
            }
        }

        var log = function() {
            if (window.console && window.console.log) {
                try {
                    window.console.log.apply(null, arguments);
                } catch (e) {
                }
            }
        }

        win.MyUtil = {
            getContextPath : getContextPath,
            log : log
        };
    })(window);

    // 说明：以下两种声明SockJS的方法都可以
    var sock = new SockJS(MyUtil.getContextPath() + '/marcopolo');
    // var sock = new SockJS("http://" + window.location.host + MyUtil.getContextPath() + '/marcopolo');
    var stomp = Stomp.over(sock);

    stomp.connect('guest', 'guest', function (frame) {
        MyUtil.log('Opening')
        stomp.subscribe("/topic/marco", handlePolo);
        sayMarco();
    });

    function handlePolo(message) {
        MyUtil.log('Received: ', message);
        $("#output").append("<b>Received: " +
            JSON.parse(message.body).message + "</b><br/>");
        if (JSON.parse(message.body).message === 'Polo!') {
            setTimeout(function () {sayMarco()}, 2000);
        }
    }

    function sayMarco() {
        MyUtil.log('Sending Marco!');
        // 发送消息
        stomp.send("/app/marco", {},
            JSON.stringify({ 'message': 'Marco!' }));
        $("#output").append("<b>Send: Marco!</b><br/>");
    }

    $("#stop").click(function () {
        sock.close();
    });
</script>
</body>
</html>
