<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no, minimal-ui">
	<meta content="yes" name="apple-mobile-web-app-capable">
	<meta content="black" name="apple-mobile-web-app-status-bar-style">
	<meta content="telephone=no" name="format-detection">
	<meta content="email=no" name="format-detection">
</head>
<body>
123
<input type="file" name="fileData" id="fileId" />
</body>
</html>

<script src="js/jquery.min.js"></script>
<script src="js/ajaxfileupload.js"></script>

<script type="text/javascript">
    // 文件上传
    $(document).on('change', "input[type='file']", function () {
        upload(this.id);
    });

    function upload(id) {
        $.ajaxFileUpload({
            url: "/zzg/upload",
            type: "post",
            fileElementId: id,
            dataType: 'json',
            success: function (result) {
                result = eval('(' + result + ')');
                if (result.code != 0) {
                    alert(result.msg);
                    return;
                }
                alert(result.t);
            },
            error: function () {
				alert("上传异常！");
            }
        });
    }
</script>
