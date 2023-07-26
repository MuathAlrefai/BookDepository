var thumbTitle = $(".thumb-title");
for (var i = 0; i<= thumbTitle.length; i++){
    if(thumbTitle[i].innerHTML.length > 50){
        var shortendTitle =thumbTitle[i].innerHTML.slice(0, 50);
        thumbTitle[i].innerHTML = shortendTitle.concat("...");
    }
}