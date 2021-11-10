$(document).ready(function(){
    $("#incomeBtn").click(function() {
        //alert( "Handler for .click() called." );

        $('#incomeColumn').append('<form class="card input-group mb-3" id="incomeColumn" th:action="@{/addIncomeEntry}" th:object="${income}" method="GET">\n' +
            '                                    <div class="card-body">\n' +
            '                                        <div class="input-group mb-3">\n' +
            '                                            <div class="input-group-prepend">\n' +
            '                                                <span class="input-group-text">Income Source</span>\n' +
            '                                            </div>\n' +
            '                                            <input class="form-control" id="source" th:field="*{source}" type="text" placeholder="E.g., Employment, Retirement, etc." aria-describedby="inputGroup-sizing-default">\n' +
            '                                        </div>\n' +
            '                                        <div class="input-group mb-3">\n' +
            '                                            <div class="input-group-prepend">\n' +
            '                                                <span class="input-group-text">ID</span>\n' +
            '                                            </div>\n' +
            '                                            <input class="form-control" id="incomeID" th:field="*{incomeID}" type="number" placeholder="Please enter a number" aria-describedby="inputGroup-sizing-default">\n' +
            '                                        </div>\n' +
            '                                        <div class="input-group mb-3">\n' +
            '                                            <div class="input-group-prepend">\n' +
            '                                                <span class="input-group-text">Amount $</span>\n' +
            '                                            </div>\n' +
            '                                            <input class="form-control" id="amount" th:field="*{amount}" type="text" placeholder="0.00" aria-describedby="inputGroup-sizing-default">\n' +
            '                                        </div>\n' +
            '                                        <div class="input-group mb-3">\n' +
            '                                            <div class="input-group-prepend">\n' +
            '                                                <span class="input-group-text">Frequency in Days</span>\n' +
            '                                            </div>\n' +
            '                                            <input class="form-control" id="frequency" th:field="*{frequency}" type="number" placeholder="E.g., 7, 14, 30, etc." aria-describedby="inputGroup-sizing-default">\n' +
            '                                        </div>\n' +
            '                                        <div class="input-group mb-3">\n' +
            '                                            <div class="input-group-prepend">\n' +
            '                                                <span class="input-group-text">Next Deposit Date</span>\n' +
            '                                            </div>\n' +
            '                                            <input class="form-control" id="depositDate" th:field="*{depositDate}" type="date" aria-describedby="inputGroup-sizing-default">\n' +
            '                                        </div>\n' +
            '\n' +
            '                                        <div class="input-group mb-3">\n' +
            '                                            <textarea class="md-textarea form-control" rows="2" id="note" th:field="*{note}" placeholder="Description"></textarea>\n' +
            '                                        </div>\n' +
            '                                        <button class="btn btn-outline-dark text-uppercase" type="submit" name="submit" value="0" id="incomeSubmit">Submit</button>\n' +
            '                                    </div>\n' +
            '                                </form>');
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