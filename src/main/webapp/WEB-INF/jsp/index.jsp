<!DOCTYPE html>
<html>
<% String title = "The Brewery"; %>
<%@ include file="header.jsp"%>
<body>
    <script type="text/javascript">
        let pageNum = 0;
        maxPage = <%= request.getAttribute("totalPages") %>;

        function back() {
            if((pageNum - 1) < 0) {
                return;
            }

            switch(currentChoice) {
                case AlcoholItem.BEER:
                    dataObjects.beer.load(pageNum--);
                    break;
                case AlcoholItem.WHISKEY:
                    dataObjects.whiskey.load(pageNum--);
                    break;
                case AlcoholItem.WINE:
                    dataObjects.wine.load(pageNum--);
                    break;
            }
        }

        function next() {
            if((pageNum + 1) >= maxPage) {
                return;
            }

            switch(currentChoice) {
                case AlcoholItem.BEER:
                    dataObjects.beer.load(pageNum++);
                    break;
                case AlcoholItem.WHISKEY:
                    dataObjects.whiskey.load(pageNum++);
                    break;
                case AlcoholItem.WINE:
                    dataObjects.wine.load(pageNum++);
                    break;
            }
        }

        dataObjects.beer.load(pageNum);
    </script>
    <style type="text/css">
        .popover {
            max-width: 200px;
            padding: 10px;
            background-color: #fff;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.3);
        }
    </style>
    <div class="row">
        <div class="col-lg-2">
            <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Switch items [Beer]
                </button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <a class="dropdown-item" href="#" id="beer-button">Beer</a>
                    <a class="dropdown-item" href="#" id="wine-button">Wine</a>
                    <a class="dropdown-item" href="#" id="whiskey-button">Whiskey</a>
                    <a class="dropdown-item" href="#" data-toggle="popover" data-placement="left" data-target="#popover-content" onclick="event.stopPropagation();">Popover</a>
                </div>
            </div>
            <div id="popover-content" style="display:none;">
                <div class="container-fluid">
                    <div class="row"><a class="dropdown-item btn" href="#">Bread</a></div>
                    <div class="row"><a class="dropdown-item btn" href="#">Grain</a></div>
                </div>
            </div>
            <div class="col-lg-10"></div>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <table class="table table-striped table-hover">
                <thead id="alcohol-thead">
                <tr>
                    <td>Link</td>
                    <td>Name</td>
                    <td>Alcohol Content</td>
                    <td>Color</td>
                    <td>Style</td>
                    <td>Size</td>
                </tr>
                </thead>
                <tbody id="alcohol-tbody">
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
                <tfoot id="alcohol-tfoot">
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td style="text-align:right"><button onclick="back()">back</button></td>
                    <td style="text-align:right"><button onclick="next()">next</button></td>
                </tr>
                </tfoot>
            </table>
        </div>
    </div>
</body>
<%@ include file="footer.jsp" %>
</html>