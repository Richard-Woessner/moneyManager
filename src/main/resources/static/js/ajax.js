$(document).ready(function(){
    $("button").click(function(){
        $.post("demo_test_post.asp",
            {
                name: "Donald Duck",
                city: "Duckburg"
            },
            function(data, status){
                alert("Data: " + data + "\nStatus: " + status);
            });
    });


    $("button").click(function(){
        $.get("demo_test.asp", function(data, status){
            alert("Data: " + data + "\nStatus: " + status);
        });
    });

});