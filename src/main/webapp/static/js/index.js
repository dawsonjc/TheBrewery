// JQUERY DEPENDENT SCRIPT

// potentially seek to lower the case
const AlcoholItem = {
    BEER: "beer",
    WINE: "wine",
    WHISKEY: "whiskey"
};

// TODO: We want to save this as a cookies maybe.
//  So that when the user returns to page we can load what they wanted to
//  Also will have to switch page number to be like this too (potentially)
let currentChoice = AlcoholItem.BEER;
let maxPage;
/**
 * It might be pertinent to make this better.
 */
class AlcoholData {
    constructor(type) {
        this.type = type;
    }

    async load(pageNum) {
        let data;
        try {
            data = await $.ajax({
                url: `${contextPath}/alcohol/get-alcohol-information/${this.type}?page=${pageNum}&size=10`,
                method: "GET",
                dataType: "json"
            });
        } catch(exception) {
            return false;
        }

        if(data.headers == null || data.body == null) {
            return false;
        }

        // don't load new headers if current type persists
        if(currentChoice !== this.type) {
            this.#loadHeaders(data.headers)
            maxPage = parseInt(data.body.totalPages);
        }

        this.#loadBody(data.body.content);
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
            let dataIndex = 3;
            // row
            $(this).children().each(function(index) {
                if(index === 0) {
                    $(this).text("Link");
                    return;
                }

                let value = content[dataIndex++].split("_")
                    .map((word) => {
                        return word.charAt(0).toUpperCase() + word.substring(1);
                    })
                    .join(" ");

                // td
                $(this).text(value);
            });
            dataColumn = 0;
            dataRow++;
        });

        return true;
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
                        newTag.attr("href", `${contextPath}/${self.type}/alcohol-entity?id=${value}`);
                        newTag.html(`<i class="fa fa-${self.type} fa-2x"></i>`)

                        $(this).html(newTag);
                        return;
                }

                // td
                $(this).text(value);
            });
            dataColumn = 0;
            dataRow++;
        });

        return true;
    }
}

const dataObjects = {
    beer: new AlcoholData(AlcoholItem.BEER),
    wine: new AlcoholData(AlcoholItem.WINE),
    whiskey: new AlcoholData(AlcoholItem.WHISKEY)
};

$(document).ready(function() {

    // buttons
    $("#beer-button").click(function() {
        if(currentChoice === AlcoholItem.BEER) {
            return;
        }
        if(dataObjects.beer.load(0) === null) {
            return;
        }
        $("#dropdownMenuButton").text("Switch items [Beer] ");

        currentChoice = AlcoholItem.BEER;
    });
    $("#wine-button").click(function() {
        if(currentChoice === AlcoholItem.WINE) {
            return;
        }
        dataObjects.wine.load(0);
        $("#dropdownMenuButton").text("Switch items [Wine] ");

        currentChoice = AlcoholItem.WINE;
    });
    $("#whiskey-button").click(function() {
        if(currentChoice === AlcoholItem.WHISKEY) {
            return;
        }
        dataObjects.whiskey.load(0);
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

