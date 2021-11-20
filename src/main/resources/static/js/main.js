$(document).ready(function(){
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