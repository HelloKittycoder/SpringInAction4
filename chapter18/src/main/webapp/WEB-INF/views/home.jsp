<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Title</title>
</head>
<body>
Hello, World!${pageContext.request.contextPath}
<button id="stop">Stop</button>
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

    var url = 'ws://' + window.location.host + MyUtil.getContextPath() + '/marco';
    var sock = new WebSocket(url); // 打开WebSocket
    sock.onopen = function () { // 处理连接开启事件
        MyUtil.log('Openinig')
        sayMarco();
    }

    sock.onmessage = function (e) { // 处理消息
        MyUtil.log('Received message: ', e.data);
        setTimeout(function () {
            sayMarco();
        }, 2000);
    }

    sock.onclose = function () { // 处理连接关闭事件
        MyUtil.log('Closing');
    }

    function sayMarco() {
        MyUtil.log('Sending Marco!');
        // 发送消息
        sock.send("Marco!")
    }

    document.getElementById('stop').onclick = function () {
        sock.close();
    }
</script>
</body>
</html>
