// JQUERY DEPENDENT SCRIPT
const AlcoholItem = {
    BEER: "BEER",
    WINE: "WINE",
    WHISKEY: "WHISKEY"
}

// TODO: We want to save this as a cookies maybe.
//  So that when the user returns to page we can load what they wanted to
//  Also will have to switch page number to be like this too (potentially)
let currentChoice = AlcoholItem.BEER;

$(document).ready(function() {
    $("#beer-button").click(function() {
        if(currentChoice === AlcoholItem.BEER) {
            return;
        }

        currentChoice = AlcoholItem.BEER;
        $("#dropdownMenuButton").text("Switch items [Beer]");

        let data = new AlcoholData(
            "beer",
            "GET"
        );

        data.start();
    });
    $("#wine-button").click(function() {
        if(currentChoice === AlcoholItem.WINE) {
            return;
        }

        currentChoice = AlcoholItem.WINE;
        $("#dropdownMenuButton").text("Switch items [Wine]");

        let data = new AlcoholData(
            "wine",
            "GET"
        );
        data.start();
    });

    $("#whiskey-button").click(function() {
        if(currentChoice === AlcoholItem.WHISKEY) {
            return;
        }

        currentChoice = AlcoholItem.WHISKEY;
        $("#dropdownMenuButton").text("Switch items [Whiskey]");

        let data = new AlcoholData(
            currentChoice.toLowerCase(),
            "GET"
        );
        data.start();
    });

    $("[data-toggle='popover']").popover({
        container: "body",
        trigger: "click",
        html: true,
        content: function() {
            return $("#popover-content").html();
        }
    });

    $(".dropdown").on("hidden.bs.dropdown", function() {
        $("[data-toggle='popover']").popover("hide");
    });
});



// TODO: scrap
class AlcoholData {
    constructor(type, method) {
        this.alcoholType = type;
        this.method = method;
        this.icon = "fa-wrench"; // default icon in case of failure
    }

    #loadHead(endpoint) {
        let url = contextPath + endpoint;
        this.#loadCells("#alcohol-thead", url)
    }

    #loadBody(endpoint) {
        let url = contextPath + endpoint;
        this.#loadCells("#alcohol-tbody", url);
    }

    #loadCells(target, url) {
        let icon = this.icon;
        let alcoholType = this.alcoholType;
        $.ajax({
            url: url,
            type: this.method
        }).then(function(data) {
            let content = data.content;
            let dataRow = 0;
            let dataColumn = 0;

            // for each row in target element
            $(target).children("tr").each(
                function() {
                    // make sure that we don't create more rows than records retrieved
                    if(content.length <= dataRow) {
                        $(this).text("");
                        return;
                    }

                    let values = Object.values(content[dataRow]); // extract data from record
                    let valuesIndex = 0;

                    // for each cell in row
                    $(this).children("td").each(
                        function(index) {
                            // get value than increment index
                            let value = values[valuesIndex++];

                            switch(index) {
                                case 0:
                                    // construct action link
                                    let newTag = $("<a>");

                                    newTag.attr("href", `${contextPath}/alcohol/${alcoholType}?id=${value}`);

                                    newTag.html(`<i class=\"fa ${icon} fa-2x\"></i>`)

                                    $(this).append(newTag);
                                    return;
                            }

                            // cell
                            $(this).text(value);
                        }
                    );

                    // next row and column 0
                    dataColumn = 0;
                    dataRow++;
                }
            );
        });
    }


    start() {
        let theadEndPoint;
        let tbodyEndPoint;

        // TODO: might have to switch size to a variable
        switch(this.alcoholType) {
            case "beer":
                this.icon = "fa-beer";
                theadEndPoint = "alcohol/get-beer-columns";
                tbodyEndPoint = `alcohol/get-beer-page?page=${pageNum}&size=10`
                break;
            case "whiskey":
                this.icon = "fa-whiskey-glass";
                theadEndPoint = "";
                tbodyEndPoint = `alcohol/get-whiskey-page?page=${pageNum}&size=10`
                break;
            case "wine":
                this.icon = "fa-wine-glass";
                theadEndPoint = "alcohol/get-wine-columns";
                tbodyEndPoint = `alcohol/get-wine-page?page=${pageNum}&size=10`
                break;
        }

        // might be a bad implementation
        this.#loadHead(theadEndPoint);
        this.#loadBody(tbodyEndPoint);
    }
}