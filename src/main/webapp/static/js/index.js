// JQUERY DEPENDENT SCRIPT
const AlcoholItem = {
    BEER: "BEER",
    WINE: "WINE",
    WHISKEY: "WHISKEY"
};

// TODO: We want to save this as a cookies maybe.
//  So that when the user returns to page we can load what they wanted to
//  Also will have to switch page number to be like this too (potentially)
let currentChoice = AlcoholItem.BEER;

/**
 * It might be pertinent to make this better.
 */
class AlcoholData {
    constructor(type) {
        this.type = type;
    }

    async load(pageNum) {
        let headers;
        let data;
        try {
            headers = await $.ajax({
                url: `${contextPath}/alcohol/get-${this.type}-columns`,
                method: "GET",
                dataType: "json"
            });
            data = await $.ajax({
                url: `${contextPath}/alcohol/get-${this.type}-page?page=${pageNum}&size=10`,
                method: "GET",
                dataType: "json"
            }).catch();
        } catch(exception) {

        }

        this.#loadHeaders(headers.content);
        this.#loadBody(data.content);
    }

    #loadHeaders(content) {
        let dataRow = 0;
        let dataColumn = 0;
        // head
        $("#alcohol-thead").children("tr").each(function() {
            if(content.length <= dataRow) {
                $(this).text("");
                return;
            }
            let dataIndex = 0;
            let values = Object.values(content[dataRow]);
            // row
            $(this).children().each(function(index) {
                if(index === 0) {
                    return;
                }
                let value = values[dataIndex++];

                // td
                $(this).text(value);
            });
            dataColumn = 0;
            dataRow++;
        });
    }

    #loadBody(content) {
        const self = this;
        let dataRow = 0;
        let dataColumn = 0;
        // tbody
        $("#alcohol-tbody").children("tr").each(function() {
            if(content.length <= dataRow) {
                $(this).text("");
                return;
            }

            let dataIndex = 0;
            let values = Object.values(content[dataRow]);
            // row
            $(this).children().each(function(index) {
                let value = values[dataIndex++];
                switch(index) {
                    case 0:
                        let newTag = $("<a>");
                        newTag.attr("href", `${contextPath}/alcohol-entity?id=${value}`);
                        newTag.html(`<i class="fa fa-${self.type} fa-2x"></i>`)

                        $(this).append(newTag);
                        return;
                }

                // td
                $(this).text(value);
            });
            dataColumn = 0;
            dataRow++;
        });
    }
}

$(document).ready(function() {
    const beerData = new AlcoholData(AlcoholItem.BEER.toLowerCase());
    const wineData = new AlcoholData(AlcoholItem.WINE.toLowerCase());
    const whiskeyData = new AlcoholData(AlcoholItem.WHISKEY.toLowerCase());

    $("#beer-button").click(function() {
        if(currentChoice === AlcoholItem.BEER) {
            return;
        }
        if(beerData.load(0) === null) {
            return;
        }
        $("#dropdownMenuButton").text("Switch items [Beer] ");

        currentChoice = AlcoholItem.BEER;
    });
    $("#wine-button").click(function() {
        if(currentChoice === AlcoholItem.WINE) {
            return;
        }
        wineData.load(0);
        $("#dropdownMenuButton").text("Switch items [Wine] ");

        currentChoice = AlcoholItem.WINE;
    });

    $("#whiskey-button").click(function() {
        if(currentChoice === AlcoholItem.WHISKEY) {
            return;
        }
        whiskeyData.load(0);
        $("#dropdownMenuButton").text("Switch items [Whiskey] ");
        currentChoice = AlcoholItem.WHISKEY;


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

