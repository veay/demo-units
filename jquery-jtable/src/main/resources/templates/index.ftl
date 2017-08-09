
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" name="viewport"
          content="width=device-width, initial-scale=1">
    <title>jquery-jtable</title>
    <script type="text/javascript" src="/lib/jquery-1.7.1.min.js"></script>
    <script type="text/javascript" src="/lib/jquery-ui.js"></script>
    <script type="text/javascript" src="/lib/jtable/jquery.jtable.js"></script>
    <script type="text/javascript" src="/lib/jtable/jquery.jtable.zh-CN.js"></script>
    <link type="text/css"  rel="stylesheet"  href="/lib/jtable/themes/lightcolor/blue/jtable.css">
    <script type="text/javascript">
        var jTable;
        $(function () {
            //审核列表
             jTable = $('.jtable').jtable({
                title: '发送列表',
                paging: true, //Enable paging
                pageSize: 10, //Set page size (default: 10)
                sorting: false, //Enable sorting
                messages: {
                    pagingInfo: '显示 {0}-{1}条   总共{2}条',
                    gotoPageLabel: '跳转到',
                    pageSizeChangeLabel: '每页显示',
                    loadingMessage: '数据加载中...',
                    editRecord: '详细',
                    noDataAvailable: '没有数据！'
                },
                actions: {
                    listAction: '/fetch'

                },
                fields: {
                    id: {
                        key: true,
                        create: false,
                        edit: false,
                        list: false
                    },
                    name: {
                        title: '姓名'
                    },
                    address: {
                        title: '地址'
                    },
                    time: {
                        title: '时间'
                    }
                }, recordsLoaded: function (event, data) {

                }

            });

            fetch();
        });
        function fetch() {
            jTable.jtable("load",{});
        }
    </script>
</head>
<body>


<div class="jtable"></div>



</body>
</html>