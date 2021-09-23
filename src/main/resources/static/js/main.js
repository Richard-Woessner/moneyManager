$(document).ready(function(){
    $("#incomeBtn").click(function() {
        //alert( "Handler for .click() called." );

        $('#incomeColumn').append('<div class="card-body">\n' +
            '                                        <div class="input-group mb-3">\n' +
            '                                            <span class="input-group-text">$</span>\n' +
            '                                            <input type="text" class="form-control" aria-label="Amount (to the nearest dollar)">\n' +
            '                                            <span class="input-group-text">.00</span>\n' +
            '                                        </div>\n' +
            '\n' +
            '                                        <div class="input-group mb-3">\n' +
            '                                            <textarea id="form21" class="md-textarea form-control" rows="2" placeholder="Description"></textarea>\n' +
            '                                        </div>\n' +
            '                                    </div>');
    });

    $("#expensesBtn").click(function() {
        //alert( "Handler for .click() called." );

        $('#expenseColumn').append('<div class="card-body">\n' +
            '                                        <div class="input-group mb-3">\n' +
            '                                            <span class="input-group-text">$</span>\n' +
            '                                            <input type="text" class="form-control" aria-label="Amount (to the nearest dollar)">\n' +
            '                                            <span class="input-group-text">.00</span>\n' +
            '                                        </div>\n' +
            '\n' +
            '                                        <div class="input-group mb-3">\n' +
            '                                            <textarea id="form21" class="md-textarea form-control" rows="2" placeholder="Description"></textarea>\n' +
            '                                        </div>\n' +
            '                                    </div>');
    });

    function calcTotal() {
        let income = $('#incomeTotal').attr("placeholder");
        let expence = $('#expensesTotal').attr("placeholder");
        let total = parseInt(income)-parseInt(expence);
        $('#netTotal').attr("placeholder",total);
    }

    $('#incomeColumn').keyup(function() {
        let total = 0;
        $("form#incomeColumn :input[type=text]").each(function () {
            let input = $(this); // This is the jquery object of the input, do what you will
            if(input.val()) {
                total = total + parseInt(input.val());
            }
            $('#incomeTotal').attr("placeholder",total);

        });
        calcTotal();
    });
    $('#expenseColumn').keyup(function() {
        let total = 0;
        $("form#expenseColumn :input[type=text]").each(function () {
            let input = $(this); // This is the jquery object of the input, do what you will
            if(input.val()) {
                total = total + parseInt(input.val());
            }
            $('#expensesTotal').attr("placeholder",total);
        });
        calcTotal()
    });
});