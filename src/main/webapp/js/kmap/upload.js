//上传知识图谱
function execClick() {
    $("#kmUploadForm").submit();
    //uploadKmaps();
}

function uploadKmaps() {
    $("#kmUploadForm").ajaxForm({
        //定义返回JSON数据，还包括xml和script格式
        //clearForm Boolean值属性，表示是否在表单提交成功后情况表单数据
        //dataType 提交成果后返回的数据格式，可选值包括xml，json或者script
        //target 服务器返回信息去更新的页面对象，可以是jquery选择器字符串或者jquer对象或者DOM对象。
        //type 提交类型可以是”GET“或者”POST“
        //url 表单提交的路径
        type: 'post',
        url: '../kmap/kmupload',
        dataType: 'json',
        resetForm: true,
        beforeSubmit: function () {
            //文件名
            var fnn = $("#uploadFile").val();
            if (fnn == null || fnn == '') {
                alert("请选择要上传的文件");
                return false;
            }
            //获取后几位的位数
            var pos = fnn.lastIndexOf(".");
            //截取文件名
            var lastname = fnn.substring(pos, fnn.length);
            //转为小写
            var resultName = lastname.toLowerCase();
            //判断文件后缀
            if ('.xls' != resultName.toString() && '.xlsx' != resultName.toString()) {
                alert('只能上传Excel文件，您上传的文件类型为' + lastname + '，请重新上传');
                return false;
            }
        },
        success: function (data) {
            $("#result_message").val(data);
        }, error: function (e) {
            alert(e);
        }
    });
    $('#kmUploadForm').submit(function () {

        $(this).ajaxSubmit(options);
    });
}

uploadKmaps();


function checkFileType(str) {
    var pos = str.lastIndexOf(".");
    var lastname = str.substring(pos, str.length);
    var resultName = lastname.toLowerCase();
    if ('.xls' != resultName.toString()) {
        alert('只能上传xls文件，您上传的文件类型为' + lastname + '，请重新上传');
        resetFile();
    }
}
