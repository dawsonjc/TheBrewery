<!DOCTYPE html>
<html>
<% String title = "The Brewery"; %>
<%@ include file="header.jsp"%>
<body>
    <script type="text/javascript">
        let pageNum = 0;
        let maxPage = null;

        async function getPage(page, size) {
            $.ajax({
                url: `${pageContext.request.contextPath}/account/getUsers?page=\${page}&size=\${size}&sort=id`,
                type: "GET"
            }).then(function(data) {
                if(maxPage === null) {
                    data.totalPages = maxPage;
                }

                let content = data.content;
                let dataRow = 0;
                let dataColumn = 0;

                // tbody
                $("#beerTable").children("tr").each(
                    function() {
                        if(content.length <= dataRow) {
                            return;
                        }
                        let dataIndex = 0;
                        let values = Object.values(content[dataRow]);

                        // row
                        $(this).children().each(
                            function(index) {
                                if(index === 0) {
                                    return;
                                }
                                // td
                                $(this).text(values[dataIndex++]);
                            }
                        );
                        dataColumn = 0;
                        dataRow++;
                    }
                );
            }).catch(function(error) {});
        }

        function back() {
            if((pageNum - 1) < 0) {
                return;
            }

            getPage(pageNum--, 10)
        }

        function next() {
            if((pageNum + 1) > maxPage) {
                return;
            }

            getPage(pageNum++, 10)
        }
        getPage(pageNum, 10)
    </script>

    <table class="table table-striped table-hover">
        <thead>
            <tr>
                <td>link</td>
                <td>Id</td>
                <td>User_Type</td>
                <td>First Name</td>
                <td>Last Name</td>
                <td>Username</td>
            </tr>
        </thead>
        <tbody id="beerTable">
            <tr id="row-0">
                <td id="row-0-col-0"></td>
                <td id="row-0-col-1"></td>
                <td id="row-0-col-2"></td>
                <td id="row-0-col-3"></td>
                <td id="row-0-col-4"></td>
                <td id="row-0-col-5"></td>
            </tr>
            <tr id="row-1">
                <td id="row-1-col-0"></td>
                <td id="row-1-col-1"></td>
                <td id="row-1-col-2"></td>
                <td id="row-1-col-3"></td>
                <td id="row-1-col-4"></td>
                <td id="row-1-col-5"></td>
            </tr>
            <tr id="row-2">
                <td id="row-2-col-0"></td>
                <td id="row-2-col-1"></td>
                <td id="row-2-col-2"></td>
                <td id="row-2-col-3"></td>
                <td id="row-2-col-4"></td>
                <td id="row-2-col-5"></td>
            </tr>
            <tr id="row-3">
                <td id="row-3-col-0"></td>
                <td id="row-3-col-1"></td>
                <td id="row-3-col-2"></td>
                <td id="row-3-col-3"></td>
                <td id="row-3-col-4"></td>
                <td id="row-3-col-5"></td>
            </tr>
            <tr id="row-4">
                <td id="row-4-col-0"></td>
                <td id="row-4-col-1"></td>
                <td id="row-4-col-2"></td>
                <td id="row-4-col-3"></td>
                <td id="row-4-col-4"></td>
                <td id="row-4-col-5"></td>
            </tr>
            <tr id="row-5">
                <td id="row-5-col-0"></td>
                <td id="row-5-col-1"></td>
                <td id="row-5-col-2"></td>
                <td id="row-5-col-3"></td>
                <td id="row-5-col-4"></td>
                <td id="row-5-col-5"></td>
            </tr>
            <tr id="row-6">
                <td id="row-6-col-0"></td>
                <td id="row-6-col-1"></td>
                <td id="row-6-col-2"></td>
                <td id="row-6-col-3"></td>
                <td id="row-6-col-4"></td>
                <td id="row-6-col-5"></td>
            </tr>
            <tr id="row-7">
                <td id="row-7-col-0"></td>
                <td id="row-7-col-1"></td>
                <td id="row-7-col-2"></td>
                <td id="row-7-col-3"></td>
                <td id="row-7-col-4"></td>
                <td id="row-7-col-5"></td>
            </tr>
            <tr id="row-8">
                <td id="row-8-col-0"></td>
                <td id="row-8-col-1"></td>
                <td id="row-8-col-2"></td>
                <td id="row-8-col-3"></td>
                <td id="row-8-col-4"></td>
                <td id="row-8-col-5"></td>
            </tr>
            <tr id="row-9">
                <td id="row-9-col-0"></td>
                <td id="row-9-col-1"></td>
                <td id="row-9-col-2"></td>
                <td id="row-9-col-3"></td>
                <td id="row-9-col-4"></td>
                <td id="row-9-col-5"></td>
            </tr>
        </tbody>
        <tfoot>
            <tr>
                <td>null</td>
                <td>null</td>
                <td>null</td>
                <td>null</td>
                <td style="text-align:right"><button onclick="back()">back</button></td>
                <td style="text-align:right"><button onclick="next()">next</button></td>
            </tr>
        </tfoot>
    </table>
</body>
<%@ include file="footer.jsp" %>
</html>