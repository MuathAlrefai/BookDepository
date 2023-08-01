<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <%--    <link rel="stylesheet" href="/CSS/contactus.css">--%>



</head>
<body>
<br> <br>
<div class="container" style="width:900px">
    <input type="text" id="searchInput" placeholder="Enter company name">
    <ul id="results"></ul>
</div>
<script>
    $(document).ready(function() {
        $("#searchInput").on("input", function() {
            let name= $(this).val();

            $.ajax({
                url: "/searchh",
                type: "GET",
                data: {
                    name: name
                },
                success: function(data) {
                    var resultsList = $("#results");
                    resultsList.empty();
                    data.forEach(function(book) {
                        resultsList.append("<li>" + book.name + "</li>");
                    });
                }
            });
        });
    });
</script>
</body>
</html>